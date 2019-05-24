package net.maxproit.salesforce2.feature.supervisor;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivitySupervisorFollowUpBinding;
import net.maxproit.salesforce2.feature.supervisor.adapter.SupervisorFupAdapter;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.model.supervisor.user.UseList;
import net.maxproit.salesforce2.util.CommonUtil;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupervisorFollowUpActivity extends BaseActivity {
    private static final String TAG = "SupervisorLeadActivity";
    ActivitySupervisorFollowUpBinding binding;
    LocalLogin localLogin;
    SupervisorFupAdapter adapter;
    String userName;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_follow_up;
    }

    @Override
    protected void initComponents() {

        binding = (ActivitySupervisorFollowUpBinding) getBinding();

        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        localLogin = new LocalLogin(getApplicationContext());
        binding.edtFollowUp.setOnClickListener(v -> {
            CommonUtil.showCurrentDatePickerFollowUp(SupervisorFollowUpActivity.this, binding.edtFollowUp, Calendar.getInstance());


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
        getApiService().getSupervisorFup("laila", date).enqueue(new Callback<UseList>() {
            @Override
            public void onResponse(Call<UseList> call, Response<UseList> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        adapter = new SupervisorFupAdapter(SupervisorFollowUpActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rv.setLayoutManager(mLayoutManager);
                        binding.rv.setAdapter(adapter);


                    } else showAlertDialog("Error", "" + response.body().getMessage());


                } else showAlertDialog("Error", "" + response.code());

            }

            @Override
            public void onFailure(Call<UseList> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error", "" + t.getMessage());

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
