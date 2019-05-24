package net.maxproit.salesforce2.feature.virifier;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityVerifierBinding;
import net.maxproit.salesforce2.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce2.model.newprospect.NewProspect;
import net.maxproit.salesforce2.model.newprospect.Verification;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifierActivity extends BaseActivity {
    private static final String TAG = "VerifierActivity";


    Bundle extras;
    OleProspect oleProspect;
    String data;

    private ActivityVerifierBinding binding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_verifier;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityVerifierBinding) getBinding();
        binding.setModel(new Verification());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        extras = getIntent().getExtras();

        data = extras.getString("DATA");
        oleProspect = new GsonBuilder().serializeNulls().create().fromJson(data, OleProspect.class);

        binding.btnSubmit.setOnClickListener(v -> {
            showProgressDialog();
            NewProspect prospect = oleProspect.getNewProspect();
            prospect.setProspectReferenceNo(oleProspect.getData().getProspectReferenceNo());
            prospect.setVerification(binding.getModel());

            Log.d(TAG, ">>>: " + toJson(prospect));
            getApiService().myProspect(prospect).enqueue(new Callback<OleProspect>() {
                @Override
                public void onResponse(Call<OleProspect> call, Response<OleProspect> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + toJson(response.body()));
                        showToast("Submit verification");
                        finish();
                    } else {
                        showToast("Try Again");
                    }
                }

                @Override
                public void onFailure(Call<OleProspect> call, Throwable t) {
                    showToast("Submit failed");
                    Log.d(TAG, "onFailure: " + t.getMessage());
                    hideProgressDialog();


                }
            });
        });


    }

    @Override
    protected void getIntentData() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
