package com.origamistudios.sample.presentation.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.origamistudios.sample.R;
import com.origamistudios.sample.presentation.account.SignUpActivity;
import com.origamistudios.sample.presentation.guide.GuideActivity;
import com.origamistudios.sample.utilities.Constants;
import com.origamistudios.sample.utilities.Utilities;

import static com.origamistudios.sample.utilities.Constants.SPLASH_DELAY_TIME;


public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent;
                if (Utilities.getInstance(getApplicationContext()).getBooleanPreferences(Constants.PREF_IS_SKIP)) {
                    mainIntent = new Intent(Splash.this, SignUpActivity.class);
                } else {
                    mainIntent = new Intent(Splash.this, GuideActivity.class);
                }

                startActivity(mainIntent);
                finish();


            }
        }, SPLASH_DELAY_TIME);
    }
}
