package net.maxproit.idlc.feature.salesOfficer.newProspect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentGuarantorsInfoBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.GuarantorInfoActivity;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.adapter.Clicklistener;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.adapter.GuarantorInfoAdapter;
import net.maxproit.idlc.model.newprospect.GuarantorsInfo;
import net.maxproit.idlc.model.setting.LocalSetting;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;


public class GuarantorsInfoFragment extends BaseFragment implements Clicklistener {
    FragmentGuarantorsInfoBinding binding;
    NewProspectActivity activity;
    public static final String GUARANTOR = "GUARANTOR";
    private static final String TAG = "GuarantorsInfoFragment";
    GuarantorsInfo gnf;
    List<GuarantorsInfo> list = new ArrayList<>();

    public static final String MODEL_DATA = "MODEL_DATA";
    public static final int REQUEST_UPDATE = 100;
    public static final String REQUEST_UPDATE_POSITION = "REQUEST_UPDATE_POSITION";
    public static final int REQUEST_NEW = 101;

    GuarantorInfoAdapter adapter;


    Context context;
    LocalSetting localSetting;


    public static GuarantorsInfoFragment newInstance() {
        Bundle args = new Bundle();
        GuarantorsInfoFragment fragment = new GuarantorsInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_guarantors_info;
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
        binding = (FragmentGuarantorsInfoBinding) getBinding();
        list = activity.getNewProspect().getGuarantorsInfo();
        setAdapter();


        binding.btnAdd.setOnClickListener(v -> {
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE, GUARANTOR);
            Intent i = new Intent(getContext(), GuarantorInfoActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(new GuarantorsInfo());

            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.GUARANTOR_INFO, date);
            startActivityForResult(i, REQUEST_NEW);


        });


    }

    private void setAdapter() {
        adapter = new GuarantorInfoAdapter(getContext(), list);
        // adapter.setContext(new AddressFragment());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.rv.setLayoutManager(mLayoutManager);
        binding.rv.setAdapter(adapter);
    }


    @Override
    public void viewClick(int i) {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.FTYPE).equals(GUARANTOR)) {
            if (resultCode == Activity.RESULT_OK) {
                if (requestCode == REQUEST_NEW) {
                    String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.GUARANTOR_INFO);
                    list.add(new GsonBuilder().serializeNulls().create().fromJson(date, GuarantorsInfo.class));

                } else if (requestCode == REQUEST_UPDATE) {
                    String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.GUARANTOR_INFO);
                    int position = SharedPreferencesEnum.getInstance().getInt(SharedPreferencesEnum.Key.GUARANTOR_INFO_POSITION);
                    list.set(position, new GsonBuilder().serializeNulls().create().fromJson(date, GuarantorsInfo.class));
                }
                setAdapter();
                if (list.size() > 0) {
                    activity.getNewProspect().setGuarantorsInfo(list);
                }

            }

        }




    }


}
