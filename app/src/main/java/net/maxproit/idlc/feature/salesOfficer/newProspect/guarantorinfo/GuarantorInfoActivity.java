package net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityGuarantorInfoBinding;
import net.maxproit.idlc.model.newprospect.GuarantorsInfo;
import net.maxproit.idlc.model.search.guarantor.SearchGuarantor;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuarantorInfoActivity extends BaseActivity {
    private static final String TAG = "GuarantorInfoActivity";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ActivityGuarantorInfoBinding binding;
    public static final String MODEL_DATA = "MODEL_DATA";
    public static final int REQUEST_NEW = 101;
    public static final String LEAD_INDEX_ID = "LEAD_INDEX_ID";
    public static final String CIF_ID = "CIF_ID";

    GuarantorsInfo gnf;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_guarantor_info;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityGuarantorInfoBinding) getBinding();
        getIntentData();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        binding.container.setAdapter(mSectionsPagerAdapter);
        binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);
        binding.tabs.setupWithViewPager(binding.container);


        binding.btnSubmit.setOnClickListener(v -> {
            if (isValidForm()) {
                Intent intent = new Intent();
                SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.GUARANTOR_INFO, toJson(gnf));
                setResult(Activity.RESULT_OK, intent);
                finish();
            }

        });

    }


    @Override
    protected void getIntentData() {
        String date = SharedPreferencesEnum.getInstance().getString(SharedPreferencesEnum.Key.GUARANTOR_INFO);
        gnf = new GsonBuilder().serializeNulls().create().fromJson(date, GuarantorsInfo.class);


    }


    public GuarantorsInfo getGuarantorsInfo() {
        if (gnf == null) {

            return gnf = new GuarantorsInfo();
        } else {
            return gnf;
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


        }


        for (Fragment fragment : getSupportFragmentManager().getFragments()) {

            fragment.onActivityResult(requestCode, resultCode, data);

        }


    }


    private boolean isValidForm() {
        if (gnf.getGuarantorName().isEmpty()) {
            showToast("Please Enter Guarantor’s Name");
            return false;
        } else if (gnf.getFathersName().isEmpty()) {
            showToast("Please Enter Father’s Name");
            return false;
        } else if (gnf.getMothersName().isEmpty()) {
            showToast("Please Enter Mother’s Name");
            return false;
//        }else if (getNewProspect().getGuarantorsInfo().getPrNetWorth().isEmpty()) {
//            showToast("Please Enter Personal Net Worth");
//            return false;
        } else if (gnf.getNid().isEmpty()) {
            showToast("Please Enter NID/Passport Number");
            return false;
        } else if (gnf.getMobilenumber().isEmpty()) {
            showToast("Please Enter Mobile Number");
            return false;
//        }else if (gnf.getRelation().isEmpty()) {
//            showToast("Please Enter Relationship with Applicant");
//            return false;
        } else if (gnf.getProfession().isEmpty()) {
            showToast("Please Enter Profession");
            return false;
        } else if (gnf.getDob().isEmpty()) {
            showToast("Please Enter Date of Birth");
            return false;
        } else if (gnf.getGender().isEmpty()) {
            showToast("Please Enter Gender");
            return false;
        } else if (gnf.getMaritalStatus().isEmpty()) {
            showToast("Please Enter Marital Status");
            return false;
        }

        return true;
    }



    private void callApi(String indexId, String cif) {
        String random = UUID.randomUUID().toString();
        showProgressDialog();


        getApiService().getGuarantor(indexId,random).enqueue(new Callback<SearchGuarantor>() {
            @Override
            public void onResponse(Call<SearchGuarantor> call, Response<SearchGuarantor> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {

                    if (response.body().getCode().equals("200")) {
                        gnf = response.body().getData();
                        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                        binding.container.setAdapter(mSectionsPagerAdapter);
                        binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);
                        binding.tabs.setupWithViewPager(binding.container);
                    } else showAlertDialog("Error", response.body().getMessage());

                }else showToast("Tray again");

            }

            @Override
            public void onFailure(Call<SearchGuarantor> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed");

            }
        });
    }
}
