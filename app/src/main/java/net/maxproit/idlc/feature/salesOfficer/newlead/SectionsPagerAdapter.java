package net.maxproit.idlc.feature.salesOfficer.newlead;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    public int fragmentCount = 0;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> pageTitles;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);

        fragmentList = new ArrayList<>();
        fragmentList.add(BasicInfoFragment.newInstance());
        fragmentList.add(IndustryInfoFragment.newInstance());
        fragmentList.add(AddressInfoFragment.newInstance());
        // fragmentList.add(LegalStructureFragment.newInstance());
        fragmentList.add(VisitRecordFragment.newInstance());
        fragmentList.add(DocumentFragment.newInstance()); //6

        pageTitles = new ArrayList<>();
        pageTitles.add("Basic Info");
        pageTitles.add("Industry");
        pageTitles.add("Address");
        //  pageTitles.add("Legal Structure");
        pageTitles.add("Visit Record");
        pageTitles.add("Documents");//7


        fragmentCount = fragmentList.size();


    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles.get(position);
    }
}