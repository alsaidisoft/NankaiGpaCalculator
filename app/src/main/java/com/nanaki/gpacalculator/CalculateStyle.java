package com.nanaki.gpacalculator;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class CalculateStyle extends AppCompatActivity {


    //declaring local variables
    public RadioGroup radioGroup;
    public static final String Calculate_style = "Calculate_style";
   String cal;

    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_style);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
