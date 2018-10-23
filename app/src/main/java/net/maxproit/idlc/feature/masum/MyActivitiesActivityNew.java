package net.maxproit.idlc.feature.masum;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toolbar;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MyActivitiesActivityNew extends BaseActivity {


    private Toolbar toolbar;
        private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_activities_new;
    }

    @Override
    protected void initComponents() {

        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewPager);
        viewPager = (ViewPager) findViewById(R.id.my_activities_viewpager);
        tabLayout.setupWithViewPager(viewPager);




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
        adapter.addFragment(new CurrentActivitiesFragment(), "Current");
        adapter.addFragment(new PreviousActivitiesFragment(), "Previous");
        adapter.addFragment(new UpcomingActivitiesFragment(), "Upcoming");
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
