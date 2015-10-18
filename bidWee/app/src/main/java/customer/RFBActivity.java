package customer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bidwee.activities.R;

public class RFBActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backImageView, refreshImageView;

    private TextView myRFBsTextview, myOrdersTextview;
    private ListView rfbListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rfb);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {

        backImageView = (ImageView) findViewById(R.id.tool_backImageView);
        refreshImageView = (ImageView) findViewById(R.id.tool_refreshImageView);

        backImageView.setOnClickListener(this);
        refreshImageView.setOnClickListener(this);

        myRFBsTextview = (TextView)findViewById(R.id.rfb_myRFBtTextview);
        myOrdersTextview = (TextView)findViewById(R.id.rfb_myOrdersTextview);

        myRFBsTextview.setOnClickListener(this);
        myOrdersTextview.setOnClickListener(this);

        rfbListView = (ListView)findViewById(R.id.rfb_rfbListview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tool_backImageView:
                finish();
                break;


            case R.id.tool_refreshImageView:
                Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rfb_myRFBtTextview:
                myOrdersTextview.setTextColor(getResources().getColor(R.color.white_color));
                myRFBsTextview.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                break;

            case R.id.rfb_myOrdersTextview:
                myRFBsTextview.setTextColor(getResources().getColor(R.color.white_color));
                myOrdersTextview.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                break;


            default:
                break;
        }
    }
}
