package com.qi.qiweather.gson;

/**
 * Created by 王俊杰 on 2017/8/5.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
        public String qlty;
    }
}
