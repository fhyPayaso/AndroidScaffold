package cn.fhypayaso.androidscaffold.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.fhypayaso.androidscaffold.base.presenter.BaseContract;

/**
 * @author FanHongyu.
 * @since 18/4/14 16:00.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePresenterActivity<P extends BaseContract.Presenter> extends BaseActivity implements BaseContract.View {

    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
    }

    /**
     * 获取Presenter实例
     *
     * @return
     */
    protected abstract P getPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
            mPresenter = null;
        }
    }
}
