package online.propaans.ravenearn.ravenearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import rest.Constants;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MainActivity";
    private TextView view;
    private FirebaseAuth mAuth;
    DatabaseReference amount;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference("Users");






        view = (TextView) findViewById(R.id.mainMoneyView);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        FirebaseUser user = mAuth.getCurrentUser();







        LinearLayout earn = (LinearLayout )findViewById(R.id.earn);
        earn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EarnActivity.class));
            }
        });

        LinearLayout faq = (LinearLayout) findViewById(R.id.redeem);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RedeemActivity.class));
            }
        });

        LinearLayout rateus = (LinearLayout) findViewById(R.id.faq);
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=online.propaans.ravenearn.ravenearn")));
            }
        });

        LinearLayout share = (LinearLayout) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = " " +
                        "Earn Money By Watching Video Ads, Download Raven Earn Today !" +
                        "https://play.google.com/store/apps/details?id=online.propaans.ravenearn.ravenearn";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });

        LinearLayout about = (LinearLayout) findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });




    }



    @Override
    protected void onResume() {
        super.onResume();
        //view.setText(" Pro Coins : " + Constants.getAmount(this));
    }



}
