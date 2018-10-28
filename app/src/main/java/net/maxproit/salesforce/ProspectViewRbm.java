package net.maxproit.salesforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProspectViewRbm extends AppCompatActivity {

    TextView tvApproval, tvReject, tvReturn;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospect_view_rbm);


        tvApproval = (TextView)findViewById(R.id.tv_approval);
        tvReject = (TextView)findViewById(R.id.tv_reject);
        tvReturn = (TextView)findViewById(R.id.tv_return);
        backButton = (ImageView) findViewById(R.id.btnBack);

        tvApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProspectViewRbm.this, "Prospect is approved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        tvReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProspectViewRbm.this, "Prospect is rejected", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        tvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProspectViewRbm.this, "Return prospect", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
