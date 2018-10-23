package net.maxproit.idlc;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.idlc.feature.dashboard.DashboardSalesOfficerActivity;
import net.maxproit.idlc.sqlite.MyLeadDbController;

import java.util.ArrayList;
import java.util.List;

public class LeadStageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView btnSave;
    private MyLeadDbController myLeadDbController;

    private Spinner spnClientType;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_stage);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Lead");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        btnSave=findViewById(R.id.btnSave);
        myLeadDbController = new MyLeadDbController(LeadStageActivity.this);

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


                if( LeadStageLoanDetailFragment.ref > 0 &&

                        LeadStageBasicInformationFragment.branchName != null &&

                        LeadStageVisitRecordFragment.followUp != null &&
                        LeadStageVisitRecordFragment.visitDate != null)
                {

                    String BranchName = LeadStageBasicInformationFragment.branchName; //
                    String profession = LeadStageBasicInformationFragment.profession; //
                    String name = LeadStageBasicInformationFragment.etUserName.getText().toString(); //
                    String organization = LeadStageBasicInformationFragment.etUserOrganization.getText().toString(); //
                    String designation = LeadStageBasicInformationFragment.etDesignattion.getText().toString(); //
                    String phone = LeadStageBasicInformationFragment.etPhone.getText().toString();
                    String address = LeadStageBasicInformationFragment.etAddress.getText().toString();
                    String loanAmount=LeadStageLoanDetailFragment.etLoadAmount.getText().toString();
                    String interest=LeadStageLoanDetailFragment.etInterest.getText().toString();
                    String fee=LeadStageLoanDetailFragment.etFee.getText().toString();
                    String refArray[]=getResources().getStringArray(R.array.source_of_reference_array);
                    String subCatArray[]=getResources().getStringArray(R.array.product_type_array);
                    String productTypeArray[]=getResources().getStringArray(R.array.product_type_array);

                    String ref=refArray[LeadStageLoanDetailFragment.ref];

                    String productType=productTypeArray[LeadStageLoanDetailFragment.productType];

                    String subCat=subCatArray[LeadStageLoanDetailFragment.subCategory];

                    String visitDate=LeadStageVisitRecordFragment.visitDate; //
                    String remark=LeadStageVisitRecordFragment.remark;
                    String followUp=LeadStageVisitRecordFragment.followUp;

                  /*  MyNewLead myNewLead=new MyNewLead(BranchName,name,profession,organization,
                            designation,phone,address,ref,productType,subCat,
                            loanAmount,interest,fee,visitDate,followUp,remark);*/

                   int insert= myLeadDbController.insertLeadData(BranchName,name,profession,organization,
                            designation,phone,address,ref,productType,subCat,
                            loanAmount,interest,fee,visitDate,followUp,remark);
                    if (insert>0){
                        Toast.makeText(LeadStageActivity.this, "data save successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LeadStageActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(LeadStageActivity.this, "required filed can not be empty", Toast.LENGTH_SHORT).show();
                }

//                Toast.makeText(LeadStageActivity.this, "save data", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LeadStageBasicInformationFragment(), "Basic Information");
        adapter.addFragment(new LeadStageLoanDetailFragment(), "Loan Detail");
        adapter.addFragment(new LeadStageVisitRecordFragment(), "Visit Record");
        adapter.addFragment(new LeadStageAttachmentFragment(), "Attachment");
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
}
