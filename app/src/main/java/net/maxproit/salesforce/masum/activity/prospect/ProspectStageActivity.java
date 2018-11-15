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
import net.maxproit.salesforce.masum.appdata.sqlite.CarLoanDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageCoApplicantFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageLoanAndSecurityDetailFragment;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.model.CarLoan;
import net.maxproit.salesforce.masum.model.CoApplicant;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

public class ProspectStageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyLeadDbController myLeadDbController;
    private CarLoanDbController carLoanDbController;
    private CoApplicantDBController coApplicantDBController;
    public static int CO_APPLICANT_REQUEST_CODE = 1;

    MyNewProspect prospect;
    String productCat = null, productDetails = null, mybranchName = null, segment = null, countOfBirth = null, districtOfBirth = null, profession = null,
            relationship = null, name = null, age = null, photoId = null, photoIdDate = null, eTin = null, fatherName = null, motherName = null, spouseName = null,
            companyName = null, designation = null, noYrsInCureentJob = null, presentAddress = null, permanentAddress = null, mobileNumber = null;
    String brandName = null, year = null, country = null, vehicleType = null, securityValue = null, loanRequired = null, loanTerm = null, proposedInterest = null,
            fee = null, dateOfBirth = null, photoIdType = null;
    String monthlyNetSalary = null, businessIncome = null, monthlySalaryAmount = null, monthlyBusinessIncome = null, semiPakaIncome = null,
            officeIncome = null, wireHouseIncome = null, apartmentIncome = null, agriculturalIncome = null, practiceConsultancyTution = null, remittance = null, interestIncome = null,
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
        carLoanDbController = new CarLoanDbController(ProspectStageActivity.this);
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
                alertDialogProceed();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogSave();
            }

        });


        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog(getDataFromProspect().getId());
            }
        });

    }

    private void insertBrandData() {
        CarLoan carLoan = new CarLoan(getDataFromProspect().getId(), brandName, year, country, vehicleType);
        int insert = 0;
        if (ProspectStageLoanAndSecurityDetailFragment.cardData > 0) {
            insert = carLoanDbController.updateData(carLoan);

        } else {
            insert = carLoanDbController.insertData(carLoan);
        }

        if (insert>0){
            Toast.makeText(this, "save "+insert, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "failed "+insert, Toast.LENGTH_SHORT).show();

        }
    }


    private void getDataFromFragment() {
        if (ProspectStageFinancialFragment.monthlyNetSalary != null) {
            monthlyNetSalary = ProspectStageFinancialFragment.monthlyNetSalary;
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


        monthlyNetSalary = ProspectStageFinancialFragment.monthlyNetSalary;

        monthlySalaryAmount = ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString();
        agriculturalIncome = ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString();
        practiceConsultancyTution = ProspectStageFinancialFragment.etPracticeConsultancyTuition.getText().toString();
        remittance = ProspectStageFinancialFragment.etRemittance.getText().toString();
        interestIncome = ProspectStageFinancialFragment.etInterestIncome.getText().toString();
        monthlyFamilyExpenditure = ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
        emiOfOtherLoans = ProspectStageFinancialFragment.etEMIOfOtherLoans.getText().toString();
        monthlySalaryAmount = ProspectStageFinancialFragment.etMonthlySalaryAmount.getText().toString();
        monthlyBusinessIncome = ProspectStageFinancialFragment.etMonthlyBusinessIncome.getText().toString();
        semiPakaIncome = ProspectStageFinancialFragment.etSemipakaIncome.getText().toString();
        apartmentIncome = ProspectStageFinancialFragment.etApartmentIncomeAmount.getText().toString();
        officeIncome = ProspectStageFinancialFragment.etOfficeSpaceIncome.getText().toString();
        wireHouseIncome = ProspectStageFinancialFragment.etWarehouseIncome.getText().toString();
        agriculturalIncome = ProspectStageFinancialFragment.etAgriculturalIncome.getText().toString();
        practiceConsultancyTution = ProspectStageFinancialFragment.etPracticeConsultancyTuition.getText().toString();
        remittance = ProspectStageFinancialFragment.etRemittance.getText().toString();
        interestIncome = ProspectStageFinancialFragment.etInterestIncome.getText().toString();
        monthlyFamilyExpenditure = ProspectStageFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
        emiOfOtherLoans = ProspectStageFinancialFragment.etEMIOfOtherLoans.getText().toString();
        productCat = ProspectStageProductAndCustomerDetailsFragment.productCat;
        productDetails = ProspectStageProductAndCustomerDetailsFragment.productDetails;
        mybranchName = ProspectStageProductAndCustomerDetailsFragment.branchName;
        segment = ProspectStageProductAndCustomerDetailsFragment.segment;
        countOfBirth = ProspectStageProductAndCustomerDetailsFragment.countOfBirth;
        dateOfBirth = ProspectStageProductAndCustomerDetailsFragment.etDob.getText().toString();
        districtOfBirth = ProspectStageProductAndCustomerDetailsFragment.districtOfBirth;
        profession = ProspectStageProductAndCustomerDetailsFragment.profession;
        relationship = ProspectStageProductAndCustomerDetailsFragment.relationship;
        name = ProspectStageProductAndCustomerDetailsFragment.etName.getText().toString();
        age = ProspectStageProductAndCustomerDetailsFragment.etAge.getText().toString();
        photoIdType = ProspectStageProductAndCustomerDetailsFragment.photoIdType;
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

        brandName = ProspectStageLoanAndSecurityDetailFragment.brandName;
        year = ProspectStageLoanAndSecurityDetailFragment.year;
        country = ProspectStageLoanAndSecurityDetailFragment.country;
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
        CarLoan carLoan = null;
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

    private boolean isValid() {
        boolean validation = true;
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
            prospect = null;
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                prospect = (MyNewProspect) bundle.getSerializable(AppConstant.CO_APPLICANT_BUNDLE_KEY);
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

    private void alertDialogSave() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(ProspectStageActivity.this);
        }
        builder.setTitle("Save");
        builder.setMessage("Do you want to save details?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            getDataFromFragment();

            if (getDataFromProspect() != null) {
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
                        relationship, permanentAddress, monthlyNetSalary,
                        monthlySalaryAmount, monthlyBusinessIncome, apartmentIncome,
                        semiPakaIncome, officeIncome, wireHouseIncome,
                        agriculturalIncome, practiceConsultancyTution, remittance,
                        interestIncome, monthlyFamilyExpenditure, emiOfOtherLoans,
                        securityValue, loanRequired, loanTerm, proposedInterest,
                        fee);

                int update = myLeadDbController.upDateProspectData(myNewProspect, getDataFromProspect().getId());
                if (update > 0) {
                    if (brandName !=null && year !=null && country !=null && vehicleType !=null){
                        insertBrandData();
                    }
                    Toast.makeText(ProspectStageActivity.this, "save successfully", Toast.LENGTH_SHORT).show();
                    ActivityUtils.getInstance().invokeActivity(ProspectStageActivity.this, MyProspectActivity.class, true);
                } else {
                    Toast.makeText(ProspectStageActivity.this, "failed", Toast.LENGTH_SHORT).show();

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
        builder.setTitle("Proceed");
        builder.setMessage("Do you want to proceed?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            getDataFromFragment();
            if (getDataFromProspect() != null) {
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
                        relationship, permanentAddress, monthlyNetSalary,
                        monthlySalaryAmount, monthlyBusinessIncome, apartmentIncome,
                        semiPakaIncome, officeIncome, wireHouseIncome,
                        agriculturalIncome, practiceConsultancyTution, remittance,
                        interestIncome, monthlyFamilyExpenditure, emiOfOtherLoans,
                        securityValue, loanRequired, loanTerm, proposedInterest,
                        fee);

                int update = myLeadDbController.upDateProspectData(myNewProspect, getDataFromProspect().getId());
                if (update > 0) {
                    if (brandName !=null && year !=null && country !=null && vehicleType !=null){
                        insertBrandData();
                    }

                    Toast.makeText(ProspectStageActivity.this, "save successfully", Toast.LENGTH_SHORT).show();
                    ActivityUtils.getInstance().invokeActivity(ProspectStageActivity.this, DashboardSalesOfficerActivity.class, true);
                } else {
                    Toast.makeText(ProspectStageActivity.this, "failed", Toast.LENGTH_SHORT).show();

                }
            }

        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}
