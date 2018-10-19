package net.maxproit.idlc.feature.salesOfficer.parallelprocess.daviation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityDaviationListBinding;
import net.maxproit.idlc.feature.salesOfficer.parallelprocess.daviation.adapter.DaviationAdapter;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.model.deviation.getlist.Daviation;
import net.maxproit.idlc.model.deviation.getlist.Daviationlist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaviationListActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "DaviationListActivity";

    ActivityDaviationListBinding binding;
    DaviationAdapter adapter;

    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";

    private List<Daviation> cibList;
    private String referrenceid = "";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_daviation_list;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDaviationListBinding) getBinding();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Deviation");
        getIntentData();


        Bundle bundle = new Bundle();
        bundle.putString(KEY_REFERRENCE_ID, referrenceid);
        Log.d(TAG, "initComponents: " + referrenceid);


        //  binding.btnAdd.setOnClickListener(v -> startActivity(DeviationActivity.class, false, bundle));
        binding.btnAdd.setOnClickListener(v -> startActivity(NewDeviationActivity.class, false, bundle));


        cibList = new ArrayList<>();
        getCibData();

        setupCifAdapter();
    }

    private void getCibData() {
        showProgressDialog();
        String random = UUID.randomUUID().toString();
        Log.d(TAG, "getCibData: " + referrenceid);
        getApiService().daviationRequestById(referrenceid, random).enqueue(new Callback<Daviationlist>() {
            @Override
            public void onResponse(Call<Daviationlist> call, Response<Daviationlist> response) {
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
            public void onFailure(Call<Daviationlist> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed");
            }
        });
    }

    private void setupCifAdapter() {
        adapter = new DaviationAdapter(this, cibList, referrenceid);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            startActivity(DaviationListActivity.class,true);
        }
    }
}
