package com.qi.qiweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *器让他让他
 */
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirst = sp.getBoolean("isFirst", false);
        if (!isFirst){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(this).edit();
            editor.putBoolean("isFirst",true);
            editor.apply();
            finish();
        }else {
            Intent intent=new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
