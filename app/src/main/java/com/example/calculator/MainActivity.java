package com.example.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
    TextView finalAns, Solving;
    String data;
    ImageButton OtherCal;

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Menu myMenu;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, zero, doubleZero, addition, multiply, sub, percentage, decimal, divide, equal, allClear, deleteOne;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finalAns = findViewById(R.id.finalAns);
        Solving = findViewById(R.id.Solving);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        zero = findViewById(R.id.zero);
        doubleZero = findViewById(R.id.doubleZero);
        addition = findViewById(R.id.addition);
        multiply = findViewById(R.id.multiply);
        sub = findViewById(R.id.subtract);
        percentage = findViewById(R.id.percentage);
        decimal = findViewById(R.id.decimal);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        allClear = findViewById(R.id.allClear);
        deleteOne = findViewById(R.id.oneDelete);
        OtherCal = findViewById(R.id.other);

        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationDrawer);
        drawerLayout = findViewById(R.id.drawerLayout);

        myMenu = navigationView.getMenu();
//        myMenu.getItem(9).setVisible(true);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation, R.string.close_navigation);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        SharedPreferences sp = getSharedPreferences("Stored_Ans", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.op_1) {
                    startActivity(new Intent(getApplicationContext(), bmi.class));
                } else if (id == R.id.bmr_op) {
                    startActivity(new Intent(getApplicationContext(), bmr.class));
                } else if (id == R.id.wbmr_op) {
                    startActivity(new Intent(getApplicationContext(), wbmr.class));
                } else if (id == R.id.discount_op) {
                    startActivity(new Intent(getApplicationContext(), discount.class));
                } else if (id == R.id.temperature_op) {
                    startActivity(new Intent(getApplicationContext(), temperature.class));
                } else if (id == R.id.time_op) {
                    startActivity(new Intent(getApplicationContext(), Time.class));
                } else if (id == R.id.length_op) {
                    startActivity(new Intent(getApplicationContext(), length.class));
                } else if (id == R.id.mass_op) {
                    startActivity(new Intent(getApplicationContext(), massConverter.class));
                } else if (id == R.id.data_op) {
                    startActivity(new Intent(getApplicationContext(), internet_data.class));
                } else if (id == R.id.About_op) {
                    startActivity(new Intent(getApplicationContext(), about_us.class));
                } else if (id == R.id.share_op) {
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.putExtra(Intent.EXTRA_TEXT, "Hii This is my first app");
                    startActivity(Intent.createChooser(share, "Select App To Share Calculator - A Safe Locker!"));
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "1");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "2");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "3");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "4");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "5");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "6");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "7");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "8");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "9");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "0");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        doubleZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "00");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "+");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "-");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "×");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "÷");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + "%");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                Solving.setText(data + ".");
                cal();
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });
        allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalAns.setText("");
                Solving.setText("");
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });

        deleteOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = Solving.getText().toString();
                if (data != null && data.length() > 0) {
                    data = data.substring(0, data.length() - 1);
                    Solving.setText(data);
                    cal();
                    editor.putString("calculation", finalAns.getText().toString());
                    editor.putString("answer", Solving.getText().toString());
                    editor.apply();
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Solving.setText(finalAns.getText().toString());
                finalAns.setText("");
                editor.putString("calculation", finalAns.getText().toString());
                editor.putString("answer", Solving.getText().toString());
                editor.apply();
            }
        });


    }

    public void cal() {
        data = Solving.getText().toString();

        data = data.replaceAll("×", "*");
        data = data.replaceAll("%", "/100");
        data = data.replaceAll("÷", "/");

        Context rhino = Context.enter();
        String store_final_ans = "";
        rhino.setOptimizationLevel(-1);

        if (!data.equals("")) {
            try {
                Scriptable scriptable = rhino.initSafeStandardObjects();
                store_final_ans = rhino.evaluateString(scriptable, data, "javascript", 1, null).toString();
                finalAns.setText(store_final_ans);
            } catch (Exception e) {
                store_final_ans = "0";
                finalAns.setText(store_final_ans);
            }
        } else {
            finalAns.setText("");
            Solving.setText("");
        }
    }

    @Override
    protected void onStart() {
        SharedPreferences sp = getSharedPreferences("Stored_Ans", MODE_PRIVATE);
        finalAns.setText(sp.getString("calculation", " "));
        Solving.setText(sp.getString("answer", " "));
        super.onStart();
    }
}