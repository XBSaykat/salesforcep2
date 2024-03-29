package net.maxproit.salesforce2.feature.login;

import android.Manifest;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityLoginBinding;
import net.maxproit.salesforce2.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce2.feature.dashboard.DashboardVirifierActivity;
import net.maxproit.salesforce2.feature.dashboard.supervisor.MainDashboardSupervisorActivity;
import net.maxproit.salesforce2.masum.appdata.preference.AppPreference;
import net.maxproit.salesforce2.masum.appdata.preference.PrefKey;
import net.maxproit.salesforce2.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;
import net.maxproit.salesforce2.masum.utility.GPSTracker;
import net.maxproit.salesforce2.model.login.Login;
import net.maxproit.salesforce2.model.login.LoginResponse;
import net.maxproit.salesforce2.model.setting.GlobalSettings;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private static final String TAG = "LoginActivity";
    String phoneIMEINumber;
    private MyLeadDbController myLeadDbController;
    GPSTracker gps;


    @Override
    protected int getLayoutResourceId() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        return R.layout.activity_login;
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void initComponents() {
        binding = (ActivityLoginBinding) getBinding();
        binding.setModel(new Login());
        AppPreference.getInstance(LoginActivity.this).setBoolean(PrefKey.IS_LOGIN, false);

//
//        String st = localCash().getString(SharedPreferencesEnum.Key.SETTING);
//        if (st.isEmpty()) {
        if (isNetworkAvailable()) {
            callSetting();
        }

//        } else {
          /*  String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
            if (!roll.isEmpty()) {
                gotoBoard(roll);
            }*/

//            }


        binding.tvForgotPass.setOnClickListener(v -> {
                    ActivityUtils.getInstance().invokeActivity(LoginActivity.this, RegistrationActivity.class, false);

                }
        );


        binding.tvNewUser.setOnClickListener(v -> {
                    ActivityUtils.getInstance().invokeActivity(LoginActivity.this, RegistrationActivity.class, false);

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
                                if (lr.getData() != null) {
                                    AppPreference.getInstance(LoginActivity.this).setBoolean(PrefKey.IS_LOGIN, true);
                                    gotoBoard(lr.getData().getUserTypeId());
                                    String lg = toJson(response.body());
                                    localCash().put(SharedPreferencesEnum.Key.LOCA_LLOGIN, lg);
                                    localCash().put(SharedPreferencesEnum.Key.USER_NAME, binding.etUsername.getText().toString());
                                    localCash().put(SharedPreferencesEnum.Key.USER_CODE, response.body().getData().getUserCode());
                                    localCash().put(SharedPreferencesEnum.Key.RBM_NAME, response.body().getData().getSpervisorName());
                                    localCash().put(SharedPreferencesEnum.Key.FULL_NAME, lr.getData().getFullName());
                                    localCash().put(SharedPreferencesEnum.Key.BRANCH, lr.getData().getBranch());
                                } else {
                                    showToast("Invalid UserId or Password");




                                }
                            }

                        } else
                            showAlertDialog("" + response.code(), "" + response.message());
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        hideProgressDialog();
                        showToast("Login Failed");
                        showAlertDialog("" + t.getMessage(), "" + t.getLocalizedMessage());

                    }
                });


            }


        });


        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_PHONE_STATE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            // do you work now
                            getPhoneIMEINo();
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



    private void getPhoneIMEINo() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            showToast("Permission granted");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    phoneIMEINumber = tm.getImei();
                    showToast("Api Level: " + Build.VERSION.SDK_INT + ": " + phoneIMEINumber);
                } catch (NullPointerException e) {
                    showToast("Oreo and above NPE: " + e.getLocalizedMessage());
                }
            } else {
                try {
                    phoneIMEINumber = tm.getDeviceId();
                    showToast("Api Level: " + Build.VERSION.SDK_INT + ": " + phoneIMEINumber);
                } catch (NullPointerException e) {
                    showToast("Below oreo NPE: " + e.getLocalizedMessage());
                }
            }
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }


    }


    private void callSetting() {
        showProgressDialog();
        getApiService().getSetting().enqueue(new Callback<GlobalSettings>() {
            @Override
            public void onResponse(Call<GlobalSettings> call, Response<GlobalSettings> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        String setting = toJson(response.body());
                        localCash().put(SharedPreferencesEnum.Key.SETTING, setting);
                        String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
                        if (!roll.isEmpty()) {
                            gotoBoard(roll);
                        }
                        showToast("Setting Data Success");
                    }
                } else
                    showToast("Setting Data Failed");
            }

            @Override
            public void onFailure(Call<GlobalSettings> call, Throwable t) {
                hideProgressDialog();
                showToast("Setting Data Failed");
                showAlertDialog("" + t.getMessage(), t.getLocalizedMessage());

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
