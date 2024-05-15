package com.nanaki.gpacalculator;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.lang.reflect.Array;

public class CustomAdapter extends BaseAdapter {

    private String[]  Title;
    private int[] imge;
    private Context mContext;
    private static LayoutInflater inflater = null;
    public static final String fontSize = "MY_FONTSIZE";

    public static final String PREFS_NAME = "MY_LANGUAGE";
    String lang;

    public CustomAdapter(Context context, String[] text1,int[] imageIds) {
        mContext = context;
        Title = text1;
        imge = imageIds;

        inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return Title.length;
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = inflater.inflate(R.layout.settings_custom_view, null);
        TextView title;
        ImageView i1;
        i1 = (ImageView) row.findViewById(R.id.settings_img);
        title = (TextView) row.findViewById(R.id.settings_title);
        RelativeLayout layout;
        layout = (RelativeLayout) row.findViewById(R.id.item_sett_lyt);

        SharedPreferences l = mContext.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        lang = l.getString("lang", "no");
        if(lang.equals("العربية")){
            layout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            title.setGravity(Gravity.RIGHT);
        }
        title.setText(Title[position]);
        i1.setImageResource(imge[position]);

        SharedPreferences prefs = mContext.getSharedPreferences(fontSize, MODE_PRIVATE);
        String font = prefs.getString("fontSize", "no");
        switch (font){
            case "small":
               title.setTextSize(16);
                i1.getLayoutParams().height = 100;
                i1.getLayoutParams().width = 100;
                i1.requestLayout();

                break;
            case "medium":
                title.setTextSize(20);
                i1.getLayoutParams().height = 110;
                i1.getLayoutParams().width = 110;
                i1.requestLayout();
                break;
            case "big":
                title.setTextSize(24);
                i1.getLayoutParams().height = 120;
                i1.getLayoutParams().width = 120;
                i1.requestLayout();
                break;
            case "bigger":
                title.setTextSize(28);
                i1.getLayoutParams().height = 150;
                i1.getLayoutParams().width = 150;
                i1.requestLayout();

                break;

        }



        return (row);
    }


}