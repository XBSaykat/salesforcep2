package net.maxproit.salesforce.masum.activity.prospect;

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
import net.maxproit.salesforce.masum.activity.lead.LeadStageActivity;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageCoApplicantFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageFinancialCalculatorFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageLoanAndSecurityDetailFragment;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.R;
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
    private MyLeadDbController myLeadDbController;
    private TextView buttonSave,btnProceed,btnReject;
    private LinearLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_stage);
        btnProceed=findViewById(R.id.tv_activity_details_proceed_to_prospect);
        btnReject=findViewById(R.id.tv_activity_details_rejected);
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
        mLayout=findViewById(R.id.btn_layout_lead);
        initListener();
    }

    private void initListener() {

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String productCat, productDetails, mybranchName, segment, countOfBirth, districtOfBirth, profession,
                        relationship, name, age, photoId, photoIdDate, eTin, fatherName, motherName, spouseName,
                        companyName, designation, noYrsInCureentJob, presentAddress, permanentAddress, mobileNumber;
                String brandName, year, country, vehicleType, securityValue, loanRequired, loanTerm, proposedInterest,
                        fee, calculatedGrossIncome;
                String monthlyNetSalary, rentalIncome, monthlySalaryAmount, monthlyBusinessIncome, etMonthlyRentalAmount,
                        agriculturalIncome, practiceConsultancyTution, remittance, interestIncome,
                        monthlyFamilyExpenditure, emiOfOtherLoans;


//              <<<<<<< ProspectStageFinancialFragment >>>>>>>>>>
                monthlyNetSalary = ProspectStageFinancialFragment.monthlyNetSalary;
                rentalIncome = ProspectStageFinancialFragment.rentalIncome;

                monthlySalaryAmount = ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString();
                monthlyBusinessIncome = ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString();
                etMonthlyRentalAmount = ProspectStageFinancialFragment.etMonthlyRentalAmount.getText().toString();
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
//                calculatedGrossIncome = ProspectStageFinancialCalculatorFragment.etCalculatedGrossIncome.getText().toString();
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
                            AppConstant.LEAD_STATUS_PROCEED,
                            productCat, productDetails,
                            segment, age, districtOfBirth,
                            countOfBirth, photoId, photoIdDate, eTin, fatherName,
                            motherName, spouseName, "", noYrsInCureentJob,
                            relationship, permanentAddress, monthlyNetSalary,
                            monthlySalaryAmount, rentalIncome, etMonthlyRentalAmount,
                            agriculturalIncome, practiceConsultancyTution, remittance,
                            interestIncome, monthlyFamilyExpenditure, emiOfOtherLoans,
                            securityValue, loanRequired, loanTerm, proposedInterest,
                            fee, calculatedGrossIncome);

                    int update = myLeadDbController.upDateProspectData(myNewProspect,getDataFromProspect().getId());
                    if (update>0){
                        Toast.makeText(ProspectStageActivity.this, "save successfully", Toast.LENGTH_SHORT).show();
                        ActivityUtils.getInstance().invokeActivity(ProspectStageActivity.this,DashboardSalesOfficerActivity.class,true);
                    }
                    else {
                        Toast.makeText(ProspectStageActivity.this, "failed", Toast.LENGTH_SHORT).show();

                    }
                }



            }
        });


        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public MyNewLead getDataFromProspect() {
        MyNewLead myNewLead = null;
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            myNewLead = (MyNewLead) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            mLayout.setVisibility(View.VISIBLE);
            buttonSave.setVisibility(View.GONE);
        }

        return myNewLead;

    }


    private void setupViewPager(ViewPager viewPager) {
        ProspectStageActivity.ViewPagerAdapter adapter = new ProspectStageActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProspectStageProductAndCustomerDetailsFragment(), "Product & Customer Details");
        adapter.addFragment(new ProspectStageFinancialFragment(), "Financials");
        adapter.addFragment(new ProspectStageLoanAndSecurityDetailFragment(), "Loan & Security Detail");
        adapter.addFragment(new ProspectStageCoApplicantFragment(), "Co-Applicant");
        adapter.addFragment(new ProspectStageFinancialCalculatorFragment(), "Financial Calculator");
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


}
