package com.nanaki.gpacalculator;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;


public class SplashActivity extends AppCompatActivity {

    public static final String Theme = "Theme";
    public static final String PREFS_NAME = "MY_LANGUAGE";
    String lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        SharedPreferences l = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lang = l.getString("lang", "no");
        switch (lang) {
            case "English":
                setLocale("en");
                break;
            case "中文":
                setLocale("zh");
                break;
            case "العربية":
                setLocale("ar");
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                break;
            default:
                setLocale("en");
                break;
        }
        SharedPreferences prefs = getSharedPreferences(Theme, MODE_PRIVATE);
        String check = prefs.getString("Theme", "no");


        if(check.equals("dark")){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        try {

            new Handler().postDelayed(new Runnable() {


                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    if(true) {
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }


                }
            }, 2000);
        }catch (Exception ex){
            System.out.println("-------->>>"+ex.getMessage());
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();

        }
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }



}