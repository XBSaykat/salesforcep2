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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;
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



        initListener();

    }

    private void initListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                String name, segment,dateOfBirth, age, districtOfBirth, countryOfBirth, photoIdType, photoIdNo,
                        photoIdIssueDate, eTin, fName, mName, sName, profession, exList, companyName,
                        designation, noOfYrsInCurrentJob, relationWithApplicant, permanentAddress,
                        presentAddress, mobileNo, monthSalaryType, monthSalaryAmount,
                        monthBusinessIncomeAmount, monthWareHouseAmount,monthOfficeSpaceIncomeAmount,
                        monthSemipakaIncomeAmount, monthApartmentIncomeAmount, monthAgricultureIncomeAmount,
                        monthTuitionIncomeAmount, remittance, interestFDRIncomeAmount, monthFamilyExpenditure,
                        emiOfOtherLoans;


//              <<<<<<< CoApplicantFinancialFragment >>>>>>>>>>

                monthAgricultureIncomeAmount = CoApplicantFinancialFragment.etAgriculturalIncome.getText().toString();
                monthTuitionIncomeAmount = CoApplicantFinancialFragment.etPracticeConsultancyTuition.getText().toString();
                remittance = CoApplicantFinancialFragment.etRemittance.getText().toString();
                interestFDRIncomeAmount = CoApplicantFinancialFragment.etInterestIncome.getText().toString();
                monthFamilyExpenditure = CoApplicantFinancialFragment.etMonthlyFamilyExpenditure.getText().toString();
                emiOfOtherLoans = CoApplicantFinancialFragment.etEMIOfOtherLoans.getText().toString();


//                productCat = CoApplicantProductAndCustomerDetailsFragment.productCat;
//


//                <<<<<< CoApplicantProductAndCustomerDetailsFragment >>>>>>>
//                productCat = CoApplicantProductAndCustomerDetailsFragment.productCat;
//                productDetails = CoApplicantProductAndCustomerDetailsFragment.productDetails;
//                mybranchName = CoApplicantProductAndCustomerDetailsFragment.branchName;
                segment = CoApplicantProductAndCustomerDetailsFragment.segment;
                countryOfBirth = CoApplicantProductAndCustomerDetailsFragment.countOfBirth;
                districtOfBirth = CoApplicantProductAndCustomerDetailsFragment.districtOfBirth;
                profession = CoApplicantProductAndCustomerDetailsFragment.profession;
                relationWithApplicant = CoApplicantProductAndCustomerDetailsFragment.relationship;
//
                name = CoApplicantProductAndCustomerDetailsFragment.etName.getText().toString();
                age = CoApplicantProductAndCustomerDetailsFragment.etAge.getText().toString();
                photoIdNo = CoApplicantProductAndCustomerDetailsFragment.etPhotoId.getText().toString();
                photoIdIssueDate = CoApplicantProductAndCustomerDetailsFragment.etName.getText().toString();
                eTin = CoApplicantProductAndCustomerDetailsFragment.etETin.getText().toString();
                fName = CoApplicantProductAndCustomerDetailsFragment.etFatherName.getText().toString();
                mName = CoApplicantProductAndCustomerDetailsFragment.etMotherName.getText().toString();
                sName = CoApplicantProductAndCustomerDetailsFragment.etSpouseName.getText().toString();
                companyName = CoApplicantProductAndCustomerDetailsFragment.etCompanyName.getText().toString();
                designation = CoApplicantProductAndCustomerDetailsFragment.etDesignation.getText().toString();
                noOfYrsInCurrentJob = CoApplicantProductAndCustomerDetailsFragment.etNoYrsInCurrentJob.getText().toString();
                presentAddress = CoApplicantProductAndCustomerDetailsFragment.etPresentAddress.getText().toString();
                permanentAddress = CoApplicantProductAndCustomerDetailsFragment.etPermanentAddress.getText().toString();
                mobileNo = CoApplicantProductAndCustomerDetailsFragment.etMobileNumber.getText().toString();

//                calculatedGrossIncome = CoApplicantFinancialCalculatorFragment.etCalculatedGrossIncome.getText().toString();
//                calculatedGrossIncome = "";
//                if (!name.equals("")) {
//                    CoApplicant coApplicant = new CoApplicant(
//
////                        pass Parameters here
//
//                            );




////                    int update = myLeadDbController.upDateProspectData(myNewProspect,getDataFromProspect().getId());
////                    if (update>0){
////                        Toast.makeText(CoApplicantActivity.this, "save successfully", Toast.LENGTH_SHORT).show();
////                    }
////                    else {
////                        Toast.makeText(CoApplicantActivity.this, "failed", Toast.LENGTH_SHORT).show();
////
////                    }
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