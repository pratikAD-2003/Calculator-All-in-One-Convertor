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

public class discount extends AppCompatActivity {
    Button getDis;
    TextView save,per;
    String str,str2 = "";
    EditText org_price,dis_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        getDis = findViewById(R.id.getDiscount);
        org_price = findViewById(R.id.org_price);
        dis_price = findViewById(R.id.dis_price);
        save = findViewById(R.id.saved);
        per = findViewById(R.id.dis_per);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewDiscount);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        getDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = org_price.getText().toString();
                str2 = dis_price.getText().toString();

                if (str.isEmpty() && str2.isEmpty()){
                    Toast.makeText(discount.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                }
                else if(str.isEmpty()){
                    Toast.makeText(discount.this, "Please Fill Original Price", Toast.LENGTH_SHORT).show();
                }
                else if(str2.isEmpty()){
                    Toast.makeText(discount.this, "Please Fill Discount Price", Toast.LENGTH_SHORT).show();
                }
                else {
                    float a = Float.parseFloat(str);
                    float b = Float.parseFloat(str2);
                    String discount_percentage = "";
                    String you_saved = "";
                    discount_percentage = String.valueOf(((a - b) / a) * 100);
                    you_saved = String.valueOf((a - b));
                    save.setText("You Saved " + you_saved);
                    per.setText("Discount : " + discount_percentage + " %");
                }
            }
        });
    }
}