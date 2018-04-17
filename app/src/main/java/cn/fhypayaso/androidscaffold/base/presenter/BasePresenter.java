package cn.fhypayaso.androidscaffold.base.presenter;

/**
 * @author FanHongyu.
 * @since 18/4/14 15:29.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {


    protected V mView;

    /**
     * P层持有对V层引用
     *
     * @param view
     */
    @Override
    public void attach(V view) {
        this.mView = view;
    }

    /**
     * P层销毁对V层的引用
     */
    @Override
    public void detach() {
        mView = null;
    }
}