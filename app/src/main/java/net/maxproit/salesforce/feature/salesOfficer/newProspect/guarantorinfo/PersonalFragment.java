package net.maxproit.salesforce.feature.salesOfficer.newProspect.guarantorinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.databinding.FragmentGuarantorPersonaBinding;
import net.maxproit.salesforce.feature.search.SearchUserActivity;
import net.maxproit.salesforce.model.newprospect.GuarantorsInfo;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class PersonalFragment extends BaseFragment {

    FragmentGuarantorPersonaBinding binding;
    GuarantorInfoActivity activity;
    Calendar calendar;
    Context context;
    LocalSetting localSetting;
    List<String> maritalList = Arrays.asList("married", "unmarried");
    public static final int SERCH_CODE = 502;



    public static PersonalFragment newInstance() {
        Bundle args = new Bundle();
        PersonalFragment fragment = new PersonalFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context =context;
        activity = (GuarantorInfoActivity) getActivity();
        calendar = Calendar.getInstance();
        localSetting = new LocalSetting(context);
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_guarantor_persona;
    }

    @Override
    protected void initFragmentComponents() {
        binding= (FragmentGuarantorPersonaBinding)getBinding();
        GuarantorsInfo guarantorsInfo =activity.getGuarantorsInfo();
        if (!StringUtils.isEmpty(guarantorsInfo.getDob())) {
            guarantorsInfo.setDob(CommonUtil.jsonToDate(guarantorsInfo.getDob()));
        }


        binding.setModel(guarantorsInfo);
        setView();
        setTitleView();


    }

    private void setTitleView() {


        CommonUtil.setSpinner(context, binding.spOwnerTitle, localSetting.getAllTitle());
        binding.spOwnerTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setGuarantorTitle(s));
        CommonUtil.bindSpinner(binding.spOwnerTitle, localSetting.getAllTitle(), binding.getModel().getGuarantorTitle());


        CommonUtil.setSpinner(context, binding.spfTitle, localSetting.getAllTitle());
        binding.spfTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setFathersTitle(s));
        CommonUtil.bindSpinner(binding.spfTitle, localSetting.getAllTitle(), binding.getModel().getFathersTitle());


        CommonUtil.setSpinner(context, binding.spmTitle, localSetting.getAllTitle());
        binding.spmTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setMothersTitle(s));
        CommonUtil.bindSpinner(binding.spmTitle, localSetting.getAllTitle(), binding.getModel().getMothersTitle());

        CommonUtil.setSpinner(context, binding.spsTitle, localSetting.getAllTitle());
        binding.spsTitle.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setSpouseTitle(s));
        CommonUtil.bindSpinner(binding.spsTitle, localSetting.getAllTitle(), binding.getModel().getSpouseTitle());


        //------------
        CommonUtil.setSpinner(context, binding.spRelationShipApp, localSetting.getRealStateTypeString());
        binding.spRelationShipApp.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setRelationShip(s));
        CommonUtil.bindSpinner(binding.spRelationShipApp, localSetting.getRealStateTypeString(), binding.getModel().getRelationShip());

        CommonUtil.setSpinner(context, binding.spProfession, localSetting.getProfessionString());
        binding.spProfession.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setProfession(s));
        CommonUtil.bindSpinner(binding.spProfession, localSetting.getProfessionString(), binding.getModel().getProfession());

        CommonUtil.setSpinner(context, binding.spMaritalStatus, maritalList);
        binding.spMaritalStatus.setOnSpinnerItemClickListener((i, s) ->binding.getModel().setMaritalStatus(s));
        CommonUtil.bindSpinner(binding.spMaritalStatus, maritalList, binding.getModel().getMaritalStatus());
    }

    private void setView() {
        binding.cbExist.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.etChif.setVisibility(View.VISIBLE);
            } else {
                binding.etChif.setVisibility(View.GONE);

            }
        });
        binding.etChif.setOnClickListener(v ->
                startActivityForResult(new Intent(getContext(), SearchUserActivity.class), SERCH_CODE));


        if (activity.getGuarantorsInfo().getGender().equals("m")) {
            binding.m.setChecked(true);
        } else if (activity.getGuarantorsInfo().getGender().equals("f")) {
            binding.f.setChecked(true);
        }

        binding.m.setOnClickListener(v -> activity.getGuarantorsInfo().setGender("m"));
        binding.f.setOnClickListener(v -> activity.getGuarantorsInfo().setGender("f"));
        binding.DateofBirth.setOnClickListener(v -> CommonUtil.showDatePicker(getContext(), binding.DateofBirth, calendar));
    }
}
