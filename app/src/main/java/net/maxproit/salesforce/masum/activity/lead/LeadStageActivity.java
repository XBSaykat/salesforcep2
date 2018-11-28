package net.maxproit.salesforce.masum.activity.lead;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.App;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;

import net.maxproit.salesforce.masum.appdata.sqlite.AttachmentDbController;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageAttachmentFragment;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageBasicInformationFragment;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageLoanDetailFragment;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageVisitRecordFragment;
import net.maxproit.salesforce.masum.model.api.Data;
import net.maxproit.salesforce.masum.model.api.MyLeadByRefApi;
import net.maxproit.salesforce.masum.model.api.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.api.MyOldLeadApi;
import net.maxproit.salesforce.masum.model.local.Attachment;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.appdata.AppConstant;

import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.ImageUtils;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadStageActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView btnSave, btnProceed, btnReject, btnReAppoint;
    private MyLeadDbController myLeadDbController;
    private AttachmentDbController attachmentDbController;
    private ArrayList<VisitPlan> visitPlanArrayList;
    private VisitPlanDbController visitPlanDbController;
    private LeadStageBasicInformationFragment leadStageBasicInformationFragment;
    private LeadStageAttachmentFragment leadStageAttachmentFragment;
    private LeadStageVisitRecordFragment leadStageVisitRecordFragment;
    private LeadStageLoanDetailFragment leadStageLoanDetailFragment;
    private LinearLayout mLayout;
    private MyLeadDataModelApi myLeadDataModelApi = null;
    private String branchName = null, profession = null, name = null, organization = null, designation = null, phone = null, address = null, loanAmount = null, interest = null, fee = null, ref = null, productType = null, subCat = null, disDate = null, visitDate = null, remark = null, followUp = null;
    private String userName = null;
    private int activityPosition;
    public static int myLeadPosition = -1;
    public static VisitPlan visitPlan = null;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_lead_stage;

    }

    @Override
    protected void initComponents() {
        myLeadDataModelApi = new MyLeadDataModelApi();
        initFragments();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Lead");
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
        viewPager.setOffscreenPageLimit(4);
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


    private void initFragments() {
        leadStageAttachmentFragment = new LeadStageAttachmentFragment();
        leadStageBasicInformationFragment = new LeadStageBasicInformationFragment();
        leadStageLoanDetailFragment = new LeadStageLoanDetailFragment();
        leadStageVisitRecordFragment = new LeadStageVisitRecordFragment();
    }

    private void setFieldsFromActivity() {


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(leadStageBasicInformationFragment, "Basic Information");
        adapter.addFragment(leadStageLoanDetailFragment, "Loan Detail");
        adapter.addFragment(leadStageVisitRecordFragment, "Visit Record");
        adapter.addFragment(leadStageAttachmentFragment, "Attachment");
        viewPager.setAdapter(adapter);
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
        VisitPlan visitPlan = null;
        String refId = null;
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            int status = extraDetail.getInt(AppConstant.STATUS_INTENT_KEY, -1);
            Bundle bundle = new Bundle();
            if (status == 0) {
                visitPlan = (VisitPlan) extraDetail.getSerializable(AppConstant.INTENT_KEY);
                bundle.putSerializable(AppConstant.INTENT_KEY, visitPlan);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY, 0);
            } else if (status == 1) {
                refId = extraDetail.getString(AppConstant.INTENT_KEY);
                bundle.putString(AppConstant.INTENT_KEY, refId);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY, 1);
                mLayout.setVisibility(View.VISIBLE);

            }

            leadStageBasicInformationFragment.setArguments(bundle);
            leadStageLoanDetailFragment.setArguments(bundle);
            leadStageVisitRecordFragment.setArguments(bundle);

        }

        String finalRefId = refId;
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  alertDialogProceed(finalRefId);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // alertDialogSave(finalRefId);
            }
        });


        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if (finalMyNewLead != null) {
                    alertDialog(finalMyNewLead.getId());
                }*/
            }
        });

    }

    private MyLeadDataModelApi getDataFromFragment(String refId) {
        branchName = LeadStageBasicInformationFragment.branchName; //
        profession = LeadStageBasicInformationFragment.profession; //
        name = LeadStageBasicInformationFragment.etUserName.getText().toString(); //
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
        visitDate = LeadStageVisitRecordFragment.etVisitDate.getText().toString(); //
        if (LeadStageVisitRecordFragment.etRemark.getText().toString() != null) {
            remark = LeadStageVisitRecordFragment.etRemark.getText().toString();
        } else {
            LeadStageVisitRecordFragment.spinnerRemarks.getSelectedItem();
        }

        followUp = LeadStageVisitRecordFragment.spinnerFollowUp.getSelectedItem();
        //api integate
        MyLeadDataModelApi myLeadApi = new MyLeadDataModelApi();
        //api for proceed lead first time
        myLeadApi.setLeadReferenceNo("");
        myLeadApi.setRmCode("336132");
        myLeadApi.setUserName(userName);
        myLeadApi.setBranchName(branchName);
        myLeadApi.setBranchCode(Integer.valueOf(LeadStageBasicInformationFragment.branchCode));
        myLeadApi.setCustomerName(name);
        myLeadApi.setCustomerId(0);
        myLeadApi.setProfession(profession);
        myLeadApi.setOrganization(organization);
        myLeadApi.setDesignation(designation);
        myLeadApi.setMobileNumberId(0);
        myLeadApi.setMobileNumber(phone);
        myLeadApi.setAddressId(0);
        myLeadApi.setAddress(address);
        myLeadApi.setSourceOfReference(ref);
        myLeadApi.setProductId(LeadStageLoanDetailFragment.productTypeCode);
        myLeadApi.setProduct(productType);
        myLeadApi.setProductSubCategoryId(LeadStageLoanDetailFragment.productSubCatCode);
        myLeadApi.setProductSubCategory(subCat);
        if (loanAmount != null)
            myLeadApi.setLoanAmount(Integer.valueOf(loanAmount.replace(",", "")));
        else
            myLeadApi.setLoanAmount(0);
        if (interest != null)
            myLeadApi.setOfferedInterestRate(Integer.valueOf(interest));
        else
            myLeadApi.setOfferedInterestRate(0);
        if (fee != null)
            myLeadApi.setOfferedProcessFee(Integer.valueOf(fee));
        else
            myLeadApi.setOfferedProcessFee(0);
        myLeadApi.setDisbursementDate(DateUtils.getDateFormateForSqlite(disDate));
        myLeadApi.setVisitId(0);
        myLeadApi.setFollowUp(followUp);
        myLeadApi.setFollowUpDate(DateUtils.getDateFormateForSqlite(visitDate));
        myLeadApi.setRemark(remark);
        if (refId != null) {
            myLeadApi.setLeadReferenceNo(refId);
        } else {
            myLeadApi.setLeadReferenceNo("");
        }

        return myLeadApi;
    }

    private void insertAttachmentData(int insert, final MyNewProspect myNewProspect) {
        byte[] bytesAtachpp = null;
        byte[] bytesAtachIdCard = null;
        byte[] bytesAtachVCard = null;
        if (leadStageAttachmentFragment.attachPp != null
                && leadStageAttachmentFragment.attachIdcard != null
                && leadStageAttachmentFragment.attachvCard != null) {


            bytesAtachpp = ImageUtils.imagetoByte(LeadStageAttachmentFragment.attachPp);
            bytesAtachIdCard = ImageUtils.imagetoByte(LeadStageAttachmentFragment.attachIdcard);
            bytesAtachVCard = ImageUtils.imagetoByte(LeadStageAttachmentFragment.attachvCard);
            int insertAttach = 0;
            if (myNewProspect != null) {
                if (attachmentDbController.getAllData(String.valueOf(myNewProspect.getId())).size() > 0) {
                    Attachment attachment = new Attachment(insert, bytesAtachpp, bytesAtachIdCard, bytesAtachVCard);
                    insertAttach = attachmentDbController.updateData(attachment);
                } else {
                    insertAttach = attachmentDbController.insertData(insert, bytesAtachpp, bytesAtachIdCard, bytesAtachVCard);
                }
            } else {
                insertAttach = attachmentDbController.insertData(insert, bytesAtachpp, bytesAtachIdCard, bytesAtachVCard);

            }
            if (insertAttach > 0) {
                Toast.makeText(LeadStageActivity.this, "Attach data save successfully", Toast.LENGTH_SHORT).show();
                ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, DashboardSalesOfficerActivity.class, true);

            } else {
                Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
            }
        }
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

    private void alertDialogSave(final String refId) {


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
            MyLeadDataModelApi myLeadDataModelApi = getDataFromFragment(refId);

            if (refId != null) {
                if (isNetworkAvailable()) {
                    //api call
                    getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                        @Override
                        public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                    int insert = myLeadDbController.updateLeadData(userName, refId,0,0,0,0, branchName, name, profession, organization,
                                            designation, phone, address, ref, productType, subCat,
                                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_OK);
                                    if (insert > 0) {
                                        Log.e("data","update into local and server");
                                        ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                        //insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);

                                    } else {
                                        Log.e("data","failed into local but update to server");
                                    }
                                }
                            } else {
                                int insert = myLeadDbController.updateLeadData(userName, refId,0,0,0,0, branchName, name, profession, organization,
                                        designation, phone, address, ref, productType, subCat,
                                        loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                                if (insert > 0) {
                                    Log.e("data","internet not connected update into local");
                                    ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                    //insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);

                                } else {
                                    Log.e("data save","internet not connected also failed into local");

                                }

                            }

                        }

                        @Override
                        public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                        }
                    });

                } else {
                    int insert = myLeadDbController.updateLeadData(userName, refId,0,0,0,0,branchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                    if (insert > 0) {
                        Log.e("data","internet not connected  update into local");
                        ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                        //insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);

                    } else {
                        Log.e("data","internet not connected also failed into local");
                    }
                }


            } else {

                if (isNetworkAvailable()) {

                    getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                        @Override
                        public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                    Data data=response.body().getData();
                                    int insert = myLeadDbController.insertLeadData(data.getUserName(), data.getLeadReferenceNo(),data.getCustomerId(),data.getMobileNumberId(),data.getVisitId(),data.getAddressId(), branchName, name, profession, organization,
                                            designation, phone, address, ref, productType, subCat,
                                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_OK);
                                    if (insert > 0) {
                                        ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                        Log.e("data","internet  connected also save into local and server");

                                        insertAttachmentData(insert, null);

                                    } else {
                                        Log.e("data","internet  connected save failed into local but save into server");

                                    }
                                }
                            } else {
                                int insert = myLeadDbController.insertLeadData(userName, "",0,0,0,0, branchName, name, profession, organization,
                                        designation, phone, address, ref, productType, subCat,
                                        loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                                if (insert > 0) {
                                    ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                    Log.e("data","internet connected save into local failed into server");
                                    insertAttachmentData(insert, null);

                                } else {
                                    Log.e("data","internet  connected also failed into local and server");
                                }


                            }

                        }

                        @Override
                        public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                        }
                    });
                } else {
                    int insert = myLeadDbController.insertLeadData(userName, "",0,0,0,0, branchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                    if (insert > 0) {
                        ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                        Log.e("data","internet not connected  save into local");
                        insertAttachmentData(insert, null);

                    } else {
                        Log.e("data","internet not connected  failed into local");
                    }
                }

            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void alertDialogProceed(final String refId) {


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
            MyLeadDataModelApi myLeadDataModelApi = getDataFromFragment(refId);
            int insert = 0;
            if (leadStageAttachmentFragment.attachPp != null
                    && leadStageAttachmentFragment.attachIdcard != null
                    && leadStageAttachmentFragment.attachvCard != null) {
                if (refId != null) {
                    if (isNetworkAvailable()) {
                        getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                            @Override
                            public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                                if (response.isSuccessful()) {
                                    if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                        int insert = myLeadDbController.updateLeadData(userName, refId, 0,0,0,0,branchName, name, profession, organization,
                                                designation, phone, address, ref, productType, subCat,
                                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_OK);
                                        if (insert > 0) {
                                            Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                                            ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                            //insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);

                                        } else {
                                            Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
                                    int insert = myLeadDbController.updateLeadData(userName, refId,0,0, 0,0,branchName, name, profession, organization,
                                            designation, phone, address, ref, productType, subCat,
                                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                                    if (insert > 0) {
                                        Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                                        ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                        //insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);

                                    } else {
                                        Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                                    }

                                }

                            }

                            @Override
                            public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                            }
                        });
                    } else {
                        insert = myLeadDbController.updateLeadData(userName, refId,0,0,0,0, branchName, name, profession, organization,
                                designation, phone, address, ref, productType, subCat,
                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW, AppConstant.SYNC_STATUS_WAIT);
                        if (insert > 0) {
                            Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                            ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                            //insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);

                        } else {
                            Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                        }
                    }


                    // insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);
                } else {

                    if (isNetworkAvailable()) {

                        getApiService().createMyLead(myLeadDataModelApi).enqueue(new Callback<MyOldLeadApi>() {
                            @Override
                            public void onResponse(Call<MyOldLeadApi> call, Response<MyOldLeadApi> response) {
                                if (response.isSuccessful()) {
                                    if (response.body().getCode().equals("200") && response.body().getStatus().equalsIgnoreCase("ok")) {
                                        Data data=response.body().getData();
                                        int insert = myLeadDbController.insertLeadData(data.getUserName(), data.getLeadReferenceNo(),data.getCustomerId(),data.getMobileNumberId(),data.getVisitId(),data.getAddressId(), branchName, name, profession, organization,
                                                designation, phone, address, ref, productType, subCat,
                                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.STATUS_NEW_PROSPECT, AppConstant.SYNC_STATUS_OK);
                                        if (insert > 0) {
                                            ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                            Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                                            insertAttachmentData(insert, null);

                                        } else {
                                            Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
                                    int insert = myLeadDbController.insertLeadData(userName, "",0,0,0,0, branchName, name, profession, organization,
                                            designation, phone, address, ref, productType, subCat,
                                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.STATUS_NEW_PROSPECT, AppConstant.SYNC_STATUS_WAIT);
                                    if (insert > 0) {
                                        ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                                        Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                                        insertAttachmentData(insert, null);

                                    } else {
                                        Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                                    }

                                }

                            }

                            @Override
                            public void onFailure(Call<MyOldLeadApi> call, Throwable t) {

                            }
                        });
                    } else {
                        insert = myLeadDbController.insertLeadData(userName, "",0,0,0,0, branchName, name, profession, organization,
                                designation, phone, address, ref, productType, subCat,
                                loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.STATUS_NEW_PROSPECT, AppConstant.SYNC_STATUS_WAIT);
                        if (insert > 0) {
                            ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
                            Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                            insertAttachmentData(insert, null);

                        } else {
                            Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

                if (insert > 0) {

                    Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                android.app.AlertDialog.Builder builderAttach;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builderAttach = new android.app.AlertDialog.Builder(LeadStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                } else {
                    builderAttach = new android.app.AlertDialog.Builder(LeadStageActivity.this);
                }
                builderAttach.setIcon(R.drawable.ic_required);
                builderAttach.setTitle(Html.fromHtml("<font color='#FF0000'>Attachment can't be empty while proceed</font>"));
                builderAttach.setNegativeButton("OK", null);
                android.app.AlertDialog dialogAttach = builderAttach.create();
                dialogAttach.show();
            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

}
