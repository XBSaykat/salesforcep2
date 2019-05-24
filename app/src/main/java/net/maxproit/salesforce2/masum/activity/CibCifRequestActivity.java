package net.maxproit.salesforce2.masum.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.masum.model.api.cibcif.CibCifResponse;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Md. Mehedi Hasan on 12/13/2018.
 * mehedipy@gmail.com
 */
public class CibCifRequestActivity extends BaseActivity {
    Button btnCib,btnCif, btnDone;
    TextView tvCib,tvCif;
    String referrenceid;
    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.cib_cif_request_dialog_view;
    }

    @Override
    protected void initComponents() {
            btnCib = findViewById(R.id.btnCibRequest);
            btnCif = findViewById(R.id.btnCifRequest);
            tvCib = findViewById(R.id.tvCibRequest);
            tvCif = findViewById(R.id.tvCifRequest);
            btnDone = findViewById(R.id.btnDone);

            getIntentData();
            initListener();

    }

    private void initListener() {
        btnCib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    getApiService().cibRequest(referrenceid, localCash().getString(SharedPreferencesEnum.Key.USER_NAME)).enqueue(new Callback<CibCifResponse>() {
                        @Override
                        public void onResponse(Call<CibCifResponse> call, Response<CibCifResponse> response) {
                            if (response.isSuccessful()){
                                tvCib.setText(response.body().getMessage());
                            }
                            else {
                                showAlertDialog("Error", response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<CibCifResponse> call, Throwable t) {
                            showAlertDialog("Error", t.getMessage());
                        }
                    });
                }
            }
        });
        btnCif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    getApiService().cifRequest(referrenceid, localCash().getString(SharedPreferencesEnum.Key.USER_NAME)).enqueue(new Callback<CibCifResponse>() {
                        @Override
                        public void onResponse(Call<CibCifResponse> call, Response<CibCifResponse> response) {
                            if (response.isSuccessful()){
                                tvCif.setText(response.body().getMessage());
                            }
                            else {
                                showAlertDialog("Error", response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<CibCifResponse> call, Throwable t) {
                                showAlertDialog("Error", t.getMessage());
                        }
                    });
                }
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void getIntentData() {
        if (getIntent().getExtras().containsKey(KEY_REFERRENCE_ID)) {
            referrenceid = getIntent().getExtras().getString(KEY_REFERRENCE_ID);
        }

    }
}
