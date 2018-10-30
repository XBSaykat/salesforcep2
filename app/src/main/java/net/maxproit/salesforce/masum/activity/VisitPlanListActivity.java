package net.maxproit.salesforce.masum.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.fragment.MyActivityListFragment;
import net.maxproit.salesforce.masum.sqlite.MyLeadDbController;

import java.util.ArrayList;
import java.util.List;

public class VisitPlanListActivity extends BaseActivity {



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
                VisitPlanListActivity.super.onBackPressed();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(VisitPlanListActivity.this).create();
                dialog.setTitle("Create new Lead?");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(VisitPlanListActivity.this, LeadStageActivity.class));
                        finish();
                        dialog.dismiss();
                    }
                });
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

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
        VisitPlanListActivity.ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyActivityListFragment(), "pending plan");
        adapter.addFragment(new MyActivityListFragment(), "Current Activity");
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
