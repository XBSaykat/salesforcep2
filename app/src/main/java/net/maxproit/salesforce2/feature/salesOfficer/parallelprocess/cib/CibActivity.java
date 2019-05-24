package net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cib;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityCibBinding;
import net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cif.CifActivity;
import net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cib.adapter.RequestCibAdapter;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.model.cib.requestedCIB.RequestedCIB;
import net.maxproit.salesforce2.model.cib.requestedCIB.RequestedCIBData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CibActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "CibActivity";

    ActivityCibBinding binding;
    RequestCibAdapter adapter;

    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";

    private List<RequestedCIB> cibList;
    private String referrenceid = "";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cib;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityCibBinding) getBinding();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Requested CIB");
        getIntentData();


        Bundle bundle = new Bundle();
        bundle.putString(CifActivity.KEY_REFERRENCE_ID, referrenceid);
        binding.btnAdd.setOnClickListener(v -> startActivity(CibActivityNew.class, false, bundle));


        cibList = new ArrayList<>();
        getCibData();

        setupCifAdapter();
    }

    private void getCibData() {
        showProgressDialog();
        String random = UUID.randomUUID().toString();
        getApiService().cibRequestById(referrenceid, random).enqueue(new Callback<RequestedCIBData>() {
            @Override
            public void onResponse(Call<RequestedCIBData> call, Response<RequestedCIBData> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + toJson(response.body()));
                    cibList.clear();
                    cibList = response.body().getData();
                    setupCifAdapter();
                } else {
                    showToast("Try again!");
                }
            }

            @Override
            public void onFailure(Call<RequestedCIBData> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed");
            }
        });
    }

    private void setupCifAdapter() {
        adapter = new RequestCibAdapter(this, cibList, referrenceid);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvCib.setLayoutManager(mLayoutManager);
        binding.rvCib.setAdapter(adapter);
    }

    @Override
    protected void getIntentData() {

        if (getIntent().getExtras().containsKey(KEY_REFERRENCE_ID)) {
            referrenceid = getIntent().getExtras().getString(KEY_REFERRENCE_ID);
        }
    }

    @Override
    public void adShowProgressDialog() {

    }

    @Override
    public void adHideProgressDialog() {

    }

    @Override
    public void adSuccess(String message) {

    }

    @Override
    public void adFailed(String message) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {

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
