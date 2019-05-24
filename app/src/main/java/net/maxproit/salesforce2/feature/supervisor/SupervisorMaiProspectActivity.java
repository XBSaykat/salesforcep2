package net.maxproit.salesforce2.feature.supervisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivitySupervisorMaiProspectBinding;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.feature.supervisor.adapter.SupervisorMainProspectsAdapter;
import net.maxproit.salesforce2.feature.supervisor.prospectview.ProspectViewActivity;
import net.maxproit.salesforce2.model.supervisor.prospects.Prospects;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorMaiProspectActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "SupervisorProspectActiv";
    ActivitySupervisorMaiProspectBinding binding;
    SupervisorMainProspectsAdapter adapter;
    String userName;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_mai_prospect;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorMaiProspectBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        callApi();
    }

    private void callApi() {
        showProgressDialog();
        getApiService().getSupervisorProspectForApp(userName, UUID.randomUUID().toString()).enqueue(new Callback<Prospects>() {
            @Override
            public void onResponse(Call<Prospects> call, Response<Prospects> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        adapter = new SupervisorMainProspectsAdapter(SupervisorMaiProspectActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rv.setLayoutManager(mLayoutManager);
                        binding.rv.setAdapter(adapter);



                    } else showAlertDialog("Error", response.body().getMessage());
                } else showAlertDialog("Error", response.message());

            }

            @Override
            public void onFailure(Call<Prospects> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error", t.getMessage());

            }
        });
    }

    @Override
    protected void getIntentData() {

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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            startActivity(SupervisorProspectActivity.class, true);
        }
    }
}
