package com.nanaki.gpacalculator;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ThemeStyle extends AppCompatActivity {

    Switch aSwitch;
    TextView txt;
    public static final String Theme = "Theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        aSwitch =(Switch)this.findViewById(R.id.switch1);
        txt = (TextView)this.findViewById(R.id.switchtext);
        SharedPreferences prefs = getSharedPreferences(Theme, MODE_PRIVATE);
        String check = prefs.getString("Theme", "no");

        if(check.equals("dark")){
            txt.setText(getResources().getString(R.string.change_to_light));
            aSwitch.setChecked(true);
        }
        else{
            txt.setText(getResources().getString(R.string.change_to_dark));
            aSwitch.setChecked(false);

        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    //setTheme(com.google.android.material.R.style.Base_Theme_Material3_Dark);

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    txt.setText(getResources().getString(R.string.change_to_light));
                    SharedPreferences.Editor editor = getSharedPreferences(Theme, MODE_PRIVATE).edit();
                    editor.putString("Theme", "dark");
                    editor.apply();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    txt.setText(getResources().getString(R.string.change_to_dark));
                    SharedPreferences.Editor editor = getSharedPreferences(Theme, MODE_PRIVATE).edit();
                    editor.putString("Theme", "light");
                    editor.apply();
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