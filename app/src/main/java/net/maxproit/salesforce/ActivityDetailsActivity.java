package net.maxproit.salesforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityDetailsActivity extends AppCompatActivity {

    Intent myActivityItemIntent;
    int itemPosition;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_details);
         myActivityItemIntent = getIntent();
            itemPosition = myActivityItemIntent.getIntExtra(AppConstant.INTENT_KEY, -1);

            Toast.makeText(this, ""+itemPosition, Toast.LENGTH_SHORT).show();






    }
}
