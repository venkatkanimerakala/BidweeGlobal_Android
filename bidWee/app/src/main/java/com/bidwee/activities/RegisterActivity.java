package com.bidwee.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameEdittext, passwordEdittext,
            residanceLocEdittext, phNumEdittext, yearOfBirtEdittext;

    private TextView showPassTextview, getLocTextview, maleTextView, femaleTextview;

    private Button registerAsMerchantButton, registerButton;

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {
        userNameEdittext = (EditText)findViewById(R.id.reg_userNameEditText);
        passwordEdittext = (EditText)findViewById(R.id.reg_passwordEditText);
        residanceLocEdittext = (EditText)findViewById(R.id.reg_locationEditText);
        phNumEdittext = (EditText)findViewById(R.id.reg_phNumEditText);
        yearOfBirtEdittext = (EditText)findViewById(R.id.reg_yearOfBirthEditText);

        showPassTextview = (TextView)findViewById(R.id.reg_showPassTextview);
        getLocTextview = (TextView)findViewById(R.id.reg_getLocationTextview);
        maleTextView = (TextView)findViewById(R.id.reg_maleTextView);
        femaleTextview = (TextView)findViewById(R.id.reg_femaleTextView);

        registerAsMerchantButton = (Button)findViewById(R.id.reg_registerAsMerchantButton);
        registerButton = (Button)findViewById(R.id.reg_registerButton);

        showPassTextview.setOnClickListener(this);
        getLocTextview.setOnClickListener(this);
        maleTextView.setOnClickListener(this);
        femaleTextview.setOnClickListener(this);

        registerAsMerchantButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.reg_showPassTextview:
                if (isPasswordVisible){
                    isPasswordVisible = false;
                    showPassTextview.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                    passwordEdittext.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    isPasswordVisible = true;
                    showPassTextview.setTextColor(getResources().getColor(R.color.white_color));
                    passwordEdittext.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                passwordEdittext.setSelection(passwordEdittext.getText().length());
                break;

            case R.id.reg_getLocationTextview:
                Toast.makeText(RegisterActivity.this,"Hope it fetched your Location from GPS", Toast.LENGTH_LONG).show();
                residanceLocEdittext.setText("Bangalore");
                break;

            case R.id.reg_maleTextView:
                maleTextView.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                femaleTextview.setTextColor(getResources().getColor(R.color.white_color));
                break;

            case R.id.reg_femaleTextView:
                maleTextView.setTextColor(getResources().getColor(R.color.white_color));
                femaleTextview.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                break;

            case R.id.reg_registerAsMerchantButton:

            case R.id.reg_registerButton:
                Intent userAuthIntent = new Intent(RegisterActivity.this, UserAuthenticationActivity.class);
                startActivity(userAuthIntent);
                break;

            default:
                break;
        }
    }
}
