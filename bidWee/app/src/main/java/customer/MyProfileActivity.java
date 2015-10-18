package customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bidwee.activities.LoginActivity;
import com.bidwee.activities.R;

public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backImageView, logoutImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {

        backImageView = (ImageView) findViewById(R.id.tool_backImageView);
        logoutImageView = (ImageView) findViewById(R.id.tool_logoutView);

        backImageView.setOnClickListener(this);
        logoutImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tool_backImageView:
                Intent dashboardIntent = new Intent(MyProfileActivity.this, CustomerDashboradActivity.class);
                startActivity(dashboardIntent);
                finish();
                break;


            case R.id.tool_logoutView:
                Intent loginIntant = new Intent(MyProfileActivity.this, LoginActivity.class);
                startActivity(loginIntant);
                finish();
                break;

            default:
                break;
        }
    }
}
