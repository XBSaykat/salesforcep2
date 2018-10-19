package net.maxproit.idlc.feature.salesOfficer.newProspect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentParalalRequestRecordBinding;
import net.maxproit.idlc.feature.salesOfficer.parallelprocess.cib.CibActivity;
import net.maxproit.idlc.feature.salesOfficer.parallelprocess.cif.CifActivity;
import net.maxproit.idlc.feature.salesOfficer.parallelprocess.DeviationActivity;
import net.maxproit.idlc.feature.salesOfficer.parallelprocess.daviation.DaviationListActivity;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class ParalalRequestFragment extends BaseFragment {
    FragmentParalalRequestRecordBinding binding;
    NewProspectActivity activity;


    public static ParalalRequestFragment newInstance() {
        Bundle args = new Bundle();
        ParalalRequestFragment fragment = new ParalalRequestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_paralal_request_record;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewProspectActivity) getActivity();

    }

    @Override
    protected void initFragmentComponents() {
        Bundle bundle = new Bundle();
        bundle.putString(CifActivity.KEY_REFERRENCE_ID,
                activity.oleProspect.getData().getProspectReferenceNo()
        );

        binding = (FragmentParalalRequestRecordBinding) getBinding();
        binding.cib.setOnClickListener(v ->
                startActivity(new Intent(getContext(), CibActivity.class).putExtras(bundle)));
        binding.sif.setOnClickListener(v ->
                startActivity(new Intent(getContext(), CifActivity.class).putExtras(bundle)
                ));
        binding.deviation.setOnClickListener(v ->
                startActivity(new Intent(getContext(), DaviationListActivity.class).putExtras(bundle)));

        // binding.rlApprove.setVisibility(activity.isApproval() ? View.VISIBLE  : View.GONE);
        activity.disableEnableControls(!activity.isApproval(), binding.basicInfoLead);

    }




}
