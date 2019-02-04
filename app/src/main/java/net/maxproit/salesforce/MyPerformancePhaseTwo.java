package net.maxproit.salesforce;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMyPerformancePhaseTwoBinding;
import net.maxproit.salesforce.masum.adapter.myperformacecountadapter.MyPerformanceItemAdapter;
import net.maxproit.salesforce.masum.model.api.performance.Datum;
import net.maxproit.salesforce.masum.model.api.performance.Getperformance;
import net.maxproit.salesforce.masum.model.local.MyPerformanceModel;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerformancePhaseTwo extends BaseActivity {

    private ActivityMyPerformancePhaseTwoBinding mBinding;

    MyPerformanceItemAdapter myLeadAdapter;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_performance_phase_two;
    }

    @Override
    protected void initComponents() {
        initVariable();
        //initView();
        initListener();
        //setAllData();
    }

    @Override
    protected void getIntentData() {

    }


    private void initVariable() {
        mBinding = (ActivityMyPerformancePhaseTwoBinding) getBinding();
        callApi();

    }

    private void callApi() {

        if (isNetworkAvailable()) {
            String username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);
            String random = UUID.randomUUID().toString();
            showProgressDialog();
            getApiService().getPerformaceCountData(username, random).enqueue(new Callback<Getperformance>() {
                @Override
                public void onResponse(Call<Getperformance> call, Response<Getperformance> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            myLeadAdapter = new MyPerformanceItemAdapter(MyPerformancePhaseTwo.this, (ArrayList<Datum>) response.body().getData());
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mBinding.recycleViewMyPerformace.setLayoutManager(mLayoutManager);
                            mBinding.recycleViewMyPerformace.setAdapter(myLeadAdapter);
                            myLeadAdapter.notifyDataSetChanged();
                            hideProgressDialog();
                        } else {
                            showAlertDialog(response.body().getStatus(), response.body().getMessage());
                            hideProgressDialog();
                        }
                    } else {
                        showAlertDialog(getString(R.string.error_text), response.errorBody().toString());
                        hideProgressDialog();

                    }
                }


                @Override
                public void onFailure(Call<Getperformance> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());
                    hideProgressDialog();
                }
            });
        } else {
            showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));
        }
    }

    private void initListener() {
        mBinding.btnBack.setOnClickListener(view -> {
            MyPerformancePhaseTwo.super.onBackPressed();
            finish();
        });


    }



}
