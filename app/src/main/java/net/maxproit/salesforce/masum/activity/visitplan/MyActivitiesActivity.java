package net.maxproit.salesforce.masum.activity.visitplan;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.fragment.myactivity.FragmentCurrentActivity;
import net.maxproit.salesforce.masum.fragment.myactivity.FragmentPreViousList;
import net.maxproit.salesforce.masum.fragment.myactivity.FragmentUpComingList;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;

import java.util.ArrayList;
import java.util.List;

public class MyActivitiesActivity extends BaseActivity {



    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView backButton, addButton;
    private SearchView searchView;
    private static FragmentCurrentActivity currentActivity;
    private static FragmentPreViousList fragmentPreViousList;
    private static FragmentUpComingList fragmentUpComingList;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_activities_new;
    }

    @Override
    protected void initComponents() {

        viewPager =  findViewById(R.id.vp_my_activity);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        tabLayout = findViewById(R.id.tab_layout_my_activity);
        tabLayout.setupWithViewPager(viewPager);
        backButton = findViewById(R.id.btn_back);
        addButton = findViewById(R.id.btn_add);
        searchView = findViewById(R.id.search_view);
        backButton.setOnClickListener(view-> {
                MyActivitiesActivity.super.onBackPressed();
        });

        addButton.setOnClickListener(view-> {
                alertDialog();


        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // this is your adapter that will be filtered
                PagerAdapter pagerAdapter = (PagerAdapter) viewPager
                        .getAdapter();
                for (int i = 0; i < pagerAdapter.getCount(); i++) {

                    Fragment viewPagerFragment = (Fragment) viewPager
                            .getAdapter().instantiateItem(viewPager, i);
                    if (viewPagerFragment != null
                            && viewPagerFragment.isAdded()) {

                        if (viewPagerFragment instanceof FragmentCurrentActivity) {
                            currentActivity = (FragmentCurrentActivity) viewPagerFragment;
                            if (currentActivity != null) {
                                currentActivity.beginSearching(query);
                            }
                        } else if (viewPagerFragment instanceof FragmentPreViousList) {
                            fragmentPreViousList = (FragmentPreViousList) viewPagerFragment;
                            if (fragmentPreViousList != null) {
                                fragmentPreViousList.beginSearching(query);
                            }
                        } else if (viewPagerFragment instanceof FragmentUpComingList) {
                            fragmentUpComingList = (FragmentUpComingList) viewPagerFragment;
                            if (fragmentUpComingList != null) {
                                fragmentUpComingList.beginSearching(query);
                            }
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // this is your adapter that will be filtered
                PagerAdapter pagerAdapter = (PagerAdapter) viewPager
                        .getAdapter();
                for (int i = 0; i < pagerAdapter.getCount(); i++) {

                    Fragment viewPagerFragment = (Fragment) viewPager
                            .getAdapter().instantiateItem(viewPager, i);
                    if (viewPagerFragment != null
                            && viewPagerFragment.isAdded()) {

                        if (viewPagerFragment instanceof FragmentCurrentActivity) {
                            currentActivity = (FragmentCurrentActivity) viewPagerFragment;
                            if (currentActivity != null) {
                                currentActivity.beginSearching(query);
                            }
                        } else if (viewPagerFragment instanceof FragmentPreViousList) {
                            fragmentPreViousList = (FragmentPreViousList) viewPagerFragment;
                            if (fragmentPreViousList != null) {
                                fragmentPreViousList.beginSearching(query);
                            }
                        } else if (viewPagerFragment instanceof FragmentUpComingList) {
                            fragmentUpComingList = (FragmentUpComingList) viewPagerFragment;
                            if (fragmentUpComingList != null) {
                                fragmentUpComingList.beginSearching(query);
                            }
                        }
                    }
                }
                return true;
            }
        });


    }

    @Override
    protected void getIntentData() {


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentCurrentActivity(), "Today's Plan");
        adapter.addFragment(new FragmentPreViousList(), "Unexecuted Plan");
        adapter.addFragment(new FragmentUpComingList(), "Upcoming Plan");
        viewPager.setAdapter(adapter);
    }

    private void alertDialog() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MyActivitiesActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(MyActivitiesActivity.this);
        }
        builder.setTitle(getString(R.string.my_activity));
        builder.setMessage(getString(R.string.create_activity));
        builder.setIcon(R.drawable.lead);
        builder.setNegativeButton(getString(R.string.no), null);
        builder.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
            startActivity(new Intent(MyActivitiesActivity.this, VisitPLanDetailsActivity.class));
            finish();

        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            notifyDataSetChanged();
            return POSITION_NONE;
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

