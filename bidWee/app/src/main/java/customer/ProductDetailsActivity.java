package customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bidwee.activities.R;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backImageView, creditsImageView, rfbImageView, notificationImageView;

    private RadioButton withAreaRadioButton, kmRadioButton;
    private EditText budgetEdittext;
    private Button reqestForBidButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {
        backImageView = (ImageView) findViewById(R.id.tool_backImageView);
        creditsImageView = (ImageView) findViewById(R.id.tool_creditsImageView);
        rfbImageView = (ImageView) findViewById(R.id.tool_rfbImageView);
        notificationImageView = (ImageView) findViewById(R.id.tool_notificationImageView);

        backImageView.setOnClickListener(this);
        creditsImageView.setOnClickListener(this);
        rfbImageView.setOnClickListener(this);
        notificationImageView.setOnClickListener(this);

        withAreaRadioButton = (RadioButton)findViewById(R.id.prod_withinAreaRadioButton);
        kmRadioButton = (RadioButton)findViewById(R.id.prod_kmRadioButton);

        budgetEdittext = (EditText)findViewById(R.id.prod_budgetEdittext);

        reqestForBidButton = (Button)findViewById(R.id.dash_cust_requestForBidButton);

        reqestForBidButton.setOnClickListener(this);

        withAreaRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kmRadioButton.setChecked(false);
                }
            }
        });

        kmRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    withAreaRadioButton.setChecked(false);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.dash_cust_requestForBidButton:
                if (TextUtils.isEmpty(budgetEdittext.getText().toString())){
                    Toast.makeText(ProductDetailsActivity.this, "Please enter your budget", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent bidRequestIntent = new Intent(ProductDetailsActivity.this, BidRequestActivity.class);
                startActivity(bidRequestIntent);
                finish();

            case R.id.tool_backImageView:
                finish();
                break;

            case R.id.tool_creditsImageView:
                Toast.makeText(ProductDetailsActivity.this, "Credits will be there some day", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tool_rfbImageView:
                Toast.makeText(ProductDetailsActivity.this, "RFB will be there some day", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tool_notificationImageView:
                Intent notificationIntent = new Intent(ProductDetailsActivity.this, NotificationsActivity.class);
                startActivity(notificationIntent);
                break;

            default:
                break;
        }
    }
}
