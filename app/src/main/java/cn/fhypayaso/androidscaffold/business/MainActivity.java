package cn.fhypayaso.androidscaffold.business;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.activity.BaseToolBarActivity;
import cn.fhypayaso.androidscaffold.base.activity.ContentView;
import cn.fhypayaso.androidscaffold.base.mvp.impl.RegisterPresenter;
import cn.fhypayaso.androidscaffold.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/5/31 20:01.
 * email fanhongyu@hrsoft.net.
 */
@ContentView(R.layout.activity_main)
@RegisterPresenter(MainPresenter.class)
public class MainActivity extends BasePresenterActivity<IMainContract.IMainPresenter> implements IMainContract.IMainView {

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        mPresenter.login("user","123456");
    }

    @Override
    public void loginSuccess() {
        ToastUtil.showToast("登录成功");
    }

    @Override
    public void loginError(@Nullable String error) {
        ToastUtil.showToast(error);
    }
}
