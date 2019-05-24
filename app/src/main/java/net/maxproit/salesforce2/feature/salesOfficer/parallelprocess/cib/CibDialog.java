package net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cib;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityCibDialogBinding;
import net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cif.CifActivity;
import net.maxproit.salesforce2.model.cib.post.CibPost;
import net.maxproit.salesforce2.model.cib.post.CibRequestDtl;
import net.maxproit.salesforce2.model.cib.postResponce.CibPostResponce;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CibDialog extends BaseActivity {
    private static final String TAG = "CibDialog";

    ActivityCibDialogBinding binding;
    private String referrenceid = "";
    private String list = "";

    @Override
    protected int getLayoutResourceId() {
        return (R.layout.activity_cib_dialog);
    }

    @Override
    protected void initComponents() {
        binding = (ActivityCibDialogBinding) getBinding();

        getIntentData();
        binding.btnSubmit.setOnClickListener(v -> {
            showProgressDialog();
            CibPost cibPost = new CibPost();
            cibPost.setMakerName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
            cibPost.setRemark(binding.etRemark.getText().toString());
            cibPost.setProspectReferenceNo(referrenceid);

            Type listType = new TypeToken<ArrayList<CibRequestDtl>>() {
            }.getType();
            List<CibRequestDtl> l = new GsonBuilder().serializeNulls().create().fromJson(list, listType);

            cibPost.setCibRequestDtls(l);

            Log.d(TAG, "initComponents: " + toJson(cibPost));

            getApiService().cibPost(cibPost).enqueue(new Callback<CibPostResponce>() {
                @Override
                public void onResponse(Call<CibPostResponce> call, Response<CibPostResponce> response) {
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
                public void onFailure(Call<CibPostResponce> call, Throwable t) {
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
            list = getIntent().getExtras().getString("CIB_LIST");
        }

    }
}
