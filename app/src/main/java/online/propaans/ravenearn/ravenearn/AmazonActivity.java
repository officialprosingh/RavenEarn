package online.propaans.ravenearn.ravenearn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import rest.Constants;

public class AmazonActivity extends AppCompatActivity {


    private TextView amazon_view;
    private SharedPreferences sharedpreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon);

       LinearLayout giftcard_500 = (LinearLayout) findViewById(R.id.amazon_giftcard_500);

       LinearLayout giftcard_1000 = (LinearLayout) findViewById(R.id.amazon_giftcard_1000);


       LinearLayout giftcard_2000 = (LinearLayout) findViewById(R.id.amazon_giftcard_2000);



        amazon_view = (TextView) findViewById(R.id.amazonEarnView);
        amazon_view.setText(" Pro Coins : " + Constants.getAmount(this));



    }


    @Override
    protected void onResume() {
        super.onResume();
        amazon_view.setText(" Pro Coins : " + Constants.getAmount(this));
    }




}
