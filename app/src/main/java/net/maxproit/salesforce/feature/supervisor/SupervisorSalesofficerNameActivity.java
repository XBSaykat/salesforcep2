package net.maxproit.salesforce.feature.supervisor;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySupervisorSalesofficerNameBinding;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.feature.supervisor.adapter.SupervisorSalesOfficersAdapter;
import net.maxproit.salesforce.model.supervisor.salesofficers.SalesOfficers;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorSalesofficerNameActivity extends BaseActivity implements AdapterInfo {
    ActivitySupervisorSalesofficerNameBinding binding;
    SupervisorSalesOfficersAdapter adapter;
    String userName;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_salesofficer_name;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorSalesofficerNameBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getSupervisorSalesOfficer(userName).enqueue(new Callback<SalesOfficers>() {
                @Override
                public void onResponse(Call<SalesOfficers> call, Response<SalesOfficers> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        adapter = new SupervisorSalesOfficersAdapter(SupervisorSalesofficerNameActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rvMyLead.setLayoutManager(mLayoutManager);
                        binding.rvMyLead.setAdapter(adapter);
                    } else showToast("Responce Failed");
                }

                @Override
                public void onFailure(Call<SalesOfficers> call, Throwable t) {
                    hideProgressDialog();
                    showToast("Responce Failed");

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
