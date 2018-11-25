package net.maxproit.salesforce;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.local.CoApplicant;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

public class CoApplicantRbmView extends AppCompatActivity {

    private TextView tvCoapplicantUserName,  tvCoapplicantAge,tvCoapplicantDob, tvCoapplicantBirthDistrict, tvCoapplicantBirthCountry, tvCoapplicantValidPhotoId, tvCoapplicantPhotoIssudate,
            tvCoapplicantEtin, tvCoapplicantFatherName, tvCoapplicantMotherName, tvCoapplicantSpouseName, tvCoapplicantProfession, tvCoapplicantCompanyName,
            tvCoapplicantDesignation, tvCoapplicantCurrentJobYear, tvCoapplicantRelationshipWithApplicant, tvCoapplicantPermanentAddress, tvCoapplicantPresentAddress,
            tvCoapplicantMobileNumber, tvCoapplicantMonthlySalary, tvCoapplicantSalaryAmount, tvCoapplicantMonthlyBusinessIncome, tvCoapplicantAgricultureIncome,
            tvCoapplicantOtherIncome, tvCoapplicantRemittance, tvCoapplicantFdr, tvCoapplicantOtherEmi,tvCoaaplicantSempaka, tvCoapplicantOfficeIncome,
            tvCoapplicantBuildingIncome,tvCoapplicantWarehouseIncome, tvCoapplicantOk;

    private ImageView btnBack;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_applicant_rbm_view);

        tvCoapplicantUserName = (TextView) findViewById(R.id.tv_coapplicant_name);
        tvCoapplicantAge = (TextView) findViewById(R.id.tv_coapplicant_age);
        tvCoapplicantDob = (TextView) findViewById(R.id.tv_coapplicant_date_of_birth);
        tvCoapplicantBirthDistrict = (TextView) findViewById(R.id.tv_coapplicant_birth_district);
        tvCoapplicantBirthCountry = (TextView) findViewById(R.id.tv_coapplicant_birth_country);
        tvCoapplicantValidPhotoId = (TextView) findViewById(R.id.tv_coapplicant_photo_id_no);
        tvCoapplicantPhotoIssudate = (TextView) findViewById(R.id.tv_coapplicant_photo_issue_date);
        tvCoapplicantEtin = (TextView) findViewById(R.id.tv_coapplicant_etin);
        tvCoapplicantFatherName = (TextView) findViewById(R.id.tv_coapplicant_fathers_name);
        tvCoapplicantMotherName = (TextView) findViewById(R.id.tv_coapplicant_mother_name);
        tvCoapplicantSpouseName = (TextView) findViewById(R.id.tv_coapplicant_spouse_name);
        tvCoapplicantProfession = (TextView) findViewById(R.id.tv_coapplicant_profession);
        tvCoapplicantCompanyName = (TextView) findViewById(R.id.tv_coapplicant_company_name);
        tvCoapplicantDesignation = (TextView) findViewById(R.id.tv_coapplicant_designation);
        tvCoapplicantCurrentJobYear = (TextView) findViewById(R.id.tv_coapplicant_years_job);
        tvCoapplicantRelationshipWithApplicant = (TextView) findViewById(R.id.tv_coapplicant_relationship_applicant);
        tvCoapplicantPermanentAddress = (TextView) findViewById(R.id.tv_coapplicant_permanent_address);
        tvCoapplicantPresentAddress = (TextView) findViewById(R.id.tv_coapplicant_present_address);
        tvCoapplicantMobileNumber = (TextView) findViewById(R.id.tv_coapplicant_mobile_number);
        tvCoapplicantMonthlySalary = (TextView) findViewById(R.id.tv_coapplicant_net_salary);
        tvCoapplicantSalaryAmount = (TextView) findViewById(R.id.tv_coapplicant_salar_amount);
        tvCoapplicantMonthlyBusinessIncome = (TextView) findViewById(R.id.tv_coapplicant_business_income);
        tvCoapplicantAgricultureIncome = (TextView) findViewById(R.id.tv_coapplicant_agriculture_income);
        tvCoapplicantOtherIncome = (TextView) findViewById(R.id.tv_coapplicant_other_income);
        tvCoapplicantRemittance = (TextView) findViewById(R.id.tv_coapplicant_remittance);
        tvCoapplicantFdr = (TextView) findViewById(R.id.tv_coapplicant_fdr);
        tvCoapplicantOtherEmi = (TextView) findViewById(R.id.tv_coapplicant_other_emi);
        tvCoaaplicantSempaka = (TextView) findViewById(R.id.tv_coapplicant_semipaka_income);
        tvCoapplicantBuildingIncome = (TextView) findViewById(R.id.tv_coapplicant_multi_apartment_income);
        tvCoapplicantOfficeIncome = (TextView) findViewById(R.id.tv_coapplicant_office_commercial_space_income);
        tvCoapplicantWarehouseIncome = (TextView) findViewById(R.id.tv_coapplicant_warehouse_factory_income);

        btnBack = (ImageView) findViewById(R.id.btn_back);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        tvCoapplicantOk = (TextView) findViewById(R.id.tv_coapplicant_ok);

        initListner();
        setAllData();
    }

    private void setAllData() {
        tvCoapplicantUserName.setText(getDataFromApplicant().getName());
        tvCoapplicantDob.setText(getDataFromApplicant().getDateOfBirth());
        tvCoapplicantAge.setText(getDataFromApplicant().getAge());
        tvCoapplicantBirthDistrict.setText(getDataFromApplicant().getDistrictOfBirth());
        tvCoapplicantBirthCountry.setText(getDataFromApplicant().getCountryOfBirth());
        tvCoapplicantValidPhotoId.setText(getDataFromApplicant().getPhotoIdNo());
        tvCoapplicantPhotoIssudate.setText(getDataFromApplicant().getPhotoIdIssueDate());
        tvCoapplicantEtin.setText(getDataFromApplicant().geteTin());
        tvCoapplicantFatherName.setText(getDataFromApplicant().getfName());
        tvCoapplicantMotherName.setText(getDataFromApplicant().getmName());
        tvCoapplicantSpouseName.setText(getDataFromApplicant().getsName());
        tvCoapplicantProfession.setText(getDataFromApplicant().getProfession());
        tvCoapplicantCompanyName.setText(getDataFromApplicant().getCompanyName());
        tvCoapplicantDesignation.setText(getDataFromApplicant().getDesignation());
        tvCoapplicantCurrentJobYear.setText(getDataFromApplicant().getNoOfYrsInCurrentJob());
        tvCoapplicantRelationshipWithApplicant.setText(getDataFromApplicant().getPermanentAddress());
        tvCoapplicantPermanentAddress.setText(getDataFromApplicant().getRelationWithApplicant());
        tvCoapplicantPresentAddress.setText(getDataFromApplicant().getPresentAddress());
        tvCoapplicantMobileNumber.setText(getDataFromApplicant().getMobileNo());
        tvCoapplicantMonthlySalary.setText(getDataFromApplicant().getMonthSalaryType());
        tvCoapplicantSalaryAmount.setText(getDataFromApplicant().getMonthSalaryAmount());
        tvCoapplicantMonthlyBusinessIncome.setText(getDataFromApplicant().getMonthBusinessIncomeAmount());
        tvCoapplicantAgricultureIncome.setText(getDataFromApplicant().getMonthAgricultureIncomeAmount());
        tvCoapplicantOtherIncome.setText(getDataFromApplicant().getMonthTuitionIncomeAmount());
        tvCoapplicantRemittance.setText(getDataFromApplicant().getRemittance());
        tvCoapplicantFdr.setText(getDataFromApplicant().getInterestFDRIncomeAmount());
        tvCoapplicantOtherEmi.setText(getDataFromApplicant().getEmiOfOtherLoans());
        tvCoaaplicantSempaka.setText(getDataFromApplicant().getMonthSemipakaIncomeAmount());
        tvCoapplicantOfficeIncome.setText(getDataFromApplicant().getMonthOfficeSpaceIncomeAmount());
        tvCoapplicantBuildingIncome.setText(getDataFromApplicant().getMonthApartmentIncomeAmount());
        tvCoapplicantWarehouseIncome.setText(getDataFromApplicant().getMonthWareHouseAmount());
    }


    public CoApplicant getDataFromApplicant() {
        CoApplicant coApplicant = null;

        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            coApplicant = (CoApplicant) extraDetail.getSerializable(AppConstant.INTENT_KEY);

        }

        return coApplicant;
    }

    public void initListner(){
        tvCoapplicantOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(CoApplicantRbmView.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(CoApplicantRbmView.this);
        }
        builder.setTitle(getString(R.string.logout_title));
        builder.setMessage(getString(R.string.logout_message));
        builder.setIcon(R.drawable.logout_icon);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            startActivity(new Intent(CoApplicantRbmView.this, LoginActivity.class));
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, "");
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    public SharedPreferencesEnum localCash() {
        return SharedPreferencesEnum.getInstance(getActivity());
    }

    public Activity getActivity() {
        return this;
    }

}
