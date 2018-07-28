package cn.fhypayaso.androidscaffold.base.mvp.view;

import android.content.Context;

import cn.fhypayaso.androidscaffold.base.fragment.BaseFragment;
import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;
import cn.fhypayaso.androidscaffold.utils.InjectUtil;


/**
 * @author FanHongyu.
 * @since 18/4/24 14:13.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePresenterFragment<P extends IBaseContract.IBasePresenter> extends BaseFragment implements IBaseContract.IBaseView{


    protected P mPresenter;

    @Override
    public void onAttach(Context context) {
        try {
            initPresenter();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        super.onAttach(context);
    }

    /**
     * 初始化绑定状态
     */
    @SuppressWarnings("unchecked")
    private void initPresenter() throws java.lang.InstantiationException, IllegalAccessException {
        mPresenter = (P) InjectUtil.registerPresenter(getContext());
        mPresenter.bindView(this);
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
