package online.propaans.ravenearn.ravenearn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaActionSound;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import rest.Constants;


public class EarnActivity extends AppCompatActivity implements RewardedVideoAdListener {


    private AdView mAdView;
    private Button google_btn,google_btn2, google_btn3 , google_btn4 , google_btn5;
    private RewardedVideoAd mRewardedVideoAd;
    private RewardedVideoAd mRewardedVideoAd2;
    private RewardedVideoAd mRewardedVideoAd3;
    private RewardedVideoAd mRewardedVideoAd4;
    private RewardedVideoAd mRewardedVideoAd5;
    private TextView view_earn;
    private SharedPreferences sharedpreferences;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn);

        view_earn = (TextView) findViewById(R.id.mainEarnView);
        view_earn.setText(" Pro Coins : " + Constants.amount);





        google_btn = (Button) findViewById(R.id.google1);
        google_btn2 = (Button) findViewById(R.id.google2);
        google_btn3 = (Button) findViewById(R.id.google3);
        google_btn4 = (Button) findViewById(R.id.google4);


        google_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }
            }
        });
        google_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd2.isLoaded()) {
                    mRewardedVideoAd2.show();
                }
            }
        });
        google_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd3.isLoaded()) {
                    mRewardedVideoAd3.show();
                }
            }
        });
        google_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedVideoAd4.isLoaded()) {
                    mRewardedVideoAd4.show();
                }
            }
        });


        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(EarnActivity.this);

        mRewardedVideoAd2 = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd2.setRewardedVideoAdListener(EarnActivity.this);

        mRewardedVideoAd3 = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd3.setRewardedVideoAdListener(EarnActivity.this);

        mRewardedVideoAd4 = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd4.setRewardedVideoAdListener(EarnActivity.this);

        mRewardedVideoAd5 = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd5.setRewardedVideoAdListener(EarnActivity.this);

        loadRewardedVideoAd();
        loadRewardedVideoAd2();
        loadRewardedVideoAd3();
        loadRewardedVideoAd4();
        loadRewardedVideoAd5();



        MobileAds.initialize(this,
                "ca-app-pub-5052346282620825~7252389702");


        mAdView = findViewById(R.id.earnad);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(EarnActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {

            }

            @Override
            public void onAdLeftApplication() {

            }

            @Override
            public void onAdClosed() {

            }


        });




    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-5052346282620825/8241073716",
                new AdRequest.Builder().build());
    }

    private void loadRewardedVideoAd2() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }
    private void loadRewardedVideoAd3() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }
    private void loadRewardedVideoAd4() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }
    private void loadRewardedVideoAd5() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        google_btn.setEnabled(true);
        google_btn2.setEnabled(true);
        google_btn3.setEnabled(true);
        google_btn4.setEnabled(true);


    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {
       updateAmount();



    }

    @Override
    public void onResume() {
        view_earn.setText(" Pro Coins : " + Constants.getAmount(this));
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    private void updateAmount() {
        String previous_amount = Constants.getAmount(EarnActivity.this);
        int sum = Integer.parseInt(previous_amount) + Constants.video_amount;
        final String amount = "" + sum;
        sharedpreferences = getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Constants.amount, amount);
        editor.commit();
        finish();

    }

    }





