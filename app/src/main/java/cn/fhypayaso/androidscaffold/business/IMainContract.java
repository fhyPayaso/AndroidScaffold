package cn.fhypayaso.androidscaffold.business;

import android.support.annotation.Nullable;

import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;

/**
 * @author fhyPayaso
 * @since 2018/7/28 on 上午9:37
 * fhyPayaso@qq.com
 */
public interface IMainContract {

    interface IMainView extends IBaseContract.IBaseView {

        void loginSuccess();

        void loginError(@Nullable String error);
    }

    interface IMainPresenter extends IBaseContract.IBasePresenter {

        void login(String user,String psw);
    }

}
