package net.maxproit.salesforce.feature.salesOfficer.newlead;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.databinding.FragmentBasicInfoBinding;
import net.maxproit.salesforce.feature.search.SearchUserActivity;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.newlead.BasicInfo;
import net.maxproit.salesforce.model.setting.LocalSetting;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class BasicInfoFragment extends BaseFragment {
    private static final String TAG = "BasicInfoFragment";
    public static final int SERCH_CODE = 500;

    FragmentBasicInfoBinding binding;
    NewLeadActivity activity;
    LocalLogin localLogin;
    BasicInfo basicInfo;
    ArrayAdapter<String> idlcRelSpAdapter;
    LocalSetting localSetting;

    public static BasicInfoFragment newInstance() {
        Bundle args = new Bundle();
        BasicInfoFragment fragment = new BasicInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_basic_info;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewLeadActivity) getActivity();
        localLogin = new LocalLogin(context);
        localSetting = new LocalSetting(context);
        idlcRelSpAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getIdlcRelationTypeStringList());

    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentBasicInfoBinding) getBinding();
        binding.setModel(activity.getNewLead().getBasicInfo());
        basicInfo = binding.getModel();


        binding.etChif.setOnClickListener(v ->
                startActivityForResult(new Intent(getContext(), SearchUserActivity.class), SERCH_CODE));


        binding.spIdlcRelation.setAdapter(idlcRelSpAdapter);
        binding.spIdlcRelation.setOnSpinnerItemClickListener((i, s) -> {
            basicInfo.setRelationshipWithIDLC(s);
            if (s.equals("Existing")) {
                binding.liChif.setVisibility(View.VISIBLE);
            } else binding.liChif.setVisibility(View.GONE);

        });


        if (activity.getNewLead().getBasicInfo().getRelationshipWithIDLC() != null && !activity.getNewLead().getBasicInfo().getRelationshipWithIDLC().isEmpty()) {
            Log.d(TAG, "initFragmentComponents: " + activity.getNewLead().getBasicInfo().getRelationshipWithIDLC());
            binding.spIdlcRelation.setSelection(localSetting.getIdlcRelationTypeStringList().lastIndexOf(activity.getNewLead().getBasicInfo().getRelationshipWithIDLC()));
        }


        // Set Model
        basicInfo.setSalesOfficerCode(localLogin.getLocalogin().getData().getUserCode());
        basicInfo.setSupervisorCode(localLogin.getLocalogin().getData().getSTMCode());
        activity.getNewLead().setBasicInfo(basicInfo);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
