package net.maxproit.salesforce.masum.activity.prospect.co_applicant;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce.masum.fragment.prospect.co_applicant.CoApplicantFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.co_applicant.CoApplicantProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.masum.model.CoApplicant;
import net.maxproit.salesforce.masum.model.MyNewProspect;

import java.util.ArrayList;
import java.util.List;

public class CoApplicantActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView btnSave;
    private CoApplicantDBController coApplicantDBController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_applicant);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Prospect Stage: Co-Applicant");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.vp_co_applicant_viewpager);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);
        tabLayout = (TabLayout) findViewById(R.id.tl_co_applicant_tabs);
        tabLayout.setupWithViewPager(viewPager);
        btnSave = findViewById(R.id.btn_save);
        coApplicantDBController = new CoApplicantDBController(getApplicationContext());



        initListener();

    }

    private void initListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                int leadId = getIntent().getIntExtra(AppConstant.LEAD_ID_FOR_CO_INTENT_KEY, -1);
                String name, segment, dateOfBirth, age, districtOfBirth, countryOfBirth, photoIdType, photoIdNo,
                        photoIdIssueDate, eTin, fName, mName, sName, profession, exList, companyName,
                        designation, noOfYrsInCurrentJob, relationWithApplicant, permanentAddress,
                        presentAddress, mobileNo, monthSalaryType, monthSalaryAmount,
                        monthBusinessIncomeAmount, monthWareHouseAmount,monthOfficeSpaceIncomeAmount,
                        monthSemipakaIncomeAmount, monthApartmentIncomeAmount, monthAgricultureIncomeAmount,
                        monthTuitionIncomeAmount, remittance, interestFDRIncomeAmount, monthFamilyExpenditure,
                        emiOfOtherLoans;

                name = CoApplicantProductAndCustomerDetailsFragment.etName.getText().toString();
                segment = CoApplicantProductAndCustomerDetailsFragment.segment;
                dateOfBirth = CoApplicantProductAndCustomerDetailsFragment.etDateOfBirth.getText().toString();
                age = CoApplicantProductAndCustomerDetailsFragment.etAge.getText().toString();
                districtOfBirth = CoApplicantProductAndCustomerDetailsFragment.districtOfBirth;
                countryOfBirth = CoApplicantProductAndCustomerDetailsFragment.countOfBirth;
                photoIdType = CoApplicantProductAndCustomerDetailsFragment.photoIdType;
                photoIdNo = CoApplicantProductAndCustomerDetailsFragment.etPhotoId.getText().toString();
                photoIdIssueDate = CoApplicantProductAndCustomerDetailsFragment.etName.getText().toString();
                eTin = CoApplicantProductAndCustomerDetailsFragment.etETin.getText().toString();
                fName = CoApplicantProductAndCustomerDetailsFragment.etFatherName.getText().toString();
                mName = CoApplicantProductAndCustomerDetailsFragment.etMotherName.getText().toString();
                sName = CoApplicantProductAndCustomerDetailsFragment.etSpouseName.getText().toString();
                profession = CoApplicantProductAndCustomerDetailsFragment.profession;
                exList = CoApplicantProductAndCustomerDetailsFragment.exList; // havent implimented in coApplicant & prospect
                companyName = CoApplicantProductAndCustomerDetailsFragment.etCompanyName.getText().toString();
                designation = CoApplicantProductAndCustomerDetailsFragment.etDesignation.getText().toString();
                noOfYrsInCurrentJob = CoApplicantProductAndCustomerDetailsFragment.etNoYrsInCurrentJob.getText().toString();
                relationWithApplicant = CoApplicantProductAndCustomerDetailsFragment.relationship;
                permanentAddress = CoApplicantProductAndCustomerDetailsFragment.etPermanentAddress.getText().toString();
                presentAddress = CoApplicantProductAndCustomerDetailsFragment.etPresentAddress.getText().toString();
                mobileNo = CoApplicantProductAndCustomerDetailsFragment.etMobileNumber.getText().toString();
                monthSalaryType = CoApplicantFinancialFragment.monthlyNetSalary;
                monthSalaryAmount = CoApplicantFinancialFragment.etMonthlySalaryAmount.toString();
                monthBusinessIncomeAmount = CoApplicantFinancialFragment.etMonthlyBusinessIncome.getText().toString();
                monthWareHouseAmount = CoApplicantFinancialFragment.etMonthlyWarehouseAmount.getText().toString();
                monthOfficeSpaceIncomeAmount = CoApplicantFinancialFragment.etMonthlyOfficeSpaceAmount.getText().toString();
                monthSemipakaIncomeAmount = CoApplicantFinancialFragment.etMonthlySemipakaAmount.getText().toString();
                monthApartmentIncomeAmount = CoApplicantFinancialFragment.etMonthlyApartmentAmount.getText().toString();
                monthAgricultureIncomeAmount = CoApplicantFinancialFragment.etAgriculturalIncome.getText().toString();
                monthTuitionIncomeAmount = CoApplicantFinancialFragment.etPracticeConsultancyTuition.getText().toString();
                remittance = CoApplicantFinancialFragment.etRemittance.getText().toString();
                interestFDRIncomeAmount = CoApplicantFinancialFragment.etInterestIncome.getText().toString();
                monthFamilyExpenditure = CoApplicantFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
                emiOfOtherLoans = CoApplicantFinancialFragment.etEMIOfOtherLoans.getText().toString();



                CoApplicant coApplicant = new CoApplicant(leadId, name, segment, dateOfBirth, age, districtOfBirth, countryOfBirth, photoIdType, photoIdNo,
                        photoIdIssueDate, eTin, fName, mName, sName, profession, exList, companyName,
                        designation, noOfYrsInCurrentJob, relationWithApplicant, permanentAddress,
                        presentAddress, mobileNo, monthSalaryType, monthSalaryAmount,
                        monthBusinessIncomeAmount, monthWareHouseAmount,monthOfficeSpaceIncomeAmount,
                        monthSemipakaIncomeAmount, monthApartmentIncomeAmount, monthAgricultureIncomeAmount,
                        monthTuitionIncomeAmount, remittance, interestFDRIncomeAmount, monthFamilyExpenditure,
                        emiOfOtherLoans);

                Log.d("tag", ""+coApplicant.getLeadId());
                Log.d("tag", ""+coApplicant.getName());

                    int update = coApplicantDBController.insertData(coApplicant);

                    if (update > 0){
                        Toast.makeText(CoApplicantActivity.this, "save successfully", Toast.LENGTH_SHORT).show();

                        Intent coApplicantIntent = new Intent(CoApplicantActivity.this, ProspectStageActivity.class);
                        setResult(Activity.RESULT_OK, coApplicantIntent);
                        finish();

                    }
                    else {
                        Toast.makeText(CoApplicantActivity.this, "failed", Toast.LENGTH_SHORT).show();

                    }
//////                }
//                    Bundle bundle = new Bundle();
//                    Intent intent = new Intent(CoApplicantActivity.this, ProspectStageActivity.class);
////                    bundle.putSerializable(AppConstant.CO_APPLICANT_BUNDLE_KEY, );
////                    bundle.putInt(AppConstant.CO_APPLICANT_STATUS_INTENT_KEY, 100);
//                    intent.putExtra(AppConstant.CO_APPLICANT_INTENT_KEY, bundle);
//                    setResult(Activity.RESULT_OK, intent);
//                    finish();
//                }else{
//                    Toast.makeText(CoApplicantActivity.this, "Name Field empty", Toast.LENGTH_SHORT).show();
//                }
//
//
//
            }
        });



    }


    private void setupViewPager(ViewPager viewPager) {
        CoApplicantActivity.ViewPagerAdapter adapter = new CoApplicantActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CoApplicantProductAndCustomerDetailsFragment(), "Product & Customer Details");
        adapter.addFragment(new CoApplicantFinancialFragment(), "Financials");
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