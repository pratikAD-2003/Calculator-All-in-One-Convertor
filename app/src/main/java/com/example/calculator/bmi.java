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

public class bmi extends AppCompatActivity {
    Button get_bmr_bmi;
    TextView condition, bmiAns;
    EditText weight_kg_bmi, height_cm_bmi, age_bmi;
    String BMI = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        get_bmr_bmi = findViewById(R.id.getBmr3);
        weight_kg_bmi = findViewById(R.id.weight_kg3);
        height_cm_bmi = findViewById(R.id.height_cm3);
        age_bmi = findViewById(R.id.age3);
        bmiAns = findViewById(R.id.bmiAns);
        condition = findViewById(R.id.condition);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewBmi);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        get_bmr_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w_kg = weight_kg_bmi.getText().toString();
                String h_cm = height_cm_bmi.getText().toString();
                String ag = age_bmi.getText().toString();
                float d = 0;
                if (w_kg.isEmpty() && h_cm.isEmpty() && ag.isEmpty()) {
                    Toast.makeText(bmi.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                } else {
                    float a = Float.parseFloat(w_kg);
                    float b = Float.parseFloat(h_cm);
                    float c = Float.parseFloat(ag);
                    BMI = String.valueOf((a / ((b * b)) * 10000));
                    bmiAns.setText(BMI.substring(0, 4) + " kg/m^2");
                    d = Float.parseFloat(BMI);
                }
                if (d == 0) {
                    condition.setText("");
                } else if (d < 16) {
                    condition.setText("Severe Thinness");
                } else if (d >= 16 && d <= 17) {
                    condition.setText("Moderate Thinness");
                } else if (d > 17 && d <= 18.5) {
                    condition.setText("Mild Thinness");
                } else if (d > 18.5 && d <= 25) {
                    condition.setText("Normal");
                } else if (d > 25 && d <= 30) {
                    condition.setText("Overweight");
                } else if (d > 30 && d <= 35) {
                    condition.setText("Obese Class |");
                } else if (d > 35 && d <= 40) {
                    condition.setText("Obese Class ||");
                } else if (d > 40) {
                    condition.setText("Obese Class |||");
                } else {
                    condition.setText("Overweight");
                }
            }
        });
    }
}