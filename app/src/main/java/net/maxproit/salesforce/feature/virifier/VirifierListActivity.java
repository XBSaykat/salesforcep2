package net.maxproit.salesforce.feature.virifier;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityVirifierListBinding;

import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.feature.virifier.adapter.VirifierListAdapter;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce.model.virifier.virifierlist.Virifier;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static net.maxproit.salesforce.feature.virifier.adapter.VirifierListAdapter.VERRIFIER;

public class VirifierListActivity extends BaseActivity implements AdapterInfo {

    ActivityVirifierListBinding binding;
    VirifierListAdapter myLeadAdapter;
    LocalLogin localLogin;
    String username;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_virifier_list;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityVirifierListBinding) getBinding();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        localLogin = new LocalLogin(getApplicationContext());
        username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);

        if (isNetworkAvailable()) {
            showProgressDialog();
            getApiService().getvirifierList(username).enqueue(new Callback<Virifier>() {
                @Override
                public void onResponse(Call<Virifier> call, Response<Virifier> response) {
                    hideProgressDialog();
                    if (response.isSuccessful()) {
                        myLeadAdapter = new VirifierListAdapter(VirifierListActivity.this, response.body().getData());
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        binding.rvMyLead.setLayoutManager(mLayoutManager);
                        binding.rvMyLead.setAdapter(myLeadAdapter);
                    } else showToast("Responce Failed");

                }

                @Override
                public void onFailure(Call<Virifier> call, Throwable t) {
                    hideProgressDialog();
                    showToast("Responce Failed");

                }
            });
        }

    }

    @Override
    protected void getIntentData() {

    }

    @Override
    public void adShowProgressDialog() {

    }

    @Override
    public void adHideProgressDialog() {

    }

    @Override
    public void adSuccess(String message) {
        startVerifiaction(message);

    }

    private void startVerifiaction(String message) {
        showProgressDialog();
        String random = UUID.randomUUID().toString();
        getApiService().getProspect(message, random).enqueue(new Callback<OleProspect>() {
            @Override
            public void onResponse(Call<OleProspect> call, Response<OleProspect> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    String en = new GsonBuilder().serializeNulls().create().toJson(response.body());
                    Bundle bundle = new Bundle();
                    bundle.putString("ROOT", VERRIFIER);
                    bundle.putString("DATA", en);
                }

            }

            @Override
            public void onFailure(Call<OleProspect> call, Throwable t) {
                hideProgressDialog();
                showToast("Failed request");

            }
        });
    }

    @Override
    public void adFailed(String message) {

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {


    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {

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
