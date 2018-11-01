package net.maxproit.salesforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.sqlite.AppConstant;

public class ProspectViewRbm extends AppCompatActivity {

    TextView tvApproval, tvReject, tvReturn, tvProdecutCategory, tvProductDetail, tvBranchName, tvUserName,tvSegment, tvAge,
            tvBirthDistrict, tvBirthCountry, tvValidPhotoId, tvPhotoIssudate, tvEtin, tvFatherName, tvMotherName, tvSpouseName,
            tvProfession, tvCompanyName,tvDesignation, tvCurrentJobYear, tvRelationshipWithApplicant, tvPermanentAddress,
            tvPresentAddress, tvMobileNumber, tvMonthlySalary, tvSalaryAmount, tvMonthlyBusinessIncome, tvMonthlyRentalIncome,
            tvRentalIncome, tvAgricultureIncome, tvOtherIncome, tvRemittance, tvFdr, tvFamilyExpenditure, tvEmi, tvSecurityValue,
            tvBrandName, tvManufacturingYear, tvManufacturingCountry, tvVehicleType, tvLoanRequired, tvLoanTerm, tvInteresterRate,
            tvFee;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospect_view_rbm);

        tvProdecutCategory = (TextView) findViewById(R.id.tv_product_category);
        tvProductDetail = (TextView) findViewById(R.id.tv_product_detail);
        tvBranchName = (TextView) findViewById(R.id.tv_branch);
        tvUserName = (TextView) findViewById(R.id.tv_name);
        tvSegment = (TextView) findViewById(R.id.tv_segment);
        tvAge = (TextView) findViewById(R.id.tv_age);
        tvBirthDistrict = (TextView) findViewById(R.id.tv_birth_district);
        tvBirthCountry = (TextView) findViewById(R.id.tv_birth_country);
        tvValidPhotoId = (TextView) findViewById(R.id.tv_photo_id_no);
        tvPhotoIssudate = (TextView) findViewById(R.id.tv_photo_issue_date);
        tvEtin = (TextView) findViewById(R.id.tv_etin);
        tvFatherName = (TextView) findViewById(R.id.tv_fathers_name);
        tvMotherName = (TextView) findViewById(R.id.tv_mother_name);
        tvSpouseName = (TextView) findViewById(R.id.tv_spouse_name);
        tvProfession = (TextView)findViewById(R.id.tv_profession);
        tvCompanyName = (TextView)findViewById(R.id.tv_company_name);
        tvDesignation = (TextView)findViewById(R.id.tv_designation);
        tvCurrentJobYear = (TextView)findViewById(R.id.tv_years_job);
        tvRelationshipWithApplicant = (TextView)findViewById(R.id.tv_relationship_applicant);
        tvPermanentAddress = (TextView) findViewById(R.id.tv_permanent_address);
        tvPresentAddress = (TextView) findViewById(R.id.tv_present_address);
        tvMobileNumber = (TextView) findViewById(R.id.tv_mobile_number);
        tvMonthlySalary = (TextView) findViewById(R.id.tv_net_salary);
        tvSalaryAmount = (TextView) findViewById(R.id.tv_salar_amount);
        tvMonthlyBusinessIncome = (TextView) findViewById(R.id.tv_business_income);
        tvMonthlyRentalIncome = (TextView) findViewById(R.id.tv_rental_income);
        tvRentalIncome = (TextView) findViewById(R.id.tv_rental_income_amount);
        tvAgricultureIncome = (TextView)findViewById(R.id.tv_agriculture_income);
        tvOtherIncome = (TextView)findViewById(R.id.tv_other_income);
        tvRemittance = (TextView)findViewById(R.id.tv_remittance);
        tvFdr = (TextView)findViewById(R.id.tv_fdr);
        tvFamilyExpenditure = (TextView)findViewById(R.id.tv_family_expenditure);
        tvEmi = (TextView)findViewById(R.id.tv_other_emi);
        tvSecurityValue = (TextView)findViewById(R.id.tv_security_value);
        tvBrandName = (TextView)findViewById(R.id.tv_brand_name);
        tvManufacturingYear = (TextView)findViewById(R.id.tv_manufacturing_year);
        tvManufacturingCountry = (TextView)findViewById(R.id.tv_manufacturing_country);
        tvVehicleType = (TextView)findViewById(R.id.tv_vehicle_type);
        tvLoanRequired = (TextView)findViewById(R.id.tv_loan_required);
        tvLoanTerm = (TextView)findViewById(R.id.tv_loan_term);
        tvInteresterRate = (TextView)findViewById(R.id.tv_proposed_interest_rate);
        tvFee = (TextView)findViewById(R.id.tv_fee);

        tvApproval = (TextView)findViewById(R.id.tv_approval);
        tvReject = (TextView)findViewById(R.id.tv_reject);
        tvReturn = (TextView)findViewById(R.id.tv_return);
        backButton = (ImageView) findViewById(R.id.btnBack);

        tvApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProspectViewRbm.this, "Prospect is approved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        tvReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProspectViewRbm.this, "Prospect is rejected", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        tvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProspectViewRbm.this, "Return prospect", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        setAllData();

    }


    /*
            ,
            tvRentalIncome, tvAgricultureIncome, tvOtherIncome, tvRemittance, tvFdr, tvFamilyExpenditure, tvEmi, tvSecurityValue,
            tvBrandName, tvManufacturingYear, tvManufacturingCountry, tvVehicleType, tvLoanRequired, tvLoanTerm, tvInteresterRate,
            tvFee;*/

    private void setAllData() {
        tvBranchName.setText(getDataFromProspect().getBranchName());
        tvProdecutCategory.setText(getDataFromProspect().getProductType());
        tvProductDetail.setText(getDataFromProspect().getProductDetail());
        tvUserName.setText(getDataFromProspect().getUserName());
        tvSegment.setText(getDataFromProspect().getSegment());
        tvAge.setText(getDataFromProspect().getAge());
        tvBirthDistrict.setText(getDataFromProspect().getDob());
        tvBirthCountry.setText(getDataFromProspect().getCob());
        tvValidPhotoId.setText(getDataFromProspect().getpIdNumber());
        tvPhotoIssudate.setText(getDataFromProspect().getpIssueDate());
        tvEtin.setText(getDataFromProspect().getEtin());
        tvFatherName.setText(getDataFromProspect().getfName());
        tvMotherName.setText(getDataFromProspect().getmName());
        tvSpouseName.setText(getDataFromProspect().getsName());
        tvProfession.setText(getDataFromProspect().getProfession());
        tvCompanyName.setText(getDataFromProspect().getOrganization());
        tvDesignation.setText(getDataFromProspect().getDesignation());
        tvCurrentJobYear.setText(getDataFromProspect().getCurrentJob());
        tvRelationshipWithApplicant.setText(getDataFromProspect().getApplicant());
        tvPermanentAddress.setText(getDataFromProspect().getpAddress());
        tvPresentAddress.setText(getDataFromProspect().getAddress());
        tvMobileNumber.setText(getDataFromProspect().getPhone());
        tvMonthlySalary.setText(getDataFromProspect().getNetSalary());
        tvSalaryAmount.setText(getDataFromProspect().getSalaryAmount());
//        tvMonthlyBusinessIncome.setText(getDataFromProspect().);
        tvMonthlyRentalIncome.setText(getDataFromProspect().getRentIncome());
        tvRentalIncome.setText(getDataFromProspect().getRentIncomeAmount());
        tvAgricultureIncome.setText(getDataFromProspect().getAg_Income());
        tvOtherIncome.setText(getDataFromProspect().getEmiOther());
        tvRemittance.setText(getDataFromProspect().getRemitance());
        tvFdr.setText(getDataFromProspect().getInFdr());
        tvFamilyExpenditure.setText(getDataFromProspect().getfExpense());
        tvEmi.setText(getDataFromProspect().getMonthlyEmi());
        tvSecurityValue.setText(getDataFromProspect().getsValue());
        tvLoanRequired.setText(getDataFromProspect().getLoanReq());
        tvLoanTerm.setText(getDataFromProspect().getLoanTerm());
        tvInteresterRate.setText(getDataFromProspect().getOrInterest());
        tvFee.setText(getDataFromProspect().getFee());
//        tvVehicleType.setText(getDataFromProspect());
//        tvManufacturingCountry.setText(getDataFromProspect());
//        tvManufacturingYear.setText(getDataFromProspect());
//        tvBrandName.setText(getDataFromProspect());
    }


    public MyNewProspect getDataFromProspect() {
        MyNewProspect propect = null;
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            propect = (MyNewProspect) extraDetail.getSerializable(AppConstant.INTENT_KEY);
        }

        return propect;


    }
}
