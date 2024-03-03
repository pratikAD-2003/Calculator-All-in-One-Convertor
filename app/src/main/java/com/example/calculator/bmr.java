package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class bmr extends AppCompatActivity {
    Button get_bmr;
    TextView bmrAns;
    EditText weight_kg, height_cm, age;
    String BMR = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        get_bmr = findViewById(R.id.getBmr);
        weight_kg = findViewById(R.id.weight_kg);
        height_cm = findViewById(R.id.height_cm);
        age = findViewById(R.id.age);
        bmrAns = findViewById(R.id.bmrAns);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewBmr);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        get_bmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w_kg = weight_kg.getText().toString();
                String h_cm = height_cm.getText().toString();
                String ag = age.getText().toString();
                if (w_kg.isEmpty() && h_cm.isEmpty() && ag.isEmpty()) {
                    Toast.makeText(bmr.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                } else {
                    float a = Float.parseFloat(w_kg);
                    float b = Float.parseFloat(h_cm);
                    float c = Float.parseFloat(ag);
                    BMR = String.valueOf(((10 * a) + ((6.25) * b) - (5 * c) + 5));
                    bmrAns.setText(BMR.substring(0, BMR.length()) + " Calories/day");
                }
            }
        });
    }
}