package net.maxproit.salesforce.feature.supervisor;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySupervisorDesBinding;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.feature.supervisor.adapter.SupervisorDisbursementAdapter;
import net.maxproit.salesforce.model.supervisor.user.UseList;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorDisbursementActivity extends BaseActivity implements AdapterInfo {

    ActivitySupervisorDesBinding binding;
    SupervisorDisbursementAdapter adapter;
    String userName;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_des;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorDesBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        callApi();


    }

    private void callApi() {
        showProgressDialog();
        getApiService().getSupervisorDisbursements("laila", UUID.randomUUID().toString()).enqueue(new Callback<UseList>() {
            @Override
            public void onResponse(Call<UseList> call, Response<UseList> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        adapter = new SupervisorDisbursementAdapter(SupervisorDisbursementActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rvMyLea.setLayoutManager(mLayoutManager);
                        binding.rvMyLea.setAdapter(adapter);


                    }else showAlertDialog("Error",""+response.body().getMessage());




                }else showAlertDialog("Error",""+response.code());

            }

            @Override
            public void onFailure(Call<UseList> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error",""+t.getMessage());

            }
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
