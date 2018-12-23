package net.maxproit.salesforce.feature.login;

import android.util.Log;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityRegistrationBinding;
import net.maxproit.salesforce.masum.model.api.useractivity.GenerateOtp;
import net.maxproit.salesforce.masum.model.api.useractivity.UserRegistration;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends BaseActivity {
    ActivityRegistrationBinding mbinding;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_registration;
    }

    @Override
    protected void initComponents() {
        mbinding = (ActivityRegistrationBinding) getBinding();

        mbinding.tvGenerateOtp.setOnClickListener(view -> {
            String userName = mbinding.etUsername.getText().toString();
            if (!MasumCommonUtils.isNullStr(userName)) {
                callApi(userName);
            } else {
                showAlertDialog(getResources().getString(R.string.error_txt), "Username field can't be empty for generate OTP");
            }

        });


        mbinding.btnLogin.setOnClickListener(view -> {
            String userName = mbinding.etUsername.getText().toString().trim();
            String otp = mbinding.etOtp.getText().toString().trim();
            if (!MasumCommonUtils.isNullStr(userName) && !MasumCommonUtils.isNullStr(otp)) {
                callApi(userName, otp);
            } else {
                showAlertDialog(getResources().getString(R.string.error_txt), "Username or OTP field can't be empty");

            }

        });

    }


    private void callApi(String uName) {
        if (isNetworkAvailable()) {
            UserRegistration generateOtp = new UserRegistration();
            generateOtp.setUserLogin(uName);
            getApiService().generateOtp(generateOtp).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        showAlertDialog(getResources().getString(R.string.success_status), getResources().getString(R.string.otp_success));
                    } else {
                        showAlertDialog(response.message(), response.toString());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    showAlertDialog(getResources().getString(R.string.error_txt), t.getMessage());
                }
            });
        } else {
            showAlertDialog(getResources().getString(R.string.error_txt), getResources().getString(R.string.internet_not_available));
        }

    }


    private void callApi(String uName, String otp) {
        if (isNetworkAvailable()) {
            UserRegistration generateOtp = new UserRegistration();
            generateOtp.setUserLogin(uName);
            generateOtp.setLastUserOTP(otp);
            getApiService().userRegistration(generateOtp).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        ActivityUtils.getInstance().invokeActivity(RegistrationActivity.this, PasswordActivity.class, true, uName, otp);
                        showAlertDialog(getResources().getString(R.string.success_status), getResources().getString(R.string.otp_success));
                    } else {
                        showAlertDialog("Invalid OTP,Please Try Again", response.toString());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    showAlertDialog(getResources().getString(R.string.error_txt), t.getMessage());
                }
            });
        } else {
            showAlertDialog(getResources().getString(R.string.error_txt), getResources().getString(R.string.internet_not_available));
        }

    }

    @Override
    protected void getIntentData() {

    }
}
