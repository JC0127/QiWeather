package com.qi.qiweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 王俊杰 on 2017/8/5.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
