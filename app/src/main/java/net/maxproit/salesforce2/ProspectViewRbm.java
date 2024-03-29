package net.maxproit.salesforce2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.masum.activity.CibCifRequestActivity;
import net.maxproit.salesforce2.masum.activity.daviation.DaviationListActivity;
import net.maxproit.salesforce2.masum.adapter.adapter.CoApplicantListAdapter;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.appdata.sqlite.CarLoanDbController;
import net.maxproit.salesforce2.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce2.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce2.masum.listener.OnItemClickListener;
import net.maxproit.salesforce2.masum.model.api.approval.Approval;
import net.maxproit.salesforce2.masum.model.local.CarLoan;
import net.maxproit.salesforce2.masum.model.local.CoApplicant;
import net.maxproit.salesforce2.masum.model.local.MyNewProspect;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;
import net.maxproit.salesforce2.masum.utility.DateUtils;
import net.maxproit.salesforce2.masum.utility.DividerItemDecoration;
import net.maxproit.salesforce2.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce2.model.mylead.approvalresponce.ApprovalResponce;
import net.maxproit.salesforce2.model.myprospect.Data;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProspectViewRbm extends BaseActivity {

    private TextView tvApproval, tvReject, tvReturn, tvProdecutCategory, tvProductDetail, tvBranchName, tvUserName, tvSegment, tvAge,
            tvBirthDistrict, tvBirthCountry, tvValidPhotoId, tvPhotoIssudate, tvEtin, tvFatherName, tvMotherName, tvSpouseName,
            tvProfession, tvCompanyName, tvDesignation, tvCurrentJobYear, tvRelationshipWithApplicant, tvPermanentAddress,
            tvPresentAddress, tvMobileNumber, tvMonthlySalary, tvSalaryAmount, tvMonthlyBusinessIncome, tvAgricultureIncome, tvtution, tvRemittance, tvFdr, tvFamilyExpenditure, tvEmi, tvSecurityValue,
            tvBrandName, tvManufacturingYear, tvManufacturingCountry, tvVehicleType, tvLoanRequired, tvLoanTerm, tvInteresterRate,
            tvFee, tvDateOfBorth, tvMultiApartmentIncome, tvSemipakaIncome, tvCifInfo, tvRuleInfo, tvOfficeCommercialSpace, tvWarehouseFactoryIncome, tvTakeApproval;

    private LinearLayout liBrandName, liManufacturingYear, liManufacturingCountry, liVehicleType;

    private ImageView backButton;
    private Button btnCoapplicantsView, btnCifCibView, btnLogout;
    private ArrayList<CoApplicant> coApplicantList = new ArrayList<>();
    private ArrayList<CarLoan> carLoanList = new ArrayList<>();
    private ArrayList<CoApplicant> filteredList = new ArrayList<>();
    private CoApplicantDBController coApplicantDBController;
    private CarLoanDbController carLoanDbController;
    MyLeadDbController myLeadDbController;
    private Data prospectListData;
    private final String APPROVED = "Y";
    private final String RETURN_TO_RM = "R";
    private final String REJECT = "C";
    private final String ALERT_BUTTON_APPROVE = "APPROVE";
    private final String TITLE_ALERT_APPROVE = "Approve Prospect?";
    private final String MESSAGE_ALERT_APPROVE = "Do you want to approve this prospect?";
    private final String ALERT_BUTTON_REJECT = "REJECT";
    private final String TITLE_ALERT_REJECT = "Reject Prospect?";
    private final String MESSAGE_ALERT_REJECT = "Do you want to reject this prospect?";
    private final String ALERT_BUTTON_RETURN_TO_RBM = "RETURN";
    private final String TITLE_ALERT_RETURN_TO_RBM = "Return Prospect?";
    private final String MESSAGE_ALERT_RETURN_TO_RBM = "Do you want to return this prospect to RM?";
    private final String APPROVAL_TYPE_PROSPECT = "Prospect";
    public static String KEY_REFERRENCE_ID = "KEY_REFERRENCE_ID";


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_prospect_view_rbm;
    }

    @Override
    protected void initComponents() {
        myLeadDbController = new MyLeadDbController(this);
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
        tvtution = (TextView) findViewById(R.id.tv_other_income);
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
        btnCifCibView = findViewById(R.id.btn_rbm_prospect_cif_cib_request);

        liBrandName = (LinearLayout) findViewById(R.id.li_brand_name);
        liManufacturingYear = (LinearLayout) findViewById(R.id.li_maufacturing_year);
        liManufacturingCountry = (LinearLayout) findViewById(R.id.li_maufacturing_country);
        liVehicleType = (LinearLayout) findViewById(R.id.li_vehicle_type);
        tvCifInfo = findViewById(R.id.tv_cif_info);
        tvRuleInfo = findViewById(R.id.tv_rule_info);
        tvApproval = (TextView) findViewById(R.id.tv_approval);
        tvReject = (TextView) findViewById(R.id.tv_reject);
        tvReturn = (TextView) findViewById(R.id.tv_return);
        backButton = (ImageView) findViewById(R.id.btnBack);
        tvTakeApproval = (TextView) findViewById(R.id.tv_take_approval);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        carLoanDbController = new CarLoanDbController(this);
        btnCoapplicantsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                followUpAlert();
            }
        });

        btnCifCibView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProspectViewRbm.this, CibCifRequestActivity.class);
                intent.putExtra(KEY_REFERRENCE_ID, getDataFromProspect().getRefNumber());
                startActivity(intent);
            }
        });


        tvApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ProspectViewRbm.this, "Prospect is approved", Toast.LENGTH_SHORT).show();
                approvalConfirmationAlertDialog(TITLE_ALERT_APPROVE, MESSAGE_ALERT_APPROVE, APPROVED, ALERT_BUTTON_APPROVE);

            }
        });

        tvReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ProspectViewRbm.this, "Prospect is rejected", Toast.LENGTH_SHORT).show();
                approvalConfirmationAlertDialog(TITLE_ALERT_REJECT, MESSAGE_ALERT_REJECT, REJECT, ALERT_BUTTON_REJECT);

            }
        });

        tvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approvalConfirmationAlertDialog(TITLE_ALERT_RETURN_TO_RBM, MESSAGE_ALERT_RETURN_TO_RBM, RETURN_TO_RM, ALERT_BUTTON_RETURN_TO_RBM);
            }
        });

        tvTakeApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new android.app.AlertDialog.Builder(ProspectViewRbm.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                } else {
                    builder = new android.app.AlertDialog.Builder(ProspectViewRbm.this);
                }
                builder.setTitle("Take approval");
                builder.setMessage("Do you want to take approval?");
                builder.setIcon(R.drawable.lead);
                builder.setNegativeButton("No", null);
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    Intent intent = new Intent(ProspectViewRbm.this, DaviationListActivity.class);
                    intent.putExtra(KEY_REFERRENCE_ID, getDataFromProspect().getRefNumber());
                    startActivity(intent);
                });
                android.app.AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

     /*   btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
*/

        setAllData();

    }

    @Override
    protected void getIntentData() {

    }


    private ArrayList<CoApplicant> filteredList() {

        coApplicantDBController = new CoApplicantDBController(getApplicationContext());
        if (!coApplicantList.isEmpty()) {
            coApplicantList.clear();
        }

        if (getDataFromProspect().getCoApplicantList() != null) {
            coApplicantList.addAll(getDataFromProspect().getCoApplicantList());
        }

        return coApplicantList;
    }


    private void followUpAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = (View) inflater.inflate(R.layout.fragment_prospect_stage_co_applicent, null);
        LinearLayout liAddSection = dialogView.findViewById(R.id.li_add_co_applicant);
        LinearLayout liAddSectionTopSpace = dialogView.findViewById(R.id.li_add_co_applicant_top_space);
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
            tvRentalIncome, tvAgricultureIncome, tvtution, tvRemittance, tvFdr, tvFamilyExpenditure, tvEmi, tvSecurityValue,
            tvBrandName, tvManufacturingYear, tvManufacturingCountry, tvVehicleType, tvLoanRequired, tvLoanTerm, tvInteresterRate,
            tvFee;*/
    private void sentDataToCoApplicant(int position) {

        CoApplicant coApplicant = new CoApplicant(coApplicantList.get(position).getId(),
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
                coApplicantList.get(position).getExceptionList(),
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

        ActivityUtils.invokCoApplicantViewStage(ProspectViewRbm.this, CoApplicantRbmView.class, coApplicant, -1, null);

    }

    private void setAllData() {
        tvBranchName.setText(getDataFromProspect().getBranchName());
        tvProdecutCategory.setText(getDataFromProspect().getProductType());
        if (getDataFromProspect().getProductType().equals(AppConstant.CAR_LOAN)) {
            if (carLoanList.size() > 0) {
                if (carLoanList.get(0).getVehicleType() != null) {
                    liVehicleType.setVisibility(View.VISIBLE);
                    tvVehicleType.setText(carLoanList.get(0).getVehicleType());

                }
                if (carLoanList.get(0).getMenuCountry() != null) {
                    liManufacturingYear.setVisibility(View.VISIBLE);
                    tvManufacturingCountry.setText(carLoanList.get(0).getMenuCountry());
                }
                if (carLoanList.get(0).getMenuYear() != null) {
                    liManufacturingCountry.setVisibility(View.VISIBLE);
                    tvManufacturingYear.setText(carLoanList.get(0).getMenuYear());
                }
                if (carLoanList.get(0).getBrandName() != null) {
                    liBrandName.setVisibility(View.VISIBLE);
                    tvBrandName.setText(carLoanList.get(0).getBrandName());
                }
            }

        }


        tvProductDetail.setText(getDataFromProspect().getProductSubcategory());
        tvUserName.setText(getDataFromProspect().getUserName());
        tvSegment.setText(getDataFromProspect().getSegment());

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
        if (getDataFromProspect().getDateOfBirth() != null) {
            String dateob = DateUtils.getDateFormateEt(getDataFromProspect().getDateOfBirth());
            tvDateOfBorth.setText(dateob);

            long timeinMIlis = DateUtils.getDateStringtoTimeInMinlis(dateob);
            tvAge.setText(MasumCommonUtils.calcutateAge(timeinMIlis));
        }

//        tvAge.setText(getDataFromProspect().getAge());

        tvMonthlySalary.setText(getDataFromProspect().getNetSalary());
        tvSalaryAmount.setText(getDataFromProspect().getSalaryAmount());
        tvMonthlyBusinessIncome.setText(getDataFromProspect().getBusinessIncomeAmount());
        tvSemipakaIncome.setText(getDataFromProspect().getSemipakaIncome());
        tvMultiApartmentIncome.setText(getDataFromProspect().getApartmentAmount());
        tvOfficeCommercialSpace.setText(getDataFromProspect().getOfficeSpaceINcome());
        tvWarehouseFactoryIncome.setText(getDataFromProspect().getWireHouseINcome());
        tvAgricultureIncome.setText(getDataFromProspect().getAg_Income());
        tvtution.setText(getDataFromProspect().getTution());
        tvRemittance.setText(getDataFromProspect().getRemitance());
        tvFdr.setText(getDataFromProspect().getInFdr());
        tvFamilyExpenditure.setText(getDataFromProspect().getfExpense());
        tvEmi.setText(getDataFromProspect().getEmiOther());
        tvSecurityValue.setText(getDataFromProspect().getsValue());
        tvLoanRequired.setText(getDataFromProspect().getLoanReq());
        tvLoanTerm.setText(getDataFromProspect().getLoanTerm());
        tvInteresterRate.setText(getDataFromProspect().getOrInterest());
        tvFee.setText(getDataFromProspect().getProspectFee());
        tvRuleInfo.setText(getDataFromProspect().getRuleEngineInformation());
        tvCifInfo.setText(getDataFromProspect().getcIBInformation());
    }


    public MyNewProspect getDataFromProspect() {
        MyNewProspect prospect = null;

        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            prospect = (MyNewProspect) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            prospectListData = (Data) extraDetail.getSerializable(AppConstant.PROSPECT_RBM_LIST_DATA_INTENT_KEY);

            if (prospectListData == null) {

                tvApproval.setVisibility(View.GONE);
                tvReject.setVisibility(View.GONE);
                tvReturn.setVisibility(View.GONE);
                backButton.setVisibility(View.GONE);
                tvTakeApproval.setVisibility(View.GONE);
                btnCifCibView.setVisibility(View.GONE);

            }
            if (!carLoanList.isEmpty()) {
                carLoanList.clear();
            }

            carLoanList.addAll(carLoanDbController.getData(String.valueOf(prospect.getId())));
        }

        return prospect;
    }

/*    private void logout() {
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
    }*/

    public SharedPreferencesEnum localCash() {
        return SharedPreferencesEnum.getInstance(getActivity());
    }

    public Activity getActivity() {
        return this;
    }

    private void approveProspect(String status) {

        Approval approval = new Approval();
        approval.setApprovalType(APPROVAL_TYPE_PROSPECT);
        approval.setReferenceNo(getDataFromProspect().getRefNumber());
        approval.setApprovalSetID(Integer.valueOf(prospectListData.getApprovalSetID()));
        approval.setCurrentLevel(Integer.valueOf(prospectListData.getCurrentLevel()));
        approval.setStatus(status);
        approval.setRemark("");
        approval.setUser(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));
        approval.setBranch(getDataFromProspect().getBranchName());
        approval.setProductId(Integer.valueOf(getDataFromProspect().getProductCode()));

        if (isNetworkAvailable()) {
            getApiService().approve(approval).enqueue(new Callback<ApprovalResponce>() {
                @Override
                public void onResponse(Call<ApprovalResponce> call, Response<ApprovalResponce> response) {
                    if (response.isSuccessful()) {

                        if (response.body().getCode().equals("200")) {
                            startActivityshowAlertDialog("Message:", "" + response.body().getMessage(), SupervisorRbmProspect.class, true);
                        } else {
                            showAlertDialog("Message:", "" + response.body().getMessage());

                        }
                        if (approval.getStatus().equals(RETURN_TO_RM) && response.body().getCode().equals("200")) {
                            myLeadDbController.updateLeadDataStatus(getDataFromProspect().getId(), AppConstant.STATUS_RETURN_RBM);
                        }

//                        startActivity(new Intent(ProspectViewRbm.this, SupervisorRbmProspect.class));
//                        finish();
                    } else {
                        showAlertDialog("" + response.code(), "Message: " + response.message());

                    }
                }

                @Override
                public void onFailure(Call<ApprovalResponce> call, Throwable t) {
                    showAlertDialog("Error", "" + t.getMessage());
                }
            });
        } else {
            showAlertDialog("Network Error", "Network not available");
        }

    }

    public void approvalConfirmationAlertDialog(String title, String message, String status, String positiveButton) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        approveProspect(status);
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



}
