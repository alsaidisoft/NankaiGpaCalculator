package com.nanaki.gpacalculator;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class About extends AppCompatActivity {

    TextView version;
    TextView aboutTxt;
    public static final String fontSize = "MY_FONTSIZE";
    public static final String PREFS_NAME = "MY_LANGUAGE";
    String lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle(R.string.about);
        SharedPreferences l = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lang = l.getString("lang", "no");
        if(lang.equals("العربية")) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        version = (TextView) findViewById(R.id.version);
        aboutTxt = (TextView) findViewById(R.id.aboutTxt);
        SharedPreferences prefs = getSharedPreferences(fontSize, MODE_PRIVATE);
        String font = prefs.getString("fontSize", "no");
        switch (font){
            case "small":
                aboutTxt.setTextSize(16);

                break;
            case "medium":
                aboutTxt.setTextSize(20);

                break;
            case "big":
                aboutTxt.setTextSize(24);

                break;
            case "bigger":
                aboutTxt.setTextSize(28);

                break;


        }
        try{
            String versionName = getApplicationContext().getPackageManager()
                    .getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
            version.setText(getResources().getString(R.string.version)+" "+versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

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