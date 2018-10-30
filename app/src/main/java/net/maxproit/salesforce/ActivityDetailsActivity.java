package net.maxproit.salesforce;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import net.maxproit.salesforce.util.ActivityUtils;

import net.maxproit.salesforce.feature.masum.MyActivitiesActivityNew;
import net.maxproit.salesforce.model.VisitPlan;
import net.maxproit.salesforce.sqlite.VisitPlanDbController;

import java.util.ArrayList;

public class ActivityDetailsActivity extends AppCompatActivity {

    public TextView tvClientType, tvVisitPurpose, tvClientName, tvMobileNumber, tvProductType,tvCity,tvPoliceStation,
    tvVisitDate, tvRemarks, tvProceedToLead, tvRejected, tvReappointment;


    Intent myActivityItemIntent;
    int itemPosition;

    ImageView backButton;

    ArrayList<VisitPlan> visitPlanArrayList, visitPlanFilterList;
    VisitPlanDbController visitPlanDbController;
    VisitPlan visitPlanModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            initView();



    }

    private void initView() {

        setContentView(R.layout.activity_activity_details);
//        tvClientType = (TextView)findViewById(R.id.tv_activity_details_client_type);
        tvVisitPurpose = (TextView)findViewById(R.id.tv_activity_details_visit_Purpose);
        tvClientType  = (TextView)findViewById(R.id.tv_activity_details_client_type);
        tvClientName = (TextView)findViewById(R.id.tv_activity_details_client_name);
        tvMobileNumber = (TextView)findViewById(R.id.tv_activity_details_mobile_no);
        tvProductType = (TextView)findViewById(R.id.tv_activity_details_product_type);
        tvCity = (TextView)findViewById(R.id.tv_activity_details_city);
        tvPoliceStation = (TextView)findViewById(R.id.tv_activity_details_police_station);
        tvVisitDate = (TextView)findViewById(R.id.tv_activity_details_visit_date);
        tvRemarks = (TextView)findViewById(R.id.tv_activity_details_remarks);
        tvProceedToLead = (TextView)findViewById(R.id.tv_activity_details_proceed_to_lead);
        tvRejected = (TextView)findViewById(R.id.tv_activity_details_rejected);
        tvReappointment = (TextView)findViewById(R.id.tv_activity_details_reappointment);

        backButton = (ImageView) findViewById(R.id.btn_back);





        myActivityItemIntent = getIntent();
        itemPosition = myActivityItemIntent.getIntExtra(AppConstant.INTENT_KEY, -1);

        Toast.makeText(this, ""+itemPosition, Toast.LENGTH_SHORT).show();



        visitPlanDbController = new VisitPlanDbController(this);
        visitPlanArrayList = new ArrayList<>();
        visitPlanArrayList.addAll(visitPlanDbController.getAllData());
//        visitPlanModel = visitPlanArrayList.get(itemPosition);


        tvClientName.setText(visitPlanArrayList.get(itemPosition).getClientName());
        tvClientType.setText(visitPlanArrayList.get(itemPosition).getClientType());
        tvVisitPurpose.setText(visitPlanArrayList.get(itemPosition).getPurposeOfVisit());
        tvMobileNumber.setText(visitPlanArrayList.get(itemPosition).getMobileNumber());
        tvProductType.setText(visitPlanArrayList.get(itemPosition).getProductType());
        tvCity.setText(visitPlanArrayList.get(itemPosition).getCity());
        tvPoliceStation.setText(visitPlanArrayList.get(itemPosition).getPoliceStation());
        tvVisitDate.setText(visitPlanArrayList.get(itemPosition).getDateOfVisit());
        tvRemarks.setText(visitPlanArrayList.get(itemPosition).getRemarks());

        tvProceedToLead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent proceedToLeadIntent = new Intent(ActivityDetailsActivity.this, LeadStageActivity.class);
//                proceedToLeadIntent.putExtra(AppConstant.INTENT_KEY, itemPosition);
//                startActivity(proceedToLeadIntent);
//                finish();

                sentDataToDetail(itemPosition);
            }
        });


        tvRejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rejected", Toast.LENGTH_SHORT).show();
                visitPlanDbController.deleteItem(visitPlanArrayList.get(itemPosition).getId());
                AlertDialog dialog = new AlertDialog.Builder(getApplicationContext()).create();
                dialog.setTitle("Reject this Activity? ");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        visitPlanDbController.deleteItem(visitPlanArrayList.get(itemPosition).getId());
                        startActivity(new Intent(ActivityDetailsActivity.this, MyActivitiesActivityNew.class));
                        finish();
                    }
                });
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        tvReappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Reappointment", Toast.LENGTH_SHORT).show();



            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void sentDataToDetail(int position) {
        VisitPlan visitPlan=new VisitPlan(visitPlanArrayList.get(position).getId(),
                visitPlanArrayList.get(position).getClientType(),
                visitPlanArrayList.get(position).getPurposeOfVisit(),
                visitPlanArrayList.get(position).getClientName(),
                visitPlanArrayList.get(position).getMobileNumber(),
                visitPlanArrayList.get(position).getProductType(),
                visitPlanArrayList.get(position).getCity(),
                visitPlanArrayList.get(position).getPoliceStation(),
                visitPlanArrayList.get(position).getDateOfVisit(),
                visitPlanArrayList.get(position).getRemarks(),
                visitPlanArrayList.get(position).getStatus());
        ActivityUtils.invokVisitPlanDetailsCreateLead(this,visitPlan);
    }


}
