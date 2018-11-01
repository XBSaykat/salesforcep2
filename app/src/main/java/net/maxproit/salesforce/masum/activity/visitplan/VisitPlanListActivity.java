package net.maxproit.salesforce.masum.activity.visitplan;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityVisitPlanListBinding;
import net.maxproit.salesforce.masum.adapter.adapterplanlist.MyVisitPlanListAdapter;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;

import java.text.ParseException;
import java.util.ArrayList;

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
    private VisitPlanDbController myDbController;
    public static int itemPosition=0;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_visit_plan_list;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityVisitPlanListBinding) getBinding();
        myDbController = new VisitPlanDbController(getContext());
        leadList=new ArrayList<>();
        visitPlanList=new ArrayList<>();
        filterList=new ArrayList<>();
        if (!leadList.isEmpty()) {
            leadList.clear();
        }
        if (!visitPlanList.isEmpty()){
            visitPlanList.clear();
        }
        if (!myDbController.getAllData().equals(null)){

            leadList.addAll(myDbController.getAllData());

            for (int i=0;i<leadList.size();i++){

                try {
                    if (isPending(leadList.get(i).getDateOfVisit()) &&
                            leadList.get(i).getStatus().equalsIgnoreCase(AppConstant.LEAD_STATUS_New_PLAN)){
                        visitPlanList.add(leadList.get(i));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        else {
            Toast.makeText(this, "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        }


        backButton = findViewById(R.id.btn_back);
        addButton = findViewById(R.id.btn_add);
        myLeadAdapter=new MyVisitPlanListAdapter(this,visitPlanList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        binding.rvMyLead.setLayoutManager(mLayoutManager);
        binding.rvMyLead.setAdapter(myLeadAdapter);
        myLeadAdapter.notifyDataSetChanged();

        initListener();

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
//        startActivity(new Intent(MyActivitiesActivityNew.this, DashboardSalesOfficerActivity.class));
//        finish();
//    }

    private void initListener() {

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VisitPlanListActivity.super.onBackPressed();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog();
           /*     AlertDialog dialog = new AlertDialog.Builder(VisitPlanListActivity.this).create();
                dialog.setTitle("Create new Plan?");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(VisitPlanListActivity.this, VisitPlanActivity.class));
                        dialog.dismiss();
                    }
                });
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();*/

            }
        });

        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
//                loadFilterData();
                switch (view.getId()) {
/*                    case R.id.btnApproved:
                        Toast.makeText(getActivity(), "Approved", Toast.LENGTH_SHORT).show();
                        //insert data into prospect
//                          myDbController.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_PROSPECT);
//                         removeItemFromList(position,AppConstant.LEAD_STATUS_PROSPECT);

                        break;
                    case R.id.btnReject:
                        Toast.makeText(getActivity(), "Rejected", Toast.LENGTH_SHORT).show();
//                         myLeadAdapter.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_REJECT);
//                        removeItemFromList(position,AppConstant.LEAD_STATUS_REJECT);
                        break;*/

                    case R.id.cl_visit_plan_item:
                        sentDataToDetail(position);
                        break;

                }
            }
        });

    }

    private void sentDataToDetail(int position) {
        VisitPlan visitPlan = new VisitPlan(
                visitPlanList.get(position).getId(),
                visitPlanList.get(position).getClientName(),
                visitPlanList.get(position).getClientType(),
                visitPlanList.get(position).getMobileNumber(),
                visitPlanList.get(position).getPoliceStation(),
                visitPlanList.get(position).getProductType(),
                visitPlanList.get(position).getCity(),
                visitPlanList.get(position).getPurposeOfVisit(),
                visitPlanList.get(position).getDateOfVisit(),
                visitPlanList.get(position).getRemarks(),
                visitPlanList.get(position).getStatus());
        ActivityUtils.invokVisitPlanDetail(getActivity(), VisitPLanDetailsActivity.class, visitPlan);
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
            startActivity(new Intent(VisitPlanListActivity.this, VisitPlanActivity.class));
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
