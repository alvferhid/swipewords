package com.example.cambridgescoreconverter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class ComplexConverter extends AppCompatActivity {

    String message;
    int reading;
    int useOfEnglish;
    int writing;
    int listening;
    int speaking;

    EditText finalReading, finalUse, readingPart1, readingPart2, readingPart3, readingPart4,
            readingPart5, readingPart6, readingPart7, readingPart8, readingPart4Half, readingPart4Full,
            finalWriting, writingPart1_1, writingPart1_2, writingPart1_3, writingPart1_4, writingPart2_1, writingPart2_2,
            writingPart2_3, writingPart2_4, finalListening, listeningPart1, listeningPart2, listeningPart3, listeningPart4, listeningPart5,
            finalSpeaking, speakingPart1, speakingPart2, speakingPart3, speakingPart4, speakingPart5, speakingPart6;

    int readPart1, readPart2, readPart3, readPart4, readPart5, readPart6, readPart7, readPart8, readPart4Half, readPart4Full,
            writPart1_1, writPart1_2, writPart1_3, writPart1_4, writPart2_1, writPart2_2, writPart2_3, writPart2_4, listPart1,
            listPart2, listPart3, listPart4, listPart5, speakPart1, speakPart2, speakPart3, speakPart4, speakPart5, speakPart6;


    //ANUNCIO
    InterstitialAd mInterstitialAd;
    //ANUNCIO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_converter);

        chargeAd();

        Intent intent = getIntent();
        message = intent.getStringExtra("levelSecond");
        switch (message) {
            case "A2":
                setContentView(R.layout.activity_a2_calculator);
                setElementsA2();
                break;
            case "B1":
                setContentView(R.layout.activity_b1_calculator);
                setElementsB1();
                break;
            case "B2":
                setContentView(R.layout.activity_b2_calculator);
                setElementsB2();
                break;
            case "C1":
                setContentView(R.layout.activity_c1_calculator);
                setElementsC1();
                break;
            case "C2":
                setContentView(R.layout.activity_c2_calculator);
                setElementsC2();
                break;
        }
    }

    public void calculateComplete(View view) {

        showAd();
        //calculateAndGoToNextActivity();


    }

    public void calculateAndGoToNextActivity() {


        Intent intentResult = new Intent(this, Results.class);
        Calculator calculator = new Calculator();
        String grades;

        switch (message) {
            case "A2":
                if (!String.valueOf(finalReading.getText()).equals("")) {
                    reading = (String.valueOf(finalReading.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalReading.getText()));
                } else {
                    readPart1 = (String.valueOf(readingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart1.getText()));
                    readPart2 = (String.valueOf(readingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart2.getText()));
                    readPart3 = (String.valueOf(readingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart3.getText()));
                    readPart4 = (String.valueOf(readingPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart4.getText()));
                    readPart5 = (String.valueOf(readingPart5.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart5.getText()));

                    reading = readPart1 + readPart2 + readPart3 + readPart4 + readPart5;
                }

                useOfEnglish = 0;

                if (!String.valueOf(finalWriting.getText()).equals("")) {
                    writing = (String.valueOf(finalWriting.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalWriting.getText()));
                } else {
                    writPart1_1 = (String.valueOf(writingPart1_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_1.getText()));
                    writPart1_2 = (String.valueOf(writingPart1_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_2.getText()));
                    writPart1_3 = (String.valueOf(writingPart1_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_3.getText()));
                    writPart2_1 = (String.valueOf(writingPart2_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_1.getText()));
                    writPart2_2 = (String.valueOf(writingPart2_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_2.getText()));
                    writPart2_3 = (String.valueOf(writingPart2_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_3.getText()));

                    writing = writPart1_1 + writPart1_2 + writPart1_3 + writPart2_1 + writPart2_2 + writPart2_3;
                }

                if (!String.valueOf(finalListening.getText()).equals("")) {
                    listening = (String.valueOf(finalListening.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalListening.getText()));
                } else {
                    listPart1 = (String.valueOf(listeningPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart1.getText()));
                    listPart2 = (String.valueOf(listeningPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart2.getText()));
                    listPart3 = (String.valueOf(listeningPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart3.getText()));
                    listPart4 = (String.valueOf(listeningPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart4.getText()));
                    listPart5 = (String.valueOf(listeningPart5.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart5.getText()));

                    listening = listPart1 + listPart2 + listPart3 + listPart4 + listPart5;
                }

                if (!String.valueOf(finalSpeaking.getText()).equals("")) {
                    speaking = (String.valueOf(finalSpeaking.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalSpeaking.getText()));
                } else {
                    speakPart1 = (String.valueOf(speakingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart1.getText())) * 2;
                    speakPart2 = (String.valueOf(speakingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart2.getText())) * 2;
                    speakPart3 = (String.valueOf(speakingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart3.getText())) * 2;
                    speakPart4 = (String.valueOf(speakingPart4.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(speakingPart4.getText())) * 3);

                    speaking = speakPart1 + speakPart2 + speakPart3 + speakPart4;
                }

                grades = calculator.convertMarks(message, reading, useOfEnglish, writing, listening, speaking);
                intentResult.putExtra("grades", grades);
                startActivity(intentResult);

                break;

            case "B1":
                if (!String.valueOf(finalReading.getText()).equals("")) {
                    reading = (String.valueOf(finalReading.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalReading.getText()));
                } else {

                    readPart1 = (String.valueOf(readingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart1.getText()));
                    readPart2 = (String.valueOf(readingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart2.getText()));
                    readPart3 = (String.valueOf(readingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart3.getText()));
                    readPart4 = (String.valueOf(readingPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart4.getText()));
                    readPart5 = (String.valueOf(readingPart5.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart5.getText()));
                    readPart6 = (String.valueOf(readingPart6.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart6.getText()));

                    reading = readPart1 + readPart2 + readPart3 + readPart4 + readPart5 + readPart6;
                }

                useOfEnglish = 0;

                if (!String.valueOf(finalWriting.getText()).equals("")) {
                    writing = (String.valueOf(finalWriting.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalWriting.getText()));
                } else {

                    writPart1_1 = (String.valueOf(writingPart1_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_1.getText()));
                    writPart1_2 = (String.valueOf(writingPart1_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_2.getText()));
                    writPart1_3 = (String.valueOf(writingPart1_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_3.getText()));
                    writPart1_4 = (String.valueOf(writingPart1_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_4.getText()));
                    writPart2_1 = (String.valueOf(writingPart2_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_1.getText()));
                    writPart2_2 = (String.valueOf(writingPart2_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_2.getText()));
                    writPart2_3 = (String.valueOf(writingPart2_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_3.getText()));
                    writPart2_4 = (String.valueOf(writingPart2_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_4.getText()));

                    writing = writPart1_1 + writPart1_2 + writPart1_3 + writPart1_4 + writPart2_1 + writPart2_2 + writPart2_3 + writPart2_4;
                }

                if (!String.valueOf(finalListening.getText()).equals("")) {
                    listening = (String.valueOf(finalListening.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalListening.getText()));
                } else {
                    listPart1 = (String.valueOf(listeningPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart1.getText()));
                    listPart2 = (String.valueOf(listeningPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart2.getText()));
                    listPart3 = (String.valueOf(listeningPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart3.getText()));
                    listPart4 = (String.valueOf(listeningPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart4.getText()));

                    listening = listPart1 + listPart2 + listPart3 + listPart4;
                }

                if (!String.valueOf(finalSpeaking.getText()).equals("")) {
                    speaking = (String.valueOf(finalSpeaking.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalSpeaking.getText()));
                } else {
                    speakPart1 = (String.valueOf(speakingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart1.getText()));
                    speakPart2 = (String.valueOf(speakingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart2.getText()));
                    speakPart3 = (String.valueOf(speakingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart3.getText()));
                    speakPart4 = (String.valueOf(speakingPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart4.getText()));
                    speakPart5 = (String.valueOf(speakingPart5.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(speakingPart5.getText())) * 2);

                    speaking = speakPart1 + speakPart2 + speakPart3 + speakPart4 + speakPart5;
                }

                grades = calculator.convertMarks(message, reading, useOfEnglish, writing, listening, speaking);
                intentResult.putExtra("grades", grades);
                startActivity(intentResult);
                break;

            case "B2":
                if (!String.valueOf(finalReading.getText()).equals("")) {
                    reading = Integer.parseInt(String.valueOf(finalReading.getText()));
                } else {

                    readPart1 = (String.valueOf(readingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart1.getText()));
                    readPart5 = (String.valueOf(readingPart5.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart5.getText())) * 2);
                    readPart6 = (String.valueOf(readingPart6.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart6.getText())) * 2);
                    readPart7 = (String.valueOf(readingPart7.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart7.getText()));

                    reading = readPart1 + readPart5 + readPart6 + readPart7;

                }

                if (!String.valueOf(finalUse.getText()).equals("")) {
                    useOfEnglish = (String.valueOf(finalUse.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalUse.getText()));
                } else {
                    readPart2 = (String.valueOf(readingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart2.getText()));
                    readPart3 = (String.valueOf(readingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart3.getText()));
                    readPart4Half = (String.valueOf(readingPart4Half.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart4Half.getText()));
                    readPart4Full = (String.valueOf(readingPart4Full.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart4Full.getText())) * 2);

                    useOfEnglish = readPart2 + readPart3 + readPart4Half + readPart4Full;

                }

                if (!String.valueOf(finalWriting.getText()).equals("")) {
                    writing = (String.valueOf(finalWriting.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalWriting.getText()));
                } else {

                    writPart1_1 = (String.valueOf(writingPart1_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_1.getText()));
                    writPart1_2 = (String.valueOf(writingPart1_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_2.getText()));
                    writPart1_3 = (String.valueOf(writingPart1_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_3.getText()));
                    writPart1_4 = (String.valueOf(writingPart1_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_4.getText()));
                    writPart2_1 = (String.valueOf(writingPart2_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_1.getText()));
                    writPart2_2 = (String.valueOf(writingPart2_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_2.getText()));
                    writPart2_3 = (String.valueOf(writingPart2_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_3.getText()));
                    writPart2_4 = (String.valueOf(writingPart2_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_4.getText()));

                    writing = writPart1_1 + writPart1_2 + writPart1_3 + writPart1_4 + writPart2_1 + writPart2_2 + writPart2_3 + writPart2_4;
                }

                if (!String.valueOf(finalListening.getText()).equals("")) {
                    listening = (String.valueOf(finalListening.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalListening.getText()));
                } else {
                    listPart1 = (String.valueOf(listeningPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart1.getText()));
                    listPart2 = (String.valueOf(listeningPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart2.getText()));
                    listPart3 = (String.valueOf(listeningPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart3.getText()));
                    listPart4 = (String.valueOf(listeningPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart4.getText()));

                    listening = listPart1 + listPart2 + listPart3 + listPart4;
                }

                if (!String.valueOf(finalSpeaking.getText()).equals("")) {
                    speaking = (String.valueOf(finalSpeaking.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalSpeaking.getText()));
                } else {
                    speakPart1 = (String.valueOf(speakingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart1.getText())) * 2;
                    speakPart2 = (String.valueOf(speakingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart2.getText())) * 2;
                    speakPart3 = (String.valueOf(speakingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart3.getText())) * 2;
                    speakPart4 = (String.valueOf(speakingPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart4.getText())) * 2;
                    speakPart5 = (String.valueOf(speakingPart5.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(speakingPart5.getText())) * 4);

                    speaking = speakPart1 + speakPart2 + speakPart3 + speakPart4 + speakPart5;
                }

                grades = calculator.convertMarks(message, reading, useOfEnglish, writing, listening, speaking);
                intentResult.putExtra("grades", grades);
                startActivity(intentResult);
                break;

            case "C1":
                if (!String.valueOf(finalReading.getText()).equals("")) {
                    reading = Integer.parseInt(String.valueOf(finalReading.getText()));
                } else {
                    readPart1 = (String.valueOf(readingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart1.getText()));
                    readPart5 = (String.valueOf(readingPart5.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart5.getText())) * 2);
                    readPart6 = (String.valueOf(readingPart6.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart6.getText())) * 2);
                    readPart7 = (String.valueOf(readingPart7.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart7.getText())) * 2);
                    readPart8 = (String.valueOf(readingPart8.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart8.getText()));

                    reading = readPart1 + readPart5 + readPart6 + readPart7 + readPart8;
                }

                if (!String.valueOf(finalUse.getText()).equals("")) {
                    useOfEnglish = (String.valueOf(finalUse.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalUse.getText()));
                } else {
                    readPart2 = (String.valueOf(readingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart2.getText()));
                    readPart3 = (String.valueOf(readingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart3.getText()));
                    readPart4Half = (String.valueOf(readingPart4Half.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart4Half.getText()));
                    readPart4Full = (String.valueOf(readingPart4Full.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart4Full.getText())) * 2);

                    useOfEnglish = readPart2 + readPart3 + readPart4Half + readPart4Full;
                }

                if (!String.valueOf(finalWriting.getText()).equals("")) {
                    writing = (String.valueOf(finalWriting.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalWriting.getText()));
                } else {

                    writPart1_1 = (String.valueOf(writingPart1_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_1.getText()));
                    writPart1_2 = (String.valueOf(writingPart1_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_2.getText()));
                    writPart1_3 = (String.valueOf(writingPart1_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_3.getText()));
                    writPart1_4 = (String.valueOf(writingPart1_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_4.getText()));
                    writPart2_1 = (String.valueOf(writingPart2_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_1.getText()));
                    writPart2_2 = (String.valueOf(writingPart2_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_2.getText()));
                    writPart2_3 = (String.valueOf(writingPart2_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_3.getText()));
                    writPart2_4 = (String.valueOf(writingPart2_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_4.getText()));

                    writing = writPart1_1 + writPart1_2 + writPart1_3 + writPart1_4 + writPart2_1 + writPart2_2 + writPart2_3 + writPart2_4;
                }

                if (!String.valueOf(finalListening.getText()).equals("")) {
                    listening = (String.valueOf(finalListening.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalListening.getText()));
                } else {
                    listPart1 = (String.valueOf(listeningPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart1.getText()));
                    listPart2 = (String.valueOf(listeningPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart2.getText()));
                    listPart3 = (String.valueOf(listeningPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart3.getText()));
                    listPart4 = (String.valueOf(listeningPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart4.getText()));

                    listening = listPart1 + listPart2 + listPart3 + listPart4;
                }

                if (!String.valueOf(finalSpeaking.getText()).equals("")) {
                    speaking = (String.valueOf(finalSpeaking.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalSpeaking.getText()));
                } else {
                    speaking = (Integer.parseInt(String.valueOf(speakingPart1.getText())) * 2) +
                            (Integer.parseInt(String.valueOf(speakingPart2.getText())) * 2) +
                            (Integer.parseInt(String.valueOf(speakingPart3.getText())) * 2) +
                            (Integer.parseInt(String.valueOf(speakingPart4.getText())) * 2) +
                            (Integer.parseInt(String.valueOf(speakingPart5.getText())) * 2) +
                            (Integer.parseInt(String.valueOf(speakingPart6.getText())) * 5);

                    speakPart1 = (String.valueOf(speakingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart1.getText())) * 2;
                    speakPart2 = (String.valueOf(speakingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart2.getText())) * 2;
                    speakPart3 = (String.valueOf(speakingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart3.getText())) * 2;
                    speakPart4 = (String.valueOf(speakingPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart4.getText())) * 2;
                    speakPart5 = (String.valueOf(speakingPart5.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(speakingPart5.getText())) * 2);
                    speakPart6 = (String.valueOf(speakingPart6.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(speakingPart6.getText())) * 5);

                    speaking = speakPart1 + speakPart2 + speakPart3 + speakPart4 + speakPart5 + speakPart6;
                }

                grades = calculator.convertMarks(message, reading, useOfEnglish, writing, listening, speaking);
                intentResult.putExtra("grades", grades);
                startActivity(intentResult);
                break;

            case "C2":
                if (!String.valueOf(finalReading.getText()).equals("")) {
                    reading = Integer.parseInt(String.valueOf(finalReading.getText()));
                } else {
                    readPart1 = (String.valueOf(readingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart1.getText()));
                    readPart5 = (String.valueOf(readingPart5.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart5.getText())) * 2);
                    readPart6 = (String.valueOf(readingPart6.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart6.getText())) * 2);
                    readPart7 = (String.valueOf(readingPart7.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart7.getText()));

                    reading = readPart1 + readPart5 + readPart6 + readPart7;
                }

                if (!String.valueOf(finalUse.getText()).equals("")) {
                    useOfEnglish = (String.valueOf(finalUse.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalUse.getText()));
                } else {
                    readPart2 = (String.valueOf(readingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart2.getText()));
                    readPart3 = (String.valueOf(readingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart3.getText()));
                    readPart4Half = (String.valueOf(readingPart4Half.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(readingPart4Half.getText()));
                    readPart4Full = (String.valueOf(readingPart4Full.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(readingPart4Full.getText())) * 2);

                    useOfEnglish = readPart2 + readPart3 + readPart4Half + readPart4Full;
                }

                if (!String.valueOf(finalWriting.getText()).equals("")) {
                    writing = (String.valueOf(finalWriting.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalWriting.getText()));
                } else {

                    writPart1_1 = (String.valueOf(writingPart1_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_1.getText()));
                    writPart1_2 = (String.valueOf(writingPart1_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_2.getText()));
                    writPart1_3 = (String.valueOf(writingPart1_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_3.getText()));
                    writPart1_4 = (String.valueOf(writingPart1_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart1_4.getText()));
                    writPart2_1 = (String.valueOf(writingPart2_1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_1.getText()));
                    writPart2_2 = (String.valueOf(writingPart2_2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_2.getText()));
                    writPart2_3 = (String.valueOf(writingPart2_3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_3.getText()));
                    writPart2_4 = (String.valueOf(writingPart2_4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(writingPart2_4.getText()));

                    writing = writPart1_1 + writPart1_2 + writPart1_3 + writPart1_4 + writPart2_1 + writPart2_2 + writPart2_3 + writPart2_4;
                }

                if (!String.valueOf(finalListening.getText()).equals("")) {
                    listening = (String.valueOf(finalListening.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalListening.getText()));
                } else {
                    listPart1 = (String.valueOf(listeningPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart1.getText()));
                    listPart2 = (String.valueOf(listeningPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart2.getText()));
                    listPart3 = (String.valueOf(listeningPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart3.getText()));
                    listPart4 = (String.valueOf(listeningPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(listeningPart4.getText()));

                    listening = listPart1 + listPart2 + listPart3 + listPart4;
                }

                if (!String.valueOf(finalSpeaking.getText()).equals("")) {
                    speaking = (String.valueOf(finalSpeaking.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(finalSpeaking.getText()));
                } else {

                    speakPart1 = (String.valueOf(speakingPart1.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart1.getText())) * 2;
                    speakPart2 = (String.valueOf(speakingPart2.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart2.getText())) * 2;
                    speakPart3 = (String.valueOf(speakingPart3.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart3.getText())) * 2;
                    speakPart4 = (String.valueOf(speakingPart4.getText()).equals("")) ? 0 : Integer.parseInt(String.valueOf(speakingPart4.getText())) * 2;
                    speakPart5 = (String.valueOf(speakingPart5.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(speakingPart5.getText())) * 2);
                    speakPart6 = (String.valueOf(speakingPart6.getText()).equals("")) ? 0 : (Integer.parseInt(String.valueOf(speakingPart6.getText())) * 5);

                    speaking = speakPart1 + speakPart2 + speakPart3 + speakPart4 + speakPart5 + speakPart6;
                }


                grades = calculator.convertMarks(message, reading, useOfEnglish, writing, listening, speaking);
                intentResult.putExtra("grades", grades);
                startActivity(intentResult);
                break;
        }
    }

    public void setElementsA2() {
        //Reading & Use of English
        finalReading = findViewById(R.id.editTextNumberReadingA2);
        readingPart1 = findViewById(R.id.editTextNumberReadingPart1A2);
        readingPart2 = findViewById(R.id.editTextNumberReadingPart2A2);
        readingPart3 = findViewById(R.id.editTextNumberReadingPart3A2);
        readingPart4 = findViewById(R.id.editTextNumberReadingPart4A2);
        readingPart5 = findViewById(R.id.editTextNumberReadingPart5A2);

        //Writing
        finalWriting = findViewById(R.id.editTextNumberWritingA2);
        writingPart1_1 = findViewById(R.id.editTextNumberWritingContent1A2);
        writingPart1_2 = findViewById(R.id.editTextNumberWritingOrganisation1A2);
        writingPart1_3 = findViewById(R.id.editTextNumberWritingLanguage1A2);

        writingPart2_1 = findViewById(R.id.editTextNumberWritingContent2A2);
        writingPart2_2 = findViewById(R.id.editTextNumberWritingOrganisation2A2);
        writingPart2_3 = findViewById(R.id.editTextNumberWritingLanguage2A2);

        //Listening
        finalListening = findViewById(R.id.editTextNumberListeningA2);
        listeningPart1 = findViewById(R.id.editTextNumberListeningPart1A2);
        listeningPart2 = findViewById(R.id.editTextNumberListeningPart2A2);
        listeningPart3 = findViewById(R.id.editTextNumberListeningPart3A2);
        listeningPart4 = findViewById(R.id.editTextNumberListeningPart4A2);
        listeningPart5 = findViewById(R.id.editTextNumberListeningPart5A2);

        //Speaking
        finalSpeaking = findViewById(R.id.editTextNumberSpeakingA2);
        speakingPart1 = findViewById(R.id.editTextNumberSpeakingGrammarAndVocabularyA2);
        speakingPart2 = findViewById(R.id.editTextNumberSpeakingPronunciationA2);
        speakingPart3 = findViewById(R.id.editTextNumberSpeakingInteractiveA2);
        speakingPart4 = findViewById(R.id.editTextNumberSpeakingGlobalA2);

    }

    public void setElementsB1() {
        //Reading & Use of English
        finalReading = findViewById(R.id.editTextNumberReadingB1);
        readingPart1 = findViewById(R.id.editTextNumberReadingPart1B1);
        readingPart2 = findViewById(R.id.editTextNumberReadingPart2B1);
        readingPart3 = findViewById(R.id.editTextNumberReadingPart3B1);
        readingPart4 = findViewById(R.id.editTextNumberReadingPart4B1);
        readingPart5 = findViewById(R.id.editTextNumberReadingPart5B1);
        readingPart6 = findViewById(R.id.editTextNumberReadingPart6B1);

        //Writing
        finalWriting = findViewById(R.id.editTextNumberWritingB1);
        writingPart1_1 = findViewById(R.id.editTextNumberWritingContent1B1);
        writingPart1_2 = findViewById(R.id.editTextNumberWritingOrganisation1B1);
        writingPart1_3 = findViewById(R.id.editTextNumberWritingLanguage1B1);
        writingPart1_4 = findViewById(R.id.editTextNumberWritingAchievement1B1);

        writingPart2_1 = findViewById(R.id.editTextNumberWritingContent2B1);
        writingPart2_2 = findViewById(R.id.editTextNumberWritingOrganisation2B1);
        writingPart2_3 = findViewById(R.id.editTextNumberWritingLanguage2B1);
        writingPart2_4 = findViewById(R.id.editTextNumberWritingAchievement2B1);

        //Listening
        finalListening = findViewById(R.id.editTextNumberListeningB1);
        listeningPart1 = findViewById(R.id.editTextNumberListeningPart1B1);
        listeningPart2 = findViewById(R.id.editTextNumberListeningPart2B1);
        listeningPart3 = findViewById(R.id.editTextNumberListeningPart3B1);
        listeningPart4 = findViewById(R.id.editTextNumberListeningPart4B1);

        //Speaking
        finalSpeaking = findViewById(R.id.editTextNumberSpeakingB1);
        speakingPart1 = findViewById(R.id.editTextNumberSpeakingGrammarAndVocabularyB1);
        speakingPart2 = findViewById(R.id.editTextNumberSpeakingPronunciationB1);
        speakingPart3 = findViewById(R.id.editTextNumberSpeakingInteractiveB1);
        speakingPart4 = findViewById(R.id.editTextNumberSpeakingDiscourseB1);
        speakingPart5 = findViewById(R.id.editTextNumberSpeakingGlobalB1);
    }

    public void setElementsB2() {
        //Reading & Use of English
        finalReading = findViewById(R.id.editTextNumberReadingB2);
        finalUse = findViewById(R.id.editTextNumberUseB2);
        readingPart1 = findViewById(R.id.editTextNumberReadingPart1B2);
        readingPart2 = findViewById(R.id.editTextNumberReadingPart2B2);
        readingPart3 = findViewById(R.id.editTextNumberReadingPart3B2);
        readingPart4Half = findViewById(R.id.editTextNumberReadingPart4_1B2);
        readingPart4Full = findViewById(R.id.editTextNumberReadingPart4_2B2);
        readingPart5 = findViewById(R.id.editTextNumberReadingPart5B2);
        readingPart6 = findViewById(R.id.editTextNumberReadingPart6B2);
        readingPart7 = findViewById(R.id.editTextNumberReadingPart7B2);

        //Writing
        finalWriting = findViewById(R.id.editTextNumberWritingB2);
        writingPart1_1 = findViewById(R.id.editTextNumberWritingContent1B2);
        writingPart1_2 = findViewById(R.id.editTextNumberWritingOrganisation1B2);
        writingPart1_3 = findViewById(R.id.editTextNumberWritingLanguage1B2);
        writingPart1_4 = findViewById(R.id.editTextNumberWritingAchievement1B2);

        writingPart2_1 = findViewById(R.id.editTextNumberWritingContent2B2);
        writingPart2_2 = findViewById(R.id.editTextNumberWritingOrganisation2B2);
        writingPart2_3 = findViewById(R.id.editTextNumberWritingLanguage2B2);
        writingPart2_4 = findViewById(R.id.editTextNumberWritingAchievement2B2);

        //Listening
        finalListening = findViewById(R.id.editTextNumberListeningB2);
        listeningPart1 = findViewById(R.id.editTextNumberListeningPart1B2);
        listeningPart2 = findViewById(R.id.editTextNumberListeningPart2B2);
        listeningPart3 = findViewById(R.id.editTextNumberListeningPart3B2);
        listeningPart4 = findViewById(R.id.editTextNumberListeningPart4B2);

        //Speaking
        finalSpeaking = findViewById(R.id.editTextNumberSpeakingB2);
        speakingPart1 = findViewById(R.id.editTextNumberSpeakingGrammarAndVocabularyB2);
        speakingPart2 = findViewById(R.id.editTextNumberSpeakingPronunciationB2);
        speakingPart3 = findViewById(R.id.editTextNumberSpeakingInteractiveB2);
        speakingPart4 = findViewById(R.id.editTextNumberSpeakingDiscourseB2);
        speakingPart5 = findViewById(R.id.editTextNumberSpeakingGlobalB2);
    }

    public void setElementsC1() {
        //Reading & Use of English
        finalReading = findViewById(R.id.editTextNumberReadingC1);
        finalUse = findViewById(R.id.editTextNumberUseC1);
        readingPart1 = findViewById(R.id.editTextNumberReadingPart1C1);
        readingPart2 = findViewById(R.id.editTextNumberReadingPart2C1);
        readingPart3 = findViewById(R.id.editTextNumberReadingPart3C1);
        readingPart4Half = findViewById(R.id.editTextNumberReadingPart4_1C1);
        readingPart4Full = findViewById(R.id.editTextNumberReadingPart4_2C1);
        readingPart5 = findViewById(R.id.editTextNumberReadingPart5C1);
        readingPart6 = findViewById(R.id.editTextNumberReadingPart6C1);
        readingPart7 = findViewById(R.id.editTextNumberReadingPart7C1);
        readingPart8 = findViewById(R.id.editTextNumberReadingPart8C1);

        //Writing
        finalWriting = findViewById(R.id.editTextNumberWritingC1);
        writingPart1_1 = findViewById(R.id.editTextNumberWritingContent1C1);
        writingPart1_2 = findViewById(R.id.editTextNumberWritingOrganisation1C1);
        writingPart1_3 = findViewById(R.id.editTextNumberWritingLanguage1C1);
        writingPart1_4 = findViewById(R.id.editTextNumberWritingAchievement1C1);

        writingPart2_1 = findViewById(R.id.editTextNumberWritingContent2C1);
        writingPart2_2 = findViewById(R.id.editTextNumberWritingOrganisation2C1);
        writingPart2_3 = findViewById(R.id.editTextNumberWritingLanguage2C1);
        writingPart2_4 = findViewById(R.id.editTextNumberWritingAchievement2C1);

        //Listening
        finalListening = findViewById(R.id.editTextNumberListeningC1);
        listeningPart1 = findViewById(R.id.editTextNumberListeningPart1C1);
        listeningPart2 = findViewById(R.id.editTextNumberListeningPart2C1);
        listeningPart3 = findViewById(R.id.editTextNumberListeningPart3C1);
        listeningPart4 = findViewById(R.id.editTextNumberListeningPart4C1);

        //Speaking
        finalSpeaking = findViewById(R.id.editTextNumberSpeakingC1);
        speakingPart1 = findViewById(R.id.editTextNumberSpeakingGrammaticalResourceC1);
        speakingPart2 = findViewById(R.id.editTextNumberSpeakingLexicalResourceC1);
        speakingPart3 = findViewById(R.id.editTextNumberSpeakingPronunciationC1);
        speakingPart4 = findViewById(R.id.editTextNumberSpeakingInteractiveC1);
        speakingPart5 = findViewById(R.id.editTextNumberSpeakingDiscourseC1);
        speakingPart6 = findViewById(R.id.editTextNumberSpeakingGlobalC1);
    }

    public void setElementsC2() {
        //Reading & Use of English
        finalReading = findViewById(R.id.editTextNumberReadingC2);
        finalUse = findViewById(R.id.editTextNumberUseC2);
        readingPart1 = findViewById(R.id.editTextNumberReadingPart1C2);
        readingPart2 = findViewById(R.id.editTextNumberReadingPart2C2);
        readingPart3 = findViewById(R.id.editTextNumberReadingPart3C2);
        readingPart4Half = findViewById(R.id.editTextNumberReadingPart4_1C2);
        readingPart4Full = findViewById(R.id.editTextNumberReadingPart4_2C2);
        readingPart5 = findViewById(R.id.editTextNumberReadingPart5C2);
        readingPart6 = findViewById(R.id.editTextNumberReadingPart6C2);
        readingPart7 = findViewById(R.id.editTextNumberReadingPart7C2);

        //Writing
        finalWriting = findViewById(R.id.editTextNumberWritingC2);
        writingPart1_1 = findViewById(R.id.editTextNumberWritingContent1C2);
        writingPart1_2 = findViewById(R.id.editTextNumberWritingOrganisation1C2);
        writingPart1_3 = findViewById(R.id.editTextNumberWritingLanguage1C2);
        writingPart1_4 = findViewById(R.id.editTextNumberWritingAchievement1C2);

        writingPart2_1 = findViewById(R.id.editTextNumberWritingContent2C2);
        writingPart2_2 = findViewById(R.id.editTextNumberWritingOrganisation2C2);
        writingPart2_3 = findViewById(R.id.editTextNumberWritingLanguage2C2);
        writingPart2_4 = findViewById(R.id.editTextNumberWritingAchievement2C2);

        //Listening
        finalListening = findViewById(R.id.editTextNumberListeningC2);
        listeningPart1 = findViewById(R.id.editTextNumberListeningPart1C2);
        listeningPart2 = findViewById(R.id.editTextNumberListeningPart2C2);
        listeningPart3 = findViewById(R.id.editTextNumberListeningPart3C2);
        listeningPart4 = findViewById(R.id.editTextNumberListeningPart4C2);

        //Speaking
        finalSpeaking = findViewById(R.id.editTextNumberSpeakingC2);
        speakingPart1 = findViewById(R.id.editTextNumberSpeakingGrammaticalResourceC2);
        speakingPart2 = findViewById(R.id.editTextNumberSpeakingLexicalResourceC2);
        speakingPart3 = findViewById(R.id.editTextNumberSpeakingPronunciationC2);
        speakingPart4 = findViewById(R.id.editTextNumberSpeakingInteractiveC2);
        speakingPart5 = findViewById(R.id.editTextNumberSpeakingDiscourseC2);
        speakingPart6 = findViewById(R.id.editTextNumberSpeakingGlobalC2);
    }

    public void showAd() {

        if (mInterstitialAd != null) {
            mInterstitialAd.show(ComplexConverter.this);

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