package net.maxproit.salesforce.feature.salesOfficer.mylead;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;

import net.maxproit.salesforce.LeadStageActivity;
import net.maxproit.salesforce.databinding.ActivityMyLeadBinding;
import net.maxproit.salesforce.AppConstant;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.feature.salesOfficer.mylead.adapter.MyLeadAdapter;
import net.maxproit.salesforce.feature.salesOfficer.newlead.NewLeadActivity;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.listener.OnItemClickListener;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.newlead.MyNewLead;
import net.maxproit.salesforce.sqlite.MyLeadDbController;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;

public class MyLeadActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyLeadActivity";
    public static final int APPROVED = 101;

//    ActivityMyLeadBinding binding;
    ActivityMyLeadBinding binding;
    MyLeadAdapter myLeadAdapter;
    MyLeadDbController myLeadDbController;
    LocalLogin localLogin;
    MyNewLead myNewLead;
    String username;
    ArrayList<MyNewLead> leadList, filterList;


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
        filterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(MyLeadActivity.this);
        username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);

        if (!leadList.isEmpty()) {
            leadList.clear();
        }

        leadList.addAll(myLeadDbController.getAllData());

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList = getFilterData(leadList, query);
                myLeadAdapter.setFilter(filterList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // If remove data on test dataBase it Will be ok
                // myLeadAdapter.getFilter().filter(newText);
                filterList = getFilterData(leadList, newText);
                myLeadAdapter.setFilter(filterList);
                return true;
            }
        });


        myLeadAdapter = new MyLeadAdapter(MyLeadActivity.this, leadList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvMyLead.setLayoutManager(mLayoutManager);
        binding.rvMyLead.setAdapter(myLeadAdapter);
        myLeadAdapter.notifyDataSetChanged();


        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()) {
                    case R.id.btnApproved:
                        //insert data into prospect
                        myLeadDbController.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_PROSPECT);
                        removeItemFromList(position,AppConstant.LEAD_STATUS_PROSPECT);
                        break;
                    case R.id.btnReject:
                        myLeadDbController.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_REJECT);
                        changeItemStatus(position,AppConstant.LEAD_STATUS_REJECT);
                        break;
                    case R.id.clLeadItem:
                        Intent createLeadIntent = new Intent(MyLeadActivity.this, LeadStageActivity.class);
                        createLeadIntent.putExtra(AppConstant.LEAD_INTENT_KEY, position);
                        startActivity(createLeadIntent);
                        finish();
                }
            }
        });
    }



    @Override
    protected void getIntentData() {

    }

    private void removeItemFromList(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                leadList.remove(i);
                myLeadAdapter.notifyItemRemoved(position);
                break;

            }
        }
    }

    private void changeItemStatus(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                myLeadAdapter.notifyDataSetChanged();
                break;

            }
        }
    }


    //filter  data
    private ArrayList<MyNewLead> getFilterData(ArrayList<MyNewLead> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<MyNewLead> filteredModelList = new ArrayList<>();
        for (MyNewLead model : models) {
            final String uName = model.getUserName().toLowerCase();
            final String phone = model.getPhone().toLowerCase();

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
