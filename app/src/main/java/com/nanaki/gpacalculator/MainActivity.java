package com.nanaki.gpacalculator;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6;
    TextView gpa,developers,about,settings,rate_us,log_out;
    public static final String fontSize = "MY_FONTSIZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpa =(TextView)findViewById(R.id.calculate);
        developers = (TextView)findViewById(R.id.developers);
        about = (TextView)findViewById(R.id.about);
        settings = (TextView)findViewById(R.id.settings);
        rate_us = (TextView)findViewById(R.id.rate_us);
        log_out = (TextView)findViewById(R.id.log_out);
        SharedPreferences prefs = getSharedPreferences(fontSize, MODE_PRIVATE);
        String font = prefs.getString("fontSize", "no");
        switch (font){
            case "small":
                gpa.setTextSize(16);
                developers.setTextSize(16);
                about.setTextSize(16);
                settings.setTextSize(16);
                rate_us.setTextSize(16);
                log_out.setTextSize(16);
                break;
            case "medium":
                gpa.setTextSize(20);
                developers.setTextSize(20);
                about.setTextSize(20);
                settings.setTextSize(20);
                rate_us.setTextSize(20);
                log_out.setTextSize(20);
                break;
            case "big":
                gpa.setTextSize(24);
                developers.setTextSize(24);
                about.setTextSize(24);
                settings.setTextSize(24);
                rate_us.setTextSize(24);
                log_out.setTextSize(24);
                break;
            case "bigger":
                gpa.setTextSize(28);
                developers.setTextSize(28);
                about.setTextSize(28);
                settings.setTextSize(28);
                rate_us.setTextSize(28);
                log_out.setTextSize(28);
                break;

        }
        c1=(CardView) findViewById(R.id.card1);
        c2=(CardView) findViewById(R.id.card2);
        c3=(CardView) findViewById(R.id.card3);
        c4=(CardView) findViewById(R.id.card4);
        c5=(CardView) findViewById(R.id.card5);
        c6=(CardView) findViewById(R.id.card6);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle(R.string.choose_num_of_course);
                String[] types = {"1", "2","3","4","5","6","7","8","9","10"};
                b.setItems(types, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();

                        Intent open = new Intent(MainActivity.this,Gpa.class);
                        open.setFlags(FLAG_ACTIVITY_NEW_TASK);
                        int course = which+1;
                        open.putExtra("Courses",course+"");
                        startActivity(open);


                    }

                });

                b.show();
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);// set title
                alertDialogBuilder.setTitle(R.string.developers);
                // set dialog message
                int mImage = R.mipmap.ic_action_developers;
                alertDialogBuilder.setIcon(mImage);
                alertDialogBuilder.setMessage(getResources().getString(R.string.app_dev))
                .setCancelable(false)
                .setNegativeButton(R.string.ok,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        // if this button is clicked, close
                        // current activity
                        dialog.cancel();

                    }
                });

                // create alert dialog
                AlertDialog alertDialog=alertDialogBuilder.create();

                // show it
                alertDialog.show();



            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(MainActivity.this,About.class);
                open.setFlags(FLAG_ACTIVITY_NEW_TASK);
                startActivity(open);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(MainActivity.this, Settings.class);
                open.setFlags(FLAG_ACTIVITY_NEW_TASK);
                startActivity(open);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + PACKAGE_NAME));
                startActivity(intent);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
                System.exit(0);
            }
        });
    }
}