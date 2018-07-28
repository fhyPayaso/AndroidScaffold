package cn.fhypayaso.androidscaffold.utils;

import android.app.Activity;
import android.support.v4.app.Fragment;

import cn.fhypayaso.androidscaffold.base.annotation.ContentView;
import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;
import cn.fhypayaso.androidscaffold.base.annotation.RegisterPresenter;

/**
 * 注解工具类
 *
 * @author FanHongyu.
 * @since 18/5/31 20:16.
 * email fanhongyu@hrsoft.net.
 */

public class InjectUtil {


    public static int getContentViewId(Class clazz) {
        //拿到注解
        ContentView contentView = (ContentView) clazz.getAnnotation(ContentView.class);
        if (contentView == null) {
            throw new NullPointerException("请绑定布局文件");
        }
        return contentView.value();
    }

    public static IBaseContract.IBasePresenter registerPresenter(Class clazz) throws IllegalAccessException, InstantiationException {
        RegisterPresenter registerPresenter = (RegisterPresenter) clazz.getAnnotation(RegisterPresenter.class);
        if(registerPresenter != null) {
            Class presenterClass = registerPresenter.value();
            return (IBaseContract.IBasePresenter) presenterClass.newInstance();
        } else {
            throw new NullPointerException("请在V层注册Presenter");
        }
    }

}
