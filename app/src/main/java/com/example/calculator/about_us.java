package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class about_us extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        textView = findViewById(R.id.textID);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewUs);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textView.setText("BMI -> The body mass index (BMI) is a measure that uses your height and weight to work out if your weight is healthy." +
                " The BMI calculation divides an adult's weight in kilograms by their height in metres squared." +
                "\n\nBMR -> The BMR refers to the amount of energy your body needs to maintain homeostasis(state of steady internal, physical, chemical, and social conditions maintained by living systems).(from google)" +
                "Owner - Pratik Yadav\n" +
                "County - INDIA\n\n"+"\tSource ~ Google.");
    }
}