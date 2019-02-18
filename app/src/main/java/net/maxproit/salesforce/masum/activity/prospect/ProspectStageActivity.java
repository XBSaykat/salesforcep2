package net.maxproit.salesforce.masum.activity.prospect;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.activity.lead.MyLeadActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.fragment.prospect.prospectstage.PropectStageAttachmentFragment;
import net.maxproit.salesforce.masum.fragment.prospect.prospectstage.ProspectStageCoApplicantFragment;
import net.maxproit.salesforce.masum.fragment.prospect.prospectstage.ProspectStageFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.prospectstage.ProspectStageLoanAndSecurityDetailFragment;
import net.maxproit.salesforce.masum.fragment.prospect.prospectstage.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.masum.model.local.CoApplicant;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.model.prospectmodel.OldPostpectResponse;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.masum.model.api.approval.Approval;
import net.maxproit.salesforce.model.mylead.approvalresponce.ApprovalResponce;
import net.maxproit.salesforce.model.newprospect.mynewprosppect.NewProspectUpdate;
import net.maxproit.salesforce.util.CommonUtil;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProspectStageActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyLeadDbController myLeadDbController;
    private String userName = null, userCode = null;
    private int exceptionListValue = 0;
    private PropectStageAttachmentFragment propectStageAttachmentFragment;
    private ProspectStageProductAndCustomerDetailsFragment prospectStageProductAndCustomerDetailsFragment;
    private ProspectStageLoanAndSecurityDetailFragment prospectStageLoanAndSecurityDetailFragment;
    private ProspectStageFinancialFragment prospectStageFinancialFragment;
    private ProspectStageCoApplicantFragment prospectStageCoApplicantFragment;
    private MyNewProspect prospect;
    private int producSubCode = 0;
    private String productCat = null, productDetails = null, mybranchName = null, segment = null, countOfBirth = null, districtOfBirth = null, profession = null,
            relationship = null, name = null, age = null, photoId = null, photoIdDate = null, eTin = null, fatherName = null, motherName = null, spouseName = null,
            companyName = null, designation = null, noYrsInCureentJob = null, presentAddress = null, permanentAddress = null, mobileNumber = null, brandName = null, year = null, country = null, vehicleType = null, securityValue = null, loanRequired = null, loanTerm = null, proposedInterest = null,
            fee = null, dateOfBirth = null, photoIdType = null, presentCity = null, presentPs = null, permanentCity = null, permanentPs = null, rmCode, monthlyNetSalaryType = null, businessIncome = null, monthlySalaryAmount = null, monthlyBusinessIncome = null, semiPakaIncome = null,
            officeIncome = null, wireHouseIncome = null, apartmentIncome = null, agriculturalIncome = null, practiceConsultancyTution = null, remittance = null, interestIncome = null,
            monthlyFamilyExpenditure = null, emiOfOtherLoans = null, validateString = null, titleName, titlefName = null, titlemName = null, titlesName = null;


    private TextView buttonSave, btnProceed, btnReject;
    private LinearLayout mLayout;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_lead_stage;
    }

    @Override
    protected void initComponents() {
        initLoader();
        showLoader();
        initFragment();
        localCash().put(SharedPreferencesEnum.Key.SEARCH_TYPE, "Prospect");
        btnProceed = findViewById(R.id.tv_activity_details_proceed_to_prospect);
        btnReject = findViewById(R.id.tv_activity_details_rejected);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Prospect Stage");
        setSupportActionBar(toolbar);
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        userCode = localCash().getString(SharedPreferencesEnum.Key.USER_CODE);

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
        buttonSave = findViewById(R.id.btnSave);
        mLayout = findViewById(R.id.btn_layout_lead);
        initListener();
        splashThread();
        setArgumentForFragment();


    }

    private void setArgumentForFragment() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, getDataFromProspect());
        propectStageAttachmentFragment.setArguments(bundle);
        prospectStageProductAndCustomerDetailsFragment.setArguments(bundle);
        prospectStageLoanAndSecurityDetailFragment.setArguments(bundle);
        prospectStageFinancialFragment.setArguments(bundle);
        prospectStageCoApplicantFragment.setArguments(bundle);
    }

    private void initFragment() {
        propectStageAttachmentFragment = new PropectStageAttachmentFragment();
        prospectStageProductAndCustomerDetailsFragment = new ProspectStageProductAndCustomerDetailsFragment();
        prospectStageLoanAndSecurityDetailFragment = new ProspectStageLoanAndSecurityDetailFragment();
        prospectStageFinancialFragment = new ProspectStageFinancialFragment();
        prospectStageCoApplicantFragment = new ProspectStageCoApplicantFragment();
    }

    @Override
    protected void getIntentData() {

    }

    private void initListener() {

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mapUtils.gpsChecker();
//                mapUtils.getLatLong();
                if (!isValid()) {
                    return;
                }

                if (!isNetworkAvailable()) {
                    showAlertDialog(getString(R.string.error_text), getString(R.string.proceed_unavailable));
                    return;
                }
                alertDialogProceed();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGpsLocation();
                if (getltd() == 0 && getLng() == 0) {
                    showAlertDialog(getString(R.string.reqired_txt), getString(R.string.enable_location));
                    return;
                }
                if (!isValid()) {
                    return;
                }
                alertDialogSave();
            }

        });


        btnReject.setOnClickListener(view -> {
            alertDialog(getDataFromProspect().getId());

        });

    }

    private void splashThread() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoader();

            }
        }, 3000);
    }

    private void getDataFromFragment() {
        if (ProspectStageFinancialFragment.monthlyNetSalaryType != null) {
            monthlyNetSalaryType = ProspectStageFinancialFragment.monthlyNetSalaryType;
        }
        if (ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString() != null) {
            monthlySalaryAmount = ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString();
        }
        if (ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString() != null) {
            monthlyBusinessIncome = ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString();
        }
        if (ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString() != null) {
            agriculturalIncome = ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString();

        }

        practiceConsultancyTution = ProspectStageFinancialFragment.etPracticeConsultancyTuition.getText().toString();
        remittance = ProspectStageFinancialFragment.etRemittance.getText().toString();
        interestIncome = ProspectStageFinancialFragment.etInterestIncome.getText().toString();
        monthlyFamilyExpenditure = ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
        emiOfOtherLoans = ProspectStageFinancialFragment.etEMIOfOtherLoans.getText().toString();

        semiPakaIncome = ProspectStageFinancialFragment.etSemipakaIncome.getText().toString();
        apartmentIncome = ProspectStageFinancialFragment.etApartmentIncomeAmount.getText().toString();
        officeIncome = ProspectStageFinancialFragment.etOfficeSpaceIncome.getText().toString();
        wireHouseIncome = ProspectStageFinancialFragment.etWarehouseIncome.getText().toString();

        practiceConsultancyTution = ProspectStageFinancialFragment.etPracticeConsultancyTuition.getText().toString();
        remittance = ProspectStageFinancialFragment.etRemittance.getText().toString();
        interestIncome = ProspectStageFinancialFragment.etInterestIncome.getText().toString();
        monthlyFamilyExpenditure = ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
        emiOfOtherLoans = ProspectStageFinancialFragment.etEMIOfOtherLoans.getText().toString();
        productCat = ProspectStageProductAndCustomerDetailsFragment.productCat;
        productDetails = ProspectStageProductAndCustomerDetailsFragment.productSub;
        mybranchName = ProspectStageProductAndCustomerDetailsFragment.branchName;
        segment = ProspectStageProductAndCustomerDetailsFragment.segment;
        producSubCode = ProspectStageProductAndCustomerDetailsFragment.productSubCatCode;
        countOfBirth = ProspectStageProductAndCustomerDetailsFragment.countOfBirth;
        dateOfBirth = ProspectStageProductAndCustomerDetailsFragment.etDob.getText().toString();
        districtOfBirth = ProspectStageProductAndCustomerDetailsFragment.districtOfBirth;
        profession = ProspectStageProductAndCustomerDetailsFragment.profession;
        relationship = ProspectStageProductAndCustomerDetailsFragment.relationship;
        name = ProspectStageProductAndCustomerDetailsFragment.etName.getText().toString();
        age = ProspectStageProductAndCustomerDetailsFragment.etAge.getText().toString();
        photoIdType = String.valueOf(ProspectStageProductAndCustomerDetailsFragment.photoIdcode);
        photoId = ProspectStageProductAndCustomerDetailsFragment.etPhotoId.getText().toString();
        photoIdDate = ProspectStageProductAndCustomerDetailsFragment.etPhotoIdDate.getText().toString();
        eTin = ProspectStageProductAndCustomerDetailsFragment.etETin.getText().toString();
        fatherName = ProspectStageProductAndCustomerDetailsFragment.etFatherName.getText().toString();
        motherName = ProspectStageProductAndCustomerDetailsFragment.etMotherName.getText().toString();
        spouseName = ProspectStageProductAndCustomerDetailsFragment.etSpouseName.getText().toString();
        companyName = ProspectStageProductAndCustomerDetailsFragment.etCompanyName.getText().toString();
        designation = ProspectStageProductAndCustomerDetailsFragment.etDesignation.getText().toString();
        noYrsInCureentJob = ProspectStageProductAndCustomerDetailsFragment.etNoYrsInCurrentJob.getText().toString();
        presentAddress = ProspectStageProductAndCustomerDetailsFragment.etPresentAddress.getText().toString();
        permanentAddress = ProspectStageProductAndCustomerDetailsFragment.etPermanentAddress.getText().toString();
        mobileNumber = ProspectStageProductAndCustomerDetailsFragment.etMobileNumber.getText().toString();
        presentCity = ProspectStageProductAndCustomerDetailsFragment.preCity;
        presentPs = ProspectStageProductAndCustomerDetailsFragment.prePoliceStation;
        permanentCity = ProspectStageProductAndCustomerDetailsFragment.perCity;
        permanentPs = ProspectStageProductAndCustomerDetailsFragment.perPoliceStation;
        exceptionListValue = ProspectStageProductAndCustomerDetailsFragment.exception;

        titleName = ProspectStageProductAndCustomerDetailsFragment.titleName;
        titlefName = ProspectStageProductAndCustomerDetailsFragment.titleF;
        titlemName = ProspectStageProductAndCustomerDetailsFragment.titleM;
        titlesName = ProspectStageProductAndCustomerDetailsFragment.titleS;


        brandName = ProspectStageLoanAndSecurityDetailFragment.brandName;
        year = ProspectStageLoanAndSecurityDetailFragment.etYear.getText().toString();
        country = ProspectStageLoanAndSecurityDetailFragment.etCountry.getText().toString();
        vehicleType = ProspectStageLoanAndSecurityDetailFragment.vehicleType;

        securityValue = ProspectStageLoanAndSecurityDetailFragment.etSecurityValue.getText().toString();
        loanRequired = ProspectStageLoanAndSecurityDetailFragment.etLoanRequired.getText().toString();
        loanTerm = ProspectStageLoanAndSecurityDetailFragment.etLoanTerm.getText().toString();
        proposedInterest = ProspectStageLoanAndSecurityDetailFragment.etProposedInterest.getText().toString();
        fee = ProspectStageLoanAndSecurityDetailFragment.etFee.getText().toString();


    }

    private void alertDialog(int id) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(ProspectStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(ProspectStageActivity.this);
        }
        builder.setTitle(getString(R.string.Reject));
        builder.setMessage(getString(R.string.reject_item));
        builder.setNegativeButton(getString(R.string.no), null);
        builder.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
            myLeadDbController.updateLeadDataStatus(id, AppConstant.LEAD_STATUS_REJECT);
            ActivityUtils.getInstance().invokeActivity(ProspectStageActivity.this, MyLeadActivity.class, true);
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public MyNewProspect getDataFromProspect() {

        MyNewProspect myNewLead = null;
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            Bundle bundle = new Bundle();
            myNewLead = (MyNewProspect) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
            mLayout.setVisibility(View.VISIBLE);
        }
        myNewLead.setFollowUp(CommonUtil.jsonToDate(myNewLead.getFollowUp()));

        return myNewLead;
    }

    private void setupViewPager(ViewPager viewPager) {
        ProspectStageActivity.ViewPagerAdapter adapter = new ProspectStageActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(prospectStageProductAndCustomerDetailsFragment, "Product & Customer Details");
        adapter.addFragment(prospectStageFinancialFragment, "Financials");
        adapter.addFragment(prospectStageLoanAndSecurityDetailFragment, "Loan & Security Detail");
        adapter.addFragment(propectStageAttachmentFragment, "Attachment");
        adapter.addFragment(prospectStageCoApplicantFragment, "Co-Applicant");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
        if (resultCode == AppConstant.ACTIVITY_RESULLT_200) {
            prospect = null;
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                prospect = (MyNewProspect) bundle.getSerializable(AppConstant.CO_APPLICANT_BUNDLE_KEY);
                Toast.makeText(getApplicationContext(), "co-applicant data saved", Toast.LENGTH_LONG).show();

            }

        } else if (resultCode == AppConstant.ACTIVITY_RESULLT_300) {
            Toast.makeText(getApplicationContext(), "co-applicant data saved", Toast.LENGTH_LONG).show();
        } else {
//            Toast.makeText(getApplicationContext(), "result not ok", Toast.LENGTH_LONG).show();

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void alertDialogSave() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this);
        }
        builder.setTitle(getString(R.string.save_txt));
        builder.setMessage(getString(R.string.save_alert));
        builder.setNegativeButton(getString(R.string.no), null);
        builder.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
            getDataFromFragment();

            if (getDataFromProspect() != null) {
                String ref = getDataFromProspect().getRefNumber();

                MyNewProspect myNewProspect = new MyNewProspect(
                        mybranchName,
                        name,
                        profession,
                        companyName,
                        designation,
                        mobileNumber, presentAddress,
                        getDataFromProspect().getSourceRef(),
                        productCat,
                        productDetails,
                        loanRequired,
                        proposedInterest,
                        fee,
                        getDataFromProspect().getVisitDate(),
                        getDataFromProspect().getDisDate(),
                        getDataFromProspect().getFollowUp(),
                        getDataFromProspect().getRemark(),
                        AppConstant.STATUS_NEW_PROSPECT,
                        segment, dateOfBirth, age, districtOfBirth,
                        countOfBirth, photoIdType, photoId, photoIdDate, eTin, fatherName,
                        motherName, spouseName, "", noYrsInCureentJob,
                        relationship, permanentAddress, monthlyNetSalaryType,
                        monthlySalaryAmount, monthlyBusinessIncome, apartmentIncome,
                        semiPakaIncome, officeIncome, wireHouseIncome,
                        agriculturalIncome, practiceConsultancyTution, remittance,
                        interestIncome, monthlyFamilyExpenditure, emiOfOtherLoans,
                        securityValue, loanRequired, loanTerm, proposedInterest,
                        fee);

                //set data for car loan
                myNewProspect.setManufacturingCountry(country);
                myNewProspect.setManufacturingYear(year);
                myNewProspect.setAssetType(vehicleType);
                myNewProspect.setAssetTypeId(ProspectStageLoanAndSecurityDetailFragment.assetId);
                myNewProspect.setManufacturingName(brandName);
                myNewProspect.setManufacturingNameId(ProspectStageLoanAndSecurityDetailFragment.manufactureNameID);
                myNewProspect.setExceptionList(exceptionListValue);

                myNewProspect.setTitleName(titleName);
                myNewProspect.setTitlefName(titlefName);
                myNewProspect.setTitlemName(titlemName);
                myNewProspect.setTitlesName(titlesName);


                try {
                    if (ProspectStageProductAndCustomerDetailsFragment.branchCode != null)
                        myNewProspect.setBranchCode(Integer.valueOf(ProspectStageProductAndCustomerDetailsFragment.branchCode));
                    myNewProspect.setProductCode(ProspectStageProductAndCustomerDetailsFragment.productTypeCode);
                } catch (NullPointerException e) {
                } catch (NumberFormatException e) {

                }
                myNewProspect.setRefNumber(getDataFromProspect().getRefNumber());
                myNewProspect.setContactId(getDataFromProspect().getContactId());
                myNewProspect.setCusId(getDataFromProspect().getCusId());
                myNewProspect.setMobileId(getDataFromProspect().getMobileId());
                myNewProspect.setPresAddressId(getDataFromProspect().getPresAddressId());
                myNewProspect.setPermAddressId(getDataFromProspect().getPermAddressId());
                myNewProspect.setPresAddressCity(presentCity);
                myNewProspect.setPresAddressPs(presentPs);
                myNewProspect.setPermAddressCity(permanentCity);
                myNewProspect.setPermAddressPs(permanentPs);
                myNewProspect.setSubCode(producSubCode);

                NewProspectUpdate newProspectUpdate = new NewProspectUpdate();
                newProspectUpdate.getPRospectDAtaForPostAPi(myNewProspect);
                String refNo = getDataFromProspect().getRefNumber();

                ArrayList<CoApplicant> coApplicantList = AppConstant.coAppLicantStaticList;
                newProspectUpdate.setCoApplicants(newProspectUpdate.setCoApplicantsFromProspect(coApplicantList));
                newProspectUpdate.setUserName(userName);
                if (isNetworkAvailable()) {
                    showProgressDialog();
                    getApiService().myNewProspect(newProspectUpdate).enqueue(new Callback<OldPostpectResponse>() {
                        @Override
                        public void onResponse(Call<OldPostpectResponse> call, Response<OldPostpectResponse> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getCode().equals(getString(R.string.success_code))) {
                                    if (!AppConstant.coAppLicantStaticList.isEmpty()) {
                                        coApplicantList.clear();
                                        AppConstant.coAppLicantStaticList.clear();
                                    }
                                    hideProgressDialog();
                                    sendGpsLocation(String.valueOf(response.body().getData().getLeadReferenceNo()), "Prospect", userName, getltd(), getLng(), getCompleteAddressString(getltd(), getLng()), ProspectStageActivity.this);
//                                errorAlert(getString(R.string.save_txt), "save successfully");

                                } else {
                                    if (!AppConstant.coAppLicantStaticList.isEmpty()) {
                                        coApplicantList.clear();
                                        AppConstant.coAppLicantStaticList.clear();
                                    }
                                    hideProgressDialog();
                                    errorAlert(getString(R.string.error_text) + " " + response.body().getCode(), response.body().getMessage());
                                }
                            } else {
                                showAlertDialog(getString(R.string.error_text) + " " + response.code(), getString(R.string.prospect_save_failed) + "\n" + response.message());
                                hideProgressDialog();
                            }

                        }

                        @Override
                        public void onFailure(Call<OldPostpectResponse> call, Throwable t) {
                            errorAlert(getString(R.string.error_text), t.getMessage());
                            hideProgressDialog();
                            if (!AppConstant.coAppLicantStaticList.isEmpty()) {
                                coApplicantList.clear();
                                AppConstant.coAppLicantStaticList.clear();
                            }
                        }
                    });
                } else {
                    showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));
                }
            }


        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void alertDialogProceed() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this);
        }
        builder.setTitle(getString(R.string.proceed_txt));
        builder.setMessage(getString(R.string.proceed_alert));
        builder.setNegativeButton(getString(R.string.no), null);
        builder.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
            getDataFromFragment();
            if (getDataFromProspect() != null) {
                String ref = getDataFromProspect().getRefNumber();
                MyNewProspect myNewProspect = new MyNewProspect(
                        mybranchName,
                        name,
                        profession,
                        companyName,
                        designation,
                        mobileNumber, presentAddress,
                        getDataFromProspect().getSourceRef(),
                        productCat,
                        productDetails,
                        loanRequired,
                        proposedInterest,
                        fee,
                        getDataFromProspect().getVisitDate(),
                        getDataFromProspect().getDisDate(),
                        getDataFromProspect().getFollowUp(),
                        getDataFromProspect().getRemark(),
                        AppConstant.STATUS_RBM,
                        segment, dateOfBirth, age, districtOfBirth,
                        countOfBirth, photoIdType, photoId, photoIdDate, eTin, fatherName,
                        motherName, spouseName, "", noYrsInCureentJob,
                        relationship, permanentAddress, monthlyNetSalaryType,
                        monthlySalaryAmount, monthlyBusinessIncome, apartmentIncome,
                        semiPakaIncome, officeIncome, wireHouseIncome,
                        agriculturalIncome, practiceConsultancyTution, remittance,
                        interestIncome, monthlyFamilyExpenditure, emiOfOtherLoans,
                        securityValue, loanRequired, loanTerm, proposedInterest,
                        fee);

                myNewProspect.setManufacturingCountry(country);
                myNewProspect.setManufacturingYear(year);
                myNewProspect.setAssetType(vehicleType);
                myNewProspect.setAssetTypeId(ProspectStageLoanAndSecurityDetailFragment.assetId);
                myNewProspect.setManufacturingName(brandName);
                myNewProspect.setManufacturingNameId(ProspectStageLoanAndSecurityDetailFragment.manufactureNameID);
                myNewProspect.setExceptionList(exceptionListValue);

                try {
                    if (ProspectStageProductAndCustomerDetailsFragment.branchCode != null)
                        myNewProspect.setBranchCode(Integer.valueOf(ProspectStageProductAndCustomerDetailsFragment.branchCode));
                    myNewProspect.setProductCode(ProspectStageProductAndCustomerDetailsFragment.productTypeCode);
                } catch (NullPointerException e) {
                } catch (NumberFormatException e) {

                }
                myNewProspect.setUserCode(userCode);
                myNewProspect.setRefNumber(getDataFromProspect().getRefNumber());
                myNewProspect.setContactId(getDataFromProspect().getContactId());
                myNewProspect.setCusId(getDataFromProspect().getCusId());
                myNewProspect.setMobileId(getDataFromProspect().getMobileId());
                myNewProspect.setAssetTypeId(getDataFromProspect().getAssetTypeId());
                myNewProspect.setPresAddressId(getDataFromProspect().getPresAddressId());
                myNewProspect.setPermAddressId(getDataFromProspect().getPermAddressId());
                myNewProspect.setUserID(getDataFromProspect().getUserID());
                myNewProspect.setSubCode(producSubCode);
                myNewProspect.setPresAddressCity(presentCity);
                myNewProspect.setPresAddressPs(presentPs);
                myNewProspect.setPermAddressCity(permanentCity);
                myNewProspect.setPermAddressPs(permanentPs);
                myNewProspect.setTitleName(titleName);
                myNewProspect.setTitlefName(titlefName);
                myNewProspect.setTitlemName(titlemName);
                myNewProspect.setTitlesName(titlesName);

                NewProspectUpdate newProspectUpdate = new NewProspectUpdate();
                newProspectUpdate.getPRospectDAtaForPostAPi(myNewProspect);

                ArrayList<CoApplicant> coApplicantList = AppConstant.coAppLicantStaticList;
                newProspectUpdate.setCoApplicants(newProspectUpdate.setCoApplicantsFromProspect(coApplicantList));
                if (isNetworkAvailable()) {
                    showProgressDialog();
                    getApiService().myNewProspect(newProspectUpdate).enqueue(new Callback<OldPostpectResponse>() {
                        @Override
                        public void onResponse(Call<OldPostpectResponse> call, Response<OldPostpectResponse> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getCode().equals(getString(R.string.success_code))) {
                                    net.maxproit.salesforce.masum.model.prospectmodel.Data data = response.body().getData();
                                    leadApprove(data, newProspectUpdate.getProductId());
                                    if (!AppConstant.coAppLicantStaticList.isEmpty()) {
                                        coApplicantList.clear();
                                        AppConstant.coAppLicantStaticList.clear();
                                    }


                                } else {
                                    errorAlert(response.body().getCode(), response.body().getMessage());
                                    if (!AppConstant.coAppLicantStaticList.isEmpty()) {
                                        coApplicantList.clear();
                                        AppConstant.coAppLicantStaticList.clear();
                                    }
                                    hideProgressDialog();

                                }
                            } else {
                                showAlertDialog(getString(R.string.error_text) + " " + response.code(), getString(R.string.prospect_save_failed) + "\n " + response.message());
                            }

                        }

                        @Override
                        public void onFailure(Call<OldPostpectResponse> call, Throwable t) {
                            errorAlert(getResources().getString(R.string.error_text), t.getMessage());
                            hideProgressDialog();
                            if (!AppConstant.coAppLicantStaticList.isEmpty()) {
                                coApplicantList.clear();
                                AppConstant.coAppLicantStaticList.clear();
                            }
                        }
                    });
                }


               /* int update = myLeadDbController.upDateProspectData(myNewProspect, getDataFromProspect().getId());

                if (update > 0) {

                }*/
            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
//String approvalType, String referenceNo, int approvalSetID, int currentLevel,
// String status, String remark, String user, String branch, int productId

    private void leadApprove(net.maxproit.salesforce.masum.model.prospectmodel.Data data, int productId) {
        Approval myLeadApproval = new Approval(AppConstant.APPROVAL_PROSPECT,
                data.getLeadReferenceNo(),
                AppConstant.APPROVAL_SET_ID_0,
                AppConstant.APPROVAL_CURRWENT_LEVEL_1,
                AppConstant.APPROVAL_PROSPECT_STATUS_YES, "",
                userName, data.getBranchName(), productId);
        getApiService().myprospectApproval(myLeadApproval).enqueue(new Callback<ApprovalResponce>() {
            @Override
            public void onResponse(Call<ApprovalResponce> call, Response<ApprovalResponce> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals(getString(R.string.success_code)) && response.body().getStatus().equalsIgnoreCase("ok")) {
                        hideProgressDialog();
                        errorAlert(getString(R.string.succes_txt), getString(R.string.prospect_approved));

                    } else {
                        hideProgressDialog();
                        errorAlert(response.body().getCode(), response.body().getMessage());
                    }
                } else
                    errorAlert(getString(R.string.error_text) + " " + response.code(), getString(R.string.proceed_failed) + "\n" + response.message());
            }

            @Override
            public void onFailure(Call<ApprovalResponce> call, Throwable t) {
                hideProgressDialog();
                errorAlert(getString(R.string.error_text), t.getMessage());

            }
        });
    }

    private void errorAlert(String title, String text) {

        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this);
        }
        builder.setTitle(title);
        builder.setMessage(text);

        builder.setPositiveButton("OK", (dialog, which) -> {
            finish();
        });


        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private boolean isValid() {
        boolean validation = true;

        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.productCat)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Product Category");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.productSub)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Product Sub Category");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.branchName)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Branch Name");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etName.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Name");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.segment)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Segment");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etDob.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Date of Birth");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.districtOfBirth)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter District of Birth");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.countOfBirth)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Country of Birth");
            return false;
        }
        if (MasumCommonUtils.isNullStr(String.valueOf(ProspectStageProductAndCustomerDetailsFragment.photoIdcode))) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Photo ID type");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etPhotoId.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Photo ID No.");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etFatherName.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Father Name");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etMotherName.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Mother Name");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.profession)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Profession");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etPermanentAddress.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Permanent Address");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.perCity)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Permanent City");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.perPoliceStation)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Permanent Police Station");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etPresentAddress.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Present Address");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.preCity)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Present City");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.prePoliceStation)) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Present Police Station");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageProductAndCustomerDetailsFragment.etMobileNumber.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Mobile Number");
            return false;
        }
        if (MasumCommonUtils.isNullStr(ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString())) {
            showAlertDialog(getString(R.string.reqired_txt), "Enter Monthly Family Expenditure");
            return false;
        }

        return validation;
    }

}
