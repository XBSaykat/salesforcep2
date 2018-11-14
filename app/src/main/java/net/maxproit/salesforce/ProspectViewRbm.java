package net.maxproit.salesforce;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.feature.login.LoginActivity;
import net.maxproit.salesforce.masum.activity.prospect.co_applicant.CoApplicantActivity;
import net.maxproit.salesforce.masum.adapter.adapter.CoApplicantListAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.CarLoanDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.CarLoan;
import net.maxproit.salesforce.masum.model.CoApplicant;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DividerItemDecoration;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;

public class ProspectViewRbm extends AppCompatActivity {

    private TextView tvApproval, tvReject, tvReturn, tvProdecutCategory, tvProductDetail, tvBranchName, tvUserName, tvSegment, tvAge,
            tvBirthDistrict, tvBirthCountry, tvValidPhotoId, tvPhotoIssudate, tvEtin, tvFatherName, tvMotherName, tvSpouseName,
            tvProfession, tvCompanyName, tvDesignation, tvCurrentJobYear, tvRelationshipWithApplicant, tvPermanentAddress,
            tvPresentAddress, tvMobileNumber, tvMonthlySalary, tvSalaryAmount, tvMonthlyBusinessIncome, tvAgricultureIncome, tvOtherIncome, tvRemittance, tvFdr, tvFamilyExpenditure, tvEmi, tvSecurityValue,
            tvBrandName, tvManufacturingYear, tvManufacturingCountry, tvVehicleType, tvLoanRequired, tvLoanTerm, tvInteresterRate,
            tvFee, tvDateOfBorth, tvMultiApartmentIncome, tvSemipakaIncome, tvOfficeCommercialSpace, tvWarehouseFactoryIncome;
    private ImageView backButton;
    private Button btnCoapplicantsView, btnLogout;
    private ArrayList<CoApplicant> coApplicantList = new ArrayList<>();
    private ArrayList<CarLoan> carLoanList = new ArrayList<>();
    private ArrayList<CoApplicant> filteredList = new ArrayList<>();
    private CoApplicantDBController coApplicantDBController;
    private CarLoanDbController carLoanDbController;


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
        tvProfession = (TextView) findViewById(R.id.tv_profession);
        tvCompanyName = (TextView) findViewById(R.id.tv_company_name);
        tvDesignation = (TextView) findViewById(R.id.tv_designation);
        tvCurrentJobYear = (TextView) findViewById(R.id.tv_years_job);
        tvRelationshipWithApplicant = (TextView) findViewById(R.id.tv_relationship_applicant);
        tvPermanentAddress = (TextView) findViewById(R.id.tv_permanent_address);
        tvPresentAddress = (TextView) findViewById(R.id.tv_present_address);
        tvMobileNumber = (TextView) findViewById(R.id.tv_mobile_number);
        tvMonthlySalary = (TextView) findViewById(R.id.tv_net_salary);
        tvSalaryAmount = (TextView) findViewById(R.id.tv_salar_amount);
        tvMonthlyBusinessIncome = (TextView) findViewById(R.id.tv_business_income);
        tvAgricultureIncome = (TextView) findViewById(R.id.tv_agriculture_income);
        tvOtherIncome = (TextView) findViewById(R.id.tv_other_income);
        tvRemittance = (TextView) findViewById(R.id.tv_remittance);
        tvFdr = (TextView) findViewById(R.id.tv_fdr);
        tvFamilyExpenditure = (TextView) findViewById(R.id.tv_family_expenditure);
        tvEmi = (TextView) findViewById(R.id.tv_other_emi);
        tvSecurityValue = (TextView) findViewById(R.id.tv_security_value);
        tvBrandName = (TextView) findViewById(R.id.tv_brand_name);
        tvManufacturingYear = (TextView) findViewById(R.id.tv_manufacturing_year);
        tvManufacturingCountry = (TextView) findViewById(R.id.tv_manufacturing_country);
        tvVehicleType = (TextView) findViewById(R.id.tv_vehicle_type);
        tvLoanRequired = (TextView) findViewById(R.id.tv_loan_required);
        tvLoanTerm = (TextView) findViewById(R.id.tv_loan_term);
        tvInteresterRate = (TextView) findViewById(R.id.tv_proposed_interest_rate);
        tvFee = (TextView) findViewById(R.id.tv_fee);
        tvDateOfBorth = (TextView) findViewById(R.id.tv_date_of_birth);
        tvMultiApartmentIncome = (TextView) findViewById(R.id.tv_multi_apartment_income);
        tvSemipakaIncome = (TextView) findViewById(R.id.tv_semipaka_income);
        tvOfficeCommercialSpace = (TextView) findViewById(R.id.tv_office_commercial_space_income);
        tvWarehouseFactoryIncome = (TextView) findViewById(R.id.tv_warehouse_factory_income);
        btnCoapplicantsView = findViewById(R.id.btn_rbm_prospect_view_coaplicant);

        tvApproval = (TextView) findViewById(R.id.tv_approval);
        tvReject = (TextView) findViewById(R.id.tv_reject);
        tvReturn = (TextView) findViewById(R.id.tv_return);
        backButton = (ImageView) findViewById(R.id.btnBack);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        carLoanDbController=new CarLoanDbController(this);
        btnCoapplicantsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                followUpAlert();
            }
        });


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

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


        setAllData();

    }

    private ArrayList<CoApplicant> filteredList() {

        coApplicantDBController = new CoApplicantDBController(getApplicationContext());
        if (!coApplicantList.isEmpty()) {
            coApplicantList.clear();
        }


        coApplicantList.addAll(coApplicantDBController.getAllData(getDataFromProspect().getId()));

        return coApplicantList;
    }


    private void followUpAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = (View) inflater.inflate(R.layout.fragment_prospect_stage_co_applicent, null);
       LinearLayout liAddSection=dialogView.findViewById(R.id.li_add_co_applicant);
       LinearLayout liAddSectionTopSpace=dialogView.findViewById(R.id.li_add_co_applicant_top_space);
        liAddSection.setVisibility(View.GONE);
        liAddSectionTopSpace.setVisibility(View.GONE);


        builder.setView(dialogView);

        RecyclerView rv = (RecyclerView) dialogView.findViewById(R.id.rv_prospect_stage_co_applicant);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        CoApplicantListAdapter adapter = new CoApplicantListAdapter(this, filteredList());
        rv.setAdapter(adapter);

        adapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                sentDataToCoApplicant(position);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setTitle("Co applicant List");
        dialog.show();
    }
    /*
            ,
            tvRentalIncome, tvAgricultureIncome, tvOtherIncome, tvRemittance, tvFdr, tvFamilyExpenditure, tvEmi, tvSecurityValue,
            tvBrandName, tvManufacturingYear, tvManufacturingCountry, tvVehicleType, tvLoanRequired, tvLoanTerm, tvInteresterRate,
            tvFee;*/
    private void sentDataToCoApplicant(int position) {

        CoApplicant coApplicant=new CoApplicant(coApplicantList.get(position).getId(),
                coApplicantList.get(position).getLeadId(),
                coApplicantList.get(position).getName(),
                coApplicantList.get(position).getDateOfBirth(),
                coApplicantList.get(position).getAge(),
                coApplicantList.get(position).getDistrictOfBirth(),
                coApplicantList.get(position).getCountryOfBirth(),
                coApplicantList.get(position).getPhotoIdType(),
                coApplicantList.get(position).getPhotoIdNo(),
                coApplicantList.get(position).getPhotoIdIssueDate(),
                coApplicantList.get(position).geteTin(),
                coApplicantList.get(position).getfName(),
                coApplicantList.get(position).getmName(),
                coApplicantList.get(position).getsName(),
                coApplicantList.get(position).getProfession(),
                coApplicantList.get(position).getExList(),
                coApplicantList.get(position).getCompanyName(),
                coApplicantList.get(position).getDesignation(),
                coApplicantList.get(position).getNoOfYrsInCurrentJob(),
                coApplicantList.get(position).getRelationWithApplicant(),
                coApplicantList.get(position).getPermanentAddress(),
                coApplicantList.get(position).getPresentAddress(),
                coApplicantList.get(position).getMobileNo(),
                coApplicantList.get(position).getMonthSalaryType(),
                coApplicantList.get(position).getMonthSalaryAmount(),
                coApplicantList.get(position).getMonthBusinessIncomeAmount(),
                coApplicantList.get(position).getMonthWareHouseAmount(),
                coApplicantList.get(position).getMonthOfficeSpaceIncomeAmount(),
                coApplicantList.get(position).getMonthSemipakaIncomeAmount(),
                coApplicantList.get(position).getMonthApartmentIncomeAmount(),
                coApplicantList.get(position).getMonthAgricultureIncomeAmount(),
                coApplicantList.get(position).getMonthTuitionIncomeAmount(),
                coApplicantList.get(position).getRemittance(),
                coApplicantList.get(position).getInterestFDRIncomeAmount(),
                coApplicantList.get(position).getMonthFamilyExpenditure(),
                coApplicantList.get(position).getEmiOfOtherLoans()
        );

        ActivityUtils.invokCoApplicantViewStage(ProspectViewRbm.this,CoApplicantRbmView.class,coApplicant);

    }

    private void setAllData() {
        tvBranchName.setText(getDataFromProspect().getBranchName());
        tvProdecutCategory.setText(getDataFromProspect().getProductType());
        tvProductDetail.setText(getDataFromProspect().getProductSubcategory());
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
        tvDateOfBorth.setText(getDataFromProspect().getDateOfBirth());

        tvMonthlySalary.setText(getDataFromProspect().getNetSalary());
        tvSalaryAmount.setText(getDataFromProspect().getSalaryAmount());
        tvMonthlyBusinessIncome.setText(getDataFromProspect().getBusinessIncomeAmount());
        tvSemipakaIncome.setText(getDataFromProspect().getSemipakaIncome());
        tvMultiApartmentIncome.setText(getDataFromProspect().getApartmentAmount());
        tvOfficeCommercialSpace.setText(getDataFromProspect().getOfficeSpaceINcome());
        tvWarehouseFactoryIncome.setText(getDataFromProspect().getWireHouseINcome());
        tvAgricultureIncome.setText(getDataFromProspect().getAg_Income());
        tvOtherIncome.setText(getDataFromProspect().getEmiOther());
        tvRemittance.setText(getDataFromProspect().getRemitance());
        tvFdr.setText(getDataFromProspect().getInFdr());
        tvFamilyExpenditure.setText(getDataFromProspect().getfExpense());
        tvEmi.setText(getDataFromProspect().getEmiOther());
        tvSecurityValue.setText(getDataFromProspect().getsValue());
        tvLoanRequired.setText(getDataFromProspect().getLoanReq());
        tvLoanTerm.setText(getDataFromProspect().getLoanTerm());
        tvInteresterRate.setText(getDataFromProspect().getOrInterest());
        tvFee.setText(getDataFromProspect().getProspectFee());
        tvVehicleType.setText(carLoanList.get(0).getVehicleType());
        tvManufacturingCountry.setText(carLoanList.get(0).getMenuCountry());
        tvManufacturingYear.setText(carLoanList.get(0).getMenuYear());
        tvBrandName.setText(carLoanList.get(0).getBrandName());
    }


    public MyNewProspect getDataFromProspect() {
        MyNewProspect propect = null;
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            propect = (MyNewProspect) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            if (!carLoanList.isEmpty()){
                carLoanList.clear();
            }

            carLoanList.addAll(carLoanDbController.getData(String.valueOf(propect.getId())));
        }

        return propect;
    }

    private void logout() {
        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(ProspectViewRbm.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(ProspectViewRbm.this);
        }
        builder.setTitle(getString(R.string.logout_title));
        builder.setMessage(getString(R.string.logout_message));
        builder.setIcon(R.drawable.logout_icon);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            startActivity(new Intent(ProspectViewRbm.this, LoginActivity.class));
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
