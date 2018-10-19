package net.maxproit.idlc.feature.salesOfficer.myPerfomance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivitySupervisorNoOffCallsBinding;
import net.maxproit.idlc.feature.salesOfficer.myPerfomance.adapter.MyPerfomanceSupervisorCallsAdapter;
import net.maxproit.idlc.feature.supervisor.SupervisorFollowUpActivity;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.feature.supervisor.prospectview.ProspectViewActivity;
import net.maxproit.idlc.model.folowup.FollowupList;
import net.maxproit.idlc.model.supervisor.calls.Calls;
import net.maxproit.idlc.util.CommonUtil;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerfomancFollowUpCallsActivity extends BaseActivity implements AdapterInfo {

    ActivitySupervisorNoOffCallsBinding binding;
    MyPerfomanceSupervisorCallsAdapter adapter;
    String userName;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_no_off_calls;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorNoOffCallsBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME_PER);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        binding.edtFollowUp.setOnClickListener(v -> {
            CommonUtil.showCurrentDatePickerFollowUp(MyPerfomancFollowUpCallsActivity.this, binding.edtFollowUp, Calendar.getInstance());


        });
        binding.edtFollowUp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String date = binding.edtFollowUp.getText().toString();

                if (!StringUtils.isEmpty(date)) {
                    callApi(date);
                }
            }
        });



    }

    private void callApi(String date) {
        showProgressDialog();
        getApiService().getSalesOfficerFolloUp(userName, date).enqueue(new Callback<FollowupList>() {
            @Override
            public void onResponse(Call<FollowupList> call, Response<FollowupList> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        adapter = new MyPerfomanceSupervisorCallsAdapter(MyPerfomancFollowUpCallsActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rvMyLea.setLayoutManager(mLayoutManager);
                        binding.rvMyLea.setAdapter(adapter);
                    } else showAlertDialog("Error", response.body().getMessage());


                } else {

                    showAlertDialog("Error", response.message());
                }

            }

            @Override
            public void onFailure(Call<FollowupList> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error", t.getMessage());

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
        Intent intent = new Intent(this, ProspectViewActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 100);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {

    }
}
