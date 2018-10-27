package net.maxproit.salesforce.feature.salesOfficer.newProspect;

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
        fragmentList.add(GeneralInfoFragment.newInstance());
        fragmentList.add(LoanInfoFragment.newInstance());
        fragmentList.add(ProprietorsInfoFragment.newInstance());
        fragmentList.add(GuarantorsInfoFragment.newInstance());
        fragmentList.add(VisitRecordFragment.newInstance());
        fragmentList.add(ProspectAddressInfoFragment.newInstance());
        fragmentList.add(DocumentFragment.newInstance()); //6
        fragmentList.add(ParalalRequestFragment.newInstance()); //6

        pageTitles = new ArrayList<>();
        pageTitles.add("General Info");
        pageTitles.add("Loan Info");
        pageTitles.add("Owner's info");
        pageTitles.add("Guarantor’s Info");
        pageTitles.add("Visit Record");
        pageTitles.add("Business Address");
        pageTitles.add("Documents");//7
        pageTitles.add("Parallel request");//7


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