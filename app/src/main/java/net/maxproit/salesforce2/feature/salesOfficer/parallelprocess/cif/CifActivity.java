package net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cif;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityCifBinding;
import net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.cif.adapter.RequestCifAdapter;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.model.cif.requestedCIf.RequestedCIf;
import net.maxproit.salesforce2.model.cif.requestedCIf.RequestedCIfData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CifActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "CibActivity";

    ActivityCifBinding binding;
    RequestCifAdapter adapter;

    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";

    private List<RequestedCIf> cifList;
    private String referrenceid = "";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cif;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityCifBinding) getBinding();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Requested Cif");
        getIntentData();


        Bundle bundle = new Bundle();
        bundle.putString(CifActivity.KEY_REFERRENCE_ID, referrenceid);
        binding.btnAdd.setOnClickListener(v -> startActivity(CifActivityNew.class, false, bundle));


        cifList = new ArrayList<>();
        getCibData();

        setupCifAdapter();
    }

    private void getCibData() {
        showProgressDialog();
        String random = UUID.randomUUID().toString();
        getApiService().cifRequestById(referrenceid, random).enqueue(new Callback<RequestedCIfData>() {
            @Override
            public void onResponse(Call<RequestedCIfData> call, Response<RequestedCIfData> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + toJson(response.body()));
                    cifList.clear();
                    cifList = response.body().getData();
                    setupCifAdapter();
                } else {
                    showToast("Try again!");
                }
            }

            @Override
            public void onFailure(Call<RequestedCIfData> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed");
            }
        });
    }

    private void setupCifAdapter() {
        adapter = new RequestCifAdapter(this, cifList, referrenceid);
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
