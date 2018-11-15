package net.maxproit.salesforce;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import net.maxproit.salesforce.feature.dashboard.supervisor.MainDashboardSupervisorActivity;
import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.adapter.adapter.MyNewProspectAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;

public class SupervisorRbmProspect extends AppCompatActivity {

    private Button btnLogout;
    private ImageView btnBack;

    ArrayList<MyNewProspect> prospectArrayList, filterList;

    MyNewProspectAdapter myAdapter;
//    String userName;
//    Bundle extras;
    MyLeadDbController myLeadDbController;
    RecyclerView rvProspect;

//    ArrayList<MyNewLead> followUpList, filterList;
//    Button btnAddProspect;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_rbm_prospect);
        rvProspect = findViewById(R.id.rv_supervisor_rbm);

        btnLogout = (Button) findViewById(R.id.btn_logout);
        btnBack = (ImageView) findViewById(R.id.btn_back);

        prospectArrayList = new ArrayList<>();
        filterList = new ArrayList<>();

        myAdapter = new MyNewProspectAdapter(this, filterList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvProspect.setLayoutManager(mLayoutManager);
        rvProspect.setAdapter(myAdapter);
        initListener();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initListener() {

        myAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                sentDataToDetail(position);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        myLeadDbController = new MyLeadDbController(this);
        if (!filterList.isEmpty()){
            filterList.clear();
        }

        filterList.addAll(myLeadDbController.myNewProspectGetAllData(AppConstant.STATUS_RBM));
        myAdapter.notifyDataSetChanged();
    }

    private void sentDataToDetail(int position) {
        MyNewProspect myNewLead=new MyNewProspect(filterList.get(position).getId(),
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
                filterList.get(position).getDisDate(),
                filterList.get(position).getFollowUp(),
                filterList.get(position).getRemark(),
                filterList.get(position).getStatus(),
                filterList.get(position).getSegment(),
                filterList.get(position).getDateOfBirth(),
                filterList.get(position).getAge(),
                filterList.get(position).getDisDate(),
                filterList.get(position).getCob(),
                filterList.get(position).getpIDType(),
                filterList.get(position).getpIdNumber(),
                filterList.get(position).getpIssueDate(),
                filterList.get(position).getEtin(),
                filterList.get(position).getfName(),
                filterList.get(position).getmName(),
                filterList.get(position).getsName(),
                filterList.get(position).getExList(),
                filterList.get(position).getCurrentJob(),
                filterList.get(position).getApplicant(),
                filterList.get(position).getpAddress(),
                filterList.get(position).getNetSalary(),
                filterList.get(position).getSalaryAmount(),
                filterList.get(position).getBusinessIncomeAmount(),
                filterList.get(position).getApartmentAmount(),
                filterList.get(position).getSemipakaIncome(),
                filterList.get(position).getOfficeSpaceINcome(),
                filterList.get(position).getWireHouseINcome(),
                filterList.get(position).getAg_Income(),
                filterList.get(position).getTution(),
                filterList.get(position).getRemitance(),
                filterList.get(position).getInFdr(),
                filterList.get(position).getfExpense(),
                filterList.get(position).getEmiOther(),
                filterList.get(position).getsValue(),
                filterList.get(position).getLoanReq(),
                filterList.get(position).getLoanTerm(),
                filterList.get(position).getPiRate(),
                filterList.get(position).getProspectFee());
        ActivityUtils.invokProspectRbmViewStage(this,myNewLead);
    }

    private void logout() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(SupervisorRbmProspect.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(SupervisorRbmProspect.this);
        }
        builder.setTitle(getString(R.string.logout_title));
        builder.setMessage(getString(R.string.logout_message));
        builder.setIcon(R.drawable.logout_icon);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            startActivity(new Intent(SupervisorRbmProspect.this, LoginActivity.class));
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, "");
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public SharedPreferencesEnum localCash() {
        return SharedPreferencesEnum.getInstance(getActivity());
    }

    public Activity getActivity() {
        return this;
    }



}
