package net.maxproit.salesforce;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.adapter.adapter.MyNewProspectAdapter;

import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.lead.LeadLeastDataFromApi;
import net.maxproit.salesforce.masum.model.api.rbm.Datum;
import net.maxproit.salesforce.masum.model.api.rbm.GetRbmData;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.model.myprospect.Data;
import net.maxproit.salesforce.model.myprospect.MyProspect;
import net.maxproit.salesforce.model.myprospect.updatemyprospect.OldProspect;
import net.maxproit.salesforce.model.search.Search;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorRbmProspect extends BaseActivity {


    private ImageView btnBack;
    private SearchView searchView;

    ArrayList<Data> prospectArrayList, filterList;

    MyNewProspectAdapter myAdapter;
    //    String userName;
    MyLeadDbController myLeadDbController;
    //    Bundle extras;
    RecyclerView rvProspect;

    //    Button btnAddProspect;

    //    ArrayList<MyNewLead> followUpList, filterList;
    //

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_rbm_prospect;
    }

    @Override
    protected void initComponents() {
        rvProspect = findViewById(R.id.rv_supervisor_rbm);

        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnBack = (ImageView) findViewById(R.id.btn_back);
        searchView = findViewById(R.id.search_view);
        prospectArrayList = new ArrayList<>();
        filterList = new ArrayList<>();

        myAdapter = new MyNewProspectAdapter(this, prospectArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvProspect.setLayoutManager(mLayoutManager);
        rvProspect.setAdapter(myAdapter);
        myAdapter.isChangedFieldName(true);
        initListener();

        btnLogout.setOnClickListener(view -> {
            logout();

        });

        btnBack.setOnClickListener(view -> {
            onBackPressed();
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList = getFilterData(prospectArrayList, query);
                myAdapter.setFilter(filterList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList = getFilterData(prospectArrayList, newText);
                myAdapter.setFilter(filterList);
                return true;
            }
        });


    }

    @Override
    protected void getIntentData() {


    }


    //filter  data
    private ArrayList<Data> getFilterData(ArrayList<Data> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<Data> filteredModelList = new ArrayList<>();
        for (Data model : models) {
            final String uName = model.getName().toLowerCase();
            final String phone = model.getReference().toLowerCase();

            if (uName.contains(searchKey) || phone.contains(searchKey)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void loadFilterData() {
        if (!filterList.isEmpty()) {
            filterList.clear();
        }
        filterList.addAll(myAdapter.getDataList());
    }

    private void initListener() {

        myAdapter.setItemClickListener((view, position) -> {
            loadFilterData();
            switch (view.getId()) {
                default:
                    sentDataToDetail(position);
                    break;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        myLeadDbController = new MyLeadDbController(this);
        if (!prospectArrayList.isEmpty()) {
            prospectArrayList.clear();
        }


        callApi();
    }

    private void callApi() {


        if (isNetworkAvailable()) {
            showProgressDialog();
            String userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
            String random = UUID.randomUUID().toString();
            localCash().put(SharedPreferencesEnum.Key.USER_NAME_PER, userName);
            getApiService().getRbmData(userName, random).enqueue(new Callback<GetRbmData>() {
                @Override
                public void onResponse(Call<GetRbmData> call, Response<GetRbmData> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals(getString(R.string.success_code))) {
                            MyProspect myProspect = new MyProspect();
                            prospectArrayList.addAll(myProspect.setRbmDataModelList((ArrayList<Datum>) response.body().getData()));
                            myAdapter.notifyDataSetChanged();
                            hideProgressDialog();
                        } else if (response.body().getCode().equals("404")) {
                            initLoader();
                            hideProgressDialog();
                            showEmptyView();

                        } else {
                            showAlertDialog(getString(R.string.error_text), response.body().getMessage());
                            hideProgressDialog();
                        }
                    } else {
                        showAlertDialog(getString(R.string.error_text), response.message() + "\n" + response.errorBody().toString());
                        hideProgressDialog();
                    }
                }

                @Override
                public void onFailure(Call<GetRbmData> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());
                    hideProgressDialog();

                }
            });
        } else {
            showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));
        }

    }

    private void sentDataToDetail(int position) {
        Data prospectListData = filterList.get(position);
        String ref = filterList.get(position).getReference();
        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getRbmDataByRef(ref, UUID.randomUUID().toString()).enqueue(new Callback<OldProspect>() {
                @Override
                public void onResponse(Call<OldProspect> call, Response<OldProspect> response) {
                    if (response.body().getCode().equals(getString(R.string.success_code))) {
                        hideProgressDialog();
                        OldProspect oldProspect = response.body();
                        MyNewProspect myNewProspect = oldProspect.getMyNewProspect();
                        ActivityUtils.invokProspectRbmViewStage(SupervisorRbmProspect.this, myNewProspect, prospectListData);

                    } else {
                        showAlertDialog(getString(R.string.error_text), response.body().getMessage());
                        hideProgressDialog();
                    }

                }

                @Override
                public void onFailure(Call<OldProspect> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());
                    hideProgressDialog();
                }
            });
        } else
            showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));

    }

    private void logout() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(SupervisorRbmProspect.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(SupervisorRbmProspect.this);
        }
        builder.setTitle(getString(R.string.logout_title));
        builder.setMessage(getString(R.string.logout_message));
        builder.setIcon(R.drawable.logout_icon);
        builder.setNegativeButton(getString(R.string.no), null);
        builder.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
            startActivity(new Intent(SupervisorRbmProspect.this, LoginActivity.class));
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, "");
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public SharedPreferencesEnum localCash() {
        return SharedPreferencesEnum.getInstance(getActivity());
    }

    public Activity getActivity() {
        return this;
    }


    /* MyNewProspect myNewLead=new MyNewProspect(filterList.get(position).getId(),
             filterList.get(position).getBranchName(),
             filterList.get(position).getUserName(),
             filterList.get(position).getProfession(),
             filterList.get(position).getOrganization(),
             filterList.get(position).getDesignation(),
             filterList.get(position).getPhone(),
             filterList.get(position).getAddress(),
             filterList.get(position).getSourceRef(),
             filterList.get(position).getProductType(),
             filterList.get(position).getProductSubcategory(),
             filterList.get(position).getLoanAmount(),
             filterList.get(position).getOrInterest(),
             filterList.get(position).getOpFee(),
             filterList.get(position).getVisitDate(),
             filterList.get(position).getDisDate(),
             filterList.get(position).getFollowUp(),
             filterList.get(position).getRemark(),
             filterList.get(position).getStatus(),
             filterList.get(position).getSegment(),
             filterList.get(position).getDateOfBirth(),
             filterList.get(position).getAge(),
             filterList.get(position).getDisDate(),
             filterList.get(position).getCob(),
             filterList.get(position).getpIDType(),
             filterList.get(position).getpIdNumber(),
             filterList.get(position).getpIssueDate(),
             filterList.get(position).getEtin(),
             filterList.get(position).getfName(),
             filterList.get(position).getmName(),
             filterList.get(position).getsName(),
             filterList.get(position).getExList(),
             filterList.get(position).getCurrentJob(),
             filterList.get(position).getApplicant(),
             filterList.get(position).getpAddress(),
             filterList.get(position).getNetSalary(),
             filterList.get(position).getSalaryAmount(),
             filterList.get(position).getBusinessIncomeAmount(),
             filterList.get(position).getApartmentAmount(),
             filterList.get(position).getSemipakaIncome(),
             filterList.get(position).getOfficeSpaceINcome(),
             filterList.get(position).getWireHouseINcome(),
             filterList.get(position).getAg_Income(),
             filterList.get(position).getTution(),
             filterList.get(position).getRemitance(),
             filterList.get(position).getInFdr(),
             filterList.get(position).getfExpense(),
             filterList.get(position).getEmiOther(),
             filterList.get(position).getsValue(),
             filterList.get(position).getLoanReq(),
             filterList.get(position).getLoanTerm(),
             filterList.get(position).getPiRate(),
             filterList.get(position).getProspectFee());*/
    private Button btnLogout;
}
