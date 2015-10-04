package com.bidwee.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class UserAuthenticationActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private TextView timerTextView, resendTextView;
    private EditText digit1Edittext, digit2Edittext, digit3Edittext, digit4Edittext;
    private Button reenterDetailsButton, verifyButton;

    private EditText[] codeEdittextArray;
    private int codeArrayLastPos = 3;
    private boolean foundFocus = false;

    private int timerCount = 30;
    private Timer timer;
    private Handler timerTaskHandler;
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);
        
        getSupportActionBar().hide();
        
        initControls();
    }

    private void initControls() {
        timerTextView = (TextView)findViewById(R.id.auth_timerTextView);
        resendTextView = (TextView)findViewById(R.id.auth_resendTextview);

        reenterDetailsButton = (Button)findViewById(R.id.auth_reEnterDetailsButton);
        verifyButton = (Button)findViewById(R.id.auth_verifyButton);

        digit1Edittext = (EditText)findViewById(R.id.auth_digitCode1Edittext);
        digit2Edittext = (EditText)findViewById(R.id.auth_digitCode2Edittext);
        digit3Edittext = (EditText)findViewById(R.id.auth_digitCode3Edittext);
        digit4Edittext = (EditText)findViewById(R.id.auth_digitCode4Edittext);

        resendTextView.setOnClickListener(this);
        reenterDetailsButton.setOnClickListener(this);
        verifyButton.setOnClickListener(this);

        codeEdittextArray = new EditText[]{digit1Edittext, digit2Edittext, digit3Edittext, digit4Edittext};

        digit1Edittext.setOnClickListener(this);
        digit2Edittext.setOnClickListener(this);
        digit3Edittext.setOnClickListener(this);
        digit4Edittext.setOnClickListener(this);

        digit1Edittext.addTextChangedListener(this);
        digit2Edittext.addTextChangedListener(this);
        digit3Edittext.addTextChangedListener(this);
        digit4Edittext.addTextChangedListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        initTimer();
    }

    private void initTimer() {

        timer = new Timer();
        timerTaskHandler = new Handler();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timerTaskHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (timerCount == 24){
                            set4DigitCode();
                        }

                        if (timerCount == 22){
                            Intent dashboardIntent = new Intent(UserAuthenticationActivity.this, DashboardActivity.class);
                            dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(dashboardIntent);
                            finish();
                        }
                        if (timerCount > 0){
                            timerCount--;
                            setTimerOnTextView();
                        }
                        else {
                            timer.cancel();
                        }
                    }
                });
            }
        };

        timer.schedule(timerTask, 1000, 1000);

    }

    private void setTimerOnTextView(){
        String prefix = "";
        if (timerCount < 10){
            prefix = "(00:0";
        }
        else{
            prefix = "(00:";
        }
        timerTextView.setText(prefix + String.valueOf(timerCount) + ")");
    }

    private void set4DigitCode(){
        digit1Edittext.setText("2");
        digit2Edittext.setText("4");
        digit3Edittext.setText("7");
        digit4Edittext.setText("1");

        digit1Edittext.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_2stepverify_digit_active));
        digit2Edittext.setBackgroundDrawable( getResources().getDrawable(R.drawable.bg_2stepverify_digit_active) );
        digit3Edittext.setBackgroundDrawable( getResources().getDrawable(R.drawable.bg_2stepverify_digit_active) );
        digit4Edittext.setBackgroundDrawable( getResources().getDrawable(R.drawable.bg_2stepverify_digit_active) );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.auth_reEnterDetailsButton:
                finish();
                break;

            case R.id.auth_verifyButton:
                if (TextUtils.isEmpty(digit4Edittext.getText().toString())){
                    Toast.makeText(UserAuthenticationActivity.this,"Please enter 4 digin code",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent dashboardIntent = new Intent(UserAuthenticationActivity.this, DashboardActivity.class);
                dashboardIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(dashboardIntent);
                finish();


            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //checkFocus();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
