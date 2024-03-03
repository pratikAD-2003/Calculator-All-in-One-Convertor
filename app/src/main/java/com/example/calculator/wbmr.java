package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

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

public class wbmr extends AppCompatActivity {
    Button get_bmr2;
    EditText weight_kg2,height_cm2,age2;
    TextView wbmrAns;
    String wBMR = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wbmr);
        get_bmr2 = findViewById(R.id.getBmr2);
        weight_kg2 = findViewById(R.id.weight_kg2);
        height_cm2 = findViewById(R.id.height_cm2);
        age2 = findViewById(R.id.age2);
        wbmrAns = findViewById(R.id.wbmrAns);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewWBmr);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        get_bmr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w_kg = weight_kg2.getText().toString();
                String h_cm = height_cm2.getText().toString();
                String ag = age2.getText().toString();
                if (w_kg.isEmpty() && h_cm.isEmpty() && ag.isEmpty()) {
                    Toast.makeText(wbmr.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    float a = Float.parseFloat(w_kg);
                    float b = Float.parseFloat(h_cm);
                    float c = Float.parseFloat(ag);
                    wBMR = String.valueOf(((10 * a) + ((6.25) * b) - (5 * c) + 5) - 161);
                    wbmrAns.setText(wBMR.substring(0, wBMR.length()) + " Calories/day");
                }
            }
        });

    }
}