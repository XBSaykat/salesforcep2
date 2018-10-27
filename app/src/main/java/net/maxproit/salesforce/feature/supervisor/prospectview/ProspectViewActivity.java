package net.maxproit.salesforce.feature.supervisor.prospectview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityProspectAddressViewBinding;
import net.maxproit.salesforce.databinding.ActivityProspectAssetViewBinding;
import net.maxproit.salesforce.databinding.ActivityProspectGurantorAddressViewBinding;
import net.maxproit.salesforce.databinding.ActivityProspectGurantorInfoViewBinding;
import net.maxproit.salesforce.databinding.ActivityProspectProInfoViewBinding;
import net.maxproit.salesforce.databinding.ActivityProspectViewBinding;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.mylead.MyLeadApproval;
import net.maxproit.salesforce.model.mylead.approvalresponce.ApprovalResponce;
import net.maxproit.salesforce.model.myprospect.updateProspect.Address;
import net.maxproit.salesforce.model.myprospect.updateProspect.GuarantorsInfo;
import net.maxproit.salesforce.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce.model.myprospect.updateProspect.PersonalAssets;
import net.maxproit.salesforce.model.myprospect.updateProspect.ProprietorsInfo;
import net.maxproit.salesforce.model.myprospect.updateProspect.ProspectAddress;
import net.maxproit.salesforce.network.RestClient;
import net.maxproit.salesforce.util.CommonUtil;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProspectViewActivity extends BaseActivity {
    public static final String APPROVED = "Y";
    public static final String REJECT = "C";
    public static final String TYPE = "Prospect";
    public static final String ApprovalSetID = "ApprovalSetID";
    public static final String CurrentLevel = "CurrentLevel";
    private static final String TAG = "ProspectViewActivity";
    public String USER_NAME;
    Bundle extras;
    LocalLogin localLogin;
    OleProspect oleProspect;
    String data;
    String approvalId;
    String currentLeavel;
    private ActivityProspectViewBinding binding;
    private LinearLayout parentLinearLayout;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_prospect_view;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityProspectViewBinding) getBinding();
        binding.btnBack.setOnClickListener(v -> finish());
        localLogin = new LocalLogin(this);
        parentLinearLayout = binding.parentLinearLayout;
        getIntentData();
        USER_NAME = localCash().getString(SharedPreferencesEnum.Key.USER_NAME);
        createView();


        String roll = localCash().getString(SharedPreferencesEnum.Key.ROLLUSER);

        if (!StringUtils.isEmpty(roll)) {
            if (roll.equals("1")) {
               binding.layoutButton.setVisibility(View.GONE);
            }
        }





        binding.Approval.setOnClickListener(v ->
                approv(oleProspect.getData().getProspectReferenceNo(),
                        Integer.parseInt(approvalId),
                        Integer.parseInt(currentLeavel)));

        binding.Reject.setOnClickListener(v ->
                reject(oleProspect.getData().getProspectReferenceNo(),
                        Integer.parseInt(approvalId),
                        Integer.parseInt(currentLeavel)));


    }

    private void createView() {

        createGurantorView(oleProspect.getData().getGuarantorsInfo());
        createproprietorsView(oleProspect.getData().getProprietorsInfo());
        createproprietorsAdressView(parentLinearLayout, oleProspect.getData().getProspectAddresses());


    }

    private void createproprietorsAdressView(LinearLayout layout, List<ProspectAddress> list) {

        for (int i = 0; i < list.size(); i++) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ActivityProspectGurantorAddressViewBinding gurantorInfoAddressdBinding = DataBindingUtil.inflate(
                    inflater, R.layout.activity_prospect_gurantor_address_view, null, false);

            gurantorInfoAddressdBinding.setModel(list.get(i));

            layout.addView(gurantorInfoAddressdBinding.getRoot(), layout.getChildCount() - 1);
        }

    }




    private void createproprietorsAssetView(LinearLayout layout, List<PersonalAssets>  list) {

        for (int i = 0; i < list.size(); i++) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ActivityProspectAssetViewBinding asset = DataBindingUtil.inflate(
                    inflater, R.layout.activity_prospect_asset_view, null, false);

            asset.setModel(list.get(i));

        }

    }


    private void createpAdressView(LinearLayout layout, List<Address> list) {

        for (int i = 0; i < list.size(); i++) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ActivityProspectAddressViewBinding add = DataBindingUtil.inflate(
                    inflater, R.layout.activity_prospect_address_view, null, false);

            add.setModel(list.get(i));

            layout.addView(add.getRoot(), layout.getChildCount() - 1);
        }

    }

    private void createGurantorView(List<GuarantorsInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ActivityProspectGurantorInfoViewBinding gurantorInfochildBinding = DataBindingUtil.inflate(
                    inflater, R.layout.activity_prospect_gurantor_info_view, null, false);

            gurantorInfochildBinding.setModel(list.get(i));



            createpAdressView(gurantorInfochildBinding.parentLinearLayout, list.get(i).getAddresses());

            parentLinearLayout
                    .addView(gurantorInfochildBinding.getRoot(), parentLinearLayout.getChildCount() - 1);
        }
    }

    private void createproprietorsView(List<ProprietorsInfo> list) {

        for (int i = 0; i < list.size(); i++) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ActivityProspectProInfoViewBinding ProspectProInfochildBinding = DataBindingUtil.inflate(
                    inflater, R.layout.activity_prospect_pro_info_view, null, false);

            ProspectProInfochildBinding.setModel(list.get(i));
            ProspectProInfochildBinding.title.setText("Owner's Info (" + (i + 1) + ")");


            createpAdressView(ProspectProInfochildBinding.parentLinearLayout, list.get(i).getAddresses());
            createproprietorsAssetView(ProspectProInfochildBinding.parentLinearLayout, list.get(i).getPersonalAssets());


            parentLinearLayout
                    .addView(ProspectProInfochildBinding.getRoot(), parentLinearLayout.getChildCount() - 1);
        }
    }


    @Override
    protected void getIntentData() {
        extras = getIntent().getExtras();
        data = extras.getString("DATA");
        approvalId = extras.getString(ApprovalSetID);
        currentLeavel = extras.getString(CurrentLevel);

        oleProspect = new GsonBuilder().serializeNulls().create().fromJson(data, OleProspect.class);

try{
        if (!StringUtils.isEmpty(oleProspect.getData().getGeneralInfo().getLicenseIssuedate())) {
            oleProspect.getData().getGeneralInfo().setLicenseIssuedate(CommonUtil.jsonToDate(oleProspect.getData().getGeneralInfo().getLicenseIssuedate()));
        }
        if (!StringUtils.isEmpty(oleProspect.getData().getGeneralInfo().getLicenseExpiredate())) {
            oleProspect.getData().getGeneralInfo().setLicenseExpiredate(CommonUtil.jsonToDate(oleProspect.getData().getGeneralInfo().getLicenseExpiredate()));
        }
        if (!StringUtils.isEmpty(""+oleProspect.getData().getGeneralInfo().getBusinessSince())) {
            oleProspect.getData().getGeneralInfo().setBusinessSince(oleProspect.getData().getGeneralInfo().getBusinessSince());
        }}catch (Exception e){

}

        binding.setModel(oleProspect);

    }

    private void reject(String id, int appSetId, int currentLevel) {
        if (!id.isEmpty()) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(ProspectViewActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(ProspectViewActivity.this);
            }
            builder.setTitle("Reject Prospect");
            builder.setMessage("Are you sure you want to reject this lead?");
            builder.setIcon(R.drawable.ic_reject);
            builder.setNegativeButton("No", null);
            builder.setPositiveButton("Yes", (DialogInterface dialog, int which) ->
                    callApproval(id, REJECT, appSetId, currentLevel));
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }


    private void approv(String id, int appSetId, int currentLevel) {
        if (!id.isEmpty()) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(ProspectViewActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(ProspectViewActivity.this);
            }
            builder.setTitle("Approved Prospect");
            builder.setMessage("Are you sure you want to approved this lead?");
            builder.setIcon(R.drawable.ic_approved);
            builder.setNegativeButton("No", null);
            builder.setPositiveButton("Yes", (dialog, which) ->
                    callApproval(id, APPROVED, appSetId, currentLevel));
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


    private void callApproval(String id, String type, int appSetId, int currentLevel) {

        MyLeadApproval approval = new MyLeadApproval();
        approval.setApprovalType(TYPE);
        approval.setReferenceNo(id);
        approval.setApprovalSetID(appSetId);
        approval.setCurrentLevel(currentLevel);
        approval.setStatus(type);
        approval.setRemark("");
        approval.setUser(USER_NAME);
        approval.setBranch(localLogin.getBranch());
        approval.setSpApprovalReqId(0);

        String test = new GsonBuilder().serializeNulls().create().toJson(approval);
        Log.d(TAG, "onResponse: " + test);

        showProgressDialog();
        RestClient.getInstance().callRetrofit().supervisorApproval(approval).enqueue(new Callback<ApprovalResponce>() {
            @Override
            public void onResponse(Call<ApprovalResponce> call, Response<ApprovalResponce> response) {
                hideProgressDialog();
                if (response.isSuccessful()) {
                    String test = new GsonBuilder().serializeNulls().create().toJson(response.body());
                    Log.d(TAG, "onResponse: " + test);

                    setResult(RESULT_OK);
                    finish();

                    if (type.equals(APPROVED)) {

                        Toast.makeText(ProspectViewActivity.this, "Approved", Toast.LENGTH_SHORT).show();

                    } else
                        Toast.makeText(ProspectViewActivity.this, "Reject", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(ProspectViewActivity.this, "Responce failed", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<ApprovalResponce> call, Throwable t) {
                showToast("failed");
                hideProgressDialog();

            }
        });


    }
}
