package online.propaans.ravenearn.ravenearn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import rest.Constants;

public class RedeemActivity extends AppCompatActivity {
    private TextView redeem_view;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);

        redeem_view = (TextView) findViewById(R.id.redeemMoneyView);
        redeem_view.setText("Pro Coins : "+Constants.amount);

        LinearLayout paytm = (LinearLayout) findViewById(R.id.paytm);
        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedeemActivity.this, PaytmActivity.class));
            }
        });

        LinearLayout play = (LinearLayout) findViewById(R.id.play_store);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedeemActivity.this, PlaystoreActivity.class));
            }
        });

        LinearLayout recharge = (LinearLayout) findViewById(R.id.recharge);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedeemActivity.this, RechargeActivity.class));
            }
        });

        LinearLayout amazon = (LinearLayout) findViewById(R.id.amazon);
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedeemActivity.this, AmazonActivity.class));
            }
        });
        LinearLayout about = (LinearLayout) findViewById(R.id.about_redeem);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedeemActivity.this, AboutActivity.class));
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        redeem_view.setText(" Pro Coins : " + Constants.getAmount(this));
    }
}
