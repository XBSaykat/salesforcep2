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
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.adapter.MyLeadAdapter;
import net.maxproit.salesforce.feature.salesOfficer.newlead.NewLeadActivity;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.masum.model.MyNewLead;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;

import static net.maxproit.salesforce.masum.appdata.AppConstant.STATUS_INTENT_KEY;

public class MyLeadActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyLeadActivity";
    public static final int APPROVED = 101;

//    ActivityMyLeadBinding binding;
    ActivityMyLeadBinding binding;
    MyLeadAdapter myLeadAdapter;
    MyLeadDbController myLeadDbController;
    LocalLogin localLogin;
    MyNewProspect myNewLead;
    String username;
    ArrayList<MyNewProspect> leadList, filterList;


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
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail !=null){
            int status=extraDetail.getInt(AppConstant.STATUS_INTENT_KEY,-1);
            if (status==1){
                binding.searchView.setQueryHint("search pending lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.LEAD_STATUS_NEW));
                binding.rvMyLead.setClickable(false);
            }

            else if (status==2){
                binding.searchView.setQueryHint("search proceed lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_NEW_PROSPECT));
                binding.rvMyLead.setClickable(false);
            }

            else if (status==3){
                binding.searchView.setQueryHint("search closed lead");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.LEAD_STATUS_REJECT));
                binding.rvMyLead.setClickable(false);
            }
            else if (status==4){
                binding.searchView.setQueryHint("search Propect ");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_NEW_PROSPECT));
                binding.rvMyLead.setClickable(false);
            }
            else if (status==5){
                binding.searchView.setQueryHint("search Proceeded Prospect");
                leadList.addAll(myLeadDbController.myNewLeadGetAllData(AppConstant.STATUS_RBM));
                binding.rvMyLead.setClickable(false);
            }
        }
        else {
            leadList.addAll(myLeadDbController.myNewLeadGetAllData());
        }



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
                    case R.id.clLeadItem:
                        sentDataToDetail(position);
                        break;
                }
            }
        });
    }

    private void sentDataToDetail(int position) {
        myNewLead=new MyNewProspect(filterList.get(position).getId(),
                filterList.get(position).getBranchName(),
                filterList.get(position).getUserName(),
                filterList.get(position).getProfession(),
                filterList.get(position).getOrganization(),
                filterList.get(position).getDesignation(),
                filterList.get(position).getPhone(),
                filterList.get(position).getAddress(),
                filterList.get(position).getSourceRef(),
                filterList.get(position).getProductType(),
                filterList.get(position).getProductSubcategory(),
                filterList.get(position).getLoanAmount(),
                filterList.get(position).getOrInterest(),
                filterList.get(position).getOpFee(),
                filterList.get(position).getDisDate(),
                filterList.get(position).getVisitDate(),
                filterList.get(position).getFollowUp(),
                filterList.get(position).getRemark(),
                filterList.get(position).getStatus()
                );
        ActivityUtils.invokLeadDetailForLeadStage(this,myNewLead);
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
    private ArrayList<MyNewProspect> getFilterData(ArrayList<MyNewProspect> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<MyNewProspect> filteredModelList = new ArrayList<>();
        for (MyNewProspect model : models) {
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
