package net.maxproit.salesforce.masum.activity.prospect.co_applicant;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.preference.AppPreference;
import net.maxproit.salesforce.masum.appdata.preference.PrefKey;
import net.maxproit.salesforce.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce.masum.fragment.prospect.co_applicant.CoApplicantFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.co_applicant.CoApplicantProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.masum.model.local.CoApplicant;

import java.util.ArrayList;
import java.util.List;

public class CoApplicantActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView btnSave;
    private CoApplicantDBController coApplicantDBController;
    String leadId = null;
    public static String pr, pe,perCity,perPs,preCity,prePs;
    CoApplicantProductAndCustomerDetailsFragment coApplicantProductAndCustomerDetailsFragment;
    CoApplicantFinancialFragment coApplicantFinancialFragment;
    private int position = -1;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_co_applicant;
    }

    @Override
    protected void initComponents() {
        initFragment();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Prospect Stage: Co-Applicant");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getDataFromApplicant();
        viewPager = (ViewPager) findViewById(R.id.vp_co_applicant_viewpager);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);
        tabLayout = (TabLayout) findViewById(R.id.tl_co_applicant_tabs);
        tabLayout.setupWithViewPager(viewPager);
        btnSave = findViewById(R.id.btn_save);
        coApplicantDBController = new CoApplicantDBController(getApplicationContext());
        leadId = getIntent().getStringExtra(AppConstant.LEAD_ID_FOR_CO_INTENT_KEY);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Bundle extraFromFragment = new Bundle();
            pr = bundle.getString(AppConstant.PRESENT_ADDRESSS_KEY);
            pe = bundle.getString(AppConstant.PERMANENT_ADDRESSS_KEY);
            perCity=bundle.getString(AppConstant.PERMANENT_ADDRESSS_CITY_KEY );
            perPs= bundle.getString(AppConstant.PERMANENT_ADDRESSS_PS_KEY );
            preCity= bundle.getString(AppConstant.PRESENT_ADDRESSS_CITY_KEY );
            prePs=bundle.getString(AppConstant.PRESENT_ADDRESSS_PS_KEY );
            coApplicantProductAndCustomerDetailsFragment.setArguments(extraFromFragment);
        }
        initListener();
    }

    @Override
    protected void getIntentData() {

    }

    private void initFragment() {
        coApplicantProductAndCustomerDetailsFragment = new CoApplicantProductAndCustomerDetailsFragment();

    }

    private void initListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                 String name, dateOfBirth, age, districtOfBirth, countryOfBirth, photoIdType, photoIdNo,
                        photoIdIssueDate, eTin, fName, mName, sName, profession, companyName,
                        designation, noOfYrsInCurrentJob, relationWithApplicant, permanentAddress,
                        presentAddress, perCity, perPs, preCity, prePs, mobileNo, monthSalaryType, monthSalaryAmount,
                        monthBusinessIncomeAmount, monthWareHouseAmount, monthOfficeSpaceIncomeAmount,
                        monthSemipakaIncomeAmount, monthApartmentIncomeAmount, monthAgricultureIncomeAmount,
                        monthTuitionIncomeAmount, remittance, interestFDRIncomeAmount, monthFamilyExpenditure,
                        emiOfOtherLoans;
                int exList;
                AppPreference.getInstance(getActivity()).setBoolean(PrefKey.IS_LOADED, true);
                name = CoApplicantProductAndCustomerDetailsFragment.etName.getText().toString();
                dateOfBirth = CoApplicantProductAndCustomerDetailsFragment.etDateOfBirth.getText().toString();
                age = CoApplicantProductAndCustomerDetailsFragment.etAge.getText().toString();
                districtOfBirth = CoApplicantProductAndCustomerDetailsFragment.districtOfBirth;
                countryOfBirth = CoApplicantProductAndCustomerDetailsFragment.countOfBirth;
                photoIdType = String.valueOf(CoApplicantProductAndCustomerDetailsFragment.photoIdcode);
                photoIdNo = CoApplicantProductAndCustomerDetailsFragment.etPhotoId.getText().toString();
                photoIdIssueDate = CoApplicantProductAndCustomerDetailsFragment.etPhotoIdDate.getText().toString();
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
                preCity = CoApplicantProductAndCustomerDetailsFragment.spinnerPreCity.getText().toString();
                prePs = CoApplicantProductAndCustomerDetailsFragment.prePoliceStation;
                perCity = CoApplicantProductAndCustomerDetailsFragment.spinnerPerCity.getText().toString();
                perPs = CoApplicantProductAndCustomerDetailsFragment.perPoliceStation;

                monthSalaryType = CoApplicantFinancialFragment.monthlyNetSalary;
                monthSalaryAmount = CoApplicantFinancialFragment.etMonthlySalaryAmount.getText().toString();
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

                if (dateOfBirth.isEmpty()){
                    showAlertDialog("Error", "Enter date of birth");
                    return;
                }

                if (photoIdIssueDate.isEmpty()){
                    showAlertDialog("Error", "Enter photo issue date");
                    return;
                }

                CoApplicant coApplicant = new CoApplicant(leadId, name, dateOfBirth, age, districtOfBirth, countryOfBirth, photoIdType, photoIdNo,
                        photoIdIssueDate, eTin, fName, mName, sName, profession, exList, companyName,
                        designation, noOfYrsInCurrentJob, relationWithApplicant, permanentAddress,
                        presentAddress, mobileNo, monthSalaryType, monthSalaryAmount,
                        monthBusinessIncomeAmount, monthWareHouseAmount, monthOfficeSpaceIncomeAmount,
                        monthSemipakaIncomeAmount, monthApartmentIncomeAmount, monthAgricultureIncomeAmount,
                        monthTuitionIncomeAmount, remittance, interestFDRIncomeAmount, monthFamilyExpenditure,
                        emiOfOtherLoans);

                coApplicant.setPresentAddressCity(preCity);
                coApplicant.setPresentAddressPS(prePs);
                coApplicant.setPermanentAddressCity(perCity);
                coApplicant.setPermanentAddressPS(perPs);


                int update = 0;
                if (getDataFromApplicant() != null) {
                    coApplicant.setContactId(getDataFromApplicant().getContactId());
                    coApplicant.setCustomerId(getDataFromApplicant().getCustomerId());
                    coApplicant.setMobileNoId(getDataFromApplicant().getMobileNoId());
                    coApplicant.setPresentAddressId(getDataFromApplicant().getPresentAddressId());
                    coApplicant.setPermanentAddressId(getDataFromApplicant().getPermanentAddressId());
                    if (position >= 0) {
                        AppConstant.coAppLicantStaticList.set(position, coApplicant);
                    } else {
                        AppConstant.coAppLicantStaticList.add(coApplicant);
                        update = coApplicantDBController.updateCoApplicantData(coApplicant, getDataFromApplicant().getId());
                    }

                } else {
                    coApplicant.setCustomerId(0);
                    coApplicant.setMobileNoId(0);
                    coApplicant.setPresentAddressId(0);
                    coApplicant.setPermanentAddressId(0);
                    coApplicant.setContactId(0);
                    if (position >= 0) {
                        AppConstant.coAppLicantStaticList.set(position, coApplicant);
                    } else {
                        AppConstant.coAppLicantStaticList.add(coApplicant);
                        update = coApplicantDBController.insertData(coApplicant);
                    }
                }

                /*    if (update > 0) {*/
                Toast.makeText(CoApplicantActivity.this, "save successfully", Toast.LENGTH_SHORT).show();
                Intent coApplicantIntent = new Intent(CoApplicantActivity.this, ProspectStageActivity.class);
                setResult(AppConstant.ACTIVITY_RESULLT_200, coApplicantIntent);
                finish();

              /*  } else {
                    Toast.makeText(CoApplicantActivity.this, "failed", Toast.LENGTH_SHORT).show();

                }*/
            }
        });


    }

    public CoApplicant getDataFromApplicant() {
        CoApplicant coApplicant = null;

        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            position = extraDetail.getInt(AppConstant.STATUS_INTENT_KEY, -1);
            coApplicant = (CoApplicant) extraDetail.getSerializable(AppConstant.INTENT_KEY);

        }

        return coApplicant;
    }

    public String getLeadId() {
        return leadId;
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