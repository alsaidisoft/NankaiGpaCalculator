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


public class Language extends AppCompatActivity {


    //declaring local variables
    public RadioGroup radioGroup;
    public static final String PREFS_NAME = "MY_LANGUAGE";
   String lang;
    RelativeLayout layout;

    RadioButton r1,r2,r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        setTitle(R.string.language);
        //ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences l = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        /*lang = l.getString("lang", "no");
        layout = (RelativeLayout) findViewById(R.id.relative_language);
        if(lang.equals("العربية")) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            layout.setGravity(Gravity.LEFT);

        }*/
        //initializing variables
        radioGroup = (RadioGroup) findViewById(R.id.btngrp);


            r1 = (RadioButton) findViewById(R.id.english);
            r2 = (RadioButton) findViewById(R.id.chinese);
            r3 = (RadioButton) findViewById(R.id.arabic);


        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lang = prefs.getString("lang", "no");

        switch (lang) {
            case "English":
                r1.setChecked(true);

                break;
            case "中文":
                r2.setChecked(true);
                break;
            case "العربية":
                r3.setChecked(true);
                break;

            default:
                r1.setChecked(true);

                break;
        }



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();


                switch (rb.getText().toString()) {

                    case "English":
                        setLocale("en");
                        editor.putString("lang", "English");
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        break;
                    case "中文":
                        setLocale("zh");
                        editor.putString("lang", "中文");
                        editor.apply();
                        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        finish();
                        break;
                    case "العربية":

                        setLocale("ar");
                        editor.putString("lang", "العربية");
                        editor.apply();
                        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        finish();
                        break;


                }

            }
        });

    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

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
