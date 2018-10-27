package net.maxproit.salesforce.feature.salesOfficer.newlead;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityNewleadBinding;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.mylead.updateLead.OldLead;
import net.maxproit.salesforce.model.newlead.Address;
import net.maxproit.salesforce.model.newlead.BasicInfo;
import net.maxproit.salesforce.model.newlead.IndustryInfo;
import net.maxproit.salesforce.model.newlead.NewLead;
import net.maxproit.salesforce.model.newlead.VisitRecord;
import net.maxproit.salesforce.model.uploads.file.FileUploadResponce;
import net.maxproit.salesforce.util.GoogleLandMark;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewLeadActivity extends BaseActivity  {
    public static final int SERCH_CODE = 500;
    public static final String LEAD_INDEX_ID = "LEAD_INDEX_ID";
    public static final String CIF_ID = "CIF_ID";
    private static final String TAG = "NewLeadActivity";
    String root = "";
    Bundle extras;
    OldLead oldLead;
    String leadId;
    LocalLogin localLogin;
    List<String> landmark = new ArrayList<>();
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */

    private NewLead newLead;
    private ActivityNewleadBinding binding;
    String documentPath;
    String documentPath2;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_newlead;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityNewleadBinding) getBinding();


        GoogleLandMark googleLandMark = new GoogleLandMark(this, list -> {
            landmark.add("Select LandMark");
            landmark.addAll(list);

        });
        googleLandMark.run();

        localCash().put(SharedPreferencesEnum.Key.SEARCH_TYPE, "Lead");



        localLogin = new LocalLogin(getApplicationContext());


        extras = getIntent().getExtras();
        root = extras.getString("ROOT");


        try {
            leadId = extras.getString("leadId");
        } catch (Exception e) {
            leadId = "";
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        String title = root.equals("update") ? "Update Lead" : "New Lead";

        getSupportActionBar().setTitle(title);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        binding.container.setAdapter(mSectionsPagerAdapter);
        binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);
        binding.tabs.setupWithViewPager(binding.container);


        binding.btnSubmit.setOnClickListener(view -> {

            if (isValidForm()) {

                createNewLead();
            }
        });
    }


    private void createNewLead() {


        NewLead led = getNewLead();
        led.setUserName(localCash().getString(SharedPreferencesEnum.Key.USER_NAME));

        if (leadId == null) {
            led.setLeadReferenceNo("");
        } else led.setLeadReferenceNo(leadId);

        Log.d(TAG, "createNewLead: " + toJson(led));

        showProgressDialog();
        getApiService().createNewLead(led).enqueue(new Callback<OldLead>() {
            @Override
            public void onResponse(Call<OldLead> call, Response<OldLead> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {

                    if (response.body().getCode().equals("200")) {

                        documentPath = localCash().getString(SharedPreferencesEnum.Key.LEADPDF1);
                        documentPath2 = localCash().getString(SharedPreferencesEnum.Key.LEADPDF2);


                        if (!documentPath.isEmpty()) {
                            String fileName = "Visiting Card_" + response.body().getData().getLeadReferenceNo() + "_292.pdf";
                            uploadDocument(documentPath, fileName, response.body().getData().getLeadReferenceNo());
                        } else if (!documentPath2.isEmpty()) {

                            String fileName = "Other Attachments_" + response.body().getData().getLeadReferenceNo() + "_772.pdf";
                            uploadDocument(documentPath2, fileName, response.body().getData().getLeadReferenceNo());
                            documentPath2 = "";

                        }else {
                            showToast(response.body().getMessage());
                            finish();
                        }





                    } else showAlertDialog("Error!", "" + response.body().getMessage());


                } else {
                    showAlertDialog("Error!", "" + response.message());
                }

            }

            @Override
            public void onFailure(Call<OldLead> call, Throwable t) {
                hideProgressDialog();
                showAlertDialog("Error!", "" + t.getMessage());

            }
        });

    }

    private void uploadDocument(String path, String fileName, String id) {

        try {


        //  File f= new File("/storage/emulated/0/PDFfilesIDLC_2018:07:06_15:15:27.pdf");
        File pdffile = new File(path);
        showProgressDialog("File Uploading...");


        getApiService().fileUpload(getFile(pdffile, "file", fileName)).enqueue(new Callback<FileUploadResponce>() {
            @Override
            public void onResponse(Call<FileUploadResponce> call, Response<FileUploadResponce> response) {
                hideProgressDialog();

                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {

                        showToast("File upload successfully");
                        Log.d(TAG, "Pdf Upload Responce: " + toJson(response.body()));
                        localCash().put(SharedPreferencesEnum.Key.LEADPDF1, "");

                        if (!documentPath2.isEmpty()) {
                            String fileName = "Other Attachments_" + id + "_772.pdf";
                            uploadDocument(documentPath, fileName, id);
                            documentPath2 = "";
                        } else finish();
                    } else showAlertDialog("Error", response.body().getMessage());

                } else {
                    showAlertDialog("Error", response.message());

                }

            }

            @Override
            public void onFailure(Call<FileUploadResponce> call, Throwable t) {
                showAlertDialog("Error", t.getMessage());
                hideProgressDialog();


            }
        });
        }catch (Exception e){

        }

    }

    @Override
    protected void getIntentData() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_lead_main, menu);

        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private boolean isValidForm() {
        // Total valaidation 12
        if (StringUtils.isEmpty(getNewLead().getBasicInfo().getRelationshipWithIDLC())) {
            showToast("Please Enter Relationship with IDLC");
            return false;
        } else if (StringUtils.isEmpty(getNewLead().getBasicInfo().getCustomerName())) {
            showToast("Please Enter Business Applicant’s Name");
            return false;
        } else if (StringUtils.isEmpty(getNewLead().getIndustryInfo().getProprietorName())) {
            showToast("Please Enter Owner Name");
            return false;
        } else if (StringUtils.isEmpty(getNewLead().getIndustryInfo().getProprietorMobileNumber())) {
            showToast("Please Enter Owner Mobile Number");
            return false;

        } else if (getNewLead().getIndustryInfo().getProprietorMobileNumber().length() != 11) {
            showToast("Please Enter Owner Valid Mobile Number");
            return false;



        } else if (getNewLead().getIndustryInfo().getYearlySales()==0) {
            showToast("Please Enter Yearly Sales");
            return false;
        } else if (getNewLead().getIndustryInfo().getInventory() == 0) {
            showToast("Please Enter Inventory/Stock");
            return false;
        } else if (getNewLead().getAddresses().size() != 0) {
            for (Address add : getNewLead().getAddresses()) {
                if (add.getAddressType().isEmpty()) {
                    showToast("Please Enter Address Type");
                    return false;
                } else if (add.getCity().isEmpty()) {
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
        } else if (getNewLead().getVisitRecords().size() != 0) {

            for (VisitRecord vr : getNewLead().getVisitRecords()) {
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

    public NewLead getNewLead() {
        if (newLead == null) {
            if (root.equals("new")) {
                NewLead lead = new NewLead();
                BasicInfo bf = new BasicInfo();
                bf.setBranchName(localLogin.getBranch());
                bf.setBoothName(localLogin.getBooth());
                bf.setSalesOfficerName(localLogin.getFullname());
                lead.setBasicInfo(bf);
                lead.setIndustryInfo(new IndustryInfo());
                return newLead = lead;
            } else if (root.equals("update")) {
                String data = extras.getString("DATA");

                oldLead = new GsonBuilder().serializeNulls().create().fromJson(data, OldLead.class);


                return newLead = oldLead.getNewLead();


            }
            return newLead = new NewLead();

        } else {
            return newLead;
        }
    }

    public void setEnrollment(NewLead newLead) {
        this.newLead = newLead;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String indexId = data.getStringExtra(LEAD_INDEX_ID);
            String cif = data.getStringExtra(CIF_ID);
            if (indexId!=null) {
                callApi(indexId,cif);
            }
            Log.d(TAG, "DOCUMENT 1 ->>> " + indexId);
            Log.d(TAG, "DOCUMENT 1 ->>> " + cif);


        }

        mSectionsPagerAdapter.getItem(4).onActivityResult(requestCode, resultCode, data);




    }

    private void callApi(String indexId,String cif) {
        showProgressDialog();
        String random = UUID.randomUUID().toString();
        getApiService().getLeadByLeadIndexId(indexId,random).enqueue(new Callback<OldLead>() {
            @Override
            public void onResponse(Call<OldLead> call, Response<OldLead> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        if (response.body() != null) {
                            newLead = response.body().getNewLead();
                            newLead.getBasicInfo().setBranchName(localLogin.getBranch());
                            newLead.getBasicInfo().setBoothName(localLogin.getBooth());
                            newLead.getBasicInfo().setSalesOfficerName(localLogin.getFullname());
                            newLead. getBasicInfo().setRelationshipWithIDLC("Existing");
                            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                            binding.container.setAdapter(mSectionsPagerAdapter);
                            binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);
                            binding.tabs.setupWithViewPager(binding.container);
                        }


                    } else  showAlertDialog("Error", response.body().getMessage());

                }else showAlertDialog("Error", response.message());
            }

            @Override
            public void onFailure(Call<OldLead> call, Throwable t) {
                hideProgressDialog();
               showAlertDialog("Error",t.getMessage());

            }
        });
    }

    @NonNull
    private MultipartBody.Part getFile(File file, String fild, String fileName) {

        if (file != null) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            return MultipartBody.Part.createFormData(fild, fileName, requestBody);
        }
        return null;

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        localCash().put(SharedPreferencesEnum.Key.LEADPDF1, "");
        localCash().put(SharedPreferencesEnum.Key.LEADPDF2, "");
    }
}