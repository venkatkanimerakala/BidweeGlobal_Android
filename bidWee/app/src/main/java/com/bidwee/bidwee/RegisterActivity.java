package com.bidwee.bidwee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bidwee.activities.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {
    }
}
