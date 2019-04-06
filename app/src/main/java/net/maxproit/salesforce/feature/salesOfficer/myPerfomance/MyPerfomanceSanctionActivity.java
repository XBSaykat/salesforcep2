package net.maxproit.salesforce.feature.salesOfficer.myPerfomance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySupervisorSanctionBinding;
import net.maxproit.salesforce.feature.salesOfficer.myPerfomance.adapter.MyPerfomanceSanctionsAdapter;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.feature.supervisor.prospectview.ProspectViewActivity;
import net.maxproit.salesforce.model.supervisor.sanctions.Sanctions;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerfomanceSanctionActivity extends BaseActivity implements AdapterInfo {
    ActivitySupervisorSanctionBinding binding;
    MyPerfomanceSanctionsAdapter adapter;
    String userName;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_sanction;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorSanctionBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME_PER);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getSalesOfficerSanctions(userName, UUID.randomUUID().toString()).enqueue(new Callback<Sanctions>() {
                @Override
                public void onResponse(Call<Sanctions> call, Response<Sanctions> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {

                        adapter = new MyPerfomanceSanctionsAdapter(MyPerfomanceSanctionActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rv.setLayoutManager(mLayoutManager);
                        binding.rv.setAdapter(adapter);
                        binding.emtyHeader.setVisibility(View.GONE);

                    } else {
                        showToast("Failed");
                        binding.emtyHeader.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<Sanctions> call, Throwable t) {
                    hideProgressDialog();
                    showToast("Failed");
                    binding.emtyHeader.setVisibility(View.VISIBLE);

                }
            });
        }

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
        Intent intent = new Intent(this, ProspectViewActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 100);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {

    }
}
