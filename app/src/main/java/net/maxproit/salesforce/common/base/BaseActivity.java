package net.maxproit.salesforce.common.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.network.ApiService;
import net.maxproit.salesforce.network.RestClient;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Sadiq Md. Asif on 26-Oct-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @SuppressWarnings("deprecation")
    private ProgressDialog progressDialog;
    private ViewDataBinding binding;

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
        } else if (date1.compareTo(date2) <= 0) {
            isTrue = true;
        }
        return isTrue;
    }


}
