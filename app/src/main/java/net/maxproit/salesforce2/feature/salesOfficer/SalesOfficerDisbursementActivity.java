package net.maxproit.salesforce2.feature.salesOfficer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivitySalesOfficerDisbursementBinding;
import net.maxproit.salesforce2.feature.salesOfficer.myPerfomance.adapter.MyPerfomanceDesAdapter;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.feature.supervisor.prospectview.ProspectViewActivity;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.model.sd.DisbursementList;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalesOfficerDisbursementActivity extends BaseActivity implements AdapterInfo {

    ActivitySalesOfficerDisbursementBinding binding;
    MyPerfomanceDesAdapter adapter;
    LocalLogin localLogin;
    String username;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_sales_officer_disbursement;
    }

    @Override
    protected void initComponents() {

        binding = (ActivitySalesOfficerDisbursementBinding) getBinding();
        localLogin = new LocalLogin(getApplicationContext());
        username = localCash().getString(SharedPreferencesEnum.Key.USER_NAME_PER);
        binding.btnBack.setOnClickListener(v -> finish());

        callApi();

    }

    private void callApi() {
        showProgressDialog();
        getApiService().getSalesOfficerDes(username, UUID.randomUUID().toString()).enqueue(new Callback<DisbursementList>() {
            @Override
            public void onResponse(Call<DisbursementList> call, Response<DisbursementList> response) {
                hideProgressDialog();
                if (response.body().getCode().equals("200")) {

                    adapter = new MyPerfomanceDesAdapter(SalesOfficerDisbursementActivity.this, response.body().getData());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    binding.rvMyLead.setLayoutManager(mLayoutManager);
                    binding.rvMyLead.setAdapter(adapter);
                    binding.emtyHeader.setVisibility(View.GONE);


                } else showAlertDialog("Error", response.body().getMessage());

            }

            @Override
            public void onFailure(Call<DisbursementList> call, Throwable t) {
                hideProgressDialog();

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
}
