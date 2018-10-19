package net.maxproit.idlc.feature.salesOfficer.myPerfomance.disbursement;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivityDisbursementsBinding;

public class DisbursementsActivity extends BaseActivity {

    private ActivityDisbursementsBinding binding;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_disbursements;
    }

    @Override
    protected void initComponents() {
        binding = (ActivityDisbursementsBinding) getBinding();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        binding.container.setAdapter(mSectionsPagerAdapter);
        binding.container.setOffscreenPageLimit(mSectionsPagerAdapter.fragmentCount);
        binding.tabs.setupWithViewPager(binding.container);
        binding.btnSubmit.setOnClickListener(v -> finish());

    }

    @Override
    protected void getIntentData() {

    }
}
