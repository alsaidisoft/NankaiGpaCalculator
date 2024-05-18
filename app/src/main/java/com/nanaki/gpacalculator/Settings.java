package com.nanaki.gpacalculator;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    ListView listView;
    public static final String PREFS_NAME = "MY_LANGUAGE";
    String lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle(R.string.settings);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences l = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lang = l.getString("lang", "no");
        if(lang.equals("العربية"))
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        listView = (ListView) findViewById(R.id.listSettings);

        String[] settings = {getResources().getString(R.string.version)
        ,getResources().getString(R.string.font_size),getResources().getString(R.string.language),
                /*getResources().getString(R.string.dark_mode),*/getResources().getString(R.string.calculate_style),getResources().getString(R.string.privacy_policy)
        ,getResources().getString(R.string.send_to),getResources().getString(R.string.contact_us)};

        //int[] drawableIds = {R.mipmap.v, R.mipmap.ic_action_developers};

        int[] mimpamIds = { R.mipmap.ic_version,R.mipmap.ic_font,R.mipmap.ic_language,/*R.mipmap.ic_style,*/
                R.mipmap.ic_calculate_style,R.mipmap.ic_action_privacy_policy
        ,R.mipmap.ic_share,R.mipmap.ic_contact_us};

        CustomAdapter adapter = new CustomAdapter(this,  settings, mimpamIds);
        listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               switch (i) {

                   case 0:
                       try{
                           String versionName = getApplicationContext().getPackageManager()
                                   .getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
                           Toast.makeText(getApplicationContext(),getResources().getString(R.string.version)+" "+versionName,Toast.LENGTH_LONG).show();
                       } catch (PackageManager.NameNotFoundException e) {
                           e.printStackTrace();

                       }
                       break;

                   case 1:
                       Intent open = new Intent(Settings.this,FontSize.class);
                       open.setFlags(FLAG_ACTIVITY_NEW_TASK);
                       startActivity(open);
                       break;
                   case 2:
                       Intent lang = new Intent(Settings.this,Language.class);
                       lang.setFlags(FLAG_ACTIVITY_NEW_TASK);
                       startActivity(lang);
                       break;
                  /* case 3:
                       Intent openTheme = new Intent(Settings.this,ThemeStyle.class);
                       openTheme.setFlags(FLAG_ACTIVITY_NEW_TASK);
                       startActivity(openTheme);
                       break;*/
                   case 3:
                       Intent openCalculateStyle = new Intent(Settings.this,CalculateStyle.class);
                       openCalculateStyle.setFlags(FLAG_ACTIVITY_NEW_TASK);
                       startActivity(openCalculateStyle);
                       break;

                   case 4:
                       Intent privacy_policy = new Intent(Settings.this,PrivacyPolicy.class);
                       privacy_policy.setFlags(FLAG_ACTIVITY_NEW_TASK);
                       startActivity(privacy_policy);
                       break;

                   case 5:


                       Intent share = new Intent(Intent.ACTION_SEND);
                       String msg = "download our app GPA calculator of Nankai university for international students from google play store via: "+
                               "\n" +
                               "https://play.google.com/store/apps/details?id="+"com.nanaki.gpacalculator";
                       share.putExtra(Intent.EXTRA_TEXT, msg);
                       share.setType("text/plain");
                       startActivity(Intent.createChooser(share, getResources().getText(R.string.send_to)));

                       break;

                   case 6:
                       try {

                           Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                   "mailto", "saeed.alsaidi.developer@gmail.com", null));
                           emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject: ");
                           emailIntent.putExtra(Intent.EXTRA_TEXT, "Body: ");
                           startActivity(Intent.createChooser(emailIntent, getResources().getString(R.string.contact_us)));
                       } catch (Exception email) {
                           email.printStackTrace();
                       }

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