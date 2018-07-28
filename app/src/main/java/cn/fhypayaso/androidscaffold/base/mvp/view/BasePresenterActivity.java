package cn.fhypayaso.androidscaffold.base.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.fhypayaso.androidscaffold.base.activity.BaseNoBarActivity;
import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;
import cn.fhypayaso.androidscaffold.utils.InjectUtil;


/**
 * @author FanHongyu.
 * @since 18/4/23 19:17.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePresenterActivity<P extends IBaseContract.IBasePresenter> extends BaseNoBarActivity implements IBaseContract.IBaseView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            initPresenter();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化绑定状态
     */
    @SuppressWarnings("unchecked")
    private void initPresenter() throws IllegalAccessException, InstantiationException {
        mPresenter = (P) InjectUtil.registerPresenter(this.getClass());
        mPresenter.bindView(this);
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
