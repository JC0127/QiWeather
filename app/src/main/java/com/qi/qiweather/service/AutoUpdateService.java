package com.qi.qiweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.IntDef;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.qi.qiweather.R;
import com.qi.qiweather.WeatherActivity;
import com.qi.qiweather.gson.Weather;
import com.qi.qiweather.util.HttpUtil;
import com.qi.qiweather.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AutoUpdateService extends Service {
    public AutoUpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        updateWeather();
        updatePic();
        AlarmManager manager= (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour=60*60*1000;
        long triTime= SystemClock.elapsedRealtime()+anHour;
        Intent intent1=new Intent(this,AutoUpdateService.class);
        PendingIntent pi=PendingIntent.getService(this,0,intent,0);
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }

    private void updatePic() {
        String urlPic="http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(urlPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bingPic=response.body().string();
                SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                editor.putString("picUrl",bingPic);
                editor.apply();

            }
        });
    }

    private void updateWeather() {
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
        String weatherStr=preferences.getString("weather",null);
        if (weatherStr!=null){
            Weather weather= Utility.handleWeatherResponse(weatherStr);
            String weatherId=weather.basic.weatherId;
            String urlWeather = "https://free-api.heweather.com/v5/weather?city="
                    + weatherId + "&key=c2402d90b67f42c49aa72d466a35d8d8";
            HttpUtil.sendOkHttpRequest(urlWeather, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String reText=response.body().string();
                    Weather weather1=Utility.handleWeatherResponse(reText);
                    if (weather1!=null&&"ok".equals(weather1.status)){
                        SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(AutoUpdateService.this).edit();
                        editor.putString("weather",reText);
                        editor.apply();
                    }
                }
            });
        }
    }
}
