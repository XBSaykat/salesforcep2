package net.maxproit.salesforce.feature.salesOfficer.newProspect;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.databinding.FragmentGeneralInfoBinding;
import net.maxproit.salesforce.model.newprospect.GeneralInfo;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.CommonUtil;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;


public class GeneralInfoFragment extends BaseFragment {
    private static final String TAG = "GeneralInfoFragment";
    LocalSetting localSetting;
    FragmentGeneralInfoBinding binding;
    NewProspectActivity activity;
    Calendar calendar;
    boolean active = true;

    String roll;
    ArrayAdapter<String> indTypeAdapter;
    ArrayAdapter<String> relAdapter;
    private Context context;


    ArrayAdapter<String> legSpAdapter;

    public static GeneralInfoFragment newInstance() {
        Bundle args = new Bundle();
        GeneralInfoFragment fragment = new GeneralInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_general_info;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        activity = (NewProspectActivity) getActivity();

        localSetting = new LocalSetting(context);
        indTypeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getIndTypeStringList());
        relAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getIdlcRelationTypeStringList());
        legSpAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getLegalStatusTypeStringList());


    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentGeneralInfoBinding) getBinding();
        activity.disableEnableControls(!activity.isApproval(), binding.basicInfoLead);

        roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
        if (roll.equals("2")) supervisorView();

        GeneralInfo info = activity.getNewProspect().getGeneralInfo();
        binding.setModel(info);
        binding.setActive(active);


        binding.spLegalStatus.setAdapter(legSpAdapter);
        binding.spLegalStatus.setOnSpinnerItemClickListener((position, itemAtPosition) -> info.setLegalStatus(itemAtPosition));

        if (!StringUtils.isEmpty(info.getLegalStatus())) {
            binding.spLegalStatus.setSelection(localSetting.getLegalStatusTypeStringList().lastIndexOf(info.getLegalStatus()));
        }


//        if (info.getRelationShip() != null) {
//            binding.spRelationship.setSelection(localSetting.getIdlcRelationTypeStringList().lastIndexOf(info.getRelationShip()));
//        }


        if ( !StringUtils.isEmpty(info.getLicenseIssuedate())) {
            info.setLicenseIssuedate(CommonUtil.jsonToDate(info.getLicenseIssuedate()));
        }
        if (!StringUtils.isEmpty(info.getLicenseExpiredate())) {
            info.setLicenseExpiredate(CommonUtil.jsonToDate(info.getLicenseExpiredate()));
        }

        if (!StringUtils.isEmpty(info.getBusinessSince())) {
            info.setBusinessSince(CommonUtil.jsonToDate(info.getBusinessSince()));
        }


        GeneralInfo generalInfo = binding.getModel();

        binding.spIndustryType.setAdapter(indTypeAdapter);
        binding.spIndustryType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                generalInfo.setIndustryType(s);
            }
        });

        if (info.getIndustryType() != null) {
            binding.spIndustryType.setSelection(localSetting.getIndTypeStringList().lastIndexOf(info.getIndustryType()));
        }


        binding.spRelationship.setAdapter(relAdapter);
        binding.spRelationship.setOnSpinnerItemClickListener((i, s) -> generalInfo.setRelationShip(s));
        if (!StringUtils.isEmpty(info.getRelationShip())) {
            Log.d(TAG, "initFragmentComponents: " + info.getRelationShip());
            if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(localSetting.getIdlcRelationTypeStringList(), info.getRelationShip()))) {
                binding.spRelationship.setSelection(CommonUtil.getListPosition(localSetting.getIdlcRelationTypeStringList(), info.getRelationShip()));
            }
        }


        calendar = Calendar.getInstance();
        binding.lisDate.setOnClickListener(v -> CommonUtil.showDatePicker(getContext(), binding.lisDate, calendar));
        binding.liexpDate.setOnClickListener(v -> CommonUtil.showDatePicker(getContext(), binding.liexpDate, calendar));
        binding.etBusinessSince.setOnClickListener(v -> {
            CommonUtil.showMonthYearPicker(getContext(), binding.etBusinessSince, calendar);
            if (!StringUtils.isEmpty(binding.etBusinessSince.getText().toString())) {
                generalInfo.setBusinessSince(binding.etBusinessSince.getText().toString()+01);
            }
        });



        activity.getNewProspect().setGeneralInfo(generalInfo);

    }

    private void supervisorView() {
        active = false;
        binding.setActive(active);
    }


}
