package net.maxproit.salesforce.masum.activity.visitplan;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.masum.adapter.adapterplanlist.MyVisitPlanListAdapter;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;

public class MyActivitiesActivity extends BaseActivity {
    private static final String TAG = "MyLeadActivity";
    public static final int APPROVED = 101;

    MyVisitPlanListAdapter myLeadAdapter;
    VisitPlanDbController myDbController;
    private ImageView backButton, addButton;
    private SearchView searchView;
    private RecyclerView rvMyLead;
    LocalLogin localLogin;
    String username;
    ArrayList<VisitPlan> leadList, filterList;



    //filter  data
    private ArrayList<VisitPlan> getFilterData(ArrayList<VisitPlan> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<VisitPlan> filteredModelList = new ArrayList<>();
        for (VisitPlan model : models) {
            final String uName = model.getCity().toLowerCase();
            final String phone = model.getClientType().toLowerCase();

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
    protected int getLayoutResourceId() {
        return R.layout.activity_my_activites;
    }

    @Override
    protected void initComponents() {
        leadList = new ArrayList<>();
        filterList = new ArrayList<>();
        myDbController = new VisitPlanDbController(this);
        username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);

        if (!leadList.isEmpty()) {
            leadList.clear();
        }
       leadList.addAll(myDbController.getAllData());

        searchView = findViewById(R.id.search_view);
        rvMyLead = findViewById(R.id.rvMyLead);

        backButton = findViewById(R.id.btn_back);
        addButton = findViewById(R.id.btn_add);
        rvMyLead = findViewById(R.id.rvMyLead);





        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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


        myLeadAdapter = new MyVisitPlanListAdapter(this, leadList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvMyLead.setLayoutManager(mLayoutManager);
        rvMyLead.setAdapter(myLeadAdapter);
        myLeadAdapter.notifyDataSetChanged();


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyActivitiesActivity.super.onBackPressed();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "add button pressed", Toast.LENGTH_LONG).show();
            }
        });

        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()) {
                    case R.id.btnApproved:
                        //insert data into prospect
//                          myDbController.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_PROSPECT);
//                         removeItemFromList(position,AppConstant.LEAD_STATUS_PROSPECT);

                        break;
                    case R.id.btnReject:
                        // myLeadAdapter.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_REJECT);
                        //removeItemFromList(position,AppConstant.LEAD_STATUS_REJECT);
                        break;
                }
            }
        });




    }

    @Override
    protected void getIntentData() {

    }
}