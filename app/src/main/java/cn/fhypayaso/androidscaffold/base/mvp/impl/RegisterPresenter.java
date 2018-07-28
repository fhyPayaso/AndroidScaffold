package cn.fhypayaso.androidscaffold.base.mvp.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author fhyPayaso
 * @since 2018/7/28 on 上午9:16
 * fhyPayaso@qq.com
 */
@Target(ElementType.TYPE)//在类的作用范围内
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface RegisterPresenter {

    Class<? extends IBaseContract.IBasePresenter> value();
}
