package net.maxproit.idlc.feature.supervisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivitySupervisorProspectBinding;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.feature.supervisor.adapter.SupervisorLeadAdapter;
import net.maxproit.idlc.feature.supervisor.adapter.SupervisorProspectsAdapter;
import net.maxproit.idlc.feature.supervisor.lead.SupervisorLeadActivity;
import net.maxproit.idlc.feature.supervisor.prospectview.ProspectViewActivity;
import net.maxproit.idlc.model.supervisor.prospects.Prospects;
import net.maxproit.idlc.model.supervisor.user.UseList;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorProspectActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "SupervisorProspectActiv";
    ActivitySupervisorProspectBinding binding;
    SupervisorProspectsAdapter adapter;
    String userName;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_prospect;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorProspectBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        callApi();

    }


    private void callApi() {
        showProgressDialog();
        getApiService().getSupervisorProspect("laila",UUID.randomUUID().toString()).enqueue(new Callback<UseList>() {
            @Override
            public void onResponse(Call<UseList> call, Response<UseList> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        adapter = new SupervisorProspectsAdapter(SupervisorProspectActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rv.setLayoutManager(mLayoutManager);
                        binding.rv.setAdapter(adapter);


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
        recreate();

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
