package com.bidwee.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MerchantDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_dashboard);

        getSupportActionBar().hide();
    }
}
