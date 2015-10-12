package com.bidwee.activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapters.RecomendationAdapters;
import models.RecommendationModel;

public class BidRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backImageView, notificationImageView;

    private ImageView requestSendingImageview;
    private AnimationDrawable requestSendingtAnimation;

    private TextView noOfOuteletsTextview;
    private ListView recomendationListView;
    private BaseAdapter recomendationAdapter;

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

        requestSendingImageview = (ImageView)findViewById(R.id.bidreq_requestSendingImageView);
        requestSendingImageview.setBackgroundResource(R.drawable.bid_submit_anim);

        requestSendingtAnimation = (AnimationDrawable) requestSendingImageview.getBackground();
        requestSendingtAnimation.start();

        noOfOuteletsTextview = (TextView)findViewById(R.id.bidreq_noOfOutletsTextview);

        recomendationListView = (ListView)findViewById(R.id.bidreq_recomendationListview);

        recomendationAdapter = new RecomendationAdapters(this, getRecomendationList());

        recomendationListView.setAdapter(recomendationAdapter);
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
                Intent notificationIntent = new Intent(BidRequestActivity.this, NotificationActivity.class);
                startActivity(notificationIntent);
                finish();
                break;

            default:
                break;
        }
    }
}
