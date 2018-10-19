package net.maxproit.idlc.feature.salesOfficer.newlead;

import android.content.Context;
import android.os.Bundle;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentLegalStructureBinding;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class LegalStructureFragment extends BaseFragment {
    FragmentLegalStructureBinding binding;
    NewLeadActivity activity;


    public static LegalStructureFragment newInstance() {
        Bundle args = new Bundle();
        LegalStructureFragment fragment = new LegalStructureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_legal_structure;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewLeadActivity) getActivity();

    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentLegalStructureBinding) getBinding();
        // TODo: Error
        //binding.setModel(activity.getNewLead().getLegalStructure());


    }


}
