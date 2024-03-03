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

public class length extends AppCompatActivity {
    ArrayList<String> spinnerText = new ArrayList<>();
    EditText convertTem_length;
    Spinner spinner_length,spinner2_length;
    String value1,value2,str;
    Button getTem_length;
    TextView lengthAns;
    String ans = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        spinner_length = findViewById(R.id.spinner_length);
        spinner2_length = findViewById(R.id.spinner2_length);
        lengthAns = findViewById(R.id.lengthAns);
        getTem_length = findViewById(R.id.getTem_length);
        spinnerText.add("Kilometer");
        spinnerText.add("Meter");
        spinnerText.add("Decimeter");
        spinnerText.add("Centimeter");
        spinnerText.add("Millimeter");
        spinnerText.add("Micrometer");
        spinnerText.add("Nanometer");
        spinnerText.add("Mile");
        spinnerText.add("Yard");
        spinnerText.add("Foot");
        spinnerText.add("Inch");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
//                Toast.makeText(bmr.this, " successful ", Toast.LENGTH_SHORT).show();
            }
        });
        AdView mAdView;
        mAdView = findViewById(R.id.adViewLength);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        convertTem_length = findViewById(R.id.convertTem_length);
        ArrayAdapter<String> a =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner_length.setAdapter(a);

        ArrayAdapter<String> b =new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinnerText);
        spinner2_length.setAdapter(a);

        spinner_length.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value1 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner2_length.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                value2 = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getTem_length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value1.equals("Kilometer") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1000);
                    lengthAns.setText(ans + " m");
                } else if (value1.equals("Kilometer") && value2.equals("Decimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(10000 * ab);
                    lengthAns.setText(ans + " dm");
                } else if (value1.equals("Kilometer") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 100000);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Kilometer") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 1000000));
                    lengthAns.setText(ans + " mm");
                }
                 else if (value1.equals("Kilometer") && value2.equals("Mile")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.621371192);
                    lengthAns.setText(ans + " mi");
                } else if (value1.equals("Kilometer") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab *1093.6133);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Kilometer") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3280.8399));
                    lengthAns.setText(ans + " ft");
                } else if (value1.equals("Kilometer") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 39370.0787));
                    lengthAns.setText(ans + " in");
                }
                else if (value1.equals("Meter") && value2.equals("Kilometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.001);
                    lengthAns.setText(ans + " km");
                } else if (value1.equals("Meter") && value2.equals("Decimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(10 * ab);
                    lengthAns.setText(ans + " dm");
                } else if (value1.equals("Meter") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab *100);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Meter") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 1000));
                    lengthAns.setText(ans + " mm");
                } else if (value1.equals("Meter") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1000000);
                    lengthAns.setText(ans + " um");
                } else if (value1.equals("Meter") && value2.equals("Mile")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.000621371192);
                    lengthAns.setText(ans + " mi");
                } else if (value1.equals("Meter") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1.0936133);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Meter") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3.2808399));
                    lengthAns.setText(ans + " ft");
                } else if (value1.equals("Meter") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 39.3700787));
                    lengthAns.setText(ans + " in");
                }

                else if (value1.equals("Decimeter") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.1);
                    lengthAns.setText(ans + " m");
                } else if (value1.equals("Decimeter") && value2.equals("Kilometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(0.0001 * ab);
                    lengthAns.setText(ans + " km");
                } else if (value1.equals("Decimeter") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 10);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Decimeter") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 100));
                    lengthAns.setText(ans + " mm");
                } else if (value1.equals("Decimeter") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 100000);
                    lengthAns.setText(ans + " um");
                } else if (value1.equals("Decimeter") && value2.equals("Nanometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 100000000);
                    lengthAns.setText(ans + " nm");
                } else if (value1.equals("Decimeter") && value2.equals("Mile")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 6.2137119222);
                    lengthAns.setText(ans + " mi");
                } else if (value1.equals("Decimeter") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.10936133);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Decimeter") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.32808399));
                    lengthAns.setText(ans + " ft");
                } else if (value1.equals("Decimeter") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3.93700787));
                    lengthAns.setText(ans + " in");
                }

                else if (value1.equals("Centimeter") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.01);
                    lengthAns.setText(ans + " m");
                }
                 else if (value1.equals("Centimeter") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 10));
                    lengthAns.setText(ans + " mm");
                } else if (value1.equals("Centimeter") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 10000);
                    lengthAns.setText(ans + " um");
                } else if (value1.equals("Centimeter") && value2.equals("Nanometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 100000000);
                    lengthAns.setText(ans + " nm");
                } else if (value1.equals("Centimeter") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.010936133);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Centimeter") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.032808399));
                    lengthAns.setText(ans + " ft");
                } else if (value1.equals("Centimeter") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.393700787));
                    lengthAns.setText(ans + " in");
                }

                else if (value1.equals("Millimeter") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.001);
                    lengthAns.setText(ans + " m");
                } else if (value1.equals("Millimeter") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.1);
                    lengthAns.setText(ans + " cm");
                }
                else if (value1.equals("Millimeter") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1000);
                    lengthAns.setText(ans + " um");
                } else if (value1.equals("Millimeter") && value2.equals("Nanometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1000000);
                    lengthAns.setText(ans + " nm");
                } else if (value1.equals("Millimeter") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.0010936133);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Millimeter") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.0032808399));
                    lengthAns.setText(ans + " ft");
                } else if (value1.equals("Millimeter") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.0393700787));
                    lengthAns.setText(ans + " in");
                }
                else if (value1.equals("Millimeter") && value2.equals("Decimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.01));
                    lengthAns.setText(ans + " in");
                }

                  else if (value1.equals("Micrometer") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.0001);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Micrometer") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.001));
                    lengthAns.setText(ans + " mm");
                }  else if (value1.equals("Micrometer") && value2.equals("Nanometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1000);
                    lengthAns.setText(ans + " nm");
                }


                  else if (value1.equals("Nanometer") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.001);
                    lengthAns.setText(ans + " um");
                }

                else if (value1.equals("Mile") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1609.344);
                    lengthAns.setText(ans + " m");
                }
                else if (value1.equals("Mile") && value2.equals("Decimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 16093.44);
                    lengthAns.setText(ans + " dm");
                }
                else if (value1.equals("Mile") && value2.equals("Kilometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(1.609344 * ab);
                    lengthAns.setText(ans + " km");
                } else if (value1.equals("Mile") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 160934.4);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Mile") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 1609344));
                    lengthAns.setText(ans + " mm");
                } else if (value1.equals("Mile") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 1760);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Mile") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 5280));
                    lengthAns.setText(ans + " ft");
                } else if (value1.equals("Mile") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 63360));
                    lengthAns.setText(ans + " in");
                }

                else if (value1.equals("Yard") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.9144);
                    lengthAns.setText(ans + " m");
                } else if (value1.equals("Yard") && value2.equals("Kilometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(0.0009144 * ab);
                    lengthAns.setText(ans + " km");
                } else if (value1.equals("Yard") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 91.44);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Yard") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 914.4));
                    lengthAns.setText(ans + " mm");
                } else if (value1.equals("Yard") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 914400);
                    lengthAns.setText(ans + " um");
                } else if (value1.equals("Yard") && value2.equals("Mile")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.000568181818);
                    lengthAns.setText(ans + " mi");
                } else if (value1.equals("Yard") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3));
                    lengthAns.setText(ans + " ft");
                } else if (value1.equals("Yard") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 36));
                    lengthAns.setText(ans + " in");
                }
                else if (value1.equals("Yard") && value2.equals("Decimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 9.144);
                    lengthAns.setText(ans + " dm");
                }

                else if (value1.equals("Foot") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.3048);
                    lengthAns.setText(ans + " m");
                } else if (value1.equals("Foot") && value2.equals("Kilometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(0.0003048 * ab);
                    lengthAns.setText(ans + " km");
                } else if (value1.equals("Foot") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 30.48);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Foot") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 304.8));
                    lengthAns.setText(ans + " mm");
                } else if (value1.equals("Foot") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 304800);
                    lengthAns.setText(ans + " um");
                } else if (value1.equals("Foot") && value2.equals("Mile")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.000189393939);
                    lengthAns.setText(ans + " mi");
                } else if (value1.equals("Foot") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.3333333);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Foot") && value2.equals("Decimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 3.048));
                    lengthAns.setText(ans + " dm");
                } else if (value1.equals("Foot") && value2.equals("Inch")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 12));
                    lengthAns.setText(ans + " in");
                }

                else if (value1.equals("Inch") && value2.equals("Meter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.0254);
                    lengthAns.setText(ans + " m");
                } else if (value1.equals("Inch") && value2.equals("Centimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 2.54);
                    lengthAns.setText(ans + " cm");
                } else if (value1.equals("Inch") && value2.equals("Millimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 25.4));
                    lengthAns.setText(ans + " mm");
                } else if (value1.equals("Inch") && value2.equals("Micrometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 25400);
                    lengthAns.setText(ans + " um");
                } else if (value1.equals("Inch") && value2.equals("Nanometer")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 25400000);
                    lengthAns.setText(ans + " nm");
                } else if (value1.equals("Inch") && value2.equals("Yard")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf(ab * 0.0277777778);
                    lengthAns.setText(ans + " yd");
                } else if (value1.equals("Inch") && value2.equals("Foot")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.083333333));
                    lengthAns.setText(ans + " ft");
                }
                else if (value1.equals("Inch") && value2.equals("Decimeter")) {
                    str = convertTem_length.getText().toString();
                    float ab = Float.parseFloat(str);
                    ans = String.valueOf((ab * 0.254));
                    lengthAns.setText(ans + " dm");
                }
                else if (str == null){
                    Toast.makeText(length.this, "Please Enter Any Input..", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(length.this, "Invalid Conversion Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}