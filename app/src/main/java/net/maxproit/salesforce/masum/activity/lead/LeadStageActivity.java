package net.maxproit.salesforce.masum.activity.lead;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;

import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.masum.appdata.sqlite.AttachmentDbController;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageBasicInformationFragment;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageLoanDetailFragment;
import net.maxproit.salesforce.masum.model.api.lead.Data;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.api.lead.MyOldLeadApi;
import net.maxproit.salesforce.masum.model.api.myactivity.CompleteActivity;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.appdata.AppConstant;

import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.masum.model.api.approval.Approval;
import net.maxproit.salesforce.model.mylead.approvalresponce.ApprovalResponce;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadStageActivity extends BaseActivity implements AdapterInfo {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView btnSave, btnProceed, btnReject, btnReAppoint;
    private MyLeadDbController myLeadDbController;
    private AttachmentDbController attachmentDbController;
    private ArrayList<VisitPlan> visitPlanArrayList;
    private VisitPlanDbController visitPlanDbController;
    private LeadStageBasicInformationFragment leadStageBasicInformationFragment;


    private LeadStageLoanDetailFragment leadStageLoanDetailFragment;
    private LinearLayout mLayout;
    private MyLeadDataModelApi myLeadDataModelApi = null;
    private String branchName = null, profession = null, name = null, organization = null, designation = null, phone = null, address = null, loanAmount = null, interest = null, fee = null, ref = null, productType = null, subCat = null, disDate = null, visitDate = null, remark = null, followUp = null, city = null, polishStationl = null;
    private String userName = null;
    private int activityPosition;
    public static int myLeadPosition = -1;
    private VisitPlan visitPlan = null;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_lead_stage;

    }

    @Override
    protected void initComponents() {
        initLoader();
        showLoader();
        splashThread();
        myLeadDataModelApi = new MyLeadDataModelApi();
        initFragments();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        localCash().put(SharedPreferencesEnum.Key.USER_NAME_PER, userName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        btnSave = findViewById(R.id.btnSave);
        myLeadDbController = new MyLeadDbController(LeadStageActivity.this);
        attachmentDbController = new AttachmentDbController(LeadStageActivity.this);
        mLayout = findViewById(R.id.btn_layout_lead);
        btnProceed = findViewById(R.id.tv_activity_details_proceed_to_prospect);
        btnReject = findViewById(R.id.tv_activity_details_rejected);
        getDataFromIntent();
    }

    @Override
    protected void getIntentData() {

    }

    private void splashThread() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoader();

            }
        }, 3000);
    }


    private void initFragments() {

        leadStageBasicInformationFragment = new LeadStageBasicInformationFragment();
        leadStageLoanDetailFragment = new LeadStageLoanDetailFragment();

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(leadStageBasicInformationFragment, "Basic Information");
        adapter.addFragment(leadStageLoanDetailFragment, "Loan Detail");


        viewPager.setAdapter(adapter);
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

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LeadStageActivity.this, DashboardSalesOfficerActivity.class));
        finish();
    }


    private void getDataFromIntent() {
        visitPlan = null;
        MyNewLead myNewLead = null;
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            int status = extraDetail.getInt(AppConstant.STATUS_INTENT_KEY, -1);
            Bundle bundle = new Bundle();
            getSupportActionBar().setTitle("Lead");
            if (status == 0) {
                visitPlan = (VisitPlan) extraDetail.getSerializable(AppConstant.INTENT_KEY);
                bundle.putSerializable(AppConstant.INTENT_KEY, visitPlan);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY, 0);
            } else if (status == 1) {
                myNewLead = (MyNewLead) extraDetail.getSerializable(AppConstant.INTENT_KEY);
                bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY, 1);
                mLayout.setVisibility(View.VISIBLE);

            } else {
                getSupportActionBar().setTitle("Create Lead");
            }

            leadStageBasicInformationFragment.setArguments(bundle);
            leadStageLoanDetailFragment.setArguments(bundle);


        }


        MyNewLead finalMyNewLead = myNewLead;
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetworkAvailable())
                    alertDialogProceed(finalMyNewLead);
                else
                    showAlertDialog("Error", "Proceed is not available without internet,PLease connect to the internet");

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogSave(finalMyNewLead);
            }
        });


        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalMyNewLead != null) {
                    alertDialog(finalMyNewLead.getId());
                }
            }
        });

    }

    private MyLeadDataModelApi getDataFromFragment(MyNewLead myNewLead) {
        branchName = LeadStageBasicInformationFragment.branchName; //
        profession = LeadStageBasicInformationFragment.profession; //
        name = LeadStageBasicInformationFragment.etUserName.getText().toString(); //
        city = LeadStageBasicInformationFragment.city; //
        polishStationl = LeadStageBasicInformationFragment.policeStation; //
        organization = LeadStageBasicInformationFragment.etUserOrganization.getText().toString(); //
        designation = LeadStageBasicInformationFragment.etDesignattion.getText().toString(); //
        phone = LeadStageBasicInformationFragment.etPhone.getText().toString();
        address = LeadStageBasicInformationFragment.etAddress.getText().toString();
        loanAmount = LeadStageLoanDetailFragment.etLoanAmount.getText().toString();
        interest = LeadStageLoanDetailFragment.etInterest.getText().toString();
        fee = LeadStageLoanDetailFragment.etFee.getText().toString();
        ref = LeadStageLoanDetailFragment.spinnerRef.getSelectedItem();
        productType = LeadStageLoanDetailFragment.spinnerProductType.getSelectedItem();
        subCat = LeadStageLoanDetailFragment.spinnerSubCategory.getSelectedItem();
        disDate = LeadStageLoanDetailFragment.etDisbursementDate.getText().toString();
//        visitDate = LeadStageVisitRecordFragment.etVisitDate.getText().toString(); //

        remark = LeadStageLoanDetailFragment.etRemark.getText().toString();


        // followUp = LeadStageVisitRecordFragment.spinnerFollowUp.getSelectedItem();
        //api integate
        MyLeadDataModelApi myLeadApi = new MyLeadDataModelApi();
        //api for proceed lead first time
        myLeadApi.setRmCode("336132");
        myLeadApi.setUserName(userName);
        myLeadApi.setBranchName(branchName);

        if (!MasumCommonUtils.isNullStr(LeadStageBasicInformationFragment.branchCode))
            myLeadApi.setBranchCode(Integer.valueOf(LeadStageBasicInformationFragment.branchCode));


        myLeadApi.setCustomerName(name);
        if (myNewLead != null) {
            myLeadApi.setCustomerId(myNewLead.getCusId());
            myLeadApi.setAddressId(myNewLead.getAddressId());
            myLeadApi.setMobileNumberId(myNewLead.getMobileId());
            myLeadApi.setVisitId(myNewLead.getVisitId());
        } else {
            myLeadApi.setCustomerId(0);
            myLeadApi.setAddressId(0);
            myLeadApi.setMobileNumberId(0);
            myLeadApi.setVisitId(0);
        }
        myLeadApi.setProfession(profession);
        myLeadApi.setOrganization(organization);
        myLeadApi.setDesignation(designation);
        myLeadApi.setMobileNumber(phone);
        myLeadApi.setAddress(address);
        myLeadApi.setCity(city);
        myLeadApi.setPs(polishStationl);
        myLeadApi.setSourceOfReference(ref);
        myLeadApi.setProductId(LeadStageLoanDetailFragment.productTypeCode);
        myLeadApi.setProduct(productType);
        myLeadApi.setProductSubCategoryId(LeadStageLoanDetailFragment.productSubCatCode);
        myLeadApi.setProductSubCategory(subCat);
        if (loanAmount != null)
            try {
                myLeadApi.setLoanAmount(Integer.valueOf(loanAmount.replace(",", "")));
            } catch (NumberFormatException e) {

            }
        else
            myLeadApi.setLoanAmount(0);
        if (interest != null)
            try {
                myLeadApi.setOfferedInterestRate((float) Float.valueOf(interest));
            } catch (NumberFormatException e) {

            }
        else
            myLeadApi.setOfferedInterestRate((float) 0);
        if (fee != null)
            try {
                myLeadApi.setOfferedProcessFee((float) Float.valueOf(fee));
            } catch (NumberFormatException e) {

            }
        else
            myLeadApi.setOfferedProcessFee((float) 0);
        myLeadApi.setDisbursementDate(DateUtils.getDateFormateForSqlite(disDate));

        myLeadApi.setFollowUp(followUp);
        myLeadApi.setFollowUpDate(DateUtils.getDateFormateForSqlite(visitDate));
        myLeadApi.setRemark(remark);
        if (myNewLead != null) {
            myLeadApi.setLeadReferenceNo(myNewLead.getRefNumber());
        } else {
            myLeadApi.setLeadReferenceNo("");
        }

        return myLeadApi;
    }


    private void alertDialog(int id) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(LeadStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(LeadStageActivity.this);
        }
        builder.setTitle(getString(R.string.Reject));
        builder.setMessage(getString(R.string.reject_item));
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            myLeadDbController.updateLeadDataStatus(id, AppConstant.LEAD_STATUS_REJECT);
            ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void alertDialogSave(final MyNewLead myNewLead) {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(LeadStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(LeadStageActivity.this);
        }
        builder.setTitle("Save");
        builder.setMessage("Do you want to save details?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            MyLeadDataModelApi myLeadDataModelApi = getDataFromFragment(myNewLead);

            if (myNewLead != null) {
                if (isNetworkAvailable()) {
                    //api call
                    getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                        @Override
                        public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getCode().equals("200") &&
                                        response.body().getStatus().equalsIgnoreCase("ok")) {
                                    if (response.body().getData() != null) {
                                        Data data = response.body().getData();
                                        int insert = myLeadDbController.updateLeadData(myNewLead.getId(), userName, myNewLead.getRefNumber(), data.getCustomerId(), data.getMobileNumberId(), data.getVisitId(), data.getAddressId(), data.getBranchCode(), data.getProductId(), data.getProductSubCategoryId(), branchName, name, profession, organization,
                                                designation, phone, address, ref, productType, subCat,
                                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_OK);
                                        errorAlert(response.body().getStatus(), response.body().getMessage());
                                    } else
                                        errorAlert(response.body().getStatus(), response.body().getMessage());
                                } else {
                                    errorAlert(response.body().getStatus(), response.body().getMessage());

                                }
                            } else {
                                int insert = myLeadDbController.updateLeadData(myNewLead.getId(), userName, myNewLead.getRefNumber(), myNewLead.getCusId(),
                                        myNewLead.getMobileId(), myNewLead.getVisitId(), myNewLead.getAddressId(), Integer.valueOf(LeadStageBasicInformationFragment.branchCode), Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode), Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode), branchName, name, profession, organization,
                                        designation, phone, address, ref, productType, subCat,
                                        loanAmount, interest, fee, disDate, visitDate, followUp, remark,
                                        AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                                errorAlert(response.body().getStatus(), response.body().getMessage());


                            }

                        }

                        @Override
                        public void onFailure(Call<MyOldLeadApi> call, Throwable t) {
                            errorAlert("Error", t.getMessage());

                        }
                    });

                } else {
                    int insert = myLeadDbController.updateLeadData(myNewLead.getId(), userName, myNewLead.getRefNumber(), myNewLead.getCusId(), myNewLead.getMobileId(), myNewLead.getVisitId(),
                            myNewLead.getAddressId(), Integer.valueOf(LeadStageBasicInformationFragment.branchCode),
                            Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode), Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode),
                            branchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                    finish();
                }


            } else {

                if (isNetworkAvailable()) {

                    getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                        @Override
                        public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                    Data data = response.body().getData();
                                    myLeadDbController.insertLeadData(data.getUserName(), data.getLeadReferenceNo(), data.getCustomerId(), data.getMobileNumberId(), data.getVisitId(), data.getAddressId(), data.getBranchCode(), data.getProductId(), data.getProductSubCategoryId(), branchName, name, profession, organization,
                                            designation, phone, address, ref, productType, subCat,
                                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_OK);
                                    if (visitPlan != null) {
                                        callActivityApi(visitPlan.getJournalId(), data.getLeadReferenceNo());
                                    }
                                    errorAlert(response.body().getStatus(), response.body().getMessage());
                                }
                            } else {
                                myLeadDbController.insertLeadData(userName, "", 0, 0, 0, 0,
                                        Integer.valueOf(LeadStageBasicInformationFragment.branchCode),
                                        Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode),
                                        Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode),
                                        branchName, name, profession, organization,
                                        designation, phone, address, ref, productType, subCat,
                                        loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                                errorAlert(response.body().getStatus(), "Data save seccessfully in device");


                            }

                        }

                        @Override
                        public void onFailure(Call<MyOldLeadApi> call, Throwable t) {
                            errorAlert("Error", t.getMessage());

                        }
                    });
                } else {
                    myLeadDbController.insertLeadData(userName, "", 0, 0, 0, 0, Integer.valueOf(LeadStageBasicInformationFragment.branchCode),
                            Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode),
                            Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode), branchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                    errorAlert("Success", "Internet not available,please connect to the internet ,Data save seccessfully in device");

                }

            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void callActivityApi(int journalId, String refNo) {
        getApiService().ActivityProceed(journalId, refNo).enqueue(new Callback<CompleteActivity>() {
            @Override
            public void onResponse(Call<CompleteActivity> call, Response<CompleteActivity> response) {
                if (response.body().getCode().equals("200")) {
                    ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                }

            }

            @Override
            public void onFailure(Call<CompleteActivity> call, Throwable t) {
                showAlertDialog("ERROR", t.getMessage());

            }
        });

    }

    private void alertDialogProceed(final MyNewLead myNewLead) {


        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(LeadStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(LeadStageActivity.this);
        }
        builder.setTitle("Proceed");
        builder.setMessage("Do you want to proceed?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            MyLeadDataModelApi myLeadDataModelApi = getDataFromFragment(myNewLead);
            int insert = 0;
            try {
                if (!myLeadDataModelApi.getLeadReferenceNo().equals("")) { // old lead
                    if (isNetworkAvailable()) {
                        getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                            @Override
                            public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                                if (response.isSuccessful()) {
                                    if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                        Data data = response.body().getData(); // old lead update online, offline
                                        int insert = myLeadDbController.updateLeadData(myNewLead.getId(), userName, myNewLead.getRefNumber(), data.getCustomerId(), data.getMobileNumberId(), data.getVisitId(), data.getAddressId(), data.getBranchCode(), data.getProductId(), data.getProductSubCategoryId(), branchName, name, profession, organization,
                                                designation, phone, address, ref, productType, subCat,
                                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_OK);

                                        leadApprove(data, myLeadDataModelApi.getProductId());
                                    } else {
                                        showAlertDialog("ERROR", response.body().getMessage());
                                    }
                                } else { // old lead update offline
                                    int insert = myLeadDbController.updateLeadData(myNewLead.getId(), userName, myNewLead.getRefNumber(), myNewLead.getCusId(), myNewLead.getMobileId(), myNewLead.getVisitId(), myNewLead.getAddressId(), Integer.valueOf(LeadStageBasicInformationFragment.branchCode),
                                            Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode), Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode), branchName, name, profession, organization,
                                            designation, phone, address, ref, productType, subCat,
                                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                                    finish();
                                }

                            }

                            @Override
                            public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                            }
                        });
                    } else {
                        insert = myLeadDbController.updateLeadData(myNewLead.getId(), userName, myNewLead.getRefNumber(), myNewLead.getCusId(), myNewLead.getMobileId(), myNewLead.getVisitId(), myNewLead.getAddressId(), Integer.valueOf(LeadStageBasicInformationFragment.branchCode),
                                Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode), Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode), branchName, name, profession, organization,
                                designation, phone, address, ref, productType, subCat,
                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);

                        finish();
                    }

                } else {

                    if (isNetworkAvailable()) {

                        getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                            @Override
                            public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                                if (response.isSuccessful()) {
                                    if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                        Data data = response.body().getData();
                                        myLeadDbController.insertLeadData(data.getUserName(), data.getLeadReferenceNo(), data.getCustomerId(), data.getMobileNumberId(), data.getVisitId(), data.getAddressId(),
                                                data.getBranchCode(), data.getProductId(), data.getProductSubCategoryId(), branchName, name, profession, organization,
                                                designation, phone, address, ref, productType, subCat,
                                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.STATUS_NEW_PROSPECT, AppConstant.SYNC_STATUS_OK);
                                        if (visitPlan != null) {
                                            callActivityApi(visitPlan.getJournalId(), data.getLeadReferenceNo());
                                            leadApprove(data, myLeadDataModelApi.getProductId());
                                        } else {
                                            leadApprove(data, myLeadDataModelApi.getProductId());
                                        }
                                        finish();

                                    }
                                } else {
                                    myLeadDbController.insertLeadData(userName, "", 0, 0, 0, 0, Integer.valueOf(LeadStageBasicInformationFragment.branchCode),
                                            Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode), Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode), branchName, name, profession, organization,
                                            designation, phone, address, ref, productType, subCat,
                                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.STATUS_NEW_PROSPECT, AppConstant.SYNC_STATUS_WAIT);

                                    finish();

                                }

                            }

                            @Override
                            public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                            }
                        });
                    } else {
                        insert = myLeadDbController.insertLeadData(userName, "", 0, 0, 0, 0, Integer.valueOf(LeadStageBasicInformationFragment.branchCode),
                                Integer.valueOf(LeadStageLoanDetailFragment.productTypeCode), Integer.valueOf(LeadStageLoanDetailFragment.productSubCatCode), branchName, name, profession, organization,
                                designation, phone, address, ref, productType, subCat,
                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.STATUS_NEW_PROSPECT, AppConstant.SYNC_STATUS_WAIT);
                        finish();

                    }

                }
            } catch (Exception e) {
                showToast("" + e.getLocalizedMessage());

            }


//            android.app.AlertDialog.Builder builderAttach;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                builderAttach = new android.app.AlertDialog.Builder(LeadStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
//            } else {
//                builderAttach = new android.app.AlertDialog.Builder(LeadStageActivity.this);
//            }
//            builderAttach.setIcon(R.drawable.ic_required);
//            builderAttach.setTitle(Html.fromHtml("<font color='#FF0000'>Attachment can't be empty while proceed</font>"));
//            builderAttach.setNegativeButton("OK", null);
//            android.app.AlertDialog dialogAttach = builderAttach.create();
//            dialogAttach.show();


        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void leadApprove(Data data, int productId) {
        Approval myLeadApproval = new Approval(AppConstant.APPROVAL_LEAD,
                data.getLeadReferenceNo(),
                AppConstant.APPROVAL_SET_ID_0,
                AppConstant.APPROVAL_CURRWENT_LEVEL_1,
                AppConstant.APPROVAL_STATUS_YES, "",
                data.getUserName(), data.getBranchName(), productId);
        Log.d("TAG", "leadApprove: " + myLeadApproval.toString());
        getApiService().myleadApproval(myLeadApproval).enqueue(new Callback<ApprovalResponce>() {
            @Override
            public void onResponse(Call<ApprovalResponce> call, Response<ApprovalResponce> response) {
                Log.d("tag", "onResponse: " + response.body().toString());

                if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                    errorAlert(response.body().getStatus(), response.body().getMessage());
                } else {
                    errorAlert(response.body().getCode(), " Message: " + response.body().getMessage());
                    finish();

                }
            }

            @Override
            public void onFailure(Call<ApprovalResponce> call, Throwable t) {
                Toast.makeText(LeadStageActivity.this, "Lead approved failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void errorAlert(String title, String text) {

        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(LeadStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(LeadStageActivity.this);
        }
        builder.setTitle(title);
        builder.setMessage(text);

        builder.setPositiveButton("OK", (dialog, which) -> {
            finish();
        });


        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}
