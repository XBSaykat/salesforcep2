package net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentOwnersInfoBinding;
import net.maxproit.idlc.feature.search.SearchUserActivity;
import net.maxproit.idlc.model.newprospect.ProprietorsInfo;
import net.maxproit.idlc.model.setting.LocalSetting;
import net.maxproit.idlc.util.CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Rezwan Khan Chowdhury on 7/23/2018.
 * heyrezwan@gmail.com
 */
public class OwnersInfoFragment extends BaseFragment {
    private static final String TAG = "OwnersInfoFragment";
    FragmentOwnersInfoBinding binding;
    OwnersInfoActivity activity;
    Calendar calendar;
    Context context;
    LocalSetting localSetting;
    public static final int SERCH_CODE = 501;
    ArrayAdapter<String> ownersTypeAdapter;
    ArrayAdapter<String> maritalStatusAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (OwnersInfoActivity) getActivity();
        calendar = Calendar.getInstance();
        this.context = context;
        localSetting = new LocalSetting(context);
    }

    public static OwnersInfoFragment newInstance() {
        Bundle args = new Bundle();
        OwnersInfoFragment fragment = new OwnersInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_owners_info;
    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentOwnersInfoBinding) getBinding();

        ProprietorsInfo proprietorsInfo = activity.getProprietorsInfo();
        if (!StringUtils.isEmpty(proprietorsInfo.getDob())) {
            proprietorsInfo.setDob(CommonUtil.jsonToDate(proprietorsInfo.getDob()));
        }

        binding.setModel(proprietorsInfo);
        setView();
        setTitleView();


    }

    private void setTitleView() {

        CommonUtil.setSpinner(context, binding.spOwnerTitle, localSetting.getAllTitle());
        binding.spOwnerTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setProprietorTitle(s));
        CommonUtil.bindSpinner(binding.spOwnerTitle, localSetting.getAllTitle(), binding.getModel().getProprietorTitle());


        CommonUtil.setSpinner(context, binding.spfTitle, localSetting.getAllTitle());
        binding.spfTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setFathersTitle(s));
        CommonUtil.bindSpinner(binding.spfTitle, localSetting.getAllTitle(), binding.getModel().getFathersTitle());


        CommonUtil.setSpinner(context, binding.spmTitle, localSetting.getAllTitle());
        binding.spmTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setMothersTitle(s));
        CommonUtil.bindSpinner(binding.spmTitle, localSetting.getAllTitle(), binding.getModel().getMothersTitle());

        CommonUtil.setSpinner(context, binding.spsTitle, localSetting.getAllTitle());
        binding.spsTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setSpouseTitle(s));
        CommonUtil.bindSpinner(binding.spsTitle, localSetting.getAllTitle(), binding.getModel().getSpouseTitle());


    }


    private void setView() {
        Log.d(TAG, "setView: " + binding.getModel().getDob());

        binding.cbExist.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.etChif.setVisibility(View.VISIBLE);
            } else {
                binding.etChif.setVisibility(View.GONE);

            }
        });
        binding.etChif.setOnClickListener(v ->
                startActivityForResult(new Intent(getContext(), SearchUserActivity.class), SERCH_CODE));


        if (activity.getProprietorsInfo().getGender().equals("m")) {
            binding.m.setChecked(true);
        } else if (activity.getProprietorsInfo().getGender().equals("f")) {
            binding.f.setChecked(true);
        }

        binding.m.setOnClickListener(v -> activity.getProprietorsInfo().setGender("m"));
        binding.f.setOnClickListener(v -> activity.getProprietorsInfo().setGender("f"));
        binding.DateofBirth.setOnClickListener(v -> CommonUtil.showDatePicker(getContext(), binding.DateofBirth, calendar));


        ownersTypeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getOrgOwnershipTypeStringList());
        binding.spOwnershipType.setAdapter(ownersTypeAdapter);
        if (!activity.getProprietorsInfo().getOwnershipType().isEmpty()) {
            binding.spOwnershipType.setSelection(localSetting.getOrgOwnershipTypeStringList().lastIndexOf(activity.getProprietorsInfo().getOwnershipType().isEmpty()));
        }

        binding.spOwnershipType.setOnSpinnerItemClickListener((i, s) -> activity.getProprietorsInfo().setOwnershipType(s));


        maritalStatusAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, Arrays.asList("married", "unmarried"));
        binding.spMaritalStatus.setAdapter(maritalStatusAdapter);
        binding.spMaritalStatus.setOnSpinnerItemClickListener((i, s) -> activity.getProprietorsInfo().setMaritalStatus(s));

    }
}
