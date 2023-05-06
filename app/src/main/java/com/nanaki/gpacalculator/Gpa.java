package com.nanaki.gpacalculator;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Gpa extends AppCompatActivity {

    public static final String Calculate_style = "Calculate_style";
    String cal;
    EditText mark1,credit1,mark2,credit2,mark3,credit3,mark4,credit4,mark5,credit5,mark6,
            credit6,mark7,credit7,mark8,credit8,mark9,credit9,mark10,credit10;
    RelativeLayout r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculate);

        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences prefs = getSharedPreferences(Calculate_style, MODE_PRIVATE);
        cal = prefs.getString("calc_style", "no");

        Bundle bundle = getIntent().getExtras();
        final String courses = bundle.getString("Courses");
        int course = Integer.parseInt(courses);
        Toast.makeText(getApplicationContext(),getResources().getString(R.string.num_course)+" " +courses,Toast.LENGTH_LONG).show();
        btn = (Button) findViewById(R.id.gpaCal);
        mark1 = (EditText) findViewById(R.id.mark1);
        credit1 = (EditText) findViewById(R.id.crid1);
        mark2 = (EditText) findViewById(R.id.mark2);
        credit2 = (EditText) findViewById(R.id.crid2);
        mark3 = (EditText) findViewById(R.id.mark3);
        credit3 = (EditText) findViewById(R.id.crid3);
        mark4 = (EditText) findViewById(R.id.mark4);
        credit4 = (EditText) findViewById(R.id.crid4);
        mark5 = (EditText) findViewById(R.id.mark5);
        credit5 = (EditText) findViewById(R.id.crid5);
        mark6 = (EditText) findViewById(R.id.mark6);
        credit6 = (EditText) findViewById(R.id.crid6);
        mark7 = (EditText) findViewById(R.id.mark7);
        credit7 = (EditText) findViewById(R.id.crid7);
        mark8 = (EditText) findViewById(R.id.mark8);
        credit8 = (EditText) findViewById(R.id.crid8);
        mark9 = (EditText) findViewById(R.id.mark9);
        credit9 = (EditText) findViewById(R.id.crid9);
        mark10 = (EditText) findViewById(R.id.mark10);
        credit10 = (EditText) findViewById(R.id.crid10);

        mark1.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit1.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark2.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit2.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark3.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit3.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark4.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit4.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark5.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit5.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark6.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit6.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark7.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit7.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark8.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit8.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark9.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit9.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});
        mark10.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});
        credit10.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4")});

        r1 = (RelativeLayout)findViewById(R.id.rl1);
        r2 = (RelativeLayout)findViewById(R.id.rl2);
        r3 = (RelativeLayout)findViewById(R.id.rl3);
        r4 = (RelativeLayout)findViewById(R.id.rl4);
        r5 = (RelativeLayout)findViewById(R.id.rl5);
        r6 = (RelativeLayout)findViewById(R.id.rl6);
        r7 = (RelativeLayout)findViewById(R.id.rl7);
        r8 = (RelativeLayout)findViewById(R.id.rl8);
        r9 = (RelativeLayout)findViewById(R.id.rl9);
        r10 = (RelativeLayout)findViewById(R.id.rl10);

        switch (course) {
            case 1:
                r2.setVisibility(View.GONE);
                r3.setVisibility(View.GONE);
                r4.setVisibility(View.GONE);
                r5.setVisibility(View.GONE);
                r6.setVisibility(View.GONE);
                r7.setVisibility(View.GONE);
                r8.setVisibility(View.GONE);
                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;

            case 2:
                r3.setVisibility(View.GONE);
                r4.setVisibility(View.GONE);
                r5.setVisibility(View.GONE);
                r6.setVisibility(View.GONE);
                r7.setVisibility(View.GONE);
                r8.setVisibility(View.GONE);
                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;
            case 3:

                r4.setVisibility(View.GONE);
                r5.setVisibility(View.GONE);
                r6.setVisibility(View.GONE);
                r7.setVisibility(View.GONE);
                r8.setVisibility(View.GONE);
                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;
            case 4:


                r5.setVisibility(View.GONE);
                r6.setVisibility(View.GONE);
                r7.setVisibility(View.GONE);
                r8.setVisibility(View.GONE);
                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;
            case 5:


                r6.setVisibility(View.GONE);
                r7.setVisibility(View.GONE);
                r8.setVisibility(View.GONE);
                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;
            case 6:


                r7.setVisibility(View.GONE);
                r8.setVisibility(View.GONE);
                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;
            case 7:

                r8.setVisibility(View.GONE);
                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;
            case 8:

                r9.setVisibility(View.GONE);
                r10.setVisibility(View.GONE);
                break;
            case 9:

                r10.setVisibility(View.GONE);
                break;
            case 10:
                break;

            default:
                Toast.makeText(getApplicationContext(),"There is error, try again!",Toast.LENGTH_LONG).show();
                break;


        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                double c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
                double m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;
                double t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
                double result,credits_marks,credits;
                switch (course){

                    case 1:
                        if(!isEmpty(mark1) && !isEmpty(credit1)) {
                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            t1 = c1 * m1;
                            credits_marks = t1;
                            credits = c1;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 2:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            credits = c1+c2;
                            credits_marks = t1+t2;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        } else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 3:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            credits = c1+c2+c3;
                            credits_marks = t1+t2+t3;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 4:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3) && !isEmpty(mark4) && !isEmpty(credit4)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            m4 = getUsGPA(Double.parseDouble(mark4.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());
                            c4 = Double.parseDouble(credit4.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            t4 = c4 * m4;
                            credits = c1+c2+c3+c4;
                            credits_marks = t1+t2+t3+t4;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 5:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3) && !isEmpty(mark4) && !isEmpty(credit4)
                                && !isEmpty(mark5) && !isEmpty(credit5)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            m4 = getUsGPA(Double.parseDouble(mark4.getText().toString()));
                            m5 = getUsGPA(Double.parseDouble(mark5.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());
                            c4 = Double.parseDouble(credit4.getText().toString());
                            c5 = Double.parseDouble(credit5.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            t4 = c4 * m4;
                            t5 = c5 * m5;
                            credits = c1+c2+c3+c4+c5;
                            credits_marks = t1+t2+t3+t4+t5;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 6:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3) && !isEmpty(mark4) && !isEmpty(credit4)
                                && !isEmpty(mark5) && !isEmpty(credit5)  && !isEmpty(mark6) && !isEmpty(credit6)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            m4 = getUsGPA(Double.parseDouble(mark4.getText().toString()));
                            m5 = getUsGPA(Double.parseDouble(mark5.getText().toString()));
                            m6 = getUsGPA(Double.parseDouble(mark6.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());
                            c4 = Double.parseDouble(credit4.getText().toString());
                            c5 = Double.parseDouble(credit5.getText().toString());
                            c6 = Double.parseDouble(credit6.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            t4 = c4 * m4;
                            t5 = c5 * m5;
                            t6 = c6 * m6;
                            credits = c1+c2+c3+c4+c5+c6;
                            credits_marks = t1+t2+t3+t4+t5+t6;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        } else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 7:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3) && !isEmpty(mark4) && !isEmpty(credit4)
                                && !isEmpty(mark5) && !isEmpty(credit5)  && !isEmpty(mark6) && !isEmpty(credit6)
                                && !isEmpty(mark7) && !isEmpty(credit7)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            m4 = getUsGPA(Double.parseDouble(mark4.getText().toString()));
                            m5 = getUsGPA(Double.parseDouble(mark5.getText().toString()));
                            m6 = getUsGPA(Double.parseDouble(mark6.getText().toString()));
                            m7 = getUsGPA(Double.parseDouble(mark7.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());
                            c4 = Double.parseDouble(credit4.getText().toString());
                            c5 = Double.parseDouble(credit5.getText().toString());
                            c6 = Double.parseDouble(credit6.getText().toString());
                            c7 = Double.parseDouble(credit7.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            t4 = c4 * m4;
                            t5 = c5 * m5;
                            t6 = c6 * m6;
                            t7 = c7 * m7;
                            credits = c1+c2+c3+c4+c5+c6+c7;
                            credits_marks = t1+t2+t3+t4+t5+t6+t7;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        } else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 8:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3)&& !isEmpty(mark4) && !isEmpty(credit4)
                                && !isEmpty(mark5) && !isEmpty(credit5)  && !isEmpty(mark6) && !isEmpty(credit6)
                                && !isEmpty(mark7) && !isEmpty(credit7) && !isEmpty(mark8) && !isEmpty(credit8)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            m4 = getUsGPA(Double.parseDouble(mark4.getText().toString()));
                            m5 = getUsGPA(Double.parseDouble(mark5.getText().toString()));
                            m6 = getUsGPA(Double.parseDouble(mark6.getText().toString()));
                            m7 = getUsGPA(Double.parseDouble(mark7.getText().toString()));
                            m8 = getUsGPA(Double.parseDouble(mark8.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());
                            c4 = Double.parseDouble(credit4.getText().toString());
                            c5 = Double.parseDouble(credit5.getText().toString());
                            c6 = Double.parseDouble(credit6.getText().toString());
                            c7 = Double.parseDouble(credit7.getText().toString());
                            c8 = Double.parseDouble(credit8.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            t4 = c4 * m4;
                            t5 = c5 * m5;
                            t6 = c6 * m6;
                            t7 = c7 * m7;
                            t8 = c8 * m8;
                            credits = c1+c2+c3+c4+c5+c6+c7+c8;
                            credits_marks = t1+t2+t3+t4+t5+t6+t7+t8;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        } else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 9:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3)&& !isEmpty(mark4) && !isEmpty(credit4)
                                && !isEmpty(mark5) && !isEmpty(credit5)  && !isEmpty(mark6) && !isEmpty(credit6)
                                && !isEmpty(mark7) && !isEmpty(credit7) && !isEmpty(mark8) && !isEmpty(credit8)
                                && !isEmpty(mark9) && !isEmpty(credit9)) {

                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            m4 = getUsGPA(Double.parseDouble(mark4.getText().toString()));
                            m5 = getUsGPA(Double.parseDouble(mark5.getText().toString()));
                            m6 = getUsGPA(Double.parseDouble(mark6.getText().toString()));
                            m7 = getUsGPA(Double.parseDouble(mark7.getText().toString()));
                            m8 = getUsGPA(Double.parseDouble(mark8.getText().toString()));
                            m9 = getUsGPA(Double.parseDouble(mark9.getText().toString()));
                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());
                            c4 = Double.parseDouble(credit4.getText().toString());
                            c5 = Double.parseDouble(credit5.getText().toString());
                            c6 = Double.parseDouble(credit6.getText().toString());
                            c7 = Double.parseDouble(credit7.getText().toString());
                            c8 = Double.parseDouble(credit8.getText().toString());
                            c9 = Double.parseDouble(credit9.getText().toString());

                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            t4 = c4 * m4;
                            t5 = c5 * m5;
                            t6 = c6 * m6;
                            t7 = c7 * m7;
                            t8 = c8 * m8;
                            t9 = c9 * m9;
                            credits = c1+c2+c3+c4+c5+c6+c7+c8+c9;
                            credits_marks = t1+t2+t3+t4+t5+t6+t7+t8+t9;
                            result = credits_marks / credits;
                            ShowGPAAlert(result,credits);
                        } else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 10:
                        if(!isEmpty(mark1) && !isEmpty(credit1) && !isEmpty(mark2) && !isEmpty(credit2)
                                && !isEmpty(mark3) && !isEmpty(credit3)&& !isEmpty(mark4) && !isEmpty(credit4)
                                && !isEmpty(mark5) && !isEmpty(credit5)  && !isEmpty(mark6) && !isEmpty(credit6)
                                && !isEmpty(mark7) && !isEmpty(credit7) && !isEmpty(mark8) && !isEmpty(credit8)
                                && !isEmpty(mark9) && !isEmpty(credit9) && !isEmpty(mark10) && !isEmpty(credit10)) {
                            m1 = getUsGPA(Double.parseDouble(mark1.getText().toString()));
                            m2 = getUsGPA(Double.parseDouble(mark2.getText().toString()));
                            m3 = getUsGPA(Double.parseDouble(mark3.getText().toString()));
                            m4 = getUsGPA(Double.parseDouble(mark4.getText().toString()));
                            m5 = getUsGPA(Double.parseDouble(mark5.getText().toString()));
                            m6 = getUsGPA(Double.parseDouble(mark6.getText().toString()));
                            m7 = getUsGPA(Double.parseDouble(mark7.getText().toString()));
                            m8 = getUsGPA(Double.parseDouble(mark8.getText().toString()));
                            m9 = getUsGPA(Double.parseDouble(mark9.getText().toString()));
                            m10 = getUsGPA(Double.parseDouble(mark10.getText().toString()));

                            c1 = Double.parseDouble(credit1.getText().toString());
                            c2 = Double.parseDouble(credit2.getText().toString());
                            c3 = Double.parseDouble(credit3.getText().toString());
                            c4 = Double.parseDouble(credit4.getText().toString());
                            c5 = Double.parseDouble(credit5.getText().toString());
                            c6 = Double.parseDouble(credit6.getText().toString());
                            c7 = Double.parseDouble(credit7.getText().toString());
                            c8 = Double.parseDouble(credit8.getText().toString());
                            c9 = Double.parseDouble(credit9.getText().toString());
                            c10 = Double.parseDouble(credit10.getText().toString());
                            t1 = c1 * m1;
                            t2 = c2 * m2;
                            t3 = c3 * m3;
                            t4 = c4 * m4;
                            t5 = c5 * m5;
                            t6 = c6 * m6;
                            t7 = c7 * m7;
                            t8 = c8 * m8;
                            t9 = c9 * m9;
                            t10 = c10 * m10;
                            credits = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 + c10;
                            credits_marks = t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10;
                            result = credits_marks / credits;
                            ShowGPAAlert(result, credits);
                        } else{
                            Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_missing),Toast.LENGTH_LONG).show();
                        }
                        break;

                    default:
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.some_thing_wrong),Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    public void ShowGPAAlert(double result, double credits){
        DecimalFormat df = new DecimalFormat("0.00");
        AlertDialog.Builder builder = new AlertDialog.Builder(Gpa.this);
        int mImage = R.mipmap.ic_action_calculate;
        builder.setIcon(mImage);
        builder.setTitle(R.string.result);
        builder.setMessage(getResources().getString(R.string.your_semester_gpa) +":\n"+df.format(result));
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.calculate_cumulative_gpa, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                AlertDialog.Builder builder = new AlertDialog.Builder(Gpa.this);
                final FrameLayout frameView = new FrameLayout(Gpa.this);
                builder.setView(frameView);
                final AlertDialog alertDialog = builder.create();
                LayoutInflater inflater = alertDialog.getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.activity_cumulative_gpa, frameView);
                alertDialog.setCancelable(false);
                Button calc = (Button) dialoglayout.findViewById(R.id.calc_cgpa_btn);
                ImageView exit_btn = (ImageView) dialoglayout.findViewById(R.id.exit);
                TextView txt = (TextView)dialoglayout.findViewById(R.id.result1);
                EditText hourse = (EditText) dialoglayout.findViewById(R.id.total_horse);
                EditText cgpa = (EditText) dialoglayout.findViewById(R.id.total_gpa);
                exit_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
                calc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!isEmpty(hourse) && !isEmpty(cgpa)) {
                            double h = Double.parseDouble(hourse.getText().toString());
                            double cg = Double.parseDouble(cgpa.getText().toString());
                            System.out.println(result+"\t"+credits+"\t"+cg+"\t"+h);
                            double total = (result*credits)+(cg*h);
                            total = total/(credits+h);
                            System.out.println(total);
                            txt.setText(getResources().getString(R.string.your_cumulative_gpa) + "="+df.format(total));
                            //Toast.makeText(getApplicationContext(), getResources().getString(R.string.your_cumulative_gpa) + "="+total, Toast.LENGTH_LONG).show();
                            //alertDialog.cancel();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.some_thing_missing), Toast.LENGTH_LONG).show();

                        }
                    }
                });

                alertDialog.setView(dialoglayout);
                alertDialog.show();

            }
        });
        builder.setNegativeButton(R.string.ok,new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int id){
                // if this button is clicked, close
                // current activity
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private double getUsGPA(double mark){
        double result = 0;
        if(cal.equals("Global")) {
            result = (mark * 4) / 100;
            System.out.println(result);
        }
        else {
            result = (mark / 20) - 1;
            System.out.println(result);
        }
        return result;
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