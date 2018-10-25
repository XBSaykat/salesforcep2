package net.maxproit.salesforce.feature.salesOfficer.newProspect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityNewprospectBinding;
import net.maxproit.salesforce.feature.virifier.VerifierActivity;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce.model.newlead.VisitRecord;
import net.maxproit.salesforce.model.newprospect.Address;
import net.maxproit.salesforce.model.newprospect.NewProspect;
import net.maxproit.salesforce.util.GoogleLandMark;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewProspectActivity extends BaseActivity{
    private static final String TAG = "NewProspectActivity";


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ActivityNewprospectBinding binding;
    private NewProspect newProspect;
    String root;
    Bundle extras;
    OleProspect oleProspect;
    String data;
    String userName;
    LocalLogin localLogin;
    private boolean isApproval = false;
    public static final String VERRIFIER = "verrifier";
    List<String> landmark = new ArrayList<>();
    String roll;
    boolean active =true;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_newprospect;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityNewprospectBinding) getBinding();
        userName = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        localLogin = new LocalLogin(getApplicationContext());
        localCash().put(SharedPreferencesEnum.Key.SEARCH_TYPE, "prospect");
        roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);

        if (roll.equals("2")) {
            supervisorView();
        }

        GoogleLandMark googleLandMark = new GoogleLandMark(this, list -> {
            landmark.addAll(list);

        });
        googleLandMark.run();


        extras = getIntent().getExtras();
        root = extras.getString("ROOT");
        data = extras.getString("DATA");

        oleProspect = new GsonBuilder().serializeNulls().create().fromJson(data, OleProspect.class);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String title;
        if (root.equals("C")) {
            title = "Prospect Rezect";
        } else if (root.equals("Y")) {
            title = "Prospect proceed";

        } else title = "New Prospect";

        getSupportActionBar().setTitle(title);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        binding.container.setAdapter(mSectionsPagerAdapter);
        binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);

        // mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //   tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        binding.tabs.setupWithViewPager(binding.container);
        binding.btnSubmit.setOnClickListener(view -> {

                    if (!root.equals(VERRIFIER)) {
                        createNewLead();
//                        if (isValidForm()) {
//                            createNewLead();
//                        }
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("DATA", data);
                        startActivity(VerifierActivity.class, true, bundle);
                    }


                }
        );

    }

    private void supervisorView() {
        active =false;
        binding.btnSubmit.setVisibility(View.GONE);
        binding.layoutApproval.setVisibility(View.VISIBLE);

    }

    public boolean isApproval() {
        return isApproval;
    }


    private void createNewLead() {
        NewProspect prospect = getNewProspect();
        prospect.getLoanInfo().setInstalmentAmount("1000");
        prospect.setProspectReferenceNo(oleProspect.getData().getProspectReferenceNo());
        prospect.setMakerName(userName);
        prospect.setSupervisorCode(localLogin.getLocalogin().getData().getSTMCode());

        Log.d(TAG, "createNewLead: "+toJson(prospect));

        showProgressDialog();
        getApiService().myProspect(prospect).enqueue(new Callback<OleProspect>() {
            @Override
            public void onResponse(Call<OleProspect> call, Response<OleProspect> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        showToast("Success fully saved");
                        finish();
                    }else showAlertDialog("Error", response.body().getMessage());



                } else {
                    showAlertDialog("Error", response.message());
                }
            }

            @Override
            public void onFailure(Call<OleProspect> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error", t.getMessage());

            }
        });
    }


    @Override
    protected void getIntentData() {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private boolean isValidForm() {
        // Total valaidation 41
        if (getNewProspect().getGeneralInfo().getTradeLicenseNumber().isEmpty()) {
            showToast("Please Enter Trade License Number");
            return false;
        } else if (getNewProspect().getGeneralInfo().getLicenseIssuedate().isEmpty()) {
            showToast("Please Enter License Issue Date");
            return false;
        } else if (getNewProspect().getGeneralInfo().getLicenseExpiredate().isEmpty()) {
            showToast("Please Enter License Expiry Date");
            return false;
        } else if (getNewProspect().getGeneralInfo().getBusinessSince().isEmpty()) {
            showToast("Please Enter Business Since");
            return false;
        } else if (getNewProspect().getLoanInfo().getLoanAmount().equals("0")) {
            showToast("Please Enter Proposed Loan Amount");
            return false;
        } else if (Integer.parseInt(getNewProspect().getLoanInfo().getLoanAmount()) >= 500000) {
            showToast("Please Enter Tin Number, Loan Amount is greater than 5 Lac");
            return false;
        } else if (Integer.parseInt(getNewProspect().getLoanInfo().getLoanAmount()) >= 1500000) {
            showToast("Loan amount can't greater than 15 Lac");
            return false;
        } else if (getNewProspect().getLoanInfo().getTemInMonths().equals("0")) {
            showToast("Please Enter Term in Months");
            return false;
        } else if (Integer.parseInt(getNewProspect().getLoanInfo().getTemInMonths()) > 24) {
            showToast("Please Enter Term in Months can't gather then 24 month");
            return false;
//        } else if (getNewProspect().getLoanInfo().getInterestrate().equals("0")) {
//            showToast("Please Enter Interest Rate");
//            return false;
        } else if (getNewProspect().getLoanInfo().getInstalmentAmount().equals("0")) {
            showToast("Please Enter Instalment Amount");
            return false;
//        } else if (getNewProspect().getLoanInfo().getPurposeOfFinancing().isEmpty()) {
//            showToast("Please Enter Purpose of Financing");
//            return false;
        } else if (getNewProspect().getLoanInfo().getProductCategory().isEmpty()) {
            showToast("Please Enter Product Category");
            return false;
        } else if (getNewProspect().getGuarantorsInfo() == null) {
            showToast("Please Enter Guarantor’s Info");
            return false;
        } else if (getNewProspect().getProspectAddresses().size() != 0) {
            for (Address add : getNewProspect().getProspectAddresses()) {
                if (add.getAddressType().isEmpty()) {
                    showToast("Please Enter Address Type");
                    return false;
                } else if (add.getCity() != null) {
                    showToast("Please Enter District");
                    return false;
                }
                /*else if (add.getUpazila().isEmpty()) {
                    showToast("Please Enter Thana/Upazilla");
                    return false;
                }*/
                else if (add.getPremiseOwnershipStatus().isEmpty()) {
                    showToast("Please Enter Ownership");
                    return false;
                }


            }
        } else if (getNewProspect().getVisitRecords().size() != 0) {

            for (VisitRecord vr : getNewProspect().getVisitRecords()) {
                if (vr.getMeetingDate().isEmpty()) {
                    showToast("Please Enter Meeting Date");
                    return false;
                } else if (vr.getFollowupDate().isEmpty()) {
                    showToast("Please Enter Follow Up date");
                    return false;
                } else if (vr.getVisitPurpose().isEmpty()) {
                    showToast("Please Enter Visit Purpose");
                    return false;
                }
            }


        }
        return true;
    }


    public NewProspect getNewProspect() {
        if (newProspect == null) {


            Log.d(TAG, "Get Prospect: "+toJson(oleProspect.getNewProspect()));
            return newProspect = oleProspect.getNewProspect();
            // return newProspect = new GsonBuilder().serializeNulls().create().fromJson(date,NewProspect.class);
        } else {
            return newProspect;
        }
    }

    public void setEnrollment(NewProspect newProspect) {
        this.newProspect = newProspect;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);

        }


    }


}
