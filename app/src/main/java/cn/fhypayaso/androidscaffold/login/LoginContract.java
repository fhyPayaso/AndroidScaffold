package cn.fhypayaso.androidscaffold.login;

import cn.fhypayaso.androidscaffold.base.presenter.BaseContract;

/**
 * @author FanHongyu.
 * @since 18/4/14 16:32.
 * email fanhongyu@hrsoft.net.
 */

public interface LoginContract {


    interface Presenter extends BaseContract.Presenter<View>{

        void login(String phoneNumber,String passWord);
    }

    interface View extends BaseContract.View {

        void onLoginSuccess();
    }
}
