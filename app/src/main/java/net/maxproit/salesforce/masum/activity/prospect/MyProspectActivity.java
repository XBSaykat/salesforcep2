package net.maxproit.salesforce.masum.activity.prospect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMyProspectBinding;
import net.maxproit.salesforce.masum.adapter.adapter.MyNewProspectAdapter;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.myprospect.MyProspect;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProspectActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyProspectActivity";


    ActivityMyProspectBinding binding;
    LocalLogin localLogin;
    MyNewProspectAdapter myProspectAdapter;
    String userName;
    Bundle extras;
    MyLeadDbController myLeadDbController;

    ArrayList<MyNewProspect> leadList, filterList;
    Button btnAddProspect;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_prospect;
    }

    @Override
    protected void initComponents() {


        binding = (ActivityMyProspectBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        leadList = new ArrayList<>();
        filterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(this);

        if (!leadList.isEmpty()) {
            leadList.clear();
        }

        leadList.addAll(myLeadDbController.myNewProspectGetAllData(AppConstant.STATUS_NEW_PROSPECT));

        localLogin = new LocalLogin(getApplicationContext());
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        myProspectAdapter = new MyNewProspectAdapter(MyProspectActivity.this, leadList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvMyProspect.setLayoutManager(mLayoutManager);
        binding.rvMyProspect.setAdapter(myProspectAdapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList = getFilterData(leadList, query);
                myProspectAdapter.setFilter(filterList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList = getFilterData(leadList, newText);
                myProspectAdapter.setFilter(filterList);
                return true;
            }
        });

//        try {
//            callApi();
//        } catch (Exception e) {
//            showAlertDialog("Error", e.getMessage());
//        }



        initListener();


    }

    private void initListener() {

        myProspectAdapter.setItemClickListener(new OnItemClickListener() {

            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()){
                    default:
                        sentDataToDetail(position);
                        break;
                }
            }
        });

    }


    private void removeItemFromList(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                leadList.remove(i);
                myProspectAdapter.notifyItemRemoved(position);
                break;

            }
        }
    }

    private void changeItemStatus(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                myProspectAdapter.notifyDataSetChanged();
                break;

            }
        }
    }


    private void sentDataToDetail(int position) {
        MyNewProspect myNewLead=new MyNewProspect(filterList.get(position).getId(),
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
                filterList.get(position).getDob(),
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
                filterList.get(position).getProspectFee()
                );
        ActivityUtils.invokLeadDetailForProspectStage(this,myNewLead);
    }

    //filter  data
    private ArrayList<MyNewProspect> getFilterData(ArrayList<MyNewProspect> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<MyNewProspect> filteredModelList = new ArrayList<>();
        for (MyNewProspect model : models) {
            final String uName = model.getUserName().toLowerCase();
            final String phone = model.getPhone().toLowerCase();

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
        filterList.addAll(myProspectAdapter.getDataList());
    }


    private void callApi() {
        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getMyProspect(userName, UUID.randomUUID().toString()).enqueue(new Callback<MyProspect>() {
                @Override
                public void onResponse(Call<MyProspect> call, Response<MyProspect> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {

                        } else showAlertDialog("Error", response.body().getMessage());

                    } else showAlertDialog("Error", response.message());

                }

                @Override
                public void onFailure(Call<MyProspect> call, Throwable t) {
                    hideProgressDialog();
                    showAlertDialog("Error", t.getMessage());


                }
            });
        } else showAlertDialog("Error", "Network is not available");
    }

    @Override
    protected void getIntentData() {


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void adShowProgressDialog() {
        showProgressDialog();
    }

    @Override
    public void adHideProgressDialog() {
        hideProgressDialog();

    }

    @Override
    public void adSuccess(String message) {
        //recreate();
        startActivity(MyProspectActivity.class, true);

    }

    @Override
    public void adFailed(String message) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {


    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // When an Image is picked
        if (requestCode == 200 && resultCode == RESULT_OK && null != data) {
            // startActivity(MyProspectActivity.class,true);
            recreate();

        }


    }


}
