package cn.fhypayaso.androidscaffold;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/4/13 20:27.
 * email fanhongyu@hrsoft.net.
 */

public class App extends Application {


    private static final long EXIT_TIME = 2000;

    private static long sTimeMillis;

    private static App sInstance;

    private static List<Activity> sActivityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        registerActivityLifecycleCallbacks(getActivityLifecycleCallbacks());
    }

    public static App getInstance() {
        return sInstance;

    }

    private ActivityLifecycleCallbacks getActivityLifecycleCallbacks() {

        return new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                sActivityList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                sActivityList.remove(activity);
            }
        };
    }


    /**
     * 移除Activity
     *
     * @param activity act
     */
    public static void removeActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /**
     * 清除所有Activity
     */
    public void removeAllActivity() {
        for (Activity activity : sActivityList) {
            if (activity != null && !activity.isFinishing()) {
                activity.finish();
            }
        }
        ToastUtil.cancelToast();
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        removeAllActivity();
    }

    /**
     * 双击退出应用
     */
    public void exitAppWithTwiceClick() {
        //获取当前时间戳
        long currentTime = System.currentTimeMillis();
        if ((currentTime - sTimeMillis) > EXIT_TIME) {
            ToastUtil.showToast(R.string.toast_twice_click_exit);
            //更新当前时间戳
            sTimeMillis = currentTime;
        } else {
            removeAllActivity();
        }
    }

    /**
     * 切换账户
     */
    public void exitAccount() {
        removeAllActivity();
        // TODO: 18/4/12 进入登录界面,清除缓存
    }
}
