package net.maxproit.salesforce.feature.login;


import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityPasswordBinding;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.api.useractivity.UserRegistration;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordActivity extends BaseActivity {
    ActivityPasswordBinding mBinding;
    String validationStatus = null;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_password;
    }

    @Override
    protected void initComponents() {
        mBinding = (ActivityPasswordBinding) getBinding();


        mBinding.btnLogin.setOnClickListener(view -> {
            String pass = mBinding.etUsername.getText().toString();
            String retypePass = mBinding.etPassword.getText().toString();
            if (!isValid(pass, retypePass)) {
                if (!MasumCommonUtils.isNullStr(validationStatus)) {
                    showAlertDialog("Alert", validationStatus);
                }
            } else {
                callApi(pass);
            }

        });
    }

    @Override
    protected void getIntentData() {



    }

    private void callApi(String pass) {
        if (isNetworkAvailable()) {
            showProgressDialog();
            String userName = getIntent().getStringExtra(AppConstant.INTENT_DATA1);
            String otp = getIntent().getStringExtra(AppConstant.INTENT_DATA2);
            UserRegistration registration = new UserRegistration(userName, pass, otp);
            getApiService().userRegistration(registration).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        MasumCommonUtils.statusAlert(response.message(), "Password save successfully", PasswordActivity.this);
                        hideProgressDialog();
                    } else {
                        showAlertDialog(response.message(), "");
                        hideProgressDialog();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    showAlertDialog("Error", t.getMessage());

                }
            });
        } else {
            showAlertDialog(getResources().getString(R.string.error_txt), getResources().getString(R.string.internet_not_available));
        }
    }


    private boolean isValid(String pass, String retypePass) {
        boolean isValid = true;

        if (MasumCommonUtils.isNullStr(pass) && MasumCommonUtils.isNullStr(retypePass)) {
            mBinding.etUsername.setError("Password can't be empty");
            isValid = false;
        } else if (MasumCommonUtils.isNullStr(retypePass)) {
            mBinding.etPassword.setError("Retype Password can't be empty");
            isValid = false;
        } else if (MasumCommonUtils.isNullStr(pass)) {
            isValid = false;
        } else if (!pass.equals(retypePass)) {
            validationStatus = "Password does not match the retype password";
            isValid = false;
        }


        return isValid;


    }


    @SuppressLint("MissingPermission")
    private String getImei(){
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String imei="";
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            imei=telephonyManager.getImei();
        }
        else
        {
            imei=telephonyManager.getDeviceId();
        }
        return imei;
    }


}
