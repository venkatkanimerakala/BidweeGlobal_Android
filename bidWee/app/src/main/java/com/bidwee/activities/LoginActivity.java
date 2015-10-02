package com.bidwee.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bidwee.bidwee.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView loginAsCustomerTextView, loginAsMerchantTextView,
                forgotPasswordTextView;

    private EditText usernameEditText, passwordEditText;
    private Button registerButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {
        loginAsCustomerTextView = (TextView)findViewById(R.id.login_asCustomerTextview);
        loginAsMerchantTextView = (TextView)findViewById(R.id.login_asMerchantTextview);
        forgotPasswordTextView = (TextView)findViewById(R.id.login_forgotParrwordTextview);

        usernameEditText = (EditText)findViewById(R.id.login_userNameEditText);
        passwordEditText = (EditText)findViewById(R.id.login_passwordEditText);

        registerButton = (Button)findViewById(R.id.login_registerButton);
        loginButton = (Button)findViewById(R.id.login_loginButton);

        loginAsCustomerTextView.setOnClickListener(this);
        loginAsMerchantTextView.setOnClickListener(this);
        forgotPasswordTextView.setOnClickListener(this);

        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_asCustomerTextview :
                loginAsCustomerTextView.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                loginAsMerchantTextView.setTextColor(getResources().getColor(R.color.white_color));
                break;

            case R.id.login_asMerchantTextview :
                loginAsCustomerTextView.setTextColor(getResources().getColor(R.color.white_color));
                loginAsMerchantTextView.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                break;

            case R.id.login_registerButton:
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                break;

            default:
                break;
        }
    }
}
