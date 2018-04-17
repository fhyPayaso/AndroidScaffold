package cn.fhypayaso.androidscaffold.login;

import cn.fhypayaso.androidscaffold.base.presenter.BasePresenter;
import cn.fhypayaso.androidscaffold.utils.ThreadUtil;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/4/14 16:36.
 * email fanhongyu@hrsoft.net.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Override
    public void login(String phoneNumber, String passWord) {

        if (phoneNumber.equals("15076035390") && passWord.equals("123456")) {
            mView.onLoginSuccess();
        } else {
            mView.showError("登录失败");
        }
    }
}
