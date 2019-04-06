package net.maxproit.salesforce.feature.supervisor.lead;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivitySupervisorLeadBinding;
import net.maxproit.salesforce.feature.supervisor.adapter.SupervisorLeadAdapter;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.supervisor.user.UseList;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorLeadActivity extends BaseActivity  {
    private static final String TAG = "SupervisorLeadActivity";
    ActivitySupervisorLeadBinding binding;
    LocalLogin localLogin;
    SupervisorLeadAdapter adapter;
    String userName;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_lead;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorLeadBinding) getBinding();

        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        localLogin = new LocalLogin(getApplicationContext());
            callApi();



    }

    private void callApi() {
        showProgressDialog();
        getApiService().getSupervisorLead("laila",UUID.randomUUID().toString()).enqueue(new Callback<UseList>() {
            @Override
            public void onResponse(Call<UseList> call, Response<UseList> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        binding.emtyHeader.setVisibility(View.GONE);
                        adapter = new SupervisorLeadAdapter(SupervisorLeadActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rv.setLayoutManager(mLayoutManager);
                        binding.rv.setAdapter(adapter);
                        Log.d(TAG, "onResponse: "+toJson(response.body()));
                        
                        
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


}
