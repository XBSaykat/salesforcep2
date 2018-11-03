package net.maxproit.salesforce.masum.activity.prospect.co_applicant;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageCoApplicantFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageFinancialCalculatorFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageLoanAndSecurityDetailFragment;
import net.maxproit.salesforce.masum.fragment.prospect.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.masum.fragment.prospect.co_applicant.CoApplicantFinancialFragment;
import net.maxproit.salesforce.masum.fragment.prospect.co_applicant.CoApplicantLoanAndSecurityDetailsFragment;
import net.maxproit.salesforce.masum.fragment.prospect.co_applicant.CoApplicantProductAndCustomerDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class CoApplicantActivity extends AppCompatActivity {

    private Toolbar toolbar;
    public static int CO_APPLICANT_REQUEST_CODE = 1;
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
        viewPager.setOffscreenPageLimit(3);
        tabLayout = (TabLayout) findViewById(R.id.tl_co_applicant_tabs);
        tabLayout.setupWithViewPager(viewPager);
        btnSave = findViewById(R.id.btn_save);



        initListener();

    }

    private void initListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


    private void setupViewPager(ViewPager viewPager) {
        CoApplicantActivity.ViewPagerAdapter adapter = new CoApplicantActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CoApplicantProductAndCustomerDetailsFragment(), "Product & Customer Details");
        adapter.addFragment(new CoApplicantFinancialFragment(), "Financials");
        adapter.addFragment(new CoApplicantLoanAndSecurityDetailsFragment(), "Loan & Security Detail");
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