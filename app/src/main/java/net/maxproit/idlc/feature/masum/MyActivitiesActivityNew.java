package net.maxproit.idlc.feature.masum;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.sqlite.MyLeadDbController;

import java.util.ArrayList;
import java.util.List;

public class MyActivitiesActivityNew extends BaseActivity {


    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinearLayout linearLayoutToolbar;
    private TextView btnSave;
    private MyLeadDbController myLeadDbController;
    private ImageView backButton, addButton;



    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_activities_new;
    }

    @Override
    protected void initComponents() {

        linearLayoutToolbar = findViewById(R.id.linear_layout_my_activity_toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.vp_my_activity);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_my_activity);
        tabLayout.setupWithViewPager(viewPager);


        backButton = findViewById(R.id.btn_back);
        addButton = findViewById(R.id.btn_add);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyActivitiesActivityNew.super.onBackPressed();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "add button pressed", Toast.LENGTH_LONG).show();
            }
        });


//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        setupViewPager(viewPager);
//        viewPager = (ViewPager) findViewById(R.id.my_activities_viewpager);
//        tabLayout.setupWithViewPager(viewPager);




    }

    @Override
    protected void getIntentData() {


    }

//    private Toolbar toolbar;
//    private TabLayout tabLayout;
//    private ViewPager viewPager;
//    private TextView btnSave;
//
//
//    private Spinner spnClientType;
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_activites_new);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        viewPager = (ViewPager) findViewById(R.id.my_activities_viewpager);
//        setupViewPager(viewPager);
//
//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
//
//
//
//    }
//
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyActivityListFragment(), "Current Activity");
        adapter.addFragment(new MyActivityListFragment(), "Previous Activity");
        adapter.addFragment(new MyActivityListFragment(), "Upcoming Activity");
        viewPager.setAdapter(adapter);
    }
//
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
//
//    @Override
//    public void onBackPressed() {
//
//
//        super.onBackPressed();
//        startActivity(new Intent(MyActivitiesActivityNew.this, DashboardSalesOfficerActivity.class));
//        finish();
//    }
}
