package com.prince.nursing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.company);
        String subtext = "<html>&copy;</html> prince software systems";
        textView.setText(Html.fromHtml(subtext));

        Thread splashScreenStarter = new Thread() {
            @Override
            public void run() {
                try {
                    int delay = 0;
                    while (delay <2000) {
                        sleep(150);
                        delay = delay + 100;
                    }
                    ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                    if (networkInfo != null && networkInfo.isConnected()) {
                        //There's an unverified internet connection
                        startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    }
                    else {
                        startActivity(new Intent(SplashScreen.this, checkInternet.class));
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        splashScreenStarter.start();
    }
}