package net.maxproit.salesforce.masum.activity.visitplan;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityVisitPlanListBinding;
import net.maxproit.salesforce.masum.adapter.adapterplanlist.MyVisitPlanListAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.FollowUpDbController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.myactivity.Datum;
import net.maxproit.salesforce.masum.model.api.myactivity.MyActivityGetDataApi;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitPlanListActivity extends BaseActivity {



    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinearLayout linearLayoutToolbar;
    private TextView btnSave;
    private ImageView backButton, addButton;
    private ActivityVisitPlanListBinding binding;
    private MyVisitPlanListAdapter myLeadAdapter;
    private ArrayList<VisitPlan> leadList,visitPlanList, filterList;
    private ArrayList<Datum> visitPlanApiList,filterApiList;
    private VisitPlanDbController myDbController;
    private FollowUpDbController followUpDbController;
    SearchView searchView;
    LocalSetting localSetting;
    public static int itemPosition=0;
    String userName=null;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_visit_plan_list;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityVisitPlanListBinding) getBinding();
        myDbController = new VisitPlanDbController(getContext());
        localSetting=new LocalSetting(this);
        leadList=new ArrayList<>();
        visitPlanList=new ArrayList<>();
        visitPlanApiList=new ArrayList<>();
        filterList=new ArrayList<>();
        filterApiList=new ArrayList<>();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        localCash().put(SharedPreferencesEnum.Key.USER_NAME_PER, userName);

        backButton = findViewById(R.id.btn_back);
        addButton = findViewById(R.id.btn_add);
        searchView=findViewById(R.id.search_view);
        myLeadAdapter=new MyVisitPlanListAdapter(this,visitPlanApiList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        binding.rvMyLead.setLayoutManager(mLayoutManager);
        binding.rvMyLead.setAdapter(myLeadAdapter);
        myLeadAdapter.notifyDataSetChanged();
        initListener();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!leadList.isEmpty()) {
            leadList.clear();
        }
        if (!visitPlanList.isEmpty()){
            visitPlanList.clear();
        }
        if (!visitPlanApiList.isEmpty()){
            visitPlanApiList.clear();
        }

        Bundle extraDetail = getIntent().getExtras();

        if (extraDetail !=null){
            int status=extraDetail.getInt(AppConstant.STATUS_INTENT_KEY,-1);
            if (status==1){
                visitPlanList.addAll(myDbController.getPreviousData(DateUtils.getDateString()));
                myLeadAdapter.notifyDataSetChanged();
                searchView.setQueryHint("search unexecuted plan");

            }

            else if (status==2){
                visitPlanList.addAll(myDbController.getUpComingData(DateUtils.getDateString()));
                myLeadAdapter.notifyDataSetChanged();
                searchView.setQueryHint("search upcoming plan");
            }
            else if (status==3){
                visitPlanList.addAll(myDbController.getPlanDataUsingStatus(AppConstant.STATUS_ACTIVITY));
                myLeadAdapter.notifyDataSetChanged();
                searchView.setQueryHint("search Fresh Activity");
            }
            else if (status==4){
                visitPlanList.addAll(myDbController.getPlanDataUsingStatus(AppConstant.VISITED));
                myLeadAdapter.notifyDataSetChanged();
                searchView.setQueryHint("search visited Activity");


            }
            else{
                if (isNetworkAvailable()){
                    String random = UUID.randomUUID().toString();
                    getApiService().getActivityData(userName,random).enqueue(new Callback<MyActivityGetDataApi>() {
                        @Override
                        public void onResponse(Call<MyActivityGetDataApi> call, Response<MyActivityGetDataApi> response) {
                            if (response.body().getCode().equals("200") &&
                                    response.body().getStatus().equalsIgnoreCase("ok")){
                                visitPlanApiList.addAll(response.body().getData());
                                myLeadAdapter.notifyDataSetChanged();

                            }
                        }

                        @Override
                        public void onFailure(Call<MyActivityGetDataApi> call, Throwable t) {

                        }
                    });
                }
                if (!myDbController.getPlanData().equals(null)){
                    visitPlanList.addAll(myDbController.getPlanData());
                    myLeadAdapter.notifyDataSetChanged();
                }

                else {
                    Toast.makeText(this, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
                }
            }

        }



    }

    @Override
    protected void getIntentData() {


    }

    //    private Toolbar toolbar;
//    private TabLayout tabLayout;
//    private ViewPager viewPager;
//    private TextView btnSave;
//
//
//    private Spinner spnClientType;
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_activites_new);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        viewPager = (ViewPager) findViewById(R.id.my_activities_viewpager);
//        setupViewPager(viewPager);
//
//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
//
//
//
//    }
//

//    @Override
//    public void onBackPressed() {
//
//
//        super.onBackPressed();
//        startActivity(new Intent(MyActivitiesActivity.this, DashboardSalesOfficerActivity.class));
//        finish();
//    }

    private void initListener() {

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onBackPressed();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog();
            }
        });

        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()) {
                    case R.id.cl_visit_plan_item:
                        sentDataToDetail(position);
                        break;

                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterApiList = getFilterData(visitPlanApiList, query);
                myLeadAdapter.setFilter(filterApiList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                filterApiList = getFilterData(visitPlanApiList, query);
                myLeadAdapter.setFilter(filterApiList);
                return true;
            }
        });

    }


    //filter  data
    private ArrayList<Datum> getFilterData(ArrayList<Datum> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<Datum> filteredModelList = new ArrayList<>();
        for (Datum model : models) {
            final String uName = model.getCustomerName().toLowerCase();
            final String phone = model.getMobileNo().toLowerCase();

            if (uName.contains(searchKey) || phone.contains(searchKey)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void loadFilterData() {
        if (!filterApiList.isEmpty()) {
            filterApiList.clear();
        }
        filterApiList.addAll(myLeadAdapter.getDataList());
    }

    private void sentDataToDetail(int position) {
        VisitPlan visitPlan = new VisitPlan(
                Integer.valueOf(filterApiList.get(position).getActivityJournalID()),
                filterApiList.get(position).getCustomerName(),
                filterApiList.get(position).getClientType(),
                filterApiList.get(position).getMobileNo(),
                filterApiList.get(position).getPS(),
                filterApiList.get(position).getProductType(),
                filterApiList.get(position).getCity(),
                filterApiList.get(position).getVisitPurposeType(),
                filterApiList.get(position).getActivityDate(),
                filterApiList.get(position).getRemarks(),
                filterApiList.get(position).getActivityStatus(),
                filterApiList.get(position).getActivityStatus()
                );
        ActivityUtils.invokVisitPlanDetail(getActivity(), VisitPlanActivity.class, visitPlan);
    }


    private void alertDialog() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(VisitPlanListActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(VisitPlanListActivity.this);
        }
        builder.setTitle(getString(R.string.visit_plan));
        builder.setMessage(getString(R.string.create_plan));
        builder.setIcon(R.drawable.lead);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            ActivityUtils.getInstance().invokeActivity(VisitPlanListActivity.this, VisitPlanActivity.class,false);
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
