package cn.fhypayaso.androidscaffold.business;

import cn.fhypayaso.androidscaffold.base.mvp.presenter.BasePresenter;

/**
 * @author fhyPayaso
 * @since 2018/7/28 on 上午9:36
 * fhyPayaso@qq.com
 */
public class MainPresenter extends BasePresenter<IMainContract.IMainView> implements IMainContract.IMainPresenter{


    @Override
    public void login(String user, String psw) {

        if(user.equals("user") && psw.equals("123458")) {
            mView.loginSuccess();
        } else {
            mView.loginError("用户名或密码不正确");
        }

    }
}
