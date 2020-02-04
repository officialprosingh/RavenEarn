package online.propaans.ravenearn.ravenearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import rest.Constants;

public class RechargeActivity extends AppCompatActivity {

    private TextView recharge_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        recharge_view = (TextView) findViewById(R.id.redeemMoneyView);
        recharge_view.setText(" Pro Coins : " + Constants.getAmount(this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        recharge_view.setText(" Pro Coins : " + Constants.getAmount(this));
    }
}
