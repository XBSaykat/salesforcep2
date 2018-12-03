package net.maxproit.salesforce.masum.activity.prospect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMyProspectBinding;
import net.maxproit.salesforce.masum.adapter.adapter.MyNewProspectAdapter;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.myprospect.Data;
import net.maxproit.salesforce.model.myprospect.MyProspect;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce.model.myprospect.updatemyprospect.OldProspect;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

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
    ArrayList<Data> prospectList, filterList;
    Button btnAddProspect;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_prospect;
    }

    @Override
    protected void initComponents() {


        binding = (ActivityMyProspectBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        prospectList = new ArrayList<>();
        filterList = new ArrayList<>();
        myLeadDbController = new MyLeadDbController(this);

        if (!prospectList.isEmpty()) {
            prospectList.clear();
        }

//        prospectList.addAll(myLeadDbController.myNewProspectGetAllData(AppConstant.STATUS_NEW_PROSPECT));
        localLogin = new LocalLogin(getApplicationContext());
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);

//        try {
//            callApi();
//        } catch (Exception e) {
//            showAlertDialog("Error", e.getMessage());
//        }




        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList = getFilterData(prospectList, query);
                myProspectAdapter.setFilter(filterList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList = getFilterData(prospectList, newText);
                myProspectAdapter.setFilter(filterList);
                return true;
            }
        });





//        initListener();


    }

    private void initListener() {

        myProspectAdapter.setItemClickListener(new OnItemClickListener() {

            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()){
                    default:
                        String ref = filterList.get(position).getReference();
                        callMyProspectApi(ref);

                        break;
                }
            }
        });

    }

    private void callMyProspectApi(String ref) {
        getApiService().getNewProspect(ref, UUID.randomUUID().toString() ).enqueue(new Callback<OldProspect>() {
            @Override
            public void onResponse(Call<OldProspect> call, Response<OldProspect> response) {

            }

            @Override
            public void onFailure(Call<OldProspect> call, Throwable t) {

            }
        });
    }


    private void removeItemFromList(int position,String status) {
        for (int i = 0; i < prospectList.size(); i++) {
            if (prospectList.get(i).getReference() == filterList.get(position).getReference()) {
                prospectList.get(i).setStatus(status);
                prospectList.remove(i);
                myProspectAdapter.notifyItemRemoved(position);
                break;

            }
        }
    }

    private void changeItemStatus(int position,String status) {
        for (int i = 0; i < prospectList.size(); i++) {
            if (prospectList.get(i).getReference() == filterList.get(position).getReference()) {
                prospectList.get(i).setStatus(status);
                myProspectAdapter.notifyDataSetChanged();
                break;

            }
        }
    }




    //filter  data
    private ArrayList<Data> getFilterData(ArrayList<Data> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<Data> filteredModelList = new ArrayList<>();
        for (Data model : models) {
            final String uName = model.getName().toLowerCase();
            final String reference = model.getReference().toLowerCase();

            if (uName.contains(searchKey) || reference.contains(searchKey)) {
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


    }

    @Override
    public void startActivity(boolean self, Bundle bundle, int code) {


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // When an Image is picked
        if (requestCode == 200 && resultCode == RESULT_OK && null != data) {
            // startActivity(MyProspectActivity.class,true);
            recreate();

        }


    }
//    private void sentDataToDetail(int position) {
//        MyNewProspect myNewLead=new MyNewProspect(filterList.get(position).getId(),
//                filterList.get(position).getBranchName(),
//                filterList.get(position).getUserName(),
//                filterList.get(position).getProfession(),
//                filterList.get(position).getOrganization(),
//                filterList.get(position).getDesignation(),
//                filterList.get(position).getPhone(),
//                filterList.get(position).getAddress(),
//                filterList.get(position).getSourceRef(),
//                filterList.get(position).getProductType(),
//                filterList.get(position).getProductSubcategory(),
//                filterList.get(position).getLoanAmount(),
//                filterList.get(position).getOrInterest(),
//                filterList.get(position).getOpFee(),
//                filterList.get(position).getVisitDate(),
//                filterList.get(position).getDisDate(),
//                filterList.get(position).getFollowUp(),
//                filterList.get(position).getRemark(),
//                filterList.get(position).getStatus(),
//                filterList.get(position).getSegment(),
//                filterList.get(position).getDateOfBirth(),
//                filterList.get(position).getAge(),
//                filterList.get(position).getDob(),
//                filterList.get(position).getCob(),
//                filterList.get(position).getpIDType(),
//                filterList.get(position).getpIdNumber(),
//                filterList.get(position).getpIssueDate(),
//                filterList.get(position).getEtin(),
//                filterList.get(position).getfName(),
//                filterList.get(position).getmName(),
//                filterList.get(position).getsName(),
//                filterList.get(position).getExList(),
//                filterList.get(position).getCurrentJob(),
//                filterList.get(position).getApplicant(),
//                filterList.get(position).getpAddress(),
//                filterList.get(position).getNetSalary(),
//                filterList.get(position).getSalaryAmount(),
//                filterList.get(position).getBusinessIncomeAmount(),
//                filterList.get(position).getApartmentAmount(),
//                filterList.get(position).getSemipakaIncome(),
//                filterList.get(position).getOfficeSpaceINcome(),
//                filterList.get(position).getWireHouseINcome(),
//                filterList.get(position).getAg_Income(),
//                filterList.get(position).getTution(),
//                filterList.get(position).getRemitance(),
//                filterList.get(position).getInFdr(),
//                filterList.get(position).getfExpense(),
//                filterList.get(position).getEmiOther(),
//                filterList.get(position).getsValue(),
//                filterList.get(position).getLoanReq(),
//                filterList.get(position).getLoanTerm(),
//                filterList.get(position).getPiRate(),
//                filterList.get(position).getProspectFee()
//                );
//        ActivityUtils.invokLeadDetailForProspectStage(this,myNewLead);
//    }

}
