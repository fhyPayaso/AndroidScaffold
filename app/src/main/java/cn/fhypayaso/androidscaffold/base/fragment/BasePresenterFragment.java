package cn.fhypayaso.androidscaffold.base.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import cn.fhypayaso.androidscaffold.base.presenter.BaseContract;

/**
 * @author FanHongyu.
 * @since 18/4/15 20:39.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePresenterFragment<P extends BaseContract.Presenter> extends Fragment implements
        BaseContract.View {

    protected P mPresenter;

    /**
     * 在刚与activity绑定的时候初始化
     *
     * @param context
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = getPresenter();
        mPresenter.attach(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter!=null) {
            mPresenter.detach();
            mPresenter = null;
        }
    }

    /**
     * 初始化presenter
     * @return
     */
    protected abstract P getPresenter();
}
