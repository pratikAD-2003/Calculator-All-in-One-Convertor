package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class massConverter extends AppCompatActivity {
    ArrayList<String> spinnerText = new ArrayList<>();
    EditText convertTem_mass;
    Spinner spinner_mass,spinner2_mass;
    String value1,value2,str;
    Button getTem_mass;
    TextView massAns;
    String ans = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_converter);
        spinner_mass = findViewById(R.id.spinner_mass);
        spinner2_mass = findViewById(R.id.spinner2_mass);
        massAns = findViewById(R.id.massAns);
        getTem_mass = findViewById(R.id.getTem_mass);
        spinnerText.add("Tonne");
        spinnerText.add("Kilogram");
        spinnerText.add("Gram");
        spinnerText.add("Milligram");
        spinnerText.add("Pound");
        spinnerText.add("Carat");
        spinnerText.add("Quintal");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewMassConverter);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        convertTem_mass = findViewById(R.id.convertTem_mass);
        ArrayAdapter<String> a =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner_mass.setAdapter(a);

        ArrayAdapter<String> b =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner2_mass.setAdapter(a);

        spinner_mass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value1 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner2_mass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value2 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getTem_mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value1.equals("Tonne") && value2.equals("Kilogram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*1000);
                    massAns.setText(ans+" Kg");
                }
                else if (value1.equals("Tonne") && value2.equals("Gram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*1000000);
                    massAns.setText(ans+" g");
                }
                else if (value1.equals("Tonne") && value2.equals("Quintal")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*10);
                    massAns.setText(ans+" q");
                }
                else if (value1.equals("Tonne") && value2.equals("Pound")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*2204.62262);
                    massAns.setText(ans+" lbs");
                }
                else if (value1.equals("Kilogram") && value2.equals("Tonne")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf( ab*0.001);
                    massAns.setText(ans +" t");
                }
                else if(value1.equals("Kilogram") && value2.equals("Gram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1000));
                    massAns.setText(ans+" g");
                }
                else if(value1.equals("Kilogram") && value2.equals("Milligram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*1000000);
                    massAns.setText(ans+" mg");
                }
                else if(value1.equals("Kilogram") && value2.equals("Pound")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*2.20462262);
                    massAns.setText(ans+" lbs");
                }
                else if(value1.equals("Kilogram") && value2.equals("Carat")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*5000);
                    massAns.setText(ans+" ct");
                }
                else if(value1.equals("Tonne") && value2.equals("Carat")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*5000000);
                    massAns.setText(ans+" ct");
                }
                else if(value1.equals("Gram") && value2.equals("Kilogram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.001));
                    massAns.setText(ans+" Kg");
                }
                else if(value1.equals("Gram") && value2.equals("Milligram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1000));
                    massAns.setText(ans+" mg");
                }
                else if(value1.equals("Gram") && value2.equals("Pound")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*0.00220462262);
                    massAns.setText(ans+" lbs");
                }
                else if(value1.equals("Gram") && value2.equals("Carat")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*5));
                    massAns.setText(ans+" ct");
                }
                else if(value1.equals("Milligram") && value2.equals("Gram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.001));
                    massAns.setText(ans+" g");
                }
                else if(value1.equals("Milligram") && value2.equals("Carat")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.005) );
                    massAns.setText(ans+" ct");
                }
                else if(value1.equals("Pound") && value2.equals("Kilogram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.45359237));
                    massAns.setText(ans+" Kg");
                }
                else if(value1.equals("Pound") && value2.equals("Gram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab *453.59237));
                    massAns.setText(ans+" g");
                }
                else if(value1.equals("Pound") && value2.equals("Carat")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*2267.96185));
                    massAns.setText(ans+" ct");
                }
                else if(value1.equals("Carat") && value2.equals("Kilogram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.0002));
                    massAns.setText(ans+" kg");
                }
                else if(value1.equals("Carat") && value2.equals("Gram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.2));
                    massAns.setText(ans+" g");
                }
                else if(value1.equals("Carat") && value2.equals("Milligram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*200));
                    massAns.setText(ans+" mg");
                }
                else if(value1.equals("Carat") && value2.equals("Pound")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.000440924524));
                    massAns.setText(ans+" lbs");
                }
                else if(value1.equals("Quintal") && value2.equals("Kilogram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*100));
                    massAns.setText(ans+" q");
                }
                else if(value1.equals("Quintal") && value2.equals("Tonne")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.1));
                    massAns.setText(ans+" q");
                }
                else if(value1.equals("Quintal") && value2.equals("Gram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*100000));
                    ans = String.valueOf((ab*100000));
                    massAns.setText(ans+" g");
                }
                else if(value1.equals("Quintal") && value2.equals("Pound")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*220.462262));
                    massAns.setText(ans+" lbs");
                }
                else if(value1.equals("Quintal") && value2.equals("Milligram")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*100000000));
                    massAns.setText(ans+" mg");
                }
                else if(value1.equals("Quintal") && value2.equals("Carat")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*50000));
                    massAns.setText(ans+" ct");
                }
                else if(value1.equals("Kilogram") && value2.equals("Quintal")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.01));
                    massAns.setText(ans+" q");
                }
                else if(value1.equals("Pound") && value2.equals("Quintal")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.0045359237));
                    massAns.setText(ans+" q");
                }
                else if(value1.equals("Pound") && value2.equals("Tonne")){
                    str = convertTem_mass.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.0045359237));
                    massAns.setText(ans+" q");
                }
                else if (str == null){
                    Toast.makeText(massConverter.this, "Please Enter Any Input..", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(massConverter.this, "Invalid Conversion Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}