package net.maxproit.idlc.feature.salesOfficer.myPerfomance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityMyLeadBinding;
import net.maxproit.idlc.feature.salesOfficer.myPerfomance.adapter.MyPerfomanceLeadAdapter;
import net.maxproit.idlc.feature.salesOfficer.newlead.NewLeadActivity;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.mylead.Mylead;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerfomanceLeadActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyPerfomanceLeadActivit";


    ActivityMyLeadBinding binding;
    MyPerfomanceLeadAdapter adapter;
    LocalLogin localLogin;
    String username;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_lead;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityMyLeadBinding) getBinding();
        localLogin = new LocalLogin(getApplicationContext());
        username = localCash().getString(SharedPreferencesEnum.Key.USER_NAME_PER);
        binding.btnBack.setOnClickListener(v -> finish());


        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getSalesOfficerLead(username, UUID.randomUUID().toString()).enqueue(new Callback<Mylead>() {
                @Override
                public void onResponse(Call<Mylead> call, Response<Mylead> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + toJson(response.body()));

                        adapter = new MyPerfomanceLeadAdapter(MyPerfomanceLeadActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rvMyLead.setLayoutManager(mLayoutManager);
                        binding.rvMyLead.setAdapter(adapter);
                        binding.emtyHeader.setVisibility(View.GONE);
                    } else {
                        binding.emtyHeader.setVisibility(View.VISIBLE);
                        showToast("Failed");
                    }
                }

                @Override
                public void onFailure(Call<Mylead> call, Throwable t) {
                    hideProgressDialog();
                    binding.emtyHeader.setVisibility(View.VISIBLE);

                }
            });
        } else {
            showToast("Network is not Available");
            binding.emtyHeader.setVisibility(View.VISIBLE);
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
        showProgressDialog();

    }

    @Override
    public void adHideProgressDialog() {
        hideProgressDialog();

    }

    @Override
    public void adSuccess(String message) {
        showToast(message);
        startActivity(MyPerfomanceLeadActivity.class, true);
    }

    @Override
    public void adFailed(String message) {
        showToast(message);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {
        startActivity(NewLeadActivity.class, self, bundle);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {
        Intent intent = new Intent(MyPerfomanceLeadActivity.this, NewLeadActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, code);


    }


}
