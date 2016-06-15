package com.example.chasejacobs.teamactivity09;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String FILE_NAME = "MyPrefsFile";
    public TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (TextView)findViewById(R.id.number);
        number.setText("0");
        try {
            SharedPreferences settings = getSharedPreferences(FILE_NAME, 0);
            String temp = settings.getString("counter", "");
            if (temp.equals("")){
                number.setText("0");
            }
            else{
                number.setText(temp);
            }

        }
        catch(Exception o) {
            //number.setText("0");
        }
    }

    public void advance(View a){
        if (a.getId() == R.id.countButton){
            try{
                String temp = number.getText().toString();
                int num = Integer.parseInt(temp);
                num++;
                number.setText(Integer.toString(num));
            }
            catch (Exception o){}
        }
    }

    public void save(View a){
        if (a.getId() == R.id.saveCount){
            SharedPreferences settings = getSharedPreferences(FILE_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            String temp = number.getText().toString();
            editor.putString("counter", temp);
            editor.commit();
        }
    }
}
