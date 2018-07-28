package cn.fhypayaso.androidscaffold.base.mvp.presenter;

import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;

/**
 * @author FanHongyu.
 * @since 18/4/23 18:40.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePresenter<V extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter {

    protected V mView;


    @Override
    @SuppressWarnings("unchecked")
    public void bindView(IBaseContract.IBaseView view) {
        this.mView = (V) view;
    }

    /**
     * 解绑v层
     */
    @Override
    public void unBindView() {
        if (mView != null) {
            mView = null;
        }
    }

    /**
     * 判断是否已经绑定
     *
     * @return
     */
    @Override
    public boolean isBindView() {
        return !(mView == null);
    }

}
