package net.maxproit.idlc.feature.salesOfficer.newlead;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentIndustryInfoBinding;
import net.maxproit.idlc.model.newlead.IndustryInfo;
import net.maxproit.idlc.model.setting.LocalSetting;
import net.maxproit.idlc.util.CommonUtil;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class IndustryInfoFragment extends BaseFragment {
    private static final String TAG = "IndustryInfoFragment";

    FragmentIndustryInfoBinding binding;
    NewLeadActivity activity;
    LocalSetting localSetting;
    Context context;


    ArrayAdapter<String> indSpAdapter;
    ArrayAdapter<String> legSpAdapter;

    public static IndustryInfoFragment newInstance() {
        Bundle args = new Bundle();
        IndustryInfoFragment fragment = new IndustryInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_industry_info;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewLeadActivity) getActivity();
        this.context =context;
        localSetting = new LocalSetting(context);

        indSpAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getIndTypeStringList());
        legSpAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getLegalStatusTypeStringList());


    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentIndustryInfoBinding) getBinding();
        binding.setModel(activity.getNewLead().getIndustryInfo());
        IndustryInfo info = binding.getModel();

        setTitleView();
        binding.spIndType.setAdapter(indSpAdapter);
        binding.spIndType.setOnSpinnerItemClickListener((position, itemAtPosition) -> info.setIndustry(itemAtPosition));

        binding.spLegalStatus.setAdapter(legSpAdapter);
        binding.spLegalStatus.setOnSpinnerItemClickListener((position, itemAtPosition) -> info.setLegalStatusType(itemAtPosition));


        binding.etMobileNumber.setOnFocusChangeListener((v, hasFocus) -> {
            if (!StringUtils.isEmpty(binding.etMobileNumber.getText().toString())) {
                if (binding.etMobileNumber.getText().toString().length() != 11) {
                    showToast("Invalid Mobile Number");
                }
            }
        });




        // Input Number convert To Word
        CommonUtil.numberToWord(binding.etYearlySales, binding.tvYearlySales);
        CommonUtil.numberToWord(binding.etInventory, binding.tvInventory);


        IndustryInfo industryInfo = activity.getNewLead().getIndustryInfo();
        // industryInfo.getIndustry()
        if (!StringUtils.isEmpty(industryInfo.getIndustry())) {
            binding.spIndType.setSelection(localSetting.getIndTypeStringList().lastIndexOf(industryInfo.getIndustry()));
        }

        if (!StringUtils.isEmpty(industryInfo.getLegalStatusType())) {
            binding.spLegalStatus.setSelection(localSetting.getLegalStatusTypeStringList().lastIndexOf(industryInfo.getLegalStatusType()));
        }


        activity.getNewLead().setIndustryInfo(binding.getModel());

    }

    private void setTitleView() {

        CommonUtil.setSpinner(context, binding.spOwnerTitle, localSetting.getAllTitle());
        binding.spOwnerTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setProprietorTitle(s));
        CommonUtil.bindSpinner(binding.spOwnerTitle, localSetting.getAllTitle(), binding.getModel().getProprietorTitle());
        Log.d(TAG, "setTitleView: "+binding.getModel().getProprietorTitle());
    }


}
