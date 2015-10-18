package customer.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.bidwee.activities.R;

/**
 * Created by Suneet on 12-Oct-15.
 */
public class SendingBidReqestDailogFragment extends DialogFragment {

    private View rootView;

    private ImageView requestSendingImageview;
    private AnimationDrawable requestSendingtAnimation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dailogfragment_sending_bid_request, container,
                false);
        initControls();

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return rootView;
    }

    private void initControls() {
        requestSendingImageview = (ImageView)rootView.findViewById(R.id.dailog_requestSendingImageView);
        requestSendingImageview.setBackgroundResource(R.drawable.bid_sending_anim);

        requestSendingtAnimation = (AnimationDrawable) requestSendingImageview.getBackground();
    }

    @Override
    public void onStart() {
        super.onStart();

        requestSendingtAnimation.start();
    }
}
