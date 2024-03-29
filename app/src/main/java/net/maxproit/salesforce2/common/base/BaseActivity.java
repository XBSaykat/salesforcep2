package net.maxproit.salesforce2.common.base;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;

import net.maxproit.salesforce2.BuildConfig;
import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce2.feature.dashboard.DashboardVirifierActivity;
import net.maxproit.salesforce2.feature.dashboard.supervisor.MainDashboardSupervisorActivity;
import net.maxproit.salesforce2.feature.login.LoginActivity;
import net.maxproit.salesforce2.masum.appdata.preference.AppPreference;
import net.maxproit.salesforce2.masum.appdata.preference.PrefKey;
import net.maxproit.salesforce2.masum.model.api.gpstracker.GetGpsResponse;
import net.maxproit.salesforce2.masum.utility.GPSTracker;
import net.maxproit.salesforce2.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce2.model.appversion.AppVersionResponse;
import net.maxproit.salesforce2.network.ApiService;
import net.maxproit.salesforce2.network.RestClient;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Sadiq Md. Asif on 26-Oct-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @SuppressWarnings("deprecation")
    private ProgressDialog progressDialog;
    private ViewDataBinding binding;
    private LinearLayout loadingView, noDataView;
    GPSTracker gps;

    private double latitude = 0, longitude = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutResourceId());
        initComponents();

    }


    protected abstract int getLayoutResourceId();

    /**
     * Initiate all view and listeners for the controls
     * Default values are assigned from Preference and intents.
     */
    protected abstract void initComponents();

    protected abstract void getIntentData();

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void showProgressDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog = ProgressDialog.show(BaseActivity.this, null, getString(R.string.please_wait), true);
            }
        });
    }

    public void showProgressDialog(final String title) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog = ProgressDialog.show(BaseActivity.this, title, getString(R.string.please_wait), true);
            }
        });
    }

    public void showProgressDialog(final String title, final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog = ProgressDialog.show(BaseActivity.this, title, message, true);
            }
        });
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            });
        }
    }

    public ProgressDialog getProgressDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog == null) {
                    progressDialog = ProgressDialog.show(BaseActivity.this, null, getString(R.string.please_wait), true);
                }
            }
        });
        return progressDialog;
    }

    /**
     * Shows a Alert Dialog with title and message and a OK button
     *
     * @param title   Title of the Alert Dialog
     * @param message Message of Alert Dialog
     */
    public void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    public void startActivityshowAlertDialog(String title, String message, Class<?> cls, boolean finishSelf) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(cls, finishSelf);
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void getGpsLocation() {
        gps = new GPSTracker(this);
        if (gps.canGetLocation()) {
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            // Toast.makeText(this, "lt:" + latitude + "\n" + "lng:" + longitude, Toast.LENGTH_SHORT).show();

        } /*else {
            gps.showSettingsAlert();
        }*/
    }


    public double getltd() {
        return latitude;
    }

    public double getLng() {
        return longitude;
    }


    public void sendGpsLocation(String refNo, String source, String userName, double latitude, double longitude, String info, Activity activity) {
        net.maxproit.salesforce2.masum.model.api.gpstracker.Data data = new net.maxproit.salesforce2.masum.model.api.gpstracker.Data();

        data.setReferenceNo(refNo);
        data.setLatitude(latitude);
        data.setLongitude(longitude);
        data.setUserName(userName);
        data.setSource(source);
        data.setLatitude(latitude);
        data.setLocationInfo(info);
        getApiService().sendltdlng(data).enqueue(new Callback<GetGpsResponse>() {
            @Override
            public void onResponse(Call<GetGpsResponse> call, Response<GetGpsResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        if (activity != null) {
                            MasumCommonUtils.statusAlert(getString(R.string.succes_txt), getString(R.string.save_success), activity);
                        }
                    } else {
                        if (activity != null) {
                            activity.finish();
                        }
                    }

                } else {
                    if (activity != null)
                        activity.finish();
                }
                hideProgressDialog();

            }

            @Override
            public void onFailure(Call<GetGpsResponse> call, Throwable t) {
                if (activity != null)
                    activity.finish();

                hideProgressDialog();

            }
        });
    }


    public String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strAdd;
    }


    public Context getContext() {
        return this;
    }

    public AlertDialog.Builder getAlertDialog(String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle(title)
                .setMessage(message);

        return builder;
    }

    public AlertDialog.Builder getAlertDialog() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        return builder;
    }

    public void showToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    public Activity getActivity() {
        return this;
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void startActivity(Class<?> cls, boolean finishSelf) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        if (finishSelf) {
            finish();
        }
    }

    public void startActivity(Class<?> cls, boolean finishSelf, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
        if (finishSelf) {
            finish();
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public void initLoader() {
        loadingView = (LinearLayout) findViewById(R.id.loadingView);
        noDataView = (LinearLayout) findViewById(R.id.noDataView);
    }

    public void showLoader() {
        if (loadingView != null) {
            loadingView.setVisibility(View.VISIBLE);
        }

        if (noDataView != null) {
            noDataView.setVisibility(View.GONE);
        }
    }

    public void hideLoader() {
        if (loadingView != null) {
            loadingView.setVisibility(View.GONE);
        }
        if (noDataView != null) {
            noDataView.setVisibility(View.GONE);
        }
    }

    public void showEmptyView() {
        if (loadingView != null) {
            loadingView.setVisibility(View.GONE);
        }
        if (noDataView != null) {
            noDataView.setVisibility(View.VISIBLE);
        }
    }


   /* public Util getUtility() {
        return Util.getInstance();
    }*/


    public boolean isEmpty(EditText editText) {
        return editText.getText().toString().isEmpty();

    }

    public boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public ApiService getApiService() {
        return RestClient.getInstance().callRetrofit();
    }

    public SharedPreferencesEnum localCash() {
        return SharedPreferencesEnum.getInstance(getActivity());
    }

    public String toJson(Object src) {
        if (src == null) {
            return toJson(JsonNull.INSTANCE);
        }
        return new GsonBuilder().serializeNulls().create().toJson(src);

    }

    public void disableEnableControls(boolean enable, ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View child = vg.getChildAt(i);
            child.setEnabled(enable);
            if (child instanceof ViewGroup) {
                disableEnableControls(enable, (ViewGroup) child);
            }
        }
    }

    public boolean isPending(String dateString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        Date date2 = null;

        boolean isTrue = false;
        try {
            date1 = sdf.parse(dateString);
            Date d = new Date();
            String currentDate = sdf.format(d);
            date2 = sdf.parse(currentDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1.compareTo(date2) > 0) {
            isTrue = false;
        } else if (date1.compareTo(date2) < 0) {
            isTrue = true;
        }
        return isTrue;
    }

    public String getStringFromResource(int stringID) {
        return getResources().getString(stringID);
    }

    public void checkAppVersion(Activity activity) {

//        try {
//            PackageInfo pInfo = getContext().getPackageManager().getPackageInfo(getPackageName(), 0);
//            versionName = pInfo.versionName;
//            versionCode = pInfo.versionCode;
//            showToast("version name:"+versionName + "version code: "+versionCode);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//
//        }
//        if(versionName.isEmpty()){
//        int versionName, versionCode;

        final int versionName = Integer.valueOf(BuildConfig.VERSION_NAME.replace(".", ""));
        final int versionCode = BuildConfig.VERSION_CODE;


//        }

        if (isNetworkAvailable()) {
            getApiService().getAppUpdate(UUID.randomUUID().toString()).enqueue(new Callback<AppVersionResponse>() {
                @Override
                public void onResponse(Call<AppVersionResponse> call, Response<AppVersionResponse> response) {
                    int verNameUpdate, verCodeUpdate;

                    if (response.isSuccessful()) {

                        if (response.body().getCode().equalsIgnoreCase(getString(R.string.response_code_200))) {
                            if (response.body().getData() != null) {
                                verNameUpdate = Integer.parseInt(response.body().getData().getVersionName().replace(".", ""));
                                verCodeUpdate = response.body().getData().getVersionCode();
                                showToast(
                                        "CURRENT App v." + versionName + "\nServer App v." + verNameUpdate);
                                if (verNameUpdate > versionName || verCodeUpdate > versionCode) {
                                    appUpdateAlertDialog(response.body().getData().getUrl(), verNameUpdate, versionName);
                                } else {
                                    initSplash(activity);
                                }
                            }
                        } else {
                            showAlertDialog(getStringFromResource(R.string.error_text) + "" + response.body().getCode(), response.body().getMessage());
                            initSplash(activity);
                        }
                    } else {
                        showAlertDialog(getStringFromResource(R.string.error_text) + "", response.message());
                        initSplash(activity);
                    }
                }

                @Override
                public void onFailure(Call<AppVersionResponse> call, Throwable t) {
                    initSplash(activity);
                    showAlertDialog(t.getMessage(), t.getLocalizedMessage());
                }
            });
        }


    }


    private void gotoActivity(Activity activity) {
        if (!AppPreference.getInstance(BaseActivity.this).getBoolean(PrefKey.IS_LOGIN)) {
            initSplash(activity);
        } else {
            String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
            if (!roll.isEmpty()) {
                gotoBoard(roll);
            }
        }

    }

    private void appUpdateAlertDialog(String url, int vc, int vn) {

        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(getContext());
        }
        builder.setTitle("Update Available");
        builder.setMessage("New Update Available for download. Please Download the latest version of the app.," + "\nCURRENT App v." + vn + "\nServer App v." + vc);
        builder.setIcon(R.drawable.ic_download);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", (dialog, which) -> downloadApp(url));
        android.app.AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void downloadApp(String url) {
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        String fileName;
        url = url.replace(" ", "%20");
        if (url != null) {
            fileName = url.substring(url.lastIndexOf('/') + 1, url.length()).trim();

            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.setDescription("Downloading latest version of the App");
            request.setTitle(getStringFromResource(R.string.app_name));
// in order for this if to run, you must use the android 3.2 to compile your app
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

            }
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);


// get download service and enqueue file
            try {
                manager.enqueue(request);
            } catch (NullPointerException e) {
                showAlertDialog(getStringFromResource(R.string.error_text), e.getLocalizedMessage());
            }

        } else {
            showToast("download url not found in the api");

        }
    }

    public void initSplash(Activity activity) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (!AppPreference.getInstance(activity).getBoolean(PrefKey.IS_LOGIN)) {
                    startActivity(LoginActivity.class, true);
                    activity.finish();
                } else {
                    String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
                    if (!roll.isEmpty()) {
                        gotoBoard(roll);
                    }
                }

            }
        }, 1500);
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

}
