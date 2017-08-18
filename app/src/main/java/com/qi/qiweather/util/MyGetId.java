package com.qi.qiweather.util;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by 王俊杰 on 2017/8/18.
 */

public class MyGetId {
    public static void buid(Activity activity) {
        try {
            buidView(activity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void buidView(Activity activity) throws IllegalAccessException {
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();//反射获得所有的
        for (Field field:declaredFields){
            field.setAccessible(true);

            Bind bind=field.getAnnotation(Bind.class);//获得变量上的注解
            if (bind!=null){
                int id = bind.value();
                View viewById = activity.findViewById(id);
                field.set(activity,viewById);
            }
        }
    }
}
