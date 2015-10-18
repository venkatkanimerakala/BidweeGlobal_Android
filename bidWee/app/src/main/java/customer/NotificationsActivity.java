package customer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bidwee.activities.R;

public class NotificationsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backImageView, refreshImageView;

    private TextView requestTextview,responseTextview;
    private ListView notificaitonsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {

        backImageView = (ImageView) findViewById(R.id.tool_backImageView);
        refreshImageView = (ImageView) findViewById(R.id.tool_refreshImageView);

        backImageView.setOnClickListener(this);
        refreshImageView.setOnClickListener(this);

        requestTextview = (TextView)findViewById(R.id.notifi_requestTextview);
        responseTextview = (TextView)findViewById(R.id.notifi_responsesTextview);

        requestTextview.setOnClickListener(this);
        responseTextview.setOnClickListener(this);

        notificaitonsListView = (ListView)findViewById(R.id.notifi_notificationsListview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tool_backImageView:
                finish();
                break;


            case R.id.tool_refreshImageView:
                Toast.makeText(this,"Refreshing...",Toast.LENGTH_SHORT).show();
                break;

            case R.id.notifi_requestTextview:
                responseTextview.setTextColor(getResources().getColor(R.color.white_color));
                requestTextview.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                break;

            case R.id.notifi_responsesTextview:
                requestTextview.setTextColor(getResources().getColor(R.color.white_color));
                responseTextview.setTextColor(getResources().getColor(R.color.login_selectedtext_color));
                break;


            default:
                break;
        }
    }
}
