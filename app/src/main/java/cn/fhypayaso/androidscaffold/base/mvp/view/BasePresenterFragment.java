package cn.fhypayaso.androidscaffold.base.mvp.view;

import android.content.Context;

import cn.fhypayaso.androidscaffold.base.fragment.BaseFragment;
import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;


/**
 * @author FanHongyu.
 * @since 18/4/24 14:13.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePresenterFragment<P extends IBaseContract.IBasePresenter> extends BaseFragment {


    protected P mPresenter;

    @Override
    public void onAttach(Context context) {
        initPresenter();
        super.onAttach(context);
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
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter.unBindView();
            mPresenter = null;
        }
        super.onDetach();
    }
}
