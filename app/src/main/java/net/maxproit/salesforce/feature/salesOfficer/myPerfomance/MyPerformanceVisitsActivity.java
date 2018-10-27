package net.maxproit.salesforce.feature.salesOfficer.myPerfomance;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySupervisorVisitsBinding;
import net.maxproit.salesforce.feature.salesOfficer.myPerfomance.adapter.MyPerfomanceVisitsAdapter;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.model.supervisor.visits.Visits;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerformanceVisitsActivity extends BaseActivity implements AdapterInfo {
    ActivitySupervisorVisitsBinding binding;
    MyPerfomanceVisitsAdapter adapter;
    String userName;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_visits;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorVisitsBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getSalesOfficerVisit(userName, UUID.randomUUID().toString()).enqueue(new Callback<Visits>() {
                @Override
                public void onResponse(Call<Visits> call, Response<Visits> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {

                        if (response.body().getData() == null) {
                            binding.emtyHeader.setVisibility(View.VISIBLE);
                        } else {

                            adapter = new MyPerfomanceVisitsAdapter(MyPerformanceVisitsActivity.this, response.body().getData());
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            binding.rvMyLead.setLayoutManager(mLayoutManager);
                            binding.rvMyLead.setAdapter(adapter);

                        }
                    } else showToast("Failed");
                }

                @Override
                public void onFailure(Call<Visits> call, Throwable t) {
                    hideProgressDialog();
                    showToast("Failed");

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

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {

    }
}