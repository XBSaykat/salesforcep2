package net.maxproit.salesforce2.feature.salesOfficer.myPerfomance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityMyProspectBinding;
import net.maxproit.salesforce2.feature.salesOfficer.myPerfomance.adapter.MyPerfomanceProspectAdapter;

import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.feature.supervisor.prospectview.ProspectViewActivity;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.model.myprospect.MyProspect;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerfomanceProspectActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyPerfomanceProspectActivity";


    ActivityMyProspectBinding binding;
    LocalLogin localLogin;
    MyPerfomanceProspectAdapter adapter;
    String userName;
    boolean isPerfomance = false;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_prospect;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityMyProspectBinding) getBinding();

        localLogin = new LocalLogin(getApplicationContext());
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME_PER);
        binding.btnBack.setOnClickListener(v -> finish());


        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getSalesOfficerProspect(userName, UUID.randomUUID().toString()).enqueue(new Callback<MyProspect>() {
                @SuppressLint("LongLogTag")
                @Override
                public void onResponse(Call<MyProspect> call, Response<MyProspect> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + toJson(response.body()));

                        adapter = new MyPerfomanceProspectAdapter(MyPerfomanceProspectActivity.this, response.body(), isPerfomance);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rvMyProspect.setLayoutManager(mLayoutManager);
                        binding.rvMyProspect.setAdapter(adapter);

                    } else {
                        Toast.makeText(MyPerfomanceProspectActivity.this, "Failed", Toast.LENGTH_SHORT).show();


                    }
                }

                @Override
                public void onFailure(Call<MyProspect> call, Throwable t) {
                    hideProgressDialog();


                }
            });
        } else showToast("Network is not available");

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


    }

    @Override
    public void adFailed(String message) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {
       // startActivity(NewProspectActivity.class, self, bundle);
        Intent intent = new Intent(this, ProspectViewActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 100);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {
      /*  Intent intent = new Intent(MyPerfomanceProspectActivity.this, NewProspectActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, code);*/



    }


}
