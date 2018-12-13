package net.maxproit.salesforce.masum.activity.lead;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.salesforce.databinding.ActivityMyLeadBinding;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.api.lead.Data;
import net.maxproit.salesforce.masum.model.api.lead.LeadLeastDataFromApi;
import net.maxproit.salesforce.masum.model.api.lead.MyGetLeadApi;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadByRefApi;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.adapter.MyLeadAdapter;

import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.util.CommonUtil;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyLeadActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyLeadActivity";
    public static final int APPROVED = 101;

    ActivityMyLeadBinding binding;
    MyLeadAdapter myLeadAdapter;
    MyLeadDbController myLeadDbController;
    LocalLogin localLogin;
    MyNewProspect myNewLead;
    ArrayList<LeadLeastDataFromApi> leadListDataFromApi, filterList;
    String username;
    ArrayList<MyNewProspect> leadList;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_lead;
    }

    @Override
    protected void initComponents() {


        binding = (ActivityMyLeadBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        localLogin = new LocalLogin(getApplicationContext());
        leadList = new ArrayList<>();
        leadListDataFromApi = new ArrayList<>();
        filterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(MyLeadActivity.this);
        username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList = getFilterData(leadListDataFromApi, query);
                myLeadAdapter.setFilter(filterList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList = getFilterData(leadListDataFromApi, newText);
                myLeadAdapter.setFilter(filterList);
                return true;
            }
        });


        myLeadAdapter = new MyLeadAdapter(MyLeadActivity.this, leadListDataFromApi);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvMyLead.setLayoutManager(mLayoutManager);
        binding.rvMyLead.setAdapter(myLeadAdapter);
        myLeadAdapter.notifyDataSetChanged();


        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()) {
                    case R.id.clLeadItem:
                        sentDataToDetail(position);
                        break;
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        showProgressDialog();
        if (!leadList.isEmpty()) {
            leadList.clear();
        }
        if (!leadListDataFromApi.isEmpty()) {
            leadListDataFromApi.clear();
        }
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            int status = extraDetail.getInt(AppConstant.STATUS_INTENT_KEY, -1);
            if (status == 1) {
                binding.searchView.setQueryHint("search pending lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.LEAD_STATUS_NEW));
                binding.rvMyLead.setClickable(false);
            } else if (status == 2) {
                binding.searchView.setQueryHint("search proceeded lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_NEW_PROSPECT));
                binding.rvMyLead.setClickable(false);
            } else if (status == 3) {
                binding.searchView.setQueryHint("search closed lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.LEAD_STATUS_REJECT));
                binding.rvMyLead.setClickable(false);
            } else if (status == 4) {
                binding.searchView.setQueryHint("search Prospect ");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_NEW_PROSPECT));
                binding.rvMyLead.setClickable(false);
            } else if (status == 5) {
                binding.searchView.setQueryHint("search Proceeded Prospect");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_RBM));
                binding.rvMyLead.setClickable(false);
            } else {

                if (isNetworkAvailable()) {
                    getDataFromServer();
                } else {

                    leadListDataFromApi.addAll(myLeadDbController.getLeadListData());
                    myLeadAdapter.notifyDataSetChanged();
                    if (leadListDataFromApi.isEmpty()) {
                        showEmptyView();
                    } else hideLoader();
                }
            }
        } else {

            if (isNetworkAvailable())
                getDataFromServer();
            else
                leadListDataFromApi.addAll(myLeadDbController.getLeadListData());
            myLeadAdapter.notifyDataSetChanged();
            if (leadListDataFromApi.isEmpty()) {
                showEmptyView();
            } else hideLoader();

        }

    }

    private void getDataFromServer() {
        String random = UUID.randomUUID().toString();
        if (isNetworkAvailable()) {

            getApiService().getLeadData(username, random).enqueue(new Callback<MyGetLeadApi>() {
                @Override
                public void onResponse(Call<MyGetLeadApi> call, Response<MyGetLeadApi> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            leadListDataFromApi.addAll(response.body().getData());
                            myLeadAdapter.notifyDataSetChanged();
                            hideProgressDialog();

                        } else {
                            hideProgressDialog();
                            showEmptyView();
                            showAlertDialog("Error", response.body().getMessage());
                        }


                    } else {
                        hideProgressDialog();
                        showEmptyView();
                        showAlertDialog("Error", response.message());
                    }
                }

                @Override
                public void onFailure(Call<MyGetLeadApi> call, Throwable t) {
                    showEmptyView();
                    hideProgressDialog();
                    showAlertDialog("Error", t.getMessage());

                }
            });
        } else {
            hideProgressDialog();
            showAlertDialog("Error", "Internet not Available,please connect to the internet");

        }

    }

    private void sentDataToDetail(int position) {
        String refID = filterList.get(position).getReference();
        String random = UUID.randomUUID().toString();
        showProgressDialog();
        if (isNetworkAvailable()) {
            getApiService().getLeadDataByRef(refID, random).enqueue(new Callback<MyLeadByRefApi>() {
                @Override
                public void onResponse(Call<MyLeadByRefApi> call, Response<MyLeadByRefApi> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            if (response.body().getData() != null) {
                                Data data = response.body().getData();
                                String disDate = CommonUtil.jsonToDate(data.getDisbursementDate());
                                String followUpDate = CommonUtil.jsonToDate(data.getFollowUpDate());
                                String loanAmount = MasumCommonUtils.isNotZero(data.getLoanAmount());
                                String interestRate = MasumCommonUtils.isNotZero(data.getOfferedInterestRate());
                                String opfee = MasumCommonUtils.isNotZero(data.getOfferedProcessFee());
                                MyNewLead myNewLead = new MyNewLead(data.getUserName(), data.getLeadReferenceNo(), data.getCustomerId(), data.getMobileNumberId(), data.getAddressId(),
                                        data.getVisitId(), data.getBranchCode(), data.getProductId(), data.getProductSubCategoryId(), 0, data.getBranchName(), data.getCustomerName(), data.getProfession(), data.getOrganization(),
                                        data.getDesignation(), data.getMobileNumber(), data.getAddress(), data.getSourceOfReference(), data.getProduct(),
                                        data.getProductSubCategory(), loanAmount, interestRate, opfee, disDate,
                                        followUpDate, data.getFollowUp(), data.getRemark(), data.getStatus(), "");
                                myNewLead.setPs(data.getPs());
                                myNewLead.setCity(data.getCity());
                                ActivityUtils.invokLeadDetailForLeadStage(MyLeadActivity.this, myNewLead);
                                if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.DONUT) {
                                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                                }
                                hideProgressDialog();
                            } else showEmptyView();
                        } else {
                            showAlertDialog("Error", response.body().getMessage());

                        }
                    } else showAlertDialog("Error", response.message());

                }

                @Override
                public void onFailure(Call<MyLeadByRefApi> call, Throwable t) {

                    showAlertDialog("ERROR", t.getMessage());

                }
            });

        } else {
            MyNewLead myNewLead = myLeadDbController.getDataById(filterList.get(position).getId()).get(0);
            ActivityUtils.invokLeadDetailForLeadStage(MyLeadActivity.this, myNewLead);

        }

    }


    @Override
    protected void getIntentData() {

    }


    //filter  data
    private ArrayList<LeadLeastDataFromApi> getFilterData(ArrayList<LeadLeastDataFromApi> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<LeadLeastDataFromApi> filteredModelList = new ArrayList<>();
        for (LeadLeastDataFromApi model : models) {
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
        filterList.addAll(myLeadAdapter.getDataList());
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // When an Image is picked
        if (requestCode == APPROVED && resultCode == RESULT_OK && null != data) {
            startActivity(MyLeadActivity.class, true);
        }

    }

    @Override
    public void adShowProgressDialog() {

    }

    @Override
    public void adHideProgressDialog() {

    }

    @Override
    public void adSuccess(String message) {

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
}
