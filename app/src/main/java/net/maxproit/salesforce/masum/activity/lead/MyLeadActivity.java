package net.maxproit.salesforce.masum.activity.lead;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import net.maxproit.salesforce.databinding.ActivityMyLeadBinding;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.api.LeadDataFromApi;
import net.maxproit.salesforce.masum.model.api.MyGetLeadApi;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.adapter.MyLeadAdapter;
import net.maxproit.salesforce.feature.salesOfficer.newlead.NewLeadActivity;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyLeadActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyLeadActivity";
    public static final int APPROVED = 101;

    ActivityMyLeadBinding binding;
    MyLeadAdapter myLeadAdapter;
    MyLeadDbController myLeadDbController;
    LocalLogin localLogin;
    MyNewProspect myNewLead;
    ArrayList<LeadDataFromApi> leadDataFromApiList,filterList;
    String username;
    ArrayList<MyNewProspect> leadList;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_lead;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityMyLeadBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        localLogin = new LocalLogin(getApplicationContext());
        leadList = new ArrayList<>();
        leadDataFromApiList = new ArrayList<>();
        filterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(MyLeadActivity.this);
        username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);

        if (!leadList.isEmpty()) {
            leadList.clear();
        } if (!leadDataFromApiList.isEmpty()) {
            leadDataFromApiList.clear();
        }
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail !=null){
            int status=extraDetail.getInt(AppConstant.STATUS_INTENT_KEY,-1);
            if (status==1){
                binding.searchView.setQueryHint("search pending lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.LEAD_STATUS_NEW));
                binding.rvMyLead.setClickable(false);
            }

            else if (status==2){
                binding.searchView.setQueryHint("search proceeded lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_NEW_PROSPECT));
                binding.rvMyLead.setClickable(false);
            }

            else if (status==3){
                binding.searchView.setQueryHint("search closed lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.LEAD_STATUS_REJECT));
                binding.rvMyLead.setClickable(false);
            }
            else if (status==4){
                binding.searchView.setQueryHint("search Prospect ");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_NEW_PROSPECT));
                binding.rvMyLead.setClickable(false);
            }
            else if (status==5){
                binding.searchView.setQueryHint("search Proceeded Prospect");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_RBM));
                binding.rvMyLead.setClickable(false);
            }
            else {
                getDataFromServer();
                leadList.addAll(myLeadDbController.myNewLeadGetAllData());
            }
        }
        else {
            getDataFromServer();
            leadList.addAll(myLeadDbController.myNewLeadGetAllData());
        }



        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList = getFilterData(leadDataFromApiList, query);
                myLeadAdapter.setFilter(filterList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // If remove data on test dataBase it Will be ok
                // myLeadAdapter.getFilter().filter(newText);
                filterList = getFilterData(leadDataFromApiList, newText);
                myLeadAdapter.setFilter(filterList);
                return true;
            }
        });


        myLeadAdapter = new MyLeadAdapter(MyLeadActivity.this, leadDataFromApiList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvMyLead.setLayoutManager(mLayoutManager);
        binding.rvMyLead.setAdapter(myLeadAdapter);
        myLeadAdapter.notifyDataSetChanged();


        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()) {
                    case R.id.clLeadItem:
                        sentDataToDetail(position);
                        break;
                }
            }
        });
    }

    private void getDataFromServer(){
        getApiService().getLeadData(username,"1").enqueue(new Callback<MyGetLeadApi>() {
            @Override
            public void onResponse(Call<MyGetLeadApi> call, Response<MyGetLeadApi> response) {
                if (response.isSuccessful()){
                    leadDataFromApiList.addAll(response.body().getData());
                     myLeadAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MyGetLeadApi> call, Throwable t) {

            }
        });
    }

    private void sentDataToDetail(int position) {
        ActivityUtils.invokRefNumber(this,LeadStageActivity.class,filterList.get(position).getReference());
    }


    @Override
    protected void getIntentData() {

    }



    //filter  data
    private ArrayList<LeadDataFromApi> getFilterData(ArrayList<LeadDataFromApi> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<LeadDataFromApi> filteredModelList = new ArrayList<>();
        for (LeadDataFromApi model : models) {
            final String uName = model.getName().toLowerCase();
            final String phone = model.getReference().toLowerCase();

            if (uName.contains(searchKey) || phone.contains(searchKey)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void loadFilterData() {
        if (!filterList.isEmpty()) {
            filterList.clear();
        }
        filterList.addAll(myLeadAdapter.getDataList());
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


    }

    @Override
    public void adHideProgressDialog() {


    }

    @Override
    public void adSuccess(String message) {
        recreate();
    }

    @Override
    public void adFailed(String message) {
        showToast(message);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle) {
        startActivity(NewLeadActivity.class, self, bundle);

    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {
        Intent intent = new Intent(MyLeadActivity.this, NewLeadActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, code);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // When an Image is picked
        if (requestCode == APPROVED && resultCode == RESULT_OK && null != data) {
            startActivity(MyLeadActivity.class, true);


        }


    }
}
