package com.nanaki.gpacalculator;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class CalculateStyle extends AppCompatActivity {


    //declaring local variables
    public RadioGroup radioGroup;
    public static final String Calculate_style = "Calculate_style";
   String cal;
    public static final String PREFS_NAME = "MY_LANGUAGE";
    String lang;
    RadioButton r1,r2;
    RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_style);
        setTitle(R.string.calculate_style);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences l = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lang = l.getString("lang", "no");
        layout = (RelativeLayout) findViewById(R.id.relative_calculate_style);
        if(lang.equals("العربية")) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            layout.setGravity(Gravity.LEFT);
        }
        //initializing variables
        radioGroup = (RadioGroup) findViewById(R.id.btngrp);


          r1 = (RadioButton) findViewById(R.id.us);
          r2 = (RadioButton) findViewById(R.id.global);


        SharedPreferences prefs = getSharedPreferences(Calculate_style, MODE_PRIVATE);
        cal = prefs.getString("calc_style", "no");

        switch (cal) {
            case "US":
                r1.setChecked(true);

                break;
            case "Global":
                r2.setChecked(true);
                break;

            default:
                r1.setChecked(true);
                break;
        }



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                SharedPreferences.Editor editor = getSharedPreferences(Calculate_style, MODE_PRIVATE).edit();


                switch (rb.getText().toString()) {

                    case "US":

                        editor.putString("calc_style", "US");
                        editor.apply();

                        break;
                    case "Global":
                        editor.putString("calc_style", "Global");
                        editor.apply();

                        break;

                    case "الأمريكي":

                        editor.putString("calc_style", "US");
                        editor.apply();

                        break;
                    case "العالمي":
                        editor.putString("calc_style", "Global");
                        editor.apply();

                        break;

                    case "美國":

                        editor.putString("calc_style", "US");
                        editor.apply();

                        break;
                    case "全球":
                        editor.putString("calc_style", "Global");
                        editor.apply();

                        break;


                }

            }
        });

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }



}
