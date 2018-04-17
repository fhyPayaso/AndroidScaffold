package cn.fhypayaso.androidscaffold.base.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.fhypayaso.androidscaffold.App;
import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.presenter.BaseContract;
import cn.fhypayaso.androidscaffold.utils.ThreadUtil;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/4/14 13:19.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BaseActivity extends AppCompatActivity {


    /**
     * 进度条
     */
    protected ProgressDialog mProgressDialog;

    /**
     * 获取日志输出标志
     */
    protected final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allowScreenHorizontal(false);
        setContentView(getLayoutId());
        initActivity(savedInstanceState);
    }

    protected void initActivity(Bundle savedInstanceState) {
        initData(savedInstanceState);
        initView();
    }

    /**
     * 获取父布局
     *
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutId();


    /**
     * 加载数据
     *
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);


    /**
     * 初始化View
     */
    protected abstract void initView();


    /**
     * 设置是否允许app横屏
     *
     * @param isAllow
     */
    private void allowScreenHorizontal(boolean isAllow) {
        if (!isAllow) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    /**
     * 启动新活动
     */
    protected void startActivity(Class<?> newActivity) {
        startActivity(newActivity, null);
    }

    /**
     * 启动新活动(传输简单数据)
     *
     * @param newActivity
     * @param bundle
     */
    protected void startActivity(Class<?> newActivity, Bundle bundle) {
        Intent intent = new Intent(BaseActivity.this, newActivity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**
     * 简单类型的ProgressDialog
     */
    public void showProgressDialog() {
        showProgressDialog(App.getInstance().getResources().getString(R.string.empty));
    }


    public void showProgressDialog(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setMessage(msg);
        }
        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressDialog.show();
            }
        });
    }

    /**
     * 隐藏ProgressDialog
     */
    public void dismissProgressDialog() {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            ThreadUtil.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgressDialog.dismiss();
                }
            });
        }
    }

    /**
     * 显示错误信息
     *
     * @param msg
     */
    public void showError(String msg) {
        ToastUtil.showToast(msg);
    }


    @Override
    protected void onDestroy() {
        dismissProgressDialog();
        super.onDestroy();
    }
}
