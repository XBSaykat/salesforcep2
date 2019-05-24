package net.maxproit.salesforce2.masum.fragment.prospect.myprospect;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseFragment;
import net.maxproit.salesforce2.masum.adapter.adapter.MyNewProspectReturnAdapter;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce2.masum.model.local.MyNewProspect;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;
import net.maxproit.salesforce2.model.myprospect.Data;
import net.maxproit.salesforce2.model.myprospect.MyProspect;
import net.maxproit.salesforce2.model.myprospect.updatemyprospect.OldProspect;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProspectreturn extends BaseFragment {

    MyNewProspectReturnAdapter myProspectAdapter;
    String userName;
    MyLeadDbController myLeadDbController;
    RecyclerView recyclerView;
    ArrayList<MyNewProspect> leadList;
    ArrayList<Data> dataList, dataFilterList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_activity_list, container, false);
        leadList = new ArrayList<>();
        dataList = new ArrayList<>();
        dataFilterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(getActivity());
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);

        if (!leadList.isEmpty()) {
            leadList.clear();
        }

//        leadList.addAll(myLeadDbController.myNewProspectGetAllData(AppConstant.STATUS_NEW_PROSPECT));


//        for (int i = 0; i < leadList.size(); i++) {
//            Data data = new Data();
//            data.setReference(leadList.get(i).getRefNumber());
//            data.setName(leadList.get(i).getUserName());
//            data.setStatus(leadList.get(i).getStatus());
//            data.setBranch(leadList.get(i).getBranchName());
//            dataList.add(data);
//        }


        recyclerView = view.findViewById(R.id.rv_my_activity);

        return view;

    }

    @Override
    protected Integer layoutResourceId() {
        return null;
    }

    @Override
    protected void initFragmentComponents() {

    }

    public void beginSearching(String s) {
        dataFilterList = getFilterData(dataList, s);
        myProspectAdapter.setFilter(dataFilterList);
    }

    private void initListener() {

        myProspectAdapter.setItemClickListener((view, position) -> {
                loadFilterData();
                switch (view.getId()) {
                    default:
                        callApiLoadList(position);
                        break;
                }
        });

    }

    private void callApiLoadList(int position) {
        if (isNetworkAvailable()) {
            if (!AppConstant.coAppLicantStaticList.isEmpty()) {
                AppConstant.coAppLicantStaticList.clear();
            }
            showLoader();
            String ref = dataFilterList.get(position).getReference();
            getApiService().getNewProspect(ref, UUID.randomUUID().toString()).enqueue(new Callback<OldProspect>() {
                @Override
                public void onResponse(Call<OldProspect> call, Response<OldProspect> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals(getString(R.string.success_code))) {
                            if (response.body().getData() != null) {
                                OldProspect oldProspect = response.body();
                                ActivityUtils.invokLeadDetailForProspectStage(getActivity(), oldProspect.getMyNewProspect());

                            } else {
                                showAlertDialog(getString(R.string.error_text), getString(R.string.empty_result));
                                hideLoader();
                            }
                        } else {
                            showAlertDialog(getString(R.string.error_text), response.body().getMessage());
                            hideLoader();
                        }

                    } else {
                        showAlertDialog(getString(R.string.error_text), response.message());
                        hideLoader();
                    }

                }

                @Override
                public void onFailure(Call<OldProspect> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());
                    hideLoader();
                }
            });
        } else showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!AppConstant.coAppLicantStaticList.isEmpty()) {
            AppConstant.coAppLicantStaticList.clear();
        }
        callApi();


    }



    //filter  data
    private ArrayList<Data> getFilterData(ArrayList<Data> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<Data> filteredModelList = new ArrayList<>();
        for (Data model : models) {
            final String uName = model.getName().toLowerCase();
            final String reference = model.getReference().toLowerCase();

            if (uName.contains(searchKey) || reference.contains(searchKey)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void loadFilterData() {
        if (!dataFilterList.isEmpty()) {
            dataFilterList.clear();
        }
        dataFilterList.addAll(myProspectAdapter.getDataList());
    }

    private void callApi() {
        if (!dataList.isEmpty()) {
            dataList.clear();
        }
        initLoader();
        showLoader();
        if (isNetworkAvailable()) {

            getApiService().getMyProspect(userName, UUID.randomUUID().toString()).enqueue(new Callback<MyProspect>() {
                @Override
                public void onResponse(Call<MyProspect> call, Response<MyProspect> response) {

                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals(getString(R.string.success_code))) {
                            if (response.body().getData() != null) {
                                hideLoader();

                                for (int i = 0; i < response.body().getData().size(); i++) {
                                    if (response.body().getData().get(i).getStatus().equalsIgnoreCase(AppConstant.PROSPPECT_STATUS_FILTER_RETURN)) {
                                        dataList.add(response.body().getData().get(i));
                                    }
                                }
                                myProspectAdapter = new MyNewProspectReturnAdapter(getActivity(), dataList);
                                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                                recyclerView.setLayoutManager(mLayoutManager);
                                recyclerView.setAdapter(myProspectAdapter);
                                initListener();

                            } else showEmptyView();
                        } else {
                            showEmptyView();
                            showAlertDialog(getString(R.string.error_text), response.body().getMessage());
                        }

                    } else {
                        showEmptyView();
                        showAlertDialog(getString(R.string.error_text), response.message());
                    }

                }

                @Override
                public void onFailure(Call<MyProspect> call, Throwable t) {
                    showEmptyView();
                    showAlertDialog(getString(R.string.error_text), t.getMessage());


                }
            });
        } else {
            showEmptyView();
            showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));
        }
    }

}


