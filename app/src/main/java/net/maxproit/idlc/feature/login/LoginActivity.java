package net.maxproit.idlc.feature.login;

import android.Manifest;
import android.text.TextUtils;
import android.util.Log;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityLoginBinding;
import net.maxproit.idlc.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.idlc.feature.dashboard.DashboardVirifierActivity;
import net.maxproit.idlc.feature.dashboard.supervisor.MainDashboardSupervisorActivity;
import net.maxproit.idlc.model.login.Login;
import net.maxproit.idlc.model.login.LoginResponse;
import net.maxproit.idlc.model.setting.GlobalSettings;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private static final String TAG = "LoginActivity";

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityLoginBinding) getBinding();
        binding.setModel(new Login());


        String st = localCash().getString(SharedPreferencesEnum.Key.SETTING);
        if (st.isEmpty()) {
            callSetting();

        } else {
            String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
            if (!roll.isEmpty()) {
                gotoBoard(roll);
            }

        }

        binding.btnLogin.setOnClickListener(v -> {

                }
        );


        binding.btnLogin.setOnClickListener(view -> {

            if (TextUtils.isEmpty(binding.etUsername.getText())) {
                showToast("Ener your Username");

            } else if (TextUtils.isEmpty(binding.etPassword.getText())) {
                showToast("Ener your Password");

            } else {

                showProgressDialog();

                getApiService().login(binding.getModel()).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        hideProgressDialog();
                        if (response.isSuccessful()) {
                            LoginResponse lr = response.body();
                            Log.d(TAG, ">>>>>: " + lr.toString());

                            if (lr.getCode().equals("401")) {
                                showToast("Invalid UserId or Password");
                            } else {
                                gotoBoard(lr.getData().getUserTypeId());
                                String lg = toJson(response.body());
                                localCash().put(SharedPreferencesEnum.Key.LOCA_LLOGIN, lg);
                                localCash().put(SharedPreferencesEnum.Key.USER_NAME, binding.etUsername.getText().toString());


                            }


                        } else
                            showToast("Login Failed");
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        hideProgressDialog();
                        showToast("Login Failed");

                    }
                });


            }


        });


        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            // do you work now
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // permission is denied permenantly, navigate user to app settings
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .onSameThread()
                .check();
    }

    private void callSetting() {
        showProgressDialog();
        getApiService().getSetting().enqueue(new Callback<GlobalSettings>() {
            @Override
            public void onResponse(Call<GlobalSettings> call, Response<GlobalSettings> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    String setting = toJson(response.body());
                    localCash().put(SharedPreferencesEnum.Key.SETTING, setting);
                    showToast("Setting Data Success");

                } else
                    showToast("Setting Data Failed");

            }

            @Override
            public void onFailure(Call<GlobalSettings> call, Throwable t) {
                hideProgressDialog();
                showToast("Setting Data Failed");

            }
        });
    }

    private void gotoBoard(String uT) {

        if (uT.equals("1")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(DashboardSalesOfficerActivity.class, true);
           // startActivity(LocationTestActivity.class, true);


        } else if (uT.equals("2")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(MainDashboardSupervisorActivity.class, true);


        } else if (uT.equals("3")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(DashboardVirifierActivity.class, true);


        }

    }


    @Override
    protected void getIntentData() {

    }


}
