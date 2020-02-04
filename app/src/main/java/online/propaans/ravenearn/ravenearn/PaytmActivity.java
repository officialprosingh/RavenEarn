package online.propaans.ravenearn.ravenearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import rest.Constants;

public class PaytmActivity extends AppCompatActivity {

    private TextView paytm_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);

        paytm_view = (TextView) findViewById(R.id.paytmEarnView);
        paytm_view.setText(" Pro Coins : " + Constants.getAmount(this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        paytm_view.setText(" Pro Coins : " + Constants.getAmount(this));
    }
}
