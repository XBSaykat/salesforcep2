package net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.gson.GsonBuilder;
import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityPersonalAssetsBinding;
import net.maxproit.idlc.feature.supervisor.adapter.UtilSpinner;
import net.maxproit.idlc.model.newprospect.PersonalAssets;
import net.maxproit.idlc.model.newprospect.PersonalAssetsPropertytype;
import net.maxproit.idlc.model.newprospect.PersonalAssetsType;
import net.maxproit.idlc.model.setting.LocalSetting;
import net.maxproit.idlc.model.setting.PropertyType;
import net.maxproit.idlc.model.setting.RealStateType;
import net.maxproit.idlc.util.CommonUtil;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PersonalAssetsActivity extends BaseActivity {
    private static final String TAG = "PersonalAssetsActivity";
    ActivityPersonalAssetsBinding binding;
    public static final String MODEL_DATA = "MODEL_DATA";
    PersonalAssets personalAssets;
    LocalSetting localSetting;
    ArrayAdapter<String> propertyAdapter;

    ArrayAdapter<String> realStateAdapter;

    List<String> realStateList = new ArrayList<>();
    List<Integer> realStateListposition = new ArrayList<>();
    List<String> propertList = new ArrayList<>();
    List<Integer> propertListposition = new ArrayList<>();



    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_personal_assets;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityPersonalAssetsBinding) getBinding();
        localSetting = new LocalSetting(this);
        getIntentData();
        binding.setModel(personalAssets);
        showView();
        Log.d(TAG, "initComponents: "+toJson(personalAssets));

        binding.btnSubmit.setOnClickListener(v -> {

            Intent intent = new Intent();
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.PERSONAL_ASSETS,toJson(binding.getModel()));
            setResult(Activity.RESULT_OK, intent);
            finish();


        });

    }

    private void showView() {

        for (RealStateType in : localSetting.getRealStateType()) {
            realStateList.add(in.getRealStateType());
            realStateListposition.add(in.getRealStateTypeCode());
        }

        realStateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, realStateList);

        binding.spRealStateType.setAdapter(realStateAdapter);
        binding.spRealStateType.setOnSpinnerItemClickListener((i, s) -> {
            binding.getModel().getType().setRealStateType(s);
        });

        try {
            if (!StringUtils.isEmpty(personalAssets.getType().getRealStateType())) {
                if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(realStateList,personalAssets.getType().getRealStateType()))) {
                    binding.spRealStateType.setSelection(CommonUtil.getListPosition(realStateList,personalAssets.getType().getRealStateType()));
                }
            }

        }catch (Exception e){

        }




        for (PropertyType in : localSetting.getPropertyType()) {
            propertList.add(in.getAssetType());
            propertListposition.add(in.getAssetTypeCode());
        }

        propertyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, propertList);
        binding.spPropertyType.setAdapter(propertyAdapter);
        binding.spPropertyType.setOnSpinnerItemClickListener((i, s) -> {
            binding.getModel().getPropertytype().setPropertyType(s);
        });

        try{
        if (!StringUtils.isEmpty(personalAssets.getPropertytype().getPropertyType())) {
            if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(propertList,personalAssets.getPropertytype().getPropertyType()))) {
                binding.spPropertyType.setSelection(CommonUtil.getListPosition(propertList,personalAssets.getPropertytype().getPropertyType()));
            }
        }}catch (Exception e){}

    }

    @Override
    protected void getIntentData() {
        String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.PERSONAL_ASSETS);
        personalAssets = new GsonBuilder().serializeNulls().create().fromJson(date, PersonalAssets.class);

    }
}
