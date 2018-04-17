package cn.fhypayaso.androidscaffold.base.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.presenter.BaseContract;
import cn.fhypayaso.androidscaffold.utils.ThreadUtil;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/4/15 19:59.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BaseFragment extends Fragment {


    /**
     * 当前Fragment RootView
     */
    protected View mView;

    /**
     * 进度条
     */
    protected ProgressDialog mProgressDialog;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, mView);
        initFragment();
        return mView;
    }


    protected void initFragment() {
        initData();
        initView();
    }

    /**
     * 获取LayoutId.
     *
     * @return LayoutId 布局文件Id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化View.
     */
    protected abstract void initView();

    /**
     * 初始数据
     */
    protected abstract void initData();


    protected void showError(String msg) {
        ToastUtil.showToast(msg);
    }


    public void showProgressDialog() {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext(), ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setTitle(R.string.dialog_please_wait);
        }

        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressDialog.show();
            }
        });
    }


    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {

            ThreadUtil.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgressDialog.dismiss();
                }
            });
        }
    }

    /**
     * 获取当前Fragment的RootView
     *
     * @return RootView
     */
    protected View getRootView() {
        return mView;
    }
}
