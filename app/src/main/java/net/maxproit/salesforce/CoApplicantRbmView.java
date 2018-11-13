package net.maxproit.salesforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.CoApplicant;

public class CoApplicantRbmView extends AppCompatActivity {

    TextView tvCoapplicantUserName,  tvCoapplicantAge,tvCoapplicantDob, tvCoapplicantBirthDistrict, tvCoapplicantBirthCountry, tvCoapplicantValidPhotoId, tvCoapplicantPhotoIssudate,
            tvCoapplicantEtin, tvCoapplicantFatherName, tvCoapplicantMotherName, tvCoapplicantSpouseName, tvCoapplicantProfession, tvCoapplicantCompanyName,
            tvCoapplicantDesignation, tvCoapplicantCurrentJobYear, tvCoapplicantRelationshipWithApplicant, tvCoapplicantPermanentAddress, tvCoapplicantPresentAddress,
            tvCoapplicantMobileNumber, tvCoapplicantMonthlySalary, tvCoapplicantSalaryAmount, tvCoapplicantMonthlyBusinessIncome, tvCoapplicantAgricultureIncome,
            tvCoapplicantOtherIncome, tvCoapplicantRemittance, tvCoapplicantFdr, tvCoapplicantOtherEmi, tvCoapplicantOk;

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
        tvCoapplicantOtherEmi = (TextView) findViewById(R.id.tv_coapplicant_other_emi);
        tvCoapplicantOk = (TextView) findViewById(R.id.tv_coapplicant_ok);

        setAllData();
    }

    private void setAllData() {
        tvCoapplicantUserName.setText(getDataFromApplicant().getName());
    }


    public CoApplicant getDataFromApplicant() {
        CoApplicant coApplicant = null;

        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            coApplicant = (CoApplicant) extraDetail.getSerializable(AppConstant.INTENT_KEY);

        }

        return coApplicant;
    }
}
