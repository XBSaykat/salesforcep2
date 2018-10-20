package net.maxproit.idlc.feature.salesOfficer.myProspect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import net.maxproit.idlc.AppConstant;
import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityMyProspectBinding;
import net.maxproit.idlc.feature.salesOfficer.myProspect.adapter.MyNewProspectAdapter;
import net.maxproit.idlc.feature.salesOfficer.myProspect.adapter.MyProspectAdapter;
import net.maxproit.idlc.feature.salesOfficer.mylead.MyLeadActivity;
import net.maxproit.idlc.feature.salesOfficer.mylead.adapter.MyLeadAdapter;
import net.maxproit.idlc.feature.salesOfficer.newProspect.NewProspectActivity;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.listener.OnItemClickListener;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.myprospect.MyProspect;
import net.maxproit.idlc.model.newlead.MyNewLead;
import net.maxproit.idlc.sqlite.MyLeadDbController;
import net.maxproit.idlc.util.ActivityUtils;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProspectActivity extends BaseActivity implements AdapterInfo {
    private static final String TAG = "MyProspectActivity";


    ActivityMyProspectBinding binding;
    LocalLogin localLogin;
    MyNewProspectAdapter myProspectAdapter;
    String userName;
    Bundle extras;
    MyLeadDbController myLeadDbController;

    ArrayList<MyNewLead> leadList, filterList;
    Button btnAddProspect;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_prospect;
    }

    @Override
    protected void initComponents() {


        binding = (ActivityMyProspectBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        leadList = new ArrayList<>();
        filterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(this);

        if (!leadList.isEmpty()) {
            leadList.clear();
        }

        leadList.addAll(myLeadDbController.getProspectData());

        localLogin = new LocalLogin(getApplicationContext());
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        myProspectAdapter = new MyNewProspectAdapter(MyProspectActivity.this, leadList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvMyProspect.setLayoutManager(mLayoutManager);
        binding.rvMyProspect.setAdapter(myProspectAdapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList = getFilterData(leadList, query);
                myProspectAdapter.setFilter(filterList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList = getFilterData(leadList, newText);
                myProspectAdapter.setFilter(filterList);
                return true;
            }
        });

//        try {
//            callApi();
//        } catch (Exception e) {
//            showAlertDialog("Error", e.getMessage());
//        }

        btnAddProspect = findViewById(R.id.btnAddProspect);
        btnAddProspect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(
                        MyProspectActivity.this, ProspectStageActivity.class);
                startActivity(activityChangeIntent);
            }
        });

        initListener();


    }

    private void initListener() {

        myProspectAdapter.setItemClickListener(new OnItemClickListener() {

            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()){
                    case R.id.btnApproved:
                        myLeadDbController.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_PROSPECT);
                        removeItemFromList(position,AppConstant.LEAD_STATUS_PROSPECT);
                        break;
                    case R.id.btnReject:
                        myLeadDbController.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_REJECT);
                        changeItemStatus(position,AppConstant.LEAD_STATUS_REJECT_FROM_PROSPECT);
                        break;
                    default:
                        sentDataToDetail(position);
                        break;
                }
            }
        });

    }


    private void removeItemFromList(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                leadList.remove(i);
                myProspectAdapter.notifyItemRemoved(position);
                break;

            }
        }
    }

    private void changeItemStatus(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                myProspectAdapter.notifyDataSetChanged();
                break;

            }
        }
    }


    private void sentDataToDetail(int position) {
        MyNewLead myNewLead=new MyNewLead(filterList.get(position).getId(),
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
                filterList.get(position).getVisitDate(),
                filterList.get(position).getFollowUp(),
                filterList.get(position).getRemark(),
                filterList.get(position).getStatus());
        ActivityUtils.invokLeadDetailForProspectStage(this,myNewLead);
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
        filterList.addAll(myProspectAdapter.getDataList());
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
