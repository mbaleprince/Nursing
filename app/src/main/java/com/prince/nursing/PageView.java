package com.prince.nursing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class PageView extends AppCompatActivity {
    private AdView mAdView;
    Toolbar toolbar;
    TextView textView;
    private InterstitialAd interstitialAd;
    private static final String AD_UNIT_ID = "ca-app-pub-7555653615503037/3461469687";
    private static final String TAG = "PageView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        loadAd();

        toolbar = findViewById(R.id.toolbar_view);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("title");
        ((TextView) toolbar.getChildAt(0)).setTextSize(21);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To return to main activity
                showInterstitial();
                //PageView.super.onBackPressed();
            }
        });
        textView = findViewById(R.id.text_page_view);
        String subtext = getIntent().getStringExtra("subtext");
        textView.setText(Html.fromHtml(subtext));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void loadAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(
                this,
                AD_UNIT_ID,
                adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        PageView.this.interstitialAd = interstitialAd;
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        PageView.this.interstitialAd = null;
                                    }
                                }
                        );
                    }
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        interstitialAd = null;
                    }
                }
        );
    }
    private void showInterstitial() {
        if (interstitialAd != null){
            interstitialAd.show(this);
        }
        else {
            PageView.super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.more:
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Prince%20Software%20Systems"));
                startActivity(i);
                break;
            case R.id.share:
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Nursing and Midwifery");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "Get a list of all nursing and midwifery procedures from play store inform of an app using the link\n https://play.google.com/store/apps/details?id=com.prince.nursing");
                startActivity(Intent.createChooser(intent, "Share via"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}