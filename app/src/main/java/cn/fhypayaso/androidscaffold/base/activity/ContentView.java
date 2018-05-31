package cn.fhypayaso.androidscaffold.base.activity;

import android.support.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 绑定布局文件注解
 *
 * @author FanHongyu.
 * @since 18/5/31 20:14.
 * email fanhongyu@hrsoft.net.
 */

@Target(ElementType.TYPE)//在类的作用范围内
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface ContentView {
    @LayoutRes
    int value();
}