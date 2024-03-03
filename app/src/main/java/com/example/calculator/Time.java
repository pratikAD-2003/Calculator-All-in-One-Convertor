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

public class Time extends AppCompatActivity {
    ArrayList<String> spinnerText = new ArrayList<>();
    EditText convertTem_time;
    Spinner spinner_time, spinner2_time;
    String value1, value2, str;
    Button getTem_time;
    TextView timeAns;
    String ans = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        spinner_time = findViewById(R.id.spinner_time);
        spinner2_time = findViewById(R.id.spinner2_time);
        timeAns = findViewById(R.id.timeAns);
        getTem_time = findViewById(R.id.getTem_time);
        spinnerText.add("Year");
        spinnerText.add("Week");
        spinnerText.add("Day");
        spinnerText.add("Hour");
        spinnerText.add("Minute");
        spinnerText.add("Second");
        spinnerText.add("Millisecond");
        spinnerText.add("Microsecond");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewTime);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        convertTem_time = findViewById(R.id.convertTem_time);
        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerText);
        spinner_time.setAdapter(a);

        ArrayAdapter<String> b = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerText);
        spinner2_time.setAdapter(a);

        spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value1 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner2_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value2 = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getTem_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value1.equals("Year") && value2.equals("Month")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 12);
                    timeAns.setText(ans + " Months");
                } else if (value1.equals("Year") && value2.equals("Week")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(52 * ab);
                    timeAns.setText(ans + " Weeks");
                } else if (value1.equals("Year") && value2.equals("Day")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 365);
                    timeAns.setText(ans + " Days");
                } else if (value1.equals("Year") && value2.equals("Hour")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 8760));
                    timeAns.setText(ans + " Hours");
                } else if (value1.equals("Year") && value2.equals("Minute")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 525600);
                    timeAns.setText(ans + " Minutes");
                } else if (value1.equals("Year") && value2.equals("Second")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 31536000);
                    timeAns.setText(ans + " Seconds");
                } else if (value1.equals("Year") && value2.equals("Millisecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 3.15333);
                    timeAns.setText(ans + " Milliseconds");
                } else if (value1.equals("Year") && value2.equals("Microsecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 3.15333);
                    timeAns.setText(ans + " Microseconds");
                } else if (value1.equals("Week") && value2.equals("Day")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 7));
                    timeAns.setText(ans + " Days");
                } else if (value1.equals("Week") && value2.equals("Hour")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 168));
                    timeAns.setText(ans + " Hours");
                } else if (value1.equals("Week") && value2.equals("Minute")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 10080);
                    timeAns.setText(ans + " Minutes");
                } else if (value1.equals("Week") && value2.equals("Second")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 604800));
                    timeAns.setText(ans + " Seconds");
                } else if (value1.equals("Week") && value2.equals("Millisecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 604800000));
                    timeAns.setText(ans + " Milliseconds");
                } else if (value1.equals("Week") && value2.equals("Microsecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 604800000));
                    timeAns.setText(ans + " Microseconds");
                } else if (value1.equals("Day") && value2.equals("Hour")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 24));
                    timeAns.setText(ans + " Hours");
                } else if (value1.equals("Day") && value2.equals("Minute")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 1440));
                    timeAns.setText(ans + " Minutes");
                } else if (value1.equals("Day") && value2.equals("Second")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 86400));
                    timeAns.setText(ans + " Seconds");
                } else if (value1.equals("Day") && value2.equals("Millisecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 86400000));
                    timeAns.setText(ans + " Milliseconds");
                } else if (value1.equals("Day") && value2.equals("Microsecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 8.64000000));
                    timeAns.setText(ans + " Microseconds");
                } else if (value1.equals("Hour") && value2.equals("Minute")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 60));
                    timeAns.setText(ans + " Minutes");
                } else if (value1.equals("Hour") && value2.equals("Second")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3600));
                    timeAns.setText(ans + " Seconds");
                } else if (value1.equals("Hour") && value2.equals("Millisecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3600000));
                    timeAns.setText(ans + " Milliseconds");
                } else if (value1.equals("Hour") && value2.equals("Microsecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3.600000));
                    timeAns.setText(ans + " Microseconds");
                } else if (value1.equals("Minute") && value2.equals("Second")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 60));
                    timeAns.setText(ans + " Seconds");
                } else if (value1.equals("Minute") && value2.equals("Millisecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 60000));
                    timeAns.setText(ans + " Milliseconds");
                } else if (value1.equals("Minute") && value2.equals("Microsecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 60000000));
                    timeAns.setText(ans + " Microseconds");
                } else if (value1.equals("Second") && value2.equals("Millisecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 1000));
                    timeAns.setText(ans + " Milliseconds");
                } else if (value1.equals("Second") && value2.equals("Microsecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 1000000));
                    timeAns.setText(ans + " Microseconds");
                } else if (value1.equals("Millisecond") && value2.equals("Microsecond")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 1000));
                    timeAns.setText(ans + " Microseconds");
                } else if (value1.equals("Millisecond") && value2.equals("Year")) {
                    str = convertTem_time.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 31556952000L));
                    timeAns.setText(ans + " Year");
                } else if (str == null) {
                    Toast.makeText(Time.this, "Please Enter Any Input..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Time.this, "Invalid Conversion Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}