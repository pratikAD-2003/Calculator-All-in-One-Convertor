package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class temperature extends AppCompatActivity {
    ArrayList<String> spinnerText = new ArrayList<>();
    EditText convertTem;
    Spinner spinner,spinner2;
    String value1,value2,str;
    TextView tempAns;
    Button getTem;
    String ans = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        tempAns = findViewById(R.id.tempAns);
        getTem = findViewById(R.id.getTem);
        spinnerText.add("Celsius");
        spinnerText.add("Fahrenheit");
        spinnerText.add("Kelvin");
        convertTem = findViewById(R.id.convertTem);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewTemp);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        ArrayAdapter<String> a =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner.setAdapter(a);

        ArrayAdapter<String> b =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner2.setAdapter(a);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                 value1 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value2 = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getTem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value1.equals("Celsius") && value2.equals("Fahrenheit")){
                    str = convertTem.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1.8) + 32);
                    tempAns.setText(ans+" F");
                }
                else if (value1.equals("Fahrenheit") && value2.equals("Celsius")){
                    str = convertTem.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab - 32)*0.555);
                    tempAns.setText(ans.substring(0,4)+" C");
                }
                else if(value1.equals("Celsius") && value2.equals("Kelvin")){
                    str = convertTem.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab+273.15));
                    tempAns.setText(ans+" K");
                }
                else if(value1.equals("Kelvin") && value2.equals("Celsius")){
                    str = convertTem.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab - 273.15);
                    tempAns.setText(ans+" C");
                }
                else if(value1.equals("Fahrenheit") && value2.equals("Kelvin")){
                    str = convertTem.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab-32) *0.555 + 273.15);
                    tempAns.setText(ans+" K");
                }
                else if(value1.equals("Kelvin") && value2.equals("Fahrenheit")){
                    str = convertTem.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab - 273.15) * 1.8 + 32);
                    tempAns.setText(ans+" F");
                }
                else if(str==null){
                    Toast.makeText(temperature.this, "Please Enter Any Input..", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}