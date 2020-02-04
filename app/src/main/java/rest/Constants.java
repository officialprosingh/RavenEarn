package rest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;

import static android.content.Context.MODE_PRIVATE;


public class Constants {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String amount = "10";



    public static final int survey_amount=10;
    public static final int video_amount=1;

    public String getName() {
        return amount;
    }




    public static String getAmount(Context context){
        SharedPreferences prefs = context.getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String token = prefs.getString(Constants.amount, "10");
        return token;
    }




}
