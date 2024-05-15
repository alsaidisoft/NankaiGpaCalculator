package com.nanaki.gpacalculator;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class FontSize extends AppCompatActivity {

    TextView testTxt;
    RelativeLayout layout;
    TextView txt;
    //declaring local variables
    public RadioGroup radioGroup;
    public static final String PREFS_NAME = "MY_FONTSIZE";
    String fontSize;
    public static final String PREFS_NAME2 = "MY_LANGUAGE";
    String lang;

    RadioButton r1,r2,r3,r4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_size);
        setTitle(R.string.font_size);
        SharedPreferences l = getSharedPreferences(PREFS_NAME2, MODE_PRIVATE);
        lang = l.getString("lang", "no");
        layout = (RelativeLayout) findViewById(R.id.relative_font_size);
        if(lang.equals("العربية")) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            layout.setGravity(Gravity.LEFT);
        }
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //initializing variables
        radioGroup = (RadioGroup) findViewById(R.id.btngrp);
        testTxt = (TextView) findViewById(R.id.test_txt);
        txt = (TextView) findViewById(R.id.txt_font);

          r1 = (RadioButton) findViewById(R.id.small);
          r2 = (RadioButton) findViewById(R.id.medium);
          r3 = (RadioButton) findViewById(R.id.big);
          r4 = (RadioButton) findViewById(R.id.bigger);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        fontSize = prefs.getString("fontSize", "no");

        switch (fontSize) {
            case "small":
                r1.setChecked(true);
                testTxt.setTextSize(16);
                //r1.setButtonTintList(colorStateList);
                break;
            case "medium":
                r2.setChecked(true);
                testTxt.setTextSize(20);
                //r2.setButtonTintList(colorStateList);

                break;
            case "big":
                r3.setChecked(true);
                testTxt.setTextSize(24);
                //r3.setButtonTintList(colorStateList);

                break;

            case "bigger":
                testTxt.setTextSize(28);
                r4.setChecked(true);
                //r4.setButtonTintList(colorStateList);

                break;
            default:
                testTxt.setTextSize(16);
                r1.setChecked(true);
                //r1.setButtonTintList(colorStateList);

                break;
        }



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb = (RadioButton) findViewById(checkedId);

                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();


                switch (rb.getText().toString()) {

                    case "Small":
                        editor.putString("fontSize", "small");
                        editor.apply();
                        testTxt.setTextSize(16);
                        break;
                    case "Medium":
                        editor.putString("fontSize", "medium");
                        editor.apply();
                        testTxt.setTextSize(20);
                        break;
                    case "Big":
                        editor.putString("fontSize", "big");
                        editor.apply();
                        testTxt.setTextSize(24);
                        break;
                    case "Bigger":
                        editor.putString("fontSize", "bigger");
                        editor.apply();
                        testTxt.setTextSize(28);
                        break;

                    case "小":
                        editor.putString("fontSize", "small");
                        editor.apply();
                        testTxt.setTextSize(16);
                        break;
                    case "中等":
                        editor.putString("fontSize", "medium");
                        editor.apply();
                        testTxt.setTextSize(20);
                        break;
                    case "大":
                        editor.putString("fontSize", "big");
                        editor.apply();
                        testTxt.setTextSize(24);
                        break;
                    case "比所有都大":
                        editor.putString("fontSize", "bigger");
                        editor.apply();
                        testTxt.setTextSize(28);
                        break;

                    case "صغير":
                        editor.putString("fontSize", "small");
                        editor.apply();
                        testTxt.setTextSize(16);
                        break;
                    case "متوسط":
                        editor.putString("fontSize", "medium");
                        editor.apply();
                        testTxt.setTextSize(20);
                        break;
                    case "كبير":
                        editor.putString("fontSize", "big");
                        editor.apply();
                        testTxt.setTextSize(24);
                        break;
                    case "كبير جدا":
                        editor.putString("fontSize", "bigger");
                        editor.apply();
                        testTxt.setTextSize(28);
                        break;

                }

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }



}
