package net.maxproit.salesforce.masum.fragment.prospect.myprospect;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.masum.adapter.adapter.MyNewProspectAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.myprospect.Data;
import net.maxproit.salesforce.model.myprospect.MyProspect;
import net.maxproit.salesforce.model.myprospect.updatemyprospect.OldProspect;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProspectPendingList extends BaseFragment {
    LocalLogin localLogin;
    MyNewProspectAdapter myProspectAdapter;
    String userName;
    Bundle extras;
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

        myProspectAdapter.setItemClickListener(new OnItemClickListener() {

            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()) {
                    default:
                        callApiLoadList(position);
                        break;
                }
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
                        if (response.body().getCode().equals("200")) {
                            if (response.body().getData() != null) {
                                OldProspect oldProspect = response.body();
                                ActivityUtils.invokLeadDetailForProspectStage(getActivity(), oldProspect.getMyNewProspect());

                            } else {
                                showAlertDialog("Error", "Server Error");
                                hideLoader();
                            }
                        } else {
                            showAlertDialog("Error", response.body().getMessage());
                            hideLoader();
                        }

                    } else {
                        showAlertDialog("Error", response.message());
                        hideLoader();
                    }

                }

                @Override
                public void onFailure(Call<OldProspect> call, Throwable t) {
                    showAlertDialog("Error", t.getMessage());
                    hideLoader();
                }
            });
        } else showAlertDialog("Error", "No Internet,please connect to the internet");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!AppConstant.coAppLicantStaticList.isEmpty()) {
            AppConstant.coAppLicantStaticList.clear();
        }
        callApi();


    }


    //    private void sentDataToDetail(int position) {
//        MyNewProspect myNewLead=new MyNewProspect(filterList.get(position).getId(),
//                filterList.get(position).getBranchName(),
//                filterList.get(position).getUserName(),
//                filterList.get(position).getProfession(),
//                filterList.get(position).getOrganization(),
//                filterList.get(position).getDesignation(),
//                filterList.get(position).getPhone(),
//                filterList.get(position).getAddress(),
//                filterList.get(position).getSourceRef(),
//                filterList.get(position).getProductType(),
//                filterList.get(position).getProductSubcategory(),
//                filterList.get(position).getLoanAmount(),
//                filterList.get(position).getOrInterest(),
//                filterList.get(position).getOpFee(),
//                filterList.get(position).getVisitDate(),
//                filterList.get(position).getDisDate(),
//                filterList.get(position).getFollowUp(),
//                filterList.get(position).getRemark(),
//                filterList.get(position).getStatus(),
//                filterList.get(position).getSegment(),
//                filterList.get(position).getDateOfBirth(),
//                filterList.get(position).getAge(),
//                filterList.get(position).getDob(),
//                filterList.get(position).getCob(),
//                filterList.get(position).getpIDType(),
//                filterList.get(position).getpIdNumber(),
//                filterList.get(position).getpIssueDate(),
//                filterList.get(position).getEtin(),
//                filterList.get(position).getfName(),
//                filterList.get(position).getmName(),
//                filterList.get(position).getsName(),
//                filterList.get(position).getExList(),
//                filterList.get(position).getCurrentJob(),
//                filterList.get(position).getApplicant(),
//                filterList.get(position).getpAddress(),
//                filterList.get(position).getNetSalary(),
//                filterList.get(position).getSalaryAmount(),
//                filterList.get(position).getBusinessIncomeAmount(),
//                filterList.get(position).getApartmentAmount(),
//                filterList.get(position).getSemipakaIncome(),
//                filterList.get(position).getOfficeSpaceINcome(),
//                filterList.get(position).getWireHouseINcome(),
//                filterList.get(position).getAg_Income(),
//                filterList.get(position).getTution(),
//                filterList.get(position).getRemitance(),
//                filterList.get(position).getInFdr(),
//                filterList.get(position).getfExpense(),
//                filterList.get(position).getEmiOther(),
//                filterList.get(position).getsValue(),
//                filterList.get(position).getLoanReq(),
//                filterList.get(position).getLoanTerm(),
//                filterList.get(position).getPiRate(),
//                filterList.get(position).getProspectFee()
//        );
//        ActivityUtils.invokLeadDetailForProspectStage(getActivity(),myNewLead);
//    }

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

        initLoader();
        showLoader();
        Log.d("tag", "callApi: ");
        if (isNetworkAvailable()) {
            if (!dataList.isEmpty()) {
                dataList.clear();
            }
            getApiService().getMyProspect(userName, UUID.randomUUID().toString()).enqueue(new Callback<MyProspect>() {
                @Override
                public void onResponse(Call<MyProspect> call, Response<MyProspect> response) {

                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            if (response.body().getData() != null) {
                                hideLoader();

                                for (int i = 0; i < response.body().getData().size(); i++) {
                                    if (!response.body().getData().get(i).getStatus().equalsIgnoreCase(AppConstant.PROSPPECT_STATUS_FILTER_RETURN)) {
                                        dataList.add(response.body().getData().get(i));
                                    }
                                }
                                myProspectAdapter = new MyNewProspectAdapter(getActivity(), dataList);
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