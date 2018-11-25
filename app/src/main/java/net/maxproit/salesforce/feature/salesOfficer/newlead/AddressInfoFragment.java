package net.maxproit.salesforce.feature.salesOfficer.newlead;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.databinding.AddressLayoutBinding;
import net.maxproit.salesforce.databinding.FragmentAddressInfoBinding;
import net.maxproit.salesforce.model.newlead.Address;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.model.setting.PSe;
import net.maxproit.salesforce.util.CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class AddressInfoFragment extends BaseFragment {
    private static final String TAG = "AddressInfoFragment";

    FragmentAddressInfoBinding binding;
    NewLeadActivity activity;
    private LinearLayout parentLinearLayout;
    int count = 0;
    Context context;

    LocalSetting localSetting;
    List<String> landmark = new ArrayList<>();
    ArrayAdapter<String> addressTypeAdapter;
    ArrayAdapter<String> ownershipAdapter;
    ArrayAdapter<String> districeAdapter;
    ArrayAdapter<String> upozalaAdapter;
    ArrayAdapter<String> upozalaAdapterFilter;
    ArrayAdapter<String> landmarkAdapter;

    List<Address> addressList = new ArrayList<>();


    public static AddressInfoFragment newInstance() {
        Bundle args = new Bundle();
        AddressInfoFragment fragment = new AddressInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_address_info;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewLeadActivity) getActivity();
        this.context = context;
        localSetting = new LocalSetting(context);


        addressTypeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getAddressTypeStringList());
        ownershipAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getPurposeOfFinanceStringList());
        districeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getCityStringList());
        upozalaAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getPseStringList());

        landmarkAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, activity.landmark);


    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentAddressInfoBinding) getBinding();
        parentLinearLayout = binding.parentLinearLayout;

        if (activity.getNewLead().getAddresses() != null) {
            for (Address address : activity.getNewLead().getAddresses()) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                AddressLayoutBinding binding = DataBindingUtil.inflate(
                        inflater, R.layout.address_layout, null, false);
                binding.setModel(address);


                binding.spAddress.setAdapter(addressTypeAdapter);
                binding.spAddress.setOnSpinnerItemClickListener((i, s) -> {
                });

                binding.spOwnership.setAdapter(ownershipAdapter);
                binding.spOwnership.setOnSpinnerItemClickListener((i, s) -> {
                });


                binding.spDistrict.setAdapter(districeAdapter);
                binding.spDistrict.setOnSpinnerItemClickListener((i, s) -> {
                });
                binding.spUpozila.setAdapter(upozalaAdapter);
                binding.spUpozila.setOnSpinnerItemClickListener((i, s) -> {
                });


                parentLinearLayout.addView(binding.getRoot(), parentLinearLayout.getChildCount() - 1);
                binding.btnCLose.setVisibility(View.GONE);


                if (!address.getAddressType().isEmpty()) {
                    binding.spAddress.setSelection(localSetting.getAddressTypeStringList().lastIndexOf(address.getAddressType()));
                }

                if (!address.getPremiseOwnershipStatus().isEmpty()) {
                    binding.spOwnership.setSelection(localSetting.getOrgOwnershipTypeStringList().lastIndexOf(address.getPremiseOwnershipStatus()));
                }



                addressList.add(getData(binding));


            }


        }


        binding.addbuton.setOnClickListener(v -> {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            AddressLayoutBinding addressBinding = DataBindingUtil.inflate(
                    inflater, R.layout.address_layout, null, false);

            addressBinding.setModel(new Address());


            addressBinding.spLandmark.setAdapter(landmarkAdapter);
            addressBinding.spLandmark.setOnSpinnerItemClickListener((i, s) -> {
                addressBinding.etLandmark.setText(s);


            });




            addressBinding.spAddress.setAdapter(addressTypeAdapter);
            addressBinding.spOwnership.setAdapter(ownershipAdapter);


            parentLinearLayout
                    .addView(addressBinding.getRoot(), parentLinearLayout.getChildCount() - 1);


            // Remove Address Layout
            addressBinding.btnCLose
                    .setOnClickListener((View view) -> parentLinearLayout.removeView((View) view.getParent()));

            addressBinding.landMark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* if (activity.landmark.size()==0) {
                        GoogleLandMark googleLandMark = new GoogleLandMark(context, list -> {
                            landmark.add("Select LandMark");
                            landmark.addAll(list);

                        });
                        googleLandMark.run();
                    }*/
                }
            });


            addressList.add(getData(addressBinding));

        });

        activity.getNewLead().setAddresses(addressList);

    }

    private Address getData(AddressLayoutBinding addressBinding) {
        Address address = addressBinding.getModel();

        String date = new GsonBuilder().serializeNulls().create().toJson(address);
        Log.d(TAG, "getData: "+date);

        addressBinding.spAddress.setOnSpinnerItemClickListener((i, s) -> address.setAddressType(s));
        addressBinding.spOwnership.setOnSpinnerItemClickListener((i, s) -> address.setPremiseOwnershipStatus(s));


        addressBinding.spDistrict.setAdapter(districeAdapter);
        addressBinding.spDistrict.setOnSpinnerItemClickListener((i, s) -> {
            address.setCity(s);
            int cityId = localSetting.getCity().get(i).getCityID();

            List<String> upListByFilter = new ArrayList<>();
            for (PSe up : localSetting.getPse()) {
                if (up.getCityID() == cityId) {
                    upListByFilter.add(up.getPS());
                }
            }

            upozalaAdapterFilter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, upListByFilter);
            addressBinding.spUpozila.setAdapter(upozalaAdapterFilter);
            addressBinding.spUpozila.setOnSpinnerItemClickListener((i1, s1) -> address.setPs(s1));

            if (!StringUtils.isEmpty(address.getPs())) {
                if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(upListByFilter,address.getPs()))) {
                    addressBinding.spUpozila.setSelection(CommonUtil.getListPosition(upListByFilter,address.getPs()));
                }
            }

        });

        if (!StringUtils.isEmpty(address.getCity())) {
            if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(localSetting.getCityStringList(),address.getCity()))) {
                addressBinding.spDistrict.setSelection(CommonUtil.getListPosition(localSetting.getCityStringList(),address.getCity()));
            }
        }

        if (!StringUtils.isEmpty(address.getPremiseOwnershipStatus())) {
            if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(localSetting.getPurposeOfFinanceStringList(),address.getPremiseOwnershipStatus()))) {
                addressBinding.spOwnership.setSelection(CommonUtil.getListPosition(localSetting.getPurposeOfFinanceStringList(),address.getPremiseOwnershipStatus()));
            }
        }
        return address;


    }




}