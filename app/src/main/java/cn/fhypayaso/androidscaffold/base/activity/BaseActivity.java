package cn.fhypayaso.androidscaffold.base.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.fhypayaso.androidscaffold.utils.InjectUtil;
import cn.fhypayaso.androidscaffold.utils.ThreadUtil;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/4/23 17:53.
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
        removeFragmentState(savedInstanceState);
        super.onCreate(savedInstanceState);
        //禁止应用横屏
        allowScreenHorizontal(false);
    }

    protected void initActivity(Bundle savedInstanceState) {
        initData(savedInstanceState);
        initView();
    }

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
        showProgressDialog("请稍后...");
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
        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }
        });
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


    /**
     * 清除fragment状态
     *
     * @param savedInstanceState
     */
    protected void removeFragmentState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.remove("android:support:fragments");
            savedInstanceState.remove("android:fragments");
        }
    }
}
