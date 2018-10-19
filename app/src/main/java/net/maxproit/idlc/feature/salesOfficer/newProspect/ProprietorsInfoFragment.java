package net.maxproit.idlc.feature.salesOfficer.newProspect;

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
import net.maxproit.idlc.databinding.FragmentProprietorsInfoBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.GuarantorInfoActivity;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.adapter.GuarantorInfoAdapter;
import net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo.OwnersInfoActivity;
import net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo.adapter.OwnerInfoAdapter;
import net.maxproit.idlc.model.newprospect.GuarantorsInfo;
import net.maxproit.idlc.model.newprospect.ProprietorsInfo;
import net.maxproit.idlc.model.setting.LocalSetting;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;


public class ProprietorsInfoFragment extends BaseFragment {
    FragmentProprietorsInfoBinding binding;
    NewProspectActivity activity;
    public static final String OWNER = "OWNER";
    public static final String MODEL_DATA = "MODEL_DATA";
    public static final int REQUEST_UPDATE = 100;
    public static final String REQUEST_UPDATE_POSITION = "REQUEST_UPDATE_POSITION";
    public static final int REQUEST_NEW = 101;


    Context context;
    List<ProprietorsInfo> list = new ArrayList<>();

    LocalSetting localSetting;
    OwnerInfoAdapter adapter;

    ProprietorsInfo info;


    public static ProprietorsInfoFragment newInstance() {
        Bundle args = new Bundle();
        ProprietorsInfoFragment fragment = new ProprietorsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_proprietors_info;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewProspectActivity) getActivity();
        this.context = context;
        localSetting = new LocalSetting(context);


    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentProprietorsInfoBinding) getBinding();
        list = activity.getNewProspect().getProprietorsInfo();
        setAdapter();



        binding.btnAdd.setOnClickListener(v->{
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE,OWNER);
            Intent i = new Intent(getContext(), OwnersInfoActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(new ProprietorsInfo());
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.OWNERS_INFO,date);
            startActivityForResult(i, REQUEST_NEW);


        });


    }

    private void setAdapter() {
        adapter = new OwnerInfoAdapter(context, list);
        // adapter.setContext(new AddressFragment());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.rv.setLayoutManager(mLayoutManager);
        binding.rv.setAdapter(adapter);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.FTYPE).equals(OWNER)) {
            if (resultCode == Activity.RESULT_OK) {
                if (requestCode == REQUEST_NEW) {
                    String date =  SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.OWNERS_INFO);
                    list.add(new GsonBuilder().serializeNulls().create().fromJson(date, ProprietorsInfo.class));

                } else if(requestCode == REQUEST_UPDATE) {
                    String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.OWNERS_INFO);
                    int position = SharedPreferencesEnum.getInstance().getInt(SharedPreferencesEnum.Key.OWNERS_INFO_POSITION);
                    list.set(position, new GsonBuilder().serializeNulls().create().fromJson(date, ProprietorsInfo.class));
                }
                setAdapter();
                if (list.size() > 0) {
                    activity.getNewProspect().setProprietorsInfo(list);
                }

            }

        }



    }




}
