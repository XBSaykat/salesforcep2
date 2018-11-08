package net.maxproit.salesforce.masum.activity.lead;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;

import net.maxproit.salesforce.masum.appdata.sqlite.AttachmentDbController;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageAttachmentFragment;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageBasicInformationFragment;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageLoanDetailFragment;
import net.maxproit.salesforce.masum.fragment.lead.LeadStageVisitRecordFragment;
import net.maxproit.salesforce.masum.model.Attachment;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;

import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.ImageUtils;

import java.util.ArrayList;
import java.util.List;

public class LeadStageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView btnSave, btnProceed, btnReject, btnReAppoint;
    private MyLeadDbController myLeadDbController;
    private AttachmentDbController attachmentDbController;
    private ArrayList<VisitPlan> visitPlanArrayList;
    private VisitPlanDbController visitPlanDbController;
    private LeadStageBasicInformationFragment leadStageBasicInformationFragment;
    private LeadStageAttachmentFragment leadStageAttachmentFragment;
    private LeadStageVisitRecordFragment leadStageVisitRecordFragment;
    private LeadStageLoanDetailFragment leadStageLoanDetailFragment;
    private LinearLayout mLayout;


    private int activityPosition;
    public static int myLeadPosition = -1;
    public static VisitPlan visitPlan = null;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_stage);
        initFragments();


        //getDataFromLead();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Lead");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(4);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        btnSave = findViewById(R.id.btnSave);
        myLeadDbController = new MyLeadDbController(LeadStageActivity.this);
        attachmentDbController = new AttachmentDbController(LeadStageActivity.this);
        mLayout = findViewById(R.id.btn_layout_lead);
        btnProceed = findViewById(R.id.tv_activity_details_proceed_to_prospect);
        btnReject = findViewById(R.id.tv_activity_details_rejected);
        getDataFromIntent();


    }


    private void initFragments() {
        leadStageAttachmentFragment = new LeadStageAttachmentFragment();
        leadStageBasicInformationFragment = new LeadStageBasicInformationFragment();
        leadStageLoanDetailFragment = new LeadStageLoanDetailFragment();
        leadStageVisitRecordFragment = new LeadStageVisitRecordFragment();
    }

    private void setFieldsFromActivity() {


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(leadStageBasicInformationFragment, "Basic Information");
        adapter.addFragment(leadStageLoanDetailFragment, "Loan Detail");
        adapter.addFragment(leadStageVisitRecordFragment, "Visit Record");
        adapter.addFragment(leadStageAttachmentFragment, "Attachment");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LeadStageActivity.this, DashboardSalesOfficerActivity.class));
        finish();
    }


    private void getDataFromIntent() {
        VisitPlan visitPlan = null;
        MyNewProspect myNewLead = null;
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail != null) {
            int status = extraDetail.getInt(AppConstant.STATUS_INTENT_KEY, -1);
            Bundle bundle = new Bundle();
            if (status == 0) {
                visitPlan = (VisitPlan) extraDetail.getSerializable(AppConstant.INTENT_KEY);
                bundle.putSerializable(AppConstant.INTENT_KEY, visitPlan);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY, 0);
            } else if (status == 1) {
                myNewLead = (MyNewProspect) extraDetail.getSerializable(AppConstant.INTENT_KEY);
                bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY, 1);
                mLayout.setVisibility(View.VISIBLE);

            }
            leadStageBasicInformationFragment.setArguments(bundle);
            leadStageLoanDetailFragment.setArguments(bundle);
            leadStageVisitRecordFragment.setArguments(bundle);
            leadStageAttachmentFragment.setArguments(bundle);

        } else {
            //dda
            Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
        }


        MyNewProspect finalMyNewLead = myNewLead;
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String BranchName = LeadStageBasicInformationFragment.branchName; //
                String profession = LeadStageBasicInformationFragment.profession; //
                String name = LeadStageBasicInformationFragment.etUserName.getText().toString(); //
                String organization = LeadStageBasicInformationFragment.etUserOrganization.getText().toString(); //
                String designation = LeadStageBasicInformationFragment.etDesignattion.getText().toString(); //
                String phone = LeadStageBasicInformationFragment.etPhone.getText().toString();
                String address = LeadStageBasicInformationFragment.etAddress.getText().toString();
                String loanAmount = LeadStageLoanDetailFragment.etLoadAmount.getText().toString();
                String interest = LeadStageLoanDetailFragment.etInterest.getText().toString();
                String fee = LeadStageLoanDetailFragment.etFee.getText().toString();
                String refArray[] = getResources().getStringArray(R.array.source_of_reference_array);
                String subCatArray[] = getResources().getStringArray(R.array.product_type_array);
//                  String productTypeArray[] = getResources().getStringArray(R.array.product_type_array);

                String ref = refArray[LeadStageLoanDetailFragment.ref];

//                    String productType = productTypeArray[LeadStageLoanDetailFragment.productType];
                String productType = LeadStageLoanDetailFragment.productType;

//                    String subCat = subCatArray[LeadStageLoanDetailFragment.subCategory];
                String subCat = LeadStageLoanDetailFragment.subCategory;
                String disDate = LeadStageLoanDetailFragment.etDisbursementDate.getText().toString();
                String visitDate = LeadStageVisitRecordFragment.visitDate; //
                String remark = LeadStageVisitRecordFragment.remark;
                String followUp = LeadStageVisitRecordFragment.followUp;
                int insert=0;
                if (finalMyNewLead !=null){
                     insert = myLeadDbController.updateLeadData(finalMyNewLead.getId(), BranchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.STATUS_NEW_PROSPECT);
                }
                else {
                    insert = myLeadDbController.insertLeadData(BranchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark,AppConstant.LEAD_STATUS_PROCEED);
                    if (insert > 0) {
                        Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                        insertAttachmentData(insert,null);

                    } else {
                        Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                    }
                }

                if (insert > 0) {
                    if (leadStageAttachmentFragment.imgAtach.getDrawable() != null
                            && leadStageAttachmentFragment.imgIdCard.getDrawable() != null
                            && leadStageAttachmentFragment.imgVisitingCard.getDrawable() != null) {

                        insertAttachmentData(finalMyNewLead.getId(), finalMyNewLead);
                    }
                    else {
                        Toast.makeText(LeadStageActivity.this, "Attachment can't be empty while proceed", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                    ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, DashboardSalesOfficerActivity.class, true);

                } else {
                    Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BranchName = LeadStageBasicInformationFragment.branchName; //
                String profession = LeadStageBasicInformationFragment.profession; //
                String name = LeadStageBasicInformationFragment.etUserName.getText().toString(); //
                String organization = LeadStageBasicInformationFragment.etUserOrganization.getText().toString(); //
                String designation = LeadStageBasicInformationFragment.etDesignattion.getText().toString(); //
                String phone = LeadStageBasicInformationFragment.etPhone.getText().toString();
                String address = LeadStageBasicInformationFragment.etAddress.getText().toString();
                String loanAmount = LeadStageLoanDetailFragment.etLoadAmount.getText().toString();
                String interest = LeadStageLoanDetailFragment.etInterest.getText().toString();
                String fee = LeadStageLoanDetailFragment.etFee.getText().toString();
                String refArray[] = getResources().getStringArray(R.array.source_of_reference_array);
                String subCatArray[] = getResources().getStringArray(R.array.product_type_array);

                String ref = refArray[LeadStageLoanDetailFragment.ref];

                String productType = LeadStageLoanDetailFragment.productType;

                String subCat = LeadStageLoanDetailFragment.subCategory;
                String disDate = LeadStageLoanDetailFragment.etDisbursementDate.getText().toString();
                String visitDate = LeadStageVisitRecordFragment.visitDate; //
                String remark = LeadStageVisitRecordFragment.remark;
                String followUp = LeadStageVisitRecordFragment.followUp;

                if (finalMyNewLead != null) {
                    int insert = myLeadDbController.updateLeadData(finalMyNewLead.getId(), BranchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark, AppConstant.LEAD_STATUS_NEW);
                    if (insert > 0) {
                        Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                        ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, DashboardSalesOfficerActivity.class, true);
                        insertAttachmentData(finalMyNewLead.getId(),finalMyNewLead);


                    } else {
                        Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    int insert = myLeadDbController.insertLeadData(BranchName, name, profession, organization,
                            designation, phone, address, ref, productType, subCat,
                            loanAmount, interest, fee, disDate, visitDate, followUp, remark,AppConstant.LEAD_STATUS_NEW);
                    if (insert > 0) {
                        Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                        insertAttachmentData(insert,null);

                    } else {
                        Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog(finalMyNewLead.getId());
            }
        });

    }

    private void insertAttachmentData(int insert,final  MyNewProspect myNewProspect) {
        byte[] bytesAtachpp = null;
        byte[] bytesAtachIdCard = null;
        byte[] bytesAtachVCard = null;
        if (leadStageAttachmentFragment.imgAtach.getDrawable() != null
                && leadStageAttachmentFragment.imgIdCard.getDrawable() != null
                && leadStageAttachmentFragment.imgVisitingCard.getDrawable() != null) {


            bytesAtachpp = ImageUtils.imagetoByte(LeadStageAttachmentFragment.imgAtach);
            bytesAtachIdCard = ImageUtils.imagetoByte(LeadStageAttachmentFragment.imgIdCard);
            bytesAtachVCard = ImageUtils.imagetoByte(LeadStageAttachmentFragment.imgVisitingCard);
            int insertAttach=0;
            if (myNewProspect !=null){
                 if(attachmentDbController.getAllData(String.valueOf(myNewProspect.getId())).size()>0){
                     Attachment attachment=new Attachment(myNewProspect.getId(),bytesAtachpp,bytesAtachIdCard,bytesAtachVCard);
                     insertAttach=attachmentDbController.updateData(attachment);
                 }
            }
            else {
                 insertAttach = attachmentDbController.insertData(insert, bytesAtachpp, bytesAtachIdCard, bytesAtachVCard);

            }
            if (insertAttach > 0) {
                Toast.makeText(LeadStageActivity.this, "Attach data save successfully", Toast.LENGTH_SHORT).show();
                ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, DashboardSalesOfficerActivity.class, true);

            } else {
                Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Toast.makeText(LeadStageActivity.this, "Attachment Can not be Empty", Toast.LENGTH_SHORT).show();
        }
    }


    private void alertDialog(int id) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(LeadStageActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(LeadStageActivity.this);
        }
        builder.setTitle(getString(R.string.Reject));
        builder.setMessage(getString(R.string.reject_item));
        builder.setIcon(R.drawable.ic_reject);
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            myLeadDbController.updateLeadDataStatus(id, AppConstant.LEAD_STATUS_REJECT);
            ActivityUtils.getInstance().invokeActivity(LeadStageActivity.this, MyLeadActivity.class, true);
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
