package net.maxproit.salesforce.feature.login;

import android.Manifest;
import android.text.TextUtils;
import android.util.Log;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityLoginBinding;
import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce.feature.dashboard.DashboardVirifierActivity;
import net.maxproit.salesforce.feature.dashboard.supervisor.MainDashboardSupervisorActivity;
import net.maxproit.salesforce.masum.appdata.preference.AppPreference;
import net.maxproit.salesforce.masum.appdata.preference.PrefKey;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.model.login.Login;
import net.maxproit.salesforce.model.login.LoginResponse;
import net.maxproit.salesforce.model.setting.GlobalSettings;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private static final String TAG = "LoginActivity";
    SpinnerDbController spinnerDbController;
    String clientType[] = null;
    String purposeOfVisit[] = null;
    String city[] = null;
    String dhakaNorthPoliceStation[] = null;
    String dhakaSouthPoliceStation[] = null;
    String narayanganjPoliceStation[] = null;
    String branch[] = null;
    String profession[] = null;
    String sourceOfReference[] = null;
    String productType[] = null;
    String productSubcategoryHomeLoan[] = null;
    String productSubcategoryCarLoan[] = null;
    String productSubcategoryPersonalLoan[] = null;
    String followUp[] = null;
    String remarks[] = null;
    String productCategory[] = null;
    String segment[] = null;
    String birthDistrict[] = null;
    String birthCountry[] = null;
    String relationshipWithApplicant[] = null;
    String monthlySalary[] = null;
    String monthlyRentalIncome[] = null;
    String brandName[] = null;
    String manufacturingYear[] = null;
    String manufacturingCountry[] = null;
    String vehicleType[] = null;
    String validPhoto[] = null;
    private MyLeadDbController myLeadDbController;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login;
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void initComponents() {
        binding = (ActivityLoginBinding) getBinding();
        binding.setModel(new Login());
        myLeadDbController = new MyLeadDbController(this);
        spinnerDbController = new SpinnerDbController(this);
        if (!AppPreference.getInstance(LoginActivity.this).getBoolean(PrefKey.IS_LOADED)) {
            AppPreference.getInstance(LoginActivity.this).setBoolean(PrefKey.IS_LOADED, true);
            setSpinnerData();
        }

        String st = localCash().getString(SharedPreferencesEnum.Key.SETTING);
        if (st.isEmpty()) {
            callSetting();

        } else {
            String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);
            if (!roll.isEmpty()) {
                gotoBoard(roll);
            }

        }




        binding.btnLogin.setOnClickListener(v -> {

                }
        );

        binding.btnLogin.setOnClickListener(view -> {

            if (TextUtils.isEmpty(binding.etUsername.getText())) {
                showToast("Ener your Username");

            } else if (TextUtils.isEmpty(binding.etPassword.getText())) {
                showToast("Ener your Password");

            } else {

                showProgressDialog();

                getApiService().login(binding.getModel()).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        hideProgressDialog();
                        if (response.isSuccessful()) {
                            LoginResponse lr = response.body();
                            Log.d(TAG, ">>>>>: " + lr.toString());

                            if (lr.getCode().equals("401")) {
                                showToast("Invalid UserId or Password");
                            } else {

                                gotoBoard(lr.getData().getUserTypeId());
                                String lg = toJson(response.body());
                                localCash().put(SharedPreferencesEnum.Key.LOCA_LLOGIN, lg);
                                localCash().put(SharedPreferencesEnum.Key.USER_NAME, binding.etUsername.getText().toString());


                            }


                        } else
                            showToast("Login Failed");
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        hideProgressDialog();
                        showToast("Login Failed");

                    }
                });


            }


        });


        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            // do you work now
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // permission is denied permenantly, navigate user to app settings
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .onSameThread()
                .check();
    }

    private void setSpinnerData() {
        clientType = getResources().getStringArray(R.array.client_types);
        if (spinnerDbController.getClientTypeData().size() == 0) {
            for (int i = 0; i < clientType.length; i++) {
                int insert = spinnerDbController.insertClientTypeData(clientType[i]);

            }
        }

        purposeOfVisit = getResources().getStringArray(R.array.purpose_of_visit);

        for (int i = 0; i < purposeOfVisit.length; i++) {
            int insert = spinnerDbController.insertPurposeOfVisitData(purposeOfVisit[i]);


        }

        city = getResources().getStringArray(R.array.city_array);

        for (int i = 0; i < city.length; i++) {
            int insert = spinnerDbController.insertCityData(city[i]);


        }

        dhakaNorthPoliceStation = getResources().getStringArray(R.array.dhaka_north_police_station_array);

        for (int i = 0; i < dhakaNorthPoliceStation.length; i++) {
            int insert = spinnerDbController.insertDhakaNorthData(dhakaNorthPoliceStation[i]);


        }

        dhakaSouthPoliceStation = getResources().getStringArray(R.array.dhaka_south_police_station_array);

        for (int i = 0; i < dhakaSouthPoliceStation.length; i++) {
            int insert = spinnerDbController.insertDhakaSouthData(dhakaSouthPoliceStation[i]);


        }

        narayanganjPoliceStation = getResources().getStringArray(R.array.narayanganj_police_station_array);

        for (int i = 0; i < narayanganjPoliceStation.length; i++) {
            int insert = spinnerDbController.insertNarayanganjData(narayanganjPoliceStation[i]);


        }

        branch = getResources().getStringArray(R.array.branch_name_array);

        for (int i = 0; i < branch.length; i++) {
            int insert = spinnerDbController.insertBranchData(branch[i]);


        }

        profession = getResources().getStringArray(R.array.profession_array);

        for (int i = 0; i < profession.length; i++) {
            int insert = spinnerDbController.insertProfessionData(profession[i]);


        }

        sourceOfReference = getResources().getStringArray(R.array.source_of_reference_array);

        for (int i = 0; i < sourceOfReference.length; i++) {
            int insert = spinnerDbController.insertSourceOfReferenceData(sourceOfReference[i]);


        }

        productType = getResources().getStringArray(R.array.product_categories_array);

        for (int i = 0; i < productType.length; i++) {
            int insert = spinnerDbController.insertProductTypeData(productType[i]);


        }

        productSubcategoryHomeLoan = getResources().getStringArray(R.array.hl_array);

        for (int i = 0; i < productSubcategoryHomeLoan.length; i++) {
            int insert = spinnerDbController.insertHomeLoanData(productSubcategoryHomeLoan[i]);


        }

        productSubcategoryCarLoan = getResources().getStringArray(R.array.cl_array);

        for (int i = 0; i < productSubcategoryCarLoan.length; i++) {
            int insert = spinnerDbController.insertCarLoanData(productSubcategoryCarLoan[i]);


        }

        productSubcategoryPersonalLoan = getResources().getStringArray(R.array.pl_array);

        for (int i = 0; i < productSubcategoryPersonalLoan.length; i++) {
            int insert = spinnerDbController.insertPersonalLoanData(productSubcategoryPersonalLoan[i]);


        }

        followUp = getResources().getStringArray(R.array.decision_array);

        for (int i = 0; i < followUp.length; i++) {
            int insert = spinnerDbController.insertFollowUpData(followUp[i]);


        }

        remarks = getResources().getStringArray(R.array.remarks_arr);

        for (int i = 0; i < remarks.length; i++) {
            int insert = spinnerDbController.insertRemarksData(remarks[i]);


        }

        productCategory = getResources().getStringArray(R.array.product_categories_array);

        for (int i = 0; i < productCategory.length; i++) {
            int insert = spinnerDbController.insertProductCategoryData(productCategory[i]);


        }

        segment = getResources().getStringArray(R.array.segment_array);

        for (int i = 0; i < segment.length; i++) {
            int insert = spinnerDbController.insertSegmentData(segment[i]);


        }

        birthDistrict = getResources().getStringArray(R.array.district_array);

        for (int i = 0; i < birthDistrict.length; i++) {
            int insert = spinnerDbController.insertBirthDistrictData(birthDistrict[i]);


        }

        birthCountry = getResources().getStringArray(R.array.countries);

        for (int i = 0; i < birthCountry.length; i++) {
            int insert = spinnerDbController.insertBirthCountryData(birthCountry[i]);


        }

        relationshipWithApplicant = getResources().getStringArray(R.array.relationship_array);

        for (int i = 0; i < relationshipWithApplicant.length; i++) {
            int insert = spinnerDbController.insertRelationshipWithApplicantData(relationshipWithApplicant[i]);


        }

        monthlySalary = getResources().getStringArray(R.array.monthly_net_salary_array);

        for (int i = 0; i < monthlySalary.length; i++) {
            int insert = spinnerDbController.insertMonthlySalarytData(monthlySalary[i]);


        }

        monthlyRentalIncome = getResources().getStringArray(R.array.monthly_rental_income);

        for (int i = 0; i < monthlyRentalIncome.length; i++) {
            int insert = spinnerDbController.insertMonthlyRentalIncometData(monthlyRentalIncome[i]);


        }

        brandName = getResources().getStringArray(R.array.car_brands);

        for (int i = 0; i < brandName.length; i++) {
            int insert = spinnerDbController.insertBrandNameData(brandName[i]);


        }

        manufacturingYear = getResources().getStringArray(R.array.years);

        for (int i = 0; i < manufacturingYear.length; i++) {
            int insert = spinnerDbController.insertManufacturingYearData(manufacturingYear[i]);


        }

        manufacturingCountry = getResources().getStringArray(R.array.countries);

        for (int i = 0; i < manufacturingYear.length; i++) {
            int insert = spinnerDbController.insertManufacturingCountryData(manufacturingCountry[i]);


        }

        vehicleType = getResources().getStringArray(R.array.vehicle_types);

        for (int i = 0; i < vehicleType.length; i++) {
            int insert = spinnerDbController.insertVehicleTypeData(vehicleType[i]);


        }

        validPhoto = getResources().getStringArray(R.array.valid_photo_id_list);

        for (int i = 0; i < validPhoto.length; i++) {
            int insert = spinnerDbController.insertValidPhotoData(validPhoto[i]);


        }
    }

    private void callSetting() {
        showProgressDialog();
        getApiService().getSetting().enqueue(new Callback<GlobalSettings>() {
            @Override
            public void onResponse(Call<GlobalSettings> call, Response<GlobalSettings> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    String setting = toJson(response.body());
                    localCash().put(SharedPreferencesEnum.Key.SETTING, setting);
                    showToast("Setting Data Success");

                } else
                    showToast("Setting Data Failed");

            }

            @Override
            public void onFailure(Call<GlobalSettings> call, Throwable t) {
                hideProgressDialog();
                showToast("Setting Data Failed");

            }
        });
    }

    private void gotoBoard(String uT) {

        if (uT.equals("1")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(DashboardSalesOfficerActivity.class, true);
            // startActivity(LocationTestActivity.class, true);


        } else if (uT.equals("2")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(MainDashboardSupervisorActivity.class, true);


        } else if (uT.equals("3")) {
            localCash().put(SharedPreferencesEnum.Key.ROLLUSER, uT);
            startActivity(DashboardVirifierActivity.class, true);


        }

    }



    @Override
    protected void getIntentData() {

    }


}
