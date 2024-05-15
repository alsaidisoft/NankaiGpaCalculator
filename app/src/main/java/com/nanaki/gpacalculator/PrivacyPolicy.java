package com.nanaki.gpacalculator;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyPolicy extends AppCompatActivity {

    TextView content;
    public static final String fontSize = "MY_FONTSIZE";
    public static final String PREFS_NAME = "MY_LANGUAGE";
    String lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        setTitle(R.string.privacy_policy);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences l = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lang = l.getString("lang", "no");
        if(lang.equals("العربية"))
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        content = (TextView) findViewById(R.id.aboutTxt);
        SharedPreferences prefs = getSharedPreferences(fontSize, MODE_PRIVATE);
        String font = prefs.getString("fontSize", "no");
        switch (font){
            case "small":
                content.setTextSize(16);

                break;
            case "medium":
                content.setTextSize(20);

                break;
            case "big":
                content.setTextSize(24);

                break;
            case "bigger":
                content.setTextSize(28);

                break;


        }




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