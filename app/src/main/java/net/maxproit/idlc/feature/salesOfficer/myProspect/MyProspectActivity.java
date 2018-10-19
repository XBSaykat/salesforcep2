package net.maxproit.idlc.feature.salesOfficer.myProspect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityMyProspectBinding;
import net.maxproit.idlc.feature.salesOfficer.myProspect.adapter.MyProspectAdapter;
import net.maxproit.idlc.feature.salesOfficer.newProspect.NewProspectActivity;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.myprospect.MyProspect;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProspectActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyProspectActivity";


    ActivityMyProspectBinding binding;
    LocalLogin localLogin;
    MyProspectAdapter myProspectAdapter;
    String userName;
    Bundle extras;
    boolean isPerfomance = false;

    Button btnAddProspect;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_prospect;
    }

    @Override
    protected void initComponents() {


        binding = (ActivityMyProspectBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());


        localLogin = new LocalLogin(getApplicationContext());
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myProspectAdapter.getFilter().filter(newText);
                return false;
            }
        });

        try {
            callApi();
        } catch (Exception e) {
            showAlertDialog("Error", e.getMessage());
        }

        btnAddProspect = findViewById(R.id.btnAddProspect);
        btnAddProspect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MyProspectActivity.this, ProspectStageActivity.class);
                startActivity(activityChangeIntent);
            }
        });


    }

    private void callApi() {
        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getMyProspect(userName, UUID.randomUUID().toString()).enqueue(new Callback<MyProspect>() {
                @Override
                public void onResponse(Call<MyProspect> call, Response<MyProspect> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            myProspectAdapter = new MyProspectAdapter(MyProspectActivity.this, response.body(), isPerfomance);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            binding.rvMyProspect.setLayoutManager(mLayoutManager);
                            binding.rvMyProspect.setAdapter(myProspectAdapter);
                        } else showAlertDialog("Error", response.body().getMessage());

                    } else showAlertDialog("Error", response.message());

                }

                @Override
                public void onFailure(Call<MyProspect> call, Throwable t) {
                    hideProgressDialog();
                    showAlertDialog("Error", t.getMessage());


                }
            });
        } else showAlertDialog("Error", "Network is not available");
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
        showProgressDialog();
    }

    @Override
    public void adHideProgressDialog() {
        hideProgressDialog();

    }

    @Override
    public void adSuccess(String message) {
        //recreate();
        startActivity(MyProspectActivity.class, true);

    }

    @Override
    public void adFailed(String message) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {
        startActivity(NewProspectActivity.class, self, bundle);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {
        Intent intent = new Intent(MyProspectActivity.this, NewProspectActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, code);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // When an Image is picked
        if (requestCode == 200 && resultCode == RESULT_OK && null != data) {
            // startActivity(MyProspectActivity.class,true);
            recreate();

        }


    }


}
