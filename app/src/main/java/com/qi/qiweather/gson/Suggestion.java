package com.qi.qiweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 王俊杰 on 2017/8/5.
 */

public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort;
    @SerializedName("cw")
    public CarWash carWash;

    public Sport  sport;

    public class Comfort{

        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }
    public class Sport{
        @SerializedName("txt")
        public String info;
    }

}
