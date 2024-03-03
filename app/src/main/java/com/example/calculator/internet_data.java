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

public class internet_data extends AppCompatActivity {
    ArrayList<String> spinnerText = new ArrayList<>();
    EditText convertTem_data;
    Spinner spinner_data,spinner2_data;
    String value1,value2,str;
    TextView dataAns;
    Button getTem_data;
    String ans = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_data);
        spinner_data = findViewById(R.id.spinner_data);
        spinner2_data = findViewById(R.id.spinner2_data);
        dataAns = findViewById(R.id.dataAns);
        getTem_data = findViewById(R.id.getTem_data);
        spinnerText.add("Byte B");
        spinnerText.add("Kilobyte KB");
        spinnerText.add("Megabyte MB");
        spinnerText.add("Gigabyte GB");
        spinnerText.add("Terabyte TB");
        spinnerText.add("Petabyte PB");
        convertTem_data = findViewById(R.id.convertTem_data);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewData);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        ArrayAdapter<String> a =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner_data.setAdapter(a);

        ArrayAdapter<String> b =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner2_data.setAdapter(a);

        spinner_data.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value1 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner2_data.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value2 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getTem_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value1.equals("Byte B") && value2.equals("Kilobyte KB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*0.0009765625);
                    dataAns.setText(ans+" KB");
                }
                else if (value1.equals("Byte B") && value2.equals("Megabyte MB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*9.536743);
                    dataAns.setText(ans+" MB");
                }
                else if (value1.equals("Byte B") && value2.equals("Gigabyte GB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf( ab*9.31322575);
                    dataAns.setText(ans +" GB");
                }
                else if(value1.equals("Byte B") && value2.equals("Terabyte TB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*9.094994));
                    dataAns.setText(ans+" TB");
                }
                else if(value1.equals("Byte B") && value2.equals("Petabyte PB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*8.8817842);
                    dataAns.setText(ans+" PB");
                }
                else if(value1.equals("Kilobyte KB") && value2.equals("Byte B")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*1024);
                    dataAns.setText(ans+" B");
                }
                else if(value1.equals("Kilobyte KB") && value2.equals("Megabyte MB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*0.0009765625);
                    dataAns.setText(ans+" MB");
                }
                else if(value1.equals("Kilobyte KB") && value2.equals("Gigabyte GB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*9.53674316);
                    dataAns.setText(ans+" GB");
                }
                else if(value1.equals("Kilobyte KB") && value2.equals("Terabyte TB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*9.31322575));
                    dataAns.setText(ans+" TB");
                }
                else if(value1.equals("Kilobyte KB") && value2.equals("Petabyte PB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*9.09494702));
                    dataAns.setText(ans+" PB");
                }
                else if(value1.equals("Megabyte MB") && value2.equals("Byte B")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab*1048576);
                    dataAns.setText(ans+" B");
                }
                else if(value1.equals("Megabyte MB") && value2.equals("Kilobyte KB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1024));
                    dataAns.setText(ans+" KB");
                }
                else if(value1.equals("Megabyte MB") && value2.equals("Gigabyte GB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.0009765625));
                    dataAns.setText(ans+" GB");
                }
                else if(value1.equals("Megabyte MB") && value2.equals("Terabyte TB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*9.536743316) );
                    dataAns.setText(ans+" TB");
                }
                else if(value1.equals("Megabyte MB") && value2.equals("Petabyte PB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*9.31322575));
                    dataAns.setText(ans+" PB");
                }
                else if(value1.equals("Gigabyte GB") && value2.equals("Byte B")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab *1.07374182));
                    dataAns.setText(ans+" B");
                }
                else if(value1.equals("Gigabyte GB") && value2.equals("Kilobyte KB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1048576));
                    dataAns.setText(ans+" KB");
                }
                else if(value1.equals("Gigabyte GB") && value2.equals("Megabyte MB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1024));
                    dataAns.setText(ans+" MB");
                }
                else if(value1.equals("Gigabyte GB") && value2.equals("Terabyte TB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.0009765625));
                    dataAns.setText(ans+" TB");
                }
                else if(value1.equals("Gigabyte GB") && value2.equals("Petabyte PB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*9.53674316));
                    dataAns.setText(ans+" PB");
                }
                else if(value1.equals("Terabyte TB") && value2.equals("Byte B")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1.09951163));
                    dataAns.setText(ans+" B");
                }
                else if(value1.equals("Terabyte TB") && value2.equals("Kilobyte B")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1.07374182));
                    dataAns.setText(ans+" KB");
                }
                else if(value1.equals("Terabyte TB") && value2.equals("Megabyte MB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1048576));
                    dataAns.setText(ans+" MB");
                }
                else if(value1.equals("Terabyte TB") && value2.equals("Kilobyte KB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1.0737418299));
                    dataAns.setText(ans+" MB");
                }
                else if(value1.equals("Terabyte TB") && value2.equals("Gigabyte GB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1024));
                    dataAns.setText(ans+" GB");
                }
                else if(value1.equals("Terabyte TB") && value2.equals("Petabyte PB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*0.0009765625));
                    dataAns.setText(ans+" PB");
                }
                else if(value1.equals("Petabyte PB") && value2.equals("Byte B")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1.12529991));
                    dataAns.setText(ans+" B");
                }
                else if(value1.equals("Petabyte PB") && value2.equals("Kilobyte KB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1.09951163));
                    dataAns.setText(ans+" KB");
                }
                else if(value1.equals("Petabyte PB") && value2.equals("Megabyte MB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1.07374182));
                    dataAns.setText(ans+" MB");
                }
                else if(value1.equals("Petabyte PB") && value2.equals("Gigabyte GB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1048576));
                    dataAns.setText(ans+" GB");
                }
                else if(value1.equals("Petabyte PB") && value2.equals("Terabyte TB")){
                    str = convertTem_data.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab*1024));
                    dataAns.setText(ans+" TB");
                }
                else if (str == null){
                    Toast.makeText(internet_data.this, "Please Enter Any Input..", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(internet_data.this, "Invalid Conversion Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}