package com.qi.qiweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 王俊杰 on 2017/8/5.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
