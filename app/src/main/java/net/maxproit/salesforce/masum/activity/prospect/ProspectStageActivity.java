package net.maxproit.salesforce.masum.activity.prospect;

import android.content.Intent;
import android.app.AlertDialog;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce.masum.activity.lead.MyLeadActivity;
import net.maxproit.salesforce.masum.adapter.adapter.CoApplicantListAdapter;
import net.maxproit.salesforce.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageCoApplicantFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageLoanAndSecurityDetailFragment;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.model.CoApplicant;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.model.MyNewLead;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

public class ProspectStageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    MyLeadDbController myLeadDbController;
    CoApplicantDBController coApplicantDBController;
    public static int CO_APPLICANT_REQUEST_CODE = 1;
    MyNewProspect coApplicant;
    String productCat = null, productDetails = null, mybranchName = null, segment = null, countOfBirth = null, districtOfBirth = null, profession = null,
            relationship = null, name = null, age = null, photoId = null, photoIdDate = null, eTin = null, fatherName = null, motherName = null, spouseName = null,
            companyName = null, designation = null, noYrsInCureentJob = null, presentAddress = null, permanentAddress = null, mobileNumber = null;
    String brandName = null, year = null, country = null, vehicleType = null, securityValue = null, loanRequired = null, loanTerm = null, proposedInterest = null,
            fee = null, calculatedGrossIncome = null;
    String monthlyNetSalary = null, rentalIncome = null, monthlySalaryAmount = null, monthlyBusinessIncome = null, etMonthlyRentalAmount = null,
            agriculturalIncome = null, practiceConsultancyTution = null, remittance = null, interestIncome = null,
            monthlyFamilyExpenditure = null, emiOfOtherLoans = null;
    ArrayList<CoApplicant> coApplicantArrayList;
    CoApplicantListAdapter coApplicantAdapter;



    private TextView buttonSave, btnProceed, btnReject;
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_stage);
        btnProceed = findViewById(R.id.tv_activity_details_proceed_to_prospect);
        btnReject = findViewById(R.id.tv_activity_details_rejected);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Prospect Stage");
        setSupportActionBar(toolbar);
        myLeadDbController = new MyLeadDbController(ProspectStageActivity.this);
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
    }

    private void initListener() {

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    monthlyNetSalary = ProspectStageFinancialFragment.monthlyNetSalary;

                    monthlySalaryAmount = ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString();
                    monthlyBusinessIncome = ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString();
                    agriculturalIncome = ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString();
                    practiceConsultancyTution = ProspectStageFinancialFragment.etPracticeConsultancyTuition.getText().toString();
                    remittance = ProspectStageFinancialFragment.etRemittance.getText().toString();
                    interestIncome = ProspectStageFinancialFragment.etInterestIncome.getText().toString();
                    monthlyFamilyExpenditure = ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
                    emiOfOtherLoans = ProspectStageFinancialFragment.etEMIOfOtherLoans.getText().toString();
                monthlySalaryAmount = ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString();
                monthlyBusinessIncome = ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString();
//                etMonthlyRentalAmount = ProspectStageFinancialFragment.etMonthlyRentalAmount.getText().toString();
                etMonthlyRentalAmount = "";
                agriculturalIncome = ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString();
                practiceConsultancyTution = ProspectStageFinancialFragment.etPracticeConsultancyTuition.getText().toString();
                remittance = ProspectStageFinancialFragment.etRemittance.getText().toString();
                interestIncome = ProspectStageFinancialFragment.etInterestIncome.getText().toString();
                monthlyFamilyExpenditure = ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
                emiOfOtherLoans = ProspectStageFinancialFragment.etEMIOfOtherLoans.getText().toString();


                    productCat = ProspectStageProductAndCustomerDetailsFragment.productCat;
//


//                <<<<<< ProspectStageProductAndCustomerDetailsFragment >>>>>>>
                    productCat = ProspectStageProductAndCustomerDetailsFragment.productCat;
                    productDetails = ProspectStageProductAndCustomerDetailsFragment.productDetails;
                    mybranchName = ProspectStageProductAndCustomerDetailsFragment.branchName;
                    segment = ProspectStageProductAndCustomerDetailsFragment.segment;
                    countOfBirth = ProspectStageProductAndCustomerDetailsFragment.countOfBirth;
                    districtOfBirth = ProspectStageProductAndCustomerDetailsFragment.districtOfBirth;
                    profession = ProspectStageProductAndCustomerDetailsFragment.profession;
                    relationship = ProspectStageProductAndCustomerDetailsFragment.relationship;

                    name = ProspectStageProductAndCustomerDetailsFragment.etName.getText().toString();
                    age = ProspectStageProductAndCustomerDetailsFragment.etAge.getText().toString();
                    photoId = ProspectStageProductAndCustomerDetailsFragment.etPhotoId.getText().toString();
                    photoIdDate = ProspectStageProductAndCustomerDetailsFragment.etName.getText().toString();
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
                    brandName = ProspectStageLoanAndSecurityDetailFragment.brandName;
                    year = ProspectStageLoanAndSecurityDetailFragment.year;
                    country = ProspectStageLoanAndSecurityDetailFragment.country;
                    vehicleType = ProspectStageLoanAndSecurityDetailFragment.vehicleType;
                    securityValue = ProspectStageLoanAndSecurityDetailFragment.etSecurityValue.getText().toString();
                    loanRequired = ProspectStageLoanAndSecurityDetailFragment.etLoanRequired.getText().toString();
                    loanTerm = ProspectStageLoanAndSecurityDetailFragment.etLoanRequired.getText().toString();
                    proposedInterest = ProspectStageLoanAndSecurityDetailFragment.etProposedInterest.getText().toString();
                    fee = ProspectStageLoanAndSecurityDetailFragment.etFee.getText().toString();
                } catch (NullPointerException e) {

                }
                    calculatedGrossIncome = "";
                    if (getDataFromProspect() != null) {
                        MyNewProspect myNewProspect = new MyNewProspect(
                                getDataFromProspect().getBranchName(),
                                getDataFromProspect().getUserName(),
                                getDataFromProspect().getProfession(),
                                getDataFromProspect().getOrganization(),
                                getDataFromProspect().getDesignation(),
                                mobileNumber, presentAddress,
                                getDataFromProspect().getSourceRef(),
                                getDataFromProspect().getProductType(),
                                getDataFromProspect().getProductSubcategory(),
                                getDataFromProspect().getLoanAmount(),
                                getDataFromProspect().getOrInterest(),
                                getDataFromProspect().getOpFee(),
                                getDataFromProspect().getVisitDate(),
                                getDataFromProspect().getDisDate(),
                                getDataFromProspect().getFollowUp(),
                                getDataFromProspect().getRemark(),
                                AppConstant.STATUS_RBM,
                                productCat, productDetails,
                                segment, age, districtOfBirth,
                                countOfBirth, photoId, photoIdDate, eTin, fatherName,
                                motherName, spouseName, "", noYrsInCureentJob,
                                relationship, permanentAddress, monthlyNetSalary,
                                monthlySalaryAmount, rentalIncome, etMonthlyRentalAmount,
                                agriculturalIncome, practiceConsultancyTution, remittance,
                                interestIncome, monthlyFamilyExpenditure, emiOfOtherLoans,
                                securityValue, loanRequired, loanTerm, proposedInterest,
                                fee, "");

                        int update = myLeadDbController.upDateProspectData(myNewProspect, getDataFromProspect().getId());
                        if (update > 0) {
                            Toast.makeText(ProspectStageActivity.this, "save successfully", Toast.LENGTH_SHORT).show();
                            ActivityUtils.getInstance().invokeActivity(ProspectStageActivity.this, DashboardSalesOfficerActivity.class, true);
                        } else {
                            Toast.makeText(ProspectStageActivity.this, "failed", Toast.LENGTH_SHORT).show();

                        }
                    }

//



            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(ProspectStageFinancialFragment.monthlyNetSalary !=null){
                        monthlyNetSalary = ProspectStageFinancialFragment.monthlyNetSalary;
                    }
                    if (ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString() !=null){
                        monthlySalaryAmount = ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString();
                    }  if (ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString() !=null){
                    monthlyBusinessIncome = ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString();
                    }
                      if (ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString() !=null){
                          agriculturalIncome = ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString();

                      }


                    practiceConsultancyTution = ProspectStageFinancialFragment.etPracticeConsultancyTuition.getText().toString();
                    remittance = ProspectStageFinancialFragment.etRemittance.getText().toString();
                    interestIncome = ProspectStageFinancialFragment.etInterestIncome.getText().toString();
                    monthlyFamilyExpenditure = ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
                    emiOfOtherLoans = ProspectStageFinancialFragment.etEMIOfOtherLoans.getText().toString();


                    productCat = ProspectStageProductAndCustomerDetailsFragment.productCat;
//


//                <<<<<< ProspectStageProductAndCustomerDetailsFragment >>>>>>>
                    productCat = ProspectStageProductAndCustomerDetailsFragment.productCat;
                    productDetails = ProspectStageProductAndCustomerDetailsFragment.productDetails;
                    mybranchName = ProspectStageProductAndCustomerDetailsFragment.branchName;
                    segment = ProspectStageProductAndCustomerDetailsFragment.segment;
                    countOfBirth = ProspectStageProductAndCustomerDetailsFragment.countOfBirth;
                    districtOfBirth = ProspectStageProductAndCustomerDetailsFragment.districtOfBirth;
                    profession = ProspectStageProductAndCustomerDetailsFragment.profession;
                    relationship = ProspectStageProductAndCustomerDetailsFragment.relationship;

                    name = ProspectStageProductAndCustomerDetailsFragment.etName.getText().toString();
                    age = ProspectStageProductAndCustomerDetailsFragment.etAge.getText().toString();
                    photoIdDate = ProspectStageProductAndCustomerDetailsFragment.etName.getText().toString();
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
                    brandName = ProspectStageLoanAndSecurityDetailFragment.brandName;
                    year = ProspectStageLoanAndSecurityDetailFragment.year;
                    country = ProspectStageLoanAndSecurityDetailFragment.country;
                    vehicleType = ProspectStageLoanAndSecurityDetailFragment.vehicleType;
                    securityValue = ProspectStageLoanAndSecurityDetailFragment.etSecurityValue.getText().toString();
                    loanRequired = ProspectStageLoanAndSecurityDetailFragment.etLoanRequired.getText().toString();
                    loanTerm = ProspectStageLoanAndSecurityDetailFragment.etLoanRequired.getText().toString();
                    proposedInterest = ProspectStageLoanAndSecurityDetailFragment.etProposedInterest.getText().toString();
                    fee = ProspectStageLoanAndSecurityDetailFragment.etFee.getText().toString();
//              calculatedGrossIncome = ProspectStageFinancialCalculatorFragment.etCalculatedGrossIncome.getText().toString();
                    calculatedGrossIncome = "";

                    if (getDataFromProspect() != null) {
                        MyNewProspect myNewProspect = new MyNewProspect(
                                getDataFromProspect().getBranchName(),
                                getDataFromProspect().getUserName(),
                                getDataFromProspect().getProfession(),
                                getDataFromProspect().getOrganization(),
                                getDataFromProspect().getDesignation(),
                                mobileNumber, presentAddress,
                                getDataFromProspect().getSourceRef(),
                                getDataFromProspect().getProductType(),
                                getDataFromProspect().getProductSubcategory(),
                                getDataFromProspect().getLoanAmount(),
                                getDataFromProspect().getOrInterest(),
                                getDataFromProspect().getOpFee(),
                                getDataFromProspect().getVisitDate(),
                                getDataFromProspect().getDisDate(),
                                getDataFromProspect().getFollowUp(),
                                getDataFromProspect().getRemark(),
                                AppConstant.STATUS_NEW_PROSPECT,
                                productCat, productDetails,
                                segment, age, districtOfBirth,
                                countOfBirth, photoId, photoIdDate, eTin, fatherName,
                                motherName, spouseName, "", noYrsInCureentJob,
                                relationship, permanentAddress, monthlyNetSalary,
                                monthlySalaryAmount, rentalIncome, etMonthlyRentalAmount,
                                agriculturalIncome, practiceConsultancyTution, remittance,
                                interestIncome, monthlyFamilyExpenditure, emiOfOtherLoans,
                                securityValue, loanRequired, loanTerm, proposedInterest,
                                fee, "");

                        int update = myLeadDbController.upDateProspectData(myNewProspect, getDataFromProspect().getId());
                        if (update > 0) {
                            Toast.makeText(ProspectStageActivity.this, "save successfully", Toast.LENGTH_SHORT).show();
                            ActivityUtils.getInstance().invokeActivity(ProspectStageActivity.this, DashboardSalesOfficerActivity.class, true);
                        } else {
                            Toast.makeText(ProspectStageActivity.this, "failed", Toast.LENGTH_SHORT).show();

                        }
                    }

            }

        });


        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog(getDataFromProspect().getId());
            }
        });

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
        builder.setIcon(R.drawable.ic_reject);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
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
            myNewLead = (MyNewProspect) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            mLayout.setVisibility(View.VISIBLE);
        }

        return myNewLead;
    }


//    public MyNewProspect getDataFromCoApplicant() {
//        MyNewProspect myNewProspect = null;
//        Bundle extraDetail = getIntent().getExtras();
//        if (extraDetail != null) {
//            myNewProspect = (MyNewProspect) extraDetail.getSerializable(AppConstant.CO_APPLICANT_BUNDLE_KEY);
//        }
//
//        return myNewProspect;
//
//    }

    private boolean isValid(){
        boolean validation=true;
        return validation;
    }


    private void setupViewPager(ViewPager viewPager) {
        ProspectStageActivity.ViewPagerAdapter adapter = new ProspectStageActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProspectStageProductAndCustomerDetailsFragment(), "Product & Customer Details");
        adapter.addFragment(new ProspectStageFinancialFragment(), "Financials");
        adapter.addFragment(new ProspectStageLoanAndSecurityDetailFragment(), "Loan & Security Detail");
        adapter.addFragment(new ProspectStageCoApplicantFragment(), "Co-Applicant");
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
        if (resultCode == RESULT_OK) {
            coApplicant = null;
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                coApplicant = (MyNewProspect) bundle.getSerializable(AppConstant.CO_APPLICANT_BUNDLE_KEY);
                Toast.makeText(getApplicationContext(), "co-applicant data saved", Toast.LENGTH_LONG).show();

            }

        } else {
            Toast.makeText(getApplicationContext(), "result not ok", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();



    }
}
