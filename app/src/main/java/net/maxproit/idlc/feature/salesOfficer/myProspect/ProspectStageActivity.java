package net.maxproit.idlc.feature.salesOfficer.myProspect;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;


import net.maxproit.idlc.AppConstant;
import net.maxproit.idlc.LeadStageActivity;
import net.maxproit.idlc.LeadStageAttachmentFragment;
import net.maxproit.idlc.LeadStageBasicInformationFragment;
import net.maxproit.idlc.LeadStageLoanDetailFragment;
import net.maxproit.idlc.LeadStageVisitRecordFragment;
import net.maxproit.idlc.ProspectStageFinancialFragment;
import net.maxproit.idlc.ProspectStageLoanAndSecurityDetailFragment;
import net.maxproit.idlc.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.idlc.R;
import net.maxproit.idlc.model.newlead.MyNewLead;

import java.util.ArrayList;
import java.util.List;

public class ProspectStageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    TextView buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_stage);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Prospect Stage");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        buttonSave = findViewById(R.id.btnSave);


        getDataFromProspect();
        initListener();
    }

    private void initListener() {

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String productCat, productDetails, branchName, segment, countOfBirth, districtOfBirth, profession,
                        relationship, name, age, photoId, photoIdDate, eTin, fatherName, motherName, spouseName,
                        companyName, designation, noYrsInCureentJob, presentAddress, permanentAddress,mobileNumber;

                 productCat = ProspectStageProductAndCustomerDetailsFragment.productCat;
                productDetails = ProspectStageProductAndCustomerDetailsFragment.productDetails;
                branchName = ProspectStageProductAndCustomerDetailsFragment.branchName;
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




            }
        });

    }

    public MyNewLead getDataFromProspect() {
        Bundle extraDetail = getIntent().getExtras();
        MyNewLead myNewLead = (MyNewLead) extraDetail.getSerializable(AppConstant.INTENT_KEY);
        return myNewLead;
    }


    private void setupViewPager(ViewPager viewPager) {
        ProspectStageActivity.ViewPagerAdapter adapter = new ProspectStageActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProspectStageProductAndCustomerDetailsFragment(), "Product & Customer Details");
        adapter.addFragment(new ProspectStageFinancialFragment(), "Financials");
        adapter.addFragment(new ProspectStageLoanAndSecurityDetailFragment(), "Loan & Security Detail");
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
