package com.qi.qiweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 王俊杰 on 2017/8/5.
 */

public class Forecast {
    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public Wind wind;



    public class Temperature{
        public String max;
        public String min;
    }
    public class More{
        @SerializedName("txt_d")
        public String info;
    }
    public class Wind{
        public String deg;
        public String dir;
        public String sc;
        public String spd;
    }
}
