package net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo.AddressFragment;
import net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo.OwnersInfoFragment;
import net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo.PersonalAssetsFragment;

import java.util.ArrayList;

/**
 * Created by Rezwan Khan Chowdhury on 7/23/2018.
 * heyrezwan@gmail.com
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    public int fragmentCount = 0;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> pageTitles;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);

        fragmentList = new ArrayList<>();
        fragmentList.add(OwnersInfoFragment.newInstance());
        fragmentList.add(PersonalAssetsFragment.newInstance());
        fragmentList.add(AddressFragment.newInstance());

        pageTitles = new ArrayList<>();
        pageTitles.add("Owners");
        pageTitles.add("Personal Assets");
        pageTitles.add("Address");


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