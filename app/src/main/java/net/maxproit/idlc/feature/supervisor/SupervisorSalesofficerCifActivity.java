package net.maxproit.idlc.feature.supervisor;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseActivity;
import net.maxproit.idlc.databinding.ActivitySupervisorSalesofficerCifBinding;

public class SupervisorSalesofficerCifActivity extends BaseActivity {
    ActivitySupervisorSalesofficerCifBinding binding;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_supervisor_salesofficer_cif;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySupervisorSalesofficerCifBinding) getBinding();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
