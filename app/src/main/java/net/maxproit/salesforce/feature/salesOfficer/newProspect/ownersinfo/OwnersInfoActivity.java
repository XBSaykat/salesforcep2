package net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityOwnersInfoBinding;
import net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo.adapter.SectionsPagerAdapter;
import net.maxproit.salesforce.model.newprospect.ProprietorsInfo;
import net.maxproit.salesforce.model.search.proprietor.SearchProprietor;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnersInfoActivity extends BaseActivity {
    private ActivityOwnersInfoBinding binding;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    ProprietorsInfo propInfo;
    private static final String TAG = "OwnersInfoActivity";
    public static final String MODEL_DATA = "MODEL_DATA";
    public static final String LEAD_INDEX_ID = "LEAD_INDEX_ID";
    public static final String CIF_ID = "CIF_ID";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_owners_info;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityOwnersInfoBinding) getBinding();
        getIntentData();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        binding.container.setAdapter(mSectionsPagerAdapter);
        binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);
        binding.tabs.setupWithViewPager(binding.container);



        binding.btnSubmit.setOnClickListener(v -> {
            if (isValidForm()) {
                Intent intent = new Intent();
                SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.OWNERS_INFO,toJson(propInfo));
                setResult(Activity.RESULT_OK, intent);
                finish();
            }


        });

    }

    @Override
    protected void getIntentData() {
        String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.OWNERS_INFO);
        propInfo = new GsonBuilder().serializeNulls().create().fromJson(date, ProprietorsInfo.class);

    }



    public ProprietorsInfo getProprietorsInfo() {
        if (propInfo == null) {
            return propInfo = new ProprietorsInfo();
        } else {
            return propInfo;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String indexId = data.getStringExtra(LEAD_INDEX_ID);
            String cif = data.getStringExtra(CIF_ID);
            callApi(indexId, cif);

            Log.d(TAG, "DOCUMENT 1 ->>> " + indexId);
            Log.d(TAG, "DOCUMENT 1 ->>> " + cif);
           // propInfo.setFathersName("Hello Test");




        }



        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);

        }


    }

    private void callApi(String indexId, String cif) {
        String random = UUID.randomUUID().toString();
        showProgressDialog();
        getApiService().getProprietor(indexId,random).enqueue(new Callback<SearchProprietor>() {
            @Override
            public void onResponse(Call<SearchProprietor> call, Response<SearchProprietor> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        propInfo = response.body().getData();
                        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                        binding.container.setAdapter(mSectionsPagerAdapter);
                        binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);
                        binding.tabs.setupWithViewPager(binding.container);
                    }else showToast(""+response.body().getMessage());





                }else showToast("Tary Again ");
            }

            @Override
            public void onFailure(Call<SearchProprietor> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed");

            }
        });
    }

    private boolean isValidForm() {
        if (propInfo.getFathersName().isEmpty()) {
            showToast("Please Enter Father’s Name");
            return false;
        } else if (propInfo.getMothersName().isEmpty()) {
            showToast("Please Enter Mother’s Name");
            return false;
        } else if (propInfo.getNid().isEmpty()) {
            showToast("Please Enter NID/Passport Number");
            return false;
        } else if (propInfo.getOwnership().isEmpty()) {
            showToast("Please Enter Share of ownership");
            return false;
        } else if (propInfo.getMobilenumber().isEmpty()) {
            showToast("Please Enter Mobile number");
            return false;
        } else if (propInfo.getDob().isEmpty()) {
            showToast("Please Enter Date of Birth");
            return false;
        } else if (propInfo.getGender().isEmpty()) {
            showToast("Please Enter Gender");
            return false;
        } else if (propInfo.getMaritalStatus().isEmpty()) {
            showToast("Please Enter Marital Status");
            return false;
        }
        return true;
    }


}
