package net.maxproit.salesforce.masum.activity.prospect;

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
import net.maxproit.salesforce.masum.appdata.preference.AppPreference;
import net.maxproit.salesforce.masum.appdata.preference.PrefKey;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.fragment.prospect.myprospect.FragmentProspectPendingList;
import net.maxproit.salesforce.masum.fragment.prospect.myprospect.FragmentProspectreturn;

import java.util.ArrayList;
import java.util.List;

public class MyProspectFragmentActivity extends BaseActivity {



    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinearLayout linearLayoutToolbar;
    private TextView btnSave;
    private MyLeadDbController myLeadDbController;
    private ImageView backButton, addButton;
    private SearchView searchView;
    private  FragmentProspectPendingList fragmentProspectPendingList;
    private  FragmentProspectreturn prospectreturn;



    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_prospect_fragment;
    }

    @Override
    protected void initComponents() {
        AppPreference.getInstance(getActivity()).setBoolean(PrefKey.IS_LOADED,false);
        linearLayoutToolbar = findViewById(R.id.linear_layout_my_activity_toolbar);
        viewPager = (ViewPager) findViewById(R.id.vp_my_activity);
        setupViewPager(viewPager);
        // viewPager.setOffscreenPageLimit(3);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_my_activity);
        tabLayout.setupWithViewPager(viewPager);
        backButton = findViewById(R.id.btn_back);
        searchView = findViewById(R.id.search_view);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyProspectFragmentActivity.super.onBackPressed();
            }
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

                        if (viewPagerFragment instanceof FragmentProspectPendingList) {
                            fragmentProspectPendingList = (FragmentProspectPendingList) viewPagerFragment;
                            if (fragmentProspectPendingList != null) {
                                fragmentProspectPendingList.beginSearching(query);
                            }
                        } else if (viewPagerFragment instanceof FragmentProspectreturn) {
                            prospectreturn = (FragmentProspectreturn) viewPagerFragment;
                            if (prospectreturn != null) {
                                prospectreturn.beginSearching(query);
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

                        if (viewPagerFragment instanceof FragmentProspectPendingList) {
                            fragmentProspectPendingList = (FragmentProspectPendingList) viewPagerFragment;
                            if (fragmentProspectPendingList != null) {
                                fragmentProspectPendingList.beginSearching(query);
                            }
                        } else if (viewPagerFragment instanceof FragmentProspectreturn) {
                            prospectreturn = (FragmentProspectreturn) viewPagerFragment;
                            if (prospectreturn != null) {
                                prospectreturn.beginSearching(query);
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
        MyProspectFragmentActivity.ViewPagerAdapter adapter = new MyProspectFragmentActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentProspectPendingList(), "Pending                  ");
        adapter.addFragment(new FragmentProspectreturn(), "Return From RBM");
        viewPager.setAdapter(adapter);

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



