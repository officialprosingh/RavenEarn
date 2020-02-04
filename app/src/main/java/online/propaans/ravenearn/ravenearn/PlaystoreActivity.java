package online.propaans.ravenearn.ravenearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import rest.Constants;

public class PlaystoreActivity extends AppCompatActivity {
    private TextView play_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playstore);

        play_view = (TextView) findViewById(R.id.playEarnView);
        play_view.setText(" Pro Coins : " + Constants.getAmount(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
        play_view.setText(" Pro Coins : " + Constants.getAmount(this));
    }

}
