package com.xhsun.girlapp;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.xhsun.girlapp.annotation.InjectView;

import java.lang.reflect.Field;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public class InjectUtils {

    public static void injectView(Activity activity) {

        //首先通过反射获取Activity信息
        Class<?> clazz = activity.getClass();
        Field[] fieldList = clazz.getDeclaredFields();

        //遍历所有成员属性
        for (Field field : fieldList) {

            //判断属性注解是否是自定义注解
            if (field.isAnnotationPresent(InjectView.class)) {

                InjectView injectView = field.getAnnotation(InjectView.class);
                //获取ID
                int id = injectView.value();
                //通过ID得到相应的View
                View view = activity.findViewById(id);

                field.setAccessible(true);

                try {
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
