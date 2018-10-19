package net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentGuarantorPersonaAddressBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.GuarantorAddressActivity;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.adapter.Clicklistener;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.adapter.GuarantorInfoAdressAdapter;
import net.maxproit.idlc.model.newprospect.Address;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class AddressFragment extends BaseFragment implements Clicklistener {
    private static final String TAG = "AddressFragment";

    FragmentGuarantorPersonaAddressBinding binding;
    public static final String MODEL_DATA = "MODEL_DATA";
    public static final int REQUEST_UPDATE = 100;
    public static final String REQUEST_UPDATE_POSITION = "REQUEST_UPDATE_POSITION";
    public static final int REQUEST_NEW = 101;
    public static final String ADDRESS = "ADDRESS";
    OwnersInfoActivity activity;

    List<Address> list = new ArrayList<>();

    GuarantorInfoAdressAdapter adapter;


    public static AddressFragment newInstance() {
        Bundle args = new Bundle();
        AddressFragment fragment = new AddressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (OwnersInfoActivity) getActivity();
    }


    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_guarantor_persona_address;
    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentGuarantorPersonaAddressBinding) getBinding();
        list = activity.getProprietorsInfo().getAddresses();
        setAdapter();

        binding.btnAdd.setOnClickListener(v -> {
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE, ADDRESS);
            Intent i = new Intent(getContext(), GuarantorAddressActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(new Address());


            net.maxproit.idlc.util.SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.ADDRESS, date);
            startActivityForResult(i, REQUEST_NEW);

        });

    }

    private void setAdapter() {
        adapter = new GuarantorInfoAdressAdapter(getContext(), list);
        adapter.setContext(new net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.AddressFragment());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.rv.setLayoutManager(mLayoutManager);
        binding.rv.setAdapter(adapter);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.FTYPE).equals(ADDRESS)) {
            if (resultCode == Activity.RESULT_OK) {
                if (requestCode == REQUEST_NEW) {
                    android.util.Log.d(TAG, "onActivityResult: --------New");
                    String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.ADDRESS);
                    list.add(new GsonBuilder().serializeNulls().create().fromJson(date, Address.class));

                } else if (requestCode == REQUEST_UPDATE) {
                    Log.d(TAG, "onActivityResult: --------Update");
                    String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.ADDRESS);
                    int position = SharedPreferencesEnum.getInstance().getInt(SharedPreferencesEnum.Key.ADDRESS_POSITION);
                    Log.d(TAG, "onActivityResult: " + position + date);
                    list.set(position, new GsonBuilder().serializeNulls().create().fromJson(date, Address.class));


                }
                setAdapter();
                if (list.size() > 0) {
                    activity.getProprietorsInfo().setAddresses(list);
                }

            }
        }


    }

    @Override
    public void viewClick(int i) {


    }
}
