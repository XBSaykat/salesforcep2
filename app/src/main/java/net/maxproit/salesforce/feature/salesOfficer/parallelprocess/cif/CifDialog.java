package net.maxproit.salesforce.feature.salesOfficer.parallelprocess.cif;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityCifDialogBinding;
import net.maxproit.salesforce.model.cif.post.CifPost;
import net.maxproit.salesforce.model.cif.post.CifRequestDtl;
import net.maxproit.salesforce.model.cif.postResponce.CifPostResponce;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CifDialog extends BaseActivity {
    private static final String TAG = "CifDialog";

    ActivityCifDialogBinding binding;
    private String referrenceid = "";
    private String list = "";

    @Override
    protected int getLayoutResourceId() {
        return (R.layout.activity_cif_dialog);
    }

    @Override
    protected void initComponents() {
        binding = (ActivityCifDialogBinding) getBinding();

        getIntentData();
        binding.btnSubmit.setOnClickListener(v -> {
            showProgressDialog();
            CifPost cifPost = new CifPost();
            cifPost.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
            cifPost.setRemark(binding.etRemark.getText().toString());
            cifPost.setProspectReferenceNo(referrenceid);


            Type listType = new TypeToken<ArrayList<CifRequestDtl>>() {
            }.getType();
            List<CifRequestDtl> l = new GsonBuilder().serializeNulls().create().fromJson(list, listType);


            cifPost.setCifRequestDtls(l);

            Log.d(TAG, "initComponents: " + toJson(cifPost));

            getApiService().cifPost(cifPost).enqueue(new Callback<CifPostResponce>() {
                @Override
                public void onResponse(Call<CifPostResponce> call, Response<CifPostResponce> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + toJson(response.body()));
                        Intent resultIntent = new Intent();
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();

                        showToast("Send request!");

                    } else {
                        showToast("Try again!");
                    }
                }

                @Override
                public void onFailure(Call<CifPostResponce> call, Throwable t) {
                    hideProgressDialog();
                    showToast("Failed");
                }
            });

        });


    }

    @Override
    protected void getIntentData() {

        if (getIntent().getExtras().containsKey(CifActivity.KEY_REFERRENCE_ID)) {
            referrenceid = getIntent().getExtras().getString(CifActivity.KEY_REFERRENCE_ID);
            list = getIntent().getExtras().getString("CIF_LIST");

        }

    }
}
