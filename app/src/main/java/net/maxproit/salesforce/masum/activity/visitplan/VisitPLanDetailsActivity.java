package net.maxproit.salesforce.masum.activity.visitplan;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.activity.lead.LeadStageActivity;
import net.maxproit.salesforce.masum.adapter.FollowUpActivityAdapter;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.FollowUpDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.FollowUpActivity;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DividerItemDecoration;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.Calendar;

import static net.maxproit.salesforce.util.MyApplication.getContext;

public class VisitPLanDetailsActivity extends AppCompatActivity {

    public EditText tvClientType, tvVisitPurpose, tvClientName, tvMobileNumber, tvProductType, tvCity, tvPoliceStation,
            tvVisitDate, tvRemarks, etNewRemark, etNewFollowUpdate;
    private AwesomeSpinner spinnerClientType;
    private SpinnerDbController spinnerDbController;
    private TextView tvProceedToLead, tvRejected, tvSave;
    Intent myActivityItemIntent;
    int itemPosition;
    private ArrayList<String> listClientType;
    private LinearLayout mlayout, mLayoutCLientTypeField;
    private Button btnFollowUp;
    private ImageView backButton;
    private ArrayList<FollowUpActivity> followUpList;

    private ArrayList<VisitPlan> visitPlanArrayList, visitPlanFilterList;
    private VisitPlanDbController visitPlanDbController;
    private FollowUpDbController followUpDbController;
    private VisitPlan visitPlanModel = null;
    String clientType = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
        initView();

        initListener();


    }

    private void initVariable() {
        visitPlanDbController = new VisitPlanDbController(this);
        spinnerDbController = new SpinnerDbController(this);
        followUpDbController = new FollowUpDbController(getContext());
        listClientType = new ArrayList<String>();
        followUpList = new ArrayList<>();
        if (!listClientType.isEmpty()) {
            listClientType.clear();
        }

        if (!followUpList.isEmpty()) {
            followUpList.clear();
        }
        listClientType.addAll(spinnerDbController.getClientTypeData());
        followUpList.addAll(followUpDbController.getAllData());

    }

    private void setAllData(VisitPlan visitPlanModel) {
        tvClientName.setText(visitPlanModel.getClientName());
        tvClientType.setText(visitPlanModel.getClientType());
        tvVisitPurpose.setText(visitPlanModel.getPurposeOfVisit());
        tvMobileNumber.setText(visitPlanModel.getMobileNumber());
        tvProductType.setText(visitPlanModel.getProductType());
        tvCity.setText(visitPlanModel.getCity());
        tvPoliceStation.setText(visitPlanModel.getPoliceStation());
        tvVisitDate.setText(visitPlanModel.getDateOfVisit());
        tvRemarks.setText(visitPlanModel.getRemarks());
        if (!visitPlanModel.getMobileNumber().equals("")) {
            tvMobileNumber.setEnabled(false);
        }

      /*  if (!visitPlanModel.getProductType().equals("")){
            tvProductType.setEnabled(false);
        }*/

        tvClientType.setEnabled(false);
        tvClientName.setEnabled(false);
        tvVisitPurpose.setEnabled(false);
        tvCity.setEnabled(false);
        tvRemarks.setEnabled(false);
        tvVisitDate.setEnabled(false);
        tvPoliceStation.setEnabled(false);


    }

    private void initView() {
        setContentView(R.layout.activity_activity_details);
//        tvClientType = (TextView)findViewById(R.id.tv_activity_details_client_type);
        tvVisitPurpose = findViewById(R.id.tv_activity_details_visit_Purpose);
        tvClientType = findViewById(R.id.tv_activity_details_client_type);
        mLayoutCLientTypeField = findViewById(R.id.activity_details_client_type);
        tvClientName = findViewById(R.id.tv_activity_details_client_name);
        tvMobileNumber = findViewById(R.id.tv_activity_details_mobile_no);
        tvProductType = findViewById(R.id.tv_activity_details_product_type);
        tvCity = findViewById(R.id.tv_activity_details_city);
        tvPoliceStation = findViewById(R.id.tv_activity_details_police_station);
        tvVisitDate = findViewById(R.id.tv_activity_details_visit_date);
        tvRemarks = findViewById(R.id.tv_activity_details_remarks);
        tvProceedToLead = findViewById(R.id.tv_activity_details_proceed_to_lead);
        tvRejected = findViewById(R.id.tv_activity_details_rejected);
        tvSave = findViewById(R.id.tv_activity_details_save);
        spinnerClientType = findViewById(R.id.awe_spinner_visit_plan_client_type);
        mlayout = findViewById(R.id.secClientType);
        etNewFollowUpdate = findViewById(R.id.et_new_follow_up_date);
        etNewRemark = findViewById(R.id.et_new_remark);
        btnFollowUp = findViewById(R.id.btn_show_followUp_history);
        ArrayAdapter<String> adptrClientType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listClientType);
        spinnerClientType.setAdapter(adptrClientType);

        backButton = (ImageView) findViewById(R.id.btn_back);
        getDataFromVisitPlan();


    }

    private void initListener() {
        spinnerClientType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

            }
        });


        tvProceedToLead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processToLeadDetails();
            }
        });


        tvRejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rejected", Toast.LENGTH_SHORT).show();
                alertDialog();
            }
        });

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpdatedData();

            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        tvVisitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog(tvVisitDate);
            }
        });


        etNewFollowUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog(etNewFollowUpdate);
            }
        });

        btnFollowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                followUpAlert();
            }
        });


    }


    private void alertDialog() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(VisitPLanDetailsActivity.this);
        }
        builder.setTitle(getString(R.string.remove));
        builder.setMessage(getString(R.string.reject_item));
        builder.setIcon(R.drawable.ic_reject);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            visitPlanDbController.deleteItem(visitPlanModel.getId());
            startActivity(new Intent(VisitPLanDetailsActivity.this, MyActivitiesActivity.class));
            finish();
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setUpdatedData() {
        if (visitPlanModel != null) {
            if (!TextUtils.isEmpty(etNewFollowUpdate.getText()) &&
                    !TextUtils.isEmpty(etNewRemark.getText())) {

                int update = visitPlanDbController.updateData(getPLanDataModel(visitPlanModel.getId(),
                        visitPlanModel.getClientName(),
                        visitPlanModel.getClientType(),
                        tvMobileNumber.getText().toString(),
                        visitPlanModel.getPoliceStation(),
                        visitPlanModel.getProductType(),
                        visitPlanModel.getCity(),
                        visitPlanModel.getPurposeOfVisit(),
                        etNewFollowUpdate.getText().toString(),
                        etNewRemark.getText().toString(),
                        visitPlanModel.getStatus()));
                if (update > 0) {
                    Toast.makeText(VisitPLanDetailsActivity.this, "update data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VisitPLanDetailsActivity.this, "failed update", Toast.LENGTH_SHORT).show();

                }
                int insert = followUpDbController.insertData(visitPlanModel.getId(),
                        etNewFollowUpdate.getText().toString(), etNewRemark.getText().toString());
                if (insert > 0) {
                    Toast.makeText(this, "inserted follow", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "failed follow", Toast.LENGTH_SHORT).show();
                }
            } else {

                int update = visitPlanDbController.updateData(getPLanDataModel(visitPlanModel.getId(),
                        visitPlanModel.getClientName(),
                        visitPlanModel.getClientType(),
                        tvMobileNumber.getText().toString(),
                        visitPlanModel.getPoliceStation(),
                        visitPlanModel.getProductType(),
                        visitPlanModel.getCity(),
                        visitPlanModel.getPurposeOfVisit(),
                        visitPlanModel.getDateOfVisit(),
                        visitPlanModel.getRemarks(),
                        visitPlanModel.getStatus()));
                if (update > 0) {

                    Toast.makeText(VisitPLanDetailsActivity.this, "update without follow", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VisitPLanDetailsActivity.this, "failed  without follow", Toast.LENGTH_SHORT).show();

                }
            }

        } else {

            int insert = visitPlanDbController.insertData(tvClientName.getText().toString(), clientType,
                    tvMobileNumber.getText().toString(), tvProductType.getText().toString(),
                    tvCity.getText().toString(), tvPoliceStation.getText().toString(), tvVisitPurpose.getText().toString(), tvVisitDate.getText().toString(),
                    tvRemarks.getText().toString(), AppConstant.STATUS_ACTIVITY);
            if (insert > 0) {
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
            }


        }
    }


    private void getDataFromVisitPlan() {

        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            mlayout.setVisibility(View.GONE);
            visitPlanModel = (VisitPlan) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            setAllData(visitPlanModel);

        } else {
            mLayoutCLientTypeField.setVisibility(View.GONE);
        }
    }


    private VisitPlan getPLanDataModel(int id, String clientName, String clientType,
                                       String phone, String station, String pType, String
                                               city, String pov, String dov, String re, String status) {
        VisitPlan visitPlan = new VisitPlan(id, clientName, clientType, phone,
                station, pType, city, pov, dov, re, status);
        return visitPlan;
    }


    public void datePickerDialog(EditText et) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth + "." + month + "." + year);
                et.getText().clear();
                et.setText(selectedDate);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                listener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.show();

    }


    private void followUpAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = (View) inflater.inflate(R.layout.follow_up_date, null);

        builder.setView(dialogView);

        RecyclerView rv = (RecyclerView) dialogView.findViewById(R.id.rv_followup);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        FollowUpActivityAdapter adapter = new FollowUpActivityAdapter(this, followUpList);
        rv.setAdapter(adapter);

        AlertDialog dialog = builder.create();

        dialog.show();
    }


    private void processToLeadDetails() {
        visitPlanDbController.updateVisitPlanDataStatus(visitPlanModel.getId(),
                AppConstant.VISITED);
        VisitPlan visitPlan = new VisitPlan(visitPlanModel.getId(),
                visitPlanModel.getClientName(),
                visitPlanModel.getClientType(),
                tvMobileNumber.getText().toString(),
                visitPlanModel.getPoliceStation(),
                visitPlanModel.getProductType(),
                visitPlanModel.getCity(),
                visitPlanModel.getPurposeOfVisit(),
                visitPlanModel.getDateOfVisit(),
                visitPlanModel.getRemarks(),
                visitPlanModel.getStatus());
        ActivityUtils.invokVisitPlanDetail(this, LeadStageActivity.class, visitPlan);
    }


}
