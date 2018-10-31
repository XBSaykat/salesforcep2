package net.maxproit.salesforce.masum.activity;

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
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.salesforce.masum.model.MyNewLead;
import net.maxproit.salesforce.masum.sqlite.AppConstant;
import net.maxproit.salesforce.masum.fragment.LeadStageAttachmentFragment;
import net.maxproit.salesforce.masum.fragment.LeadStageBasicInformationFragment;
import net.maxproit.salesforce.masum.fragment.LeadStageLoanDetailFragment;
import net.maxproit.salesforce.masum.fragment.LeadStageVisitRecordFragment;
import net.maxproit.salesforce.masum.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.model.VisitPlan;

import java.util.ArrayList;
import java.util.List;

public class LeadStageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView btnSave;
    private MyLeadDbController myLeadDbController;
    private ArrayList<VisitPlan> visitPlanArrayList;
    private VisitPlanDbController visitPlanDbController;
    private LeadStageBasicInformationFragment leadStageBasicInformationFragment;
    private LeadStageAttachmentFragment leadStageAttachmentFragment;
    private LeadStageVisitRecordFragment leadStageVisitRecordFragment;
    private LeadStageLoanDetailFragment leadStageLoanDetailFragment;


    private int activityPosition;
    public static int myLeadPosition = -1;
    public static VisitPlan visitPlan = null;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_stage);
        initFragments();

        getDataFromIntent();
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

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        btnSave = findViewById(R.id.btnSave);
        myLeadDbController = new MyLeadDbController(LeadStageActivity.this);





//        Toast.makeText(this, ""+myLeadPosition, Toast.LENGTH_SHORT).show();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            /*    this.branchName = branchName;
                this.userName = userName;
                this.profession = profession;
                this.organization = organization;
                this.designation = designation;
                this.phone = phone;
                this.address = address;
                this.sourceRef = sourceRef;
                this.productType = productType;
                this.productSubcategory = productSubcategory;
                this.loadAmount = loadAmount;
                this.orInterest = orInterest;
                this.opFee = opFee;
                this.visitDate = visitDate;
                this.followUp = followUp;
                this.remark = remark;
                */


//                if(LeadStageBasicInformationFragment.etUserName.getText()!=null ||
//
//
//
//                        LeadStageBasicInformationFragment.etUserOrganization.getText()!= null||
//                        LeadStageBasicInformationFragment.profession != null||
//                        LeadStageBasicInformationFragment.etDesignattion != null||
//                        LeadStageBasicInformationFragment.etPhone != null||
//                        LeadStageBasicInformationFragment.etAddress != null||
//                        LeadStageLoanDetailFragment.etLoadAmount != null||
//                        LeadStageLoanDetailFragment.etInterest != null||
//                        LeadStageLoanDetailFragment.etFee != null||
//                        LeadStageVisitRecordFragment.etRemark != null ||
//                        LeadStageLoanDetailFragment.productType <= 0 ||
//                        LeadStageLoanDetailFragment.subCategory <= 0
//
//
//                        )


//                if (LeadStageLoanDetailFragment.ref > 0 &&
//                        LeadStageBasicInformationFragment.branchName != null &
//                                LeadStageVisitRecordFragment.followUp != null &&
//                        LeadStageVisitRecordFragment.visitDate != null) {

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

                  /*  MyNewLead myNewLead=new MyNewLead(BranchName,name,profession,organization,
                            designation,phone,address,ref,productType,subCat,
                            loanAmount,interest,fee,visitDate,followUp,remark);*/

                int insert = myLeadDbController.insertLeadData(BranchName, name, profession, organization,
                        designation, phone, address, ref, productType, subCat,
                        loanAmount, interest, fee, disDate, visitDate, followUp, remark);
                if (insert > 0) {
                    Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                }

//                } else {
//                    Toast.makeText(LeadStageActivity.this, "required filed can not be empty", Toast.LENGTH_SHORT).show();
//                }

//                Toast.makeText(LeadStageActivity.this, "save data", Toast.LENGTH_SHORT).show();

            }
        });

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
        MyNewLead myNewLead = null;
        Bundle extraDetail = getIntent().getExtras();
        if (!getIntent().getExtras().equals(null)) {
            int status=extraDetail.getInt(AppConstant.STATUS_INTENT_KEY,-1);
            Bundle bundle = new Bundle();
            if (status==0){
                visitPlan = (VisitPlan) extraDetail.getSerializable(AppConstant.INTENT_KEY);
                bundle.putSerializable(AppConstant.INTENT_KEY, visitPlan);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY,0);
            }
            else {
                myNewLead = (MyNewLead) extraDetail.getSerializable(AppConstant.INTENT_KEY);
                bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
                bundle.putInt(AppConstant.STATUS_INTENT_KEY,1);
            }
            leadStageBasicInformationFragment.setArguments(bundle);

            //leadStageLoanDetailFragment.setArguments(bundle);
            //leadStageVisitRecordFragment.setArguments(bundle);
            //leadStageAttachmentFragment.setArguments(bundle);

        }
        else {
            //dda
            Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
        }

    }


}
