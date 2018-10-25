package net.maxproit.salesforce.feature.salesOfficer.newProspect.guarantorinfo;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityGuarantorAddressBinding;
import net.maxproit.salesforce.model.newprospect.Address;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.model.setting.PSe;
import net.maxproit.salesforce.util.GoogleLandMark;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

public class GuarantorAddressActivity extends BaseActivity  {
    private static final String TAG = "GuarantorAddressActivit";


    public static final String MODEL_DATA = "MODEL_DATA";

    ActivityGuarantorAddressBinding binding;
    Address address;


    LocalSetting localSetting;


    ArrayAdapter<String> addressTypeAdapter;
    ArrayAdapter<String> ownershipAdapter;
    ArrayAdapter<String> districeAdapter;
    ArrayAdapter<String> upozalaAdapterFilter;
    ArrayAdapter<String> landmarkAdapter;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_guarantor_address;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityGuarantorAddressBinding) getBinding();
        localSetting = new LocalSetting(this);

        addressTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, localSetting.getAddressTypeStringList());
        ownershipAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, localSetting.getPurposeOfFinanceStringList());
        districeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, localSetting.getCityStringList());


        getIntentData();
        binding.setModel(address);
        Log.d(TAG, "initComponents: "+toJson(address));
        setView();



        binding.btnSubmit.setOnClickListener(v -> {
            if (isValidForm()) {
                Intent intent = new Intent();
                SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.ADDRESS,toJson(binding.getModel()));
                setResult(Activity.RESULT_OK, intent);
                 finish();
            }


        });

    }

    private void setView() {


        GoogleLandMark googleLandMark = new GoogleLandMark(this, (List<String> list) -> {
            landmarkAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
            binding.spLandmark.setAdapter(landmarkAdapter);
            binding.spLandmark.setOnSpinnerItemClickListener((i, s) -> binding.etLandmark.setText(s));
        });
        googleLandMark.run();


        binding.spAddress.setAdapter(addressTypeAdapter);
        binding.spAddress.setOnSpinnerItemClickListener((i, s) -> address.setAddressType(s));
        if (!address.getAddressType().isEmpty()) {
            binding.spAddress.setSelection(localSetting.getAddressTypeStringList().lastIndexOf(address.getAddressType()));

        }

        binding.spOwnership.setAdapter(ownershipAdapter);
        binding.spOwnership.setOnSpinnerItemClickListener((i, s) -> address.setPremiseOwnershipStatus(s));
        if (!address.getPremiseOwnershipStatus().isEmpty()) {
            binding.spOwnership.setSelection(localSetting.getOrgOwnershipTypeStringList().lastIndexOf(address.getPremiseOwnershipStatus()));

        }


        binding.spDistrict.setAdapter(districeAdapter);
        binding.spDistrict.setOnSpinnerItemClickListener((i, s) -> {
            address.setCity(s);
            int cityId = localSetting.getCity().get(i).getCityID();

            List<String> upListByFilter = new ArrayList<>();
            for (PSe up : localSetting.getPse()) {
                if (up.getCityID() == cityId) {
                    upListByFilter.add(up.getPS());
                }
            }

            upozalaAdapterFilter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, upListByFilter);
            binding.spUpozila.setAdapter(upozalaAdapterFilter);
            binding.spUpozila.setOnSpinnerItemClickListener((i1, s1) -> address.setPs(s1));
            if (!address.getPs().isEmpty()) {
                binding.spUpozila.setSelection(upListByFilter.lastIndexOf(address.getPs()));

            }


        });


        if (!address.getCity().isEmpty()) {
            binding.spDistrict.setSelection(localSetting.getCityStringList().lastIndexOf(address.getCity()));

        }












    }


    @Override
    protected void getIntentData() {
        String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.ADDRESS);
        address = new GsonBuilder().serializeNulls().create().fromJson(date, Address.class);


    }


    private boolean isValidForm() {
        if (address.getAddressType().isEmpty()) {
            showToast("Please Enter Address Type");
            return false;
        } else if (address.getCity().isEmpty()) {
            showToast("Please Enter District");
            return false;
        /*} else if (address.getVillage().isEmpty()) {
            showToast("Please Enter Thana/Upazilla");
            return false;*/
        } else if (address.getPremiseOwnershipStatus().isEmpty()) {
            showToast("Please Enter Ownership");
            return false;
        }

        return true;
    }


}
