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
import net.maxproit.idlc.databinding.FragmentOwnersPersonalAssetsBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.GuarantorAddressActivity;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.adapter.GuarantorInfoAdressAdapter;
import net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo.adapter.OwnersInfoAssetsAdapter;
import net.maxproit.idlc.model.newprospect.Address;
import net.maxproit.idlc.model.newprospect.PersonalAssets;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/26/2018.
 * heyrezwan@gmail.com
 */
public class PersonalAssetsFragment extends BaseFragment {
    private static final String TAG = "PersonalAssetsFragment";
    FragmentOwnersPersonalAssetsBinding binding;
    public static final String PERSONAL_ASSETS ="PERSONAL_ASSETS";
    public static final String MODEL_DATA = "MODEL_DATA";
    public static final int REQUEST_UPDATE = 100;
    public static final String REQUEST_UPDATE_POSITION = "REQUEST_UPDATE_POSITION";
    public static final int REQUEST_NEW = 101;
    OwnersInfoAssetsAdapter adapter;
    OwnersInfoActivity activity;
    Context context;


    List<PersonalAssets> list= new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (OwnersInfoActivity) getActivity();
        this.context = context;
    }


    public static PersonalAssetsFragment newInstance() {
        Bundle args = new Bundle();
        PersonalAssetsFragment fragment = new PersonalAssetsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_owners_personal_assets;
    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentOwnersPersonalAssetsBinding) getBinding();
        list = activity.getProprietorsInfo().getPersonalAssets();
        setAdapter();


        binding.btnAdd.setOnClickListener(v -> {
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE,PERSONAL_ASSETS);
            Intent i = new Intent(getContext(), PersonalAssetsActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(new PersonalAssets());
            net.maxproit.idlc.util.SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.PERSONAL_ASSETS,date);
            startActivityForResult(i, REQUEST_NEW);

        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.FTYPE).equals(PERSONAL_ASSETS)) {
            if (resultCode == Activity.RESULT_OK) {
                if (requestCode == REQUEST_NEW) {
                    String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.PERSONAL_ASSETS);
                    list.add(new GsonBuilder().serializeNulls().create().fromJson(date, PersonalAssets.class));

                }else if (requestCode == REQUEST_UPDATE){
                    String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.PERSONAL_ASSETS);
                    int position = SharedPreferencesEnum.getInstance().getInt(SharedPreferencesEnum.Key.PERSONAL_ASSETS_POSITION);
                    list.set(position,new GsonBuilder().serializeNulls().create().fromJson(date, PersonalAssets.class));
                }
                setAdapter();
                if (list.size()>0) {
                    activity.getProprietorsInfo().setPersonalAssets(list);
                }

            }
        }


    }

    private void setAdapter() {
        Log.d(TAG, "setAdapter: "+activity.getProprietorsInfo().getPersonalAssets().size());
        adapter = new OwnersInfoAssetsAdapter(context, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.rv.setLayoutManager(mLayoutManager);
        binding.rv.setAdapter(adapter);
    }
}
