package customer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bidwee.activities.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import adapters.RecomendationAdapters;
import customer.fragments.SendingBidReqestDailogFragment;
import models.RecommendationModel;

public class BidRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backImageView, notificationImageView;

    private TextView noOfOuteletsTextview;
    private ListView recomendationListView;
    private BaseAdapter recomendationAdapter;

    private int timerCountInMillis = 5000;
    private Timer timer;
    private Handler timerTaskHandler;
    private TimerTask timerTask;

    private SendingBidReqestDailogFragment sendingBidReqestDailogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_request);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {

        backImageView = (ImageView) findViewById(R.id.tool_backImageView);
        notificationImageView = (ImageView) findViewById(R.id.tool_notificationImageView);

        backImageView.setOnClickListener(this);
        notificationImageView.setOnClickListener(this);

        noOfOuteletsTextview = (TextView)findViewById(R.id.bidreq_noOfOutletsTextview);

        recomendationListView = (ListView)findViewById(R.id.bidreq_recomendationListview);

        recomendationAdapter = new RecomendationAdapters(this, getRecomendationList());

        recomendationListView.setAdapter(recomendationAdapter);

        showSendingBidRequestDailog();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void showSendingBidRequestDailog() {

        sendingBidReqestDailogFragment = new SendingBidReqestDailogFragment();
        // Show Alert DialogFragment
        sendingBidReqestDailogFragment.show(getSupportFragmentManager(), "Sending Bid Request Dialog Fragment");
        sendingBidReqestDailogFragment.setCancelable(false);

        timer = new Timer();
        timerTaskHandler = new Handler();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                timerTaskHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        timerTask.cancel();
                        sendingBidReqestDailogFragment.dismiss();
                    }
                });
            }
        };

        timer.schedule(timerTask, timerCountInMillis, timerCountInMillis);
    }

    private List<RecommendationModel> getRecomendationList(){
        List<RecommendationModel> recomendationList = new ArrayList<>();

        for (int i= 0 ; i <5; i++){
            recomendationList.add(new RecommendationModel("MRP \n 50,000","Best price available \n 48,999"));
        }

        return recomendationList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tool_backImageView:
                finish();
                break;


            case R.id.tool_notificationImageView:
                Intent notificationIntent = new Intent(BidRequestActivity.this, NotificationsActivity.class);
                startActivity(notificationIntent);
                finish();
                break;

            default:
                break;
        }
    }
}
