package net.maxproit.idlc.feature.salesOfficer.myPerfomance.disbursement;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityDisbursementBinding;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.search.searchlist.disbursementsearch.DisbursementItem;
import net.maxproit.idlc.model.search.searchlist.disbursementsearch.DisbursementItemData;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerfomanceDisbursementsActivity extends BaseActivity {
    ActivityDisbursementBinding binding;
    LocalLogin localLogin;
    String userName;
    DisbursementItem itemData;
    public static final int SARCH = 200;
    public static final int ADD = 201;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_disbursement;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDisbursementBinding) getBinding();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding.btnRefSearch.setOnClickListener(v -> {
            if (TextUtils.isEmpty(binding.edtRefNumber.getText())) {
                searchFrom();
            } else searchRef(binding.edtRefNumber.getText().toString());

        });

        binding.btnAdd.setOnClickListener(v -> {
            if (itemData != null) {
                startActivityForResult(new Intent(this, DisbursementsActivity.class), ADD);
            }
        });


        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        localLogin = new LocalLogin(getApplicationContext());


    }

    private void searchRef(String id) {
        showProgressDialog();
        String testID = "1061500019301";
        getApiService().getDisbursement(testID, UUID.randomUUID().toString()).enqueue(new Callback<DisbursementItemData>() {
            @Override
            public void onResponse(Call<DisbursementItemData> call, Response<DisbursementItemData> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {

                        for (DisbursementItem i : response.body().getData()) {
                            itemData = i;
                            binding.setModel(itemData);
                        }

                    } else showAlertDialog("Error", response.body().getMessage());

                } else showAlertDialog("Error", response.message());

            }

            @Override
            public void onFailure(Call<DisbursementItemData> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error", t.getMessage());

            }
        });
    }

    private void searchFrom() {
        startActivityForResult(new Intent(this, DisbursementSearchActivity.class), SARCH);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SARCH) {
            if (resultCode == RESULT_OK) {
                searchRef(data.getStringExtra("RFID"));
                //showToast("Search "+data.getStringExtra("RFID"));
            }


        } else if (requestCode == ADD) {
            showToast("Add");
        }
    }
}
