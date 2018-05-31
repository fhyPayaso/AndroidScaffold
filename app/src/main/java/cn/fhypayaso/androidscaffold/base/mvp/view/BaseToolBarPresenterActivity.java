package cn.fhypayaso.androidscaffold.base.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.fhypayaso.androidscaffold.base.activity.BaseToolBarActivity;
import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;

/**
 * @author FanHongyu.
 * @since 18/4/24 14:12.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BaseToolBarPresenterActivity<P extends IBaseContract.IBasePresenter> extends BaseToolBarActivity {


    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initPresenter();
        super.onCreate(savedInstanceState);
    }

    /**
     * 获取Presenter实例
     *
     * @return
     */
    protected abstract P getPresenter();


    /**
     * 初始化绑定状态
     */
    @SuppressWarnings("unchecked")
    private void initPresenter() {
        mPresenter = getPresenter();
    }


    @Override
    protected void onDestroy() {

        if (mPresenter != null) {
            mPresenter.unBindView();
            mPresenter = null;
        }
        super.onDestroy();
    }


}
