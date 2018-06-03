package cn.fhypayaso.androidscaffold.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import cn.fhypayaso.androidscaffold.base.activity.ContentView;

/**
 * 注解工具类
 *
 * @author FanHongyu.
 * @since 18/5/31 20:16.
 * email fanhongyu@hrsoft.net.
 */

public class InjectUtil {


    /**
     * 注入界面布局
     *
     * @param context
     */
    public static int getContentViewId(Context context) {
        Class<? extends Context> clazz = context.getClass();
        //拿到注解
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView == null) {
            return -1;
        }
        return contentView.value();
    }
}
