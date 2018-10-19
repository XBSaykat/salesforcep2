package net.maxproit.idlc.feature.salesOfficer.newProspect;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.AddressLayoutProspectBinding;
import net.maxproit.idlc.databinding.FragmentAddressInfoBinding;
import net.maxproit.idlc.model.newprospect.Address;
import net.maxproit.idlc.model.setting.LocalSetting;
import net.maxproit.idlc.model.setting.PSe;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class ProspectAddressInfoFragment extends BaseFragment {
    private static final String TAG = "ProspectAddressInfoFrag";

    FragmentAddressInfoBinding binding;
    NewProspectActivity activity;
    private LinearLayout parentLinearLayout;
    int count = 0;
    Context context;
    ArrayAdapter<String> addressTypeAdapter;
    ArrayAdapter<String> ownershipAdapter;
    ArrayAdapter<String> districeAdapter;
    ArrayAdapter<String> upozalaAdapter;
    ArrayAdapter<String> upozalaAdapterFilter;
    ArrayAdapter<String> landmarkAdapter;
    LocalSetting localSetting;
    List<Address> addressList = new ArrayList<>();


    public static ProspectAddressInfoFragment newInstance() {
        Bundle args = new Bundle();
        ProspectAddressInfoFragment fragment = new ProspectAddressInfoFragment();
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
        activity = (NewProspectActivity) getActivity();
        this.context = context;
        localSetting = new LocalSetting(context);


        addressTypeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getAddressTypeStringList());
        ownershipAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getPurposeOfFinanceStringList());
        districeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getCityStringList());

        landmarkAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, activity.landmark);


    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentAddressInfoBinding) getBinding();
        parentLinearLayout = binding.parentLinearLayout;

        createView();

        binding.addbuton.setOnClickListener(v -> {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            AddressLayoutProspectBinding a = DataBindingUtil.inflate(
                    inflater, R.layout.address_layout_prospect, null, false);

            a.setModel(new Address());


            a.spLandmark.setAdapter(landmarkAdapter);
            a.spLandmark.setOnSpinnerItemClickListener((i, s) -> a.etLandmark.setText(s));


            a.spAddress.setAdapter(addressTypeAdapter);
            a.spOwnership.setAdapter(ownershipAdapter);


            parentLinearLayout
                    .addView(a.getRoot(), parentLinearLayout.getChildCount() - 1);
            a.btnCLose
                    .setOnClickListener((View view) -> parentLinearLayout.removeView((View) view.getParent()));


            addressList.add(getData(a));

        });

        activity.getNewProspect().setProspectAddresses(addressList);


    }

    private void createView() {

        if (activity.getNewProspect().getProspectAddresses() != null) {
            for (Address address : activity.getNewProspect().getProspectAddresses()) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                AddressLayoutProspectBinding ad = DataBindingUtil.inflate(
                        inflater, R.layout.address_layout_prospect, null, false);
                ad.setModel(address);

                String data = new GsonBuilder().serializeNulls().create().toJson(address);
                Log.d(TAG, "createView: "+data);

                parentLinearLayout.addView(ad.getRoot(), parentLinearLayout.getChildCount() - 1);
                ad.btnCLose.setVisibility(View.GONE);


                addressList.add(getData(ad));


            }


        }

    }

    private Address getData(AddressLayoutProspectBinding addressBinding) {
        Address address = addressBinding.getModel();

        addressBinding.spAddress.setAdapter(addressTypeAdapter);
        addressBinding.spAddress.setOnSpinnerItemClickListener((i, s) ->{
            address.setAddressType(s);

        });

        // Address Type
        if (!StringUtils.isEmpty(address.getAddressType())) {
            addressBinding.spAddress.setSelection(getListPosition(localSetting.getAddressTypeStringList(),address.getAddressType()));
        }



        addressBinding.spOwnership.setAdapter(ownershipAdapter);
        addressBinding.spOwnership.setOnSpinnerItemClickListener((i, s) -> address.setPremiseOwnershipStatus(s));
        if (!StringUtils.isEmpty(address.getPremiseOwnershipStatus())) {
            if (getListPosition(localSetting.getPurposeOfFinanceStringList(),address.getPremiseOwnershipStatus())!=-1) {
                addressBinding.spOwnership.setSelection(getListPosition(localSetting.getPurposeOfFinanceStringList(),address.getPremiseOwnershipStatus()));
            }

        }


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
                if (getListPosition(upListByFilter,address.getPs())!=-1) {
                    addressBinding.spUpozila.setSelection(getListPosition(upListByFilter,address.getPs()));
                }

            }


        });

        Log.d(TAG, "getData: "+addressBinding.getModel().getCity());

        if (!StringUtils.isEmpty(address.getCity())) {
            if (getListPosition(localSetting.getCityStringList(),address.getCity())!=-1) {
                addressBinding.spDistrict.setSelection(getListPosition(localSetting.getCityStringList(),address.getCity()));
            }

        }


        return address;


    }


    public int getListPosition(List<String> list, String s){
        int r =-1;
        for (int i=0; i <list.size();i++) {
            if (list.get(i).equals(s)) {
                r= i;
            }
        }

        return r;
    }

}