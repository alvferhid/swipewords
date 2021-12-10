package com.example.cambridgescoreconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class BasicConverter extends AppCompatActivity {

    //ANUNCIO
    InterstitialAd mInterstitialAd;
    //ANUNCIO

    String twentyFive = "0-25";
    String twentyEight = "0–28";
    String thirty = "0–30";
    String thirtyTwo = "0–32";
    String forty = "0–40";
    String fortyTwo = "0–42";
    String fortyFour = "0–44";
    String fortyFive = "0–45";
    String fifty = "0–50";
    String sixty = "0–60";
    String seventyFive = "0–75";

    String A2 = "A2 - KET - Key ";
    String B1 = "B1 - PET - Preliminary";
    String B2 = "B2 - FCE - First";
    String C1 = "C1 - CAE - Advanced";
    String C2 = "C1 - CPE - Proficiency";


    String message = "";

    EditText editReading, editUse, editWriting, editListening, editSpeaking;
    TextView textViewUse, textViewLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_converter);
        chargeAd();
        setElements();
        Intent intent = getIntent();
        message = intent.getStringExtra("levelSecond");
        adjustMaximum(message);
    }


    public void setElements() {
        editReading = findViewById(R.id.editTextNumberReadingBasicA2);
        editUse = findViewById(R.id.editTextNumberUseOfEnglishBasic);
        editWriting = findViewById(R.id.editTextNumberWritingBasic);
        editListening = findViewById(R.id.editTextNumberListeningBasic);
        editSpeaking = findViewById(R.id.editTextNumberSpeakingBasic);
        textViewUse = findViewById(R.id.textViewUseOfEnglishLabelBasic);
        textViewLevel = findViewById(R.id.textViewLevelLayerBasic);
    }

    public void adjustMaximum(String level) {

        switch (level) {
            case "A2":
                textViewLevel.setText(A2);
                editReading.setHint(thirty);
                textViewUse.setVisibility(View.GONE);
                editUse.setVisibility(View.GONE);
                editWriting.setHint(thirty);
                editListening.setHint(twentyFive);
                editSpeaking.setHint(fortyFive);
                break;

            case "B1":
                textViewLevel.setText(B1);
                editReading.setHint(thirtyTwo);
                textViewUse.setVisibility(View.GONE);
                editUse.setVisibility(View.GONE);
                editWriting.setHint(forty);
                editListening.setHint(twentyFive);
                editSpeaking.setHint(thirty);
                break;

            case "B2":
                textViewLevel.setText(B2);
                editReading.setHint(fortyTwo);
                editUse.setHint(twentyEight);
                editWriting.setHint(forty);
                editListening.setHint(thirty);
                editSpeaking.setHint(sixty);
                break;

            case "C1":
                textViewLevel.setText(C1);
                editReading.setHint(fifty);
                editUse.setHint(twentyEight);
                editWriting.setHint(forty);
                editListening.setHint(thirty);
                editSpeaking.setHint(seventyFive);
                break;

            case "C2":
                textViewLevel.setText(C2);
                editReading.setHint(fortyFour);
                editUse.setHint(twentyEight);
                editWriting.setHint(forty);
                editListening.setHint(thirty);
                editSpeaking.setHint(seventyFive);
                break;
        }
    }

    public void toFinalGrades(View view) {
        showAd();
    }

    public void calculateAndGoToNextActivity() {
        int reading = (String.valueOf(editReading.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(editReading.getText()));
        int useOfEnglish = (String.valueOf(editUse.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(editUse.getText()));
        int writing = (String.valueOf(editWriting.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(editWriting.getText()));
        int listening = (String.valueOf(editListening.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(editListening.getText()));
        int speaking = (String.valueOf(editSpeaking.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(editSpeaking.getText()));

        Intent intentResult = new Intent(this, Results.class);
        Calculator calculator = new Calculator();
        String grades = calculator.convertMarks(message, reading, useOfEnglish, writing, listening, speaking);
        intentResult.putExtra("grades", grades);
        startActivity(intentResult);
    }


    public void showAd() {

        if (mInterstitialAd != null) {
            mInterstitialAd.show(BasicConverter.this);

            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    calculateAndGoToNextActivity();
                }
            });
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
            calculateAndGoToNextActivity();
        }
    }

    public void chargeAd() {

        //ANUNCIO
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-1529296433001176/6498361171", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

        // Id Real del anuncio
        // ca-app-pub-1529296433001176/6498361171

    }

    @Override
    protected void onResume() {
        super.onResume();
        chargeAd();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        chargeAd();
    }
}