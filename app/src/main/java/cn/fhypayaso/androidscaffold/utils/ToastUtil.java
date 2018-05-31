package cn.fhypayaso.androidscaffold.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import cn.fhypayaso.androidscaffold.App;


/**
 * @author FanHongyu.
 * @since 18/4/14 12:03.
 * email fanhongyu@hrsoft.net.
 */

public class ToastUtil {


    private static Toast sToast;


    private ToastUtil() {

    }

    @SuppressWarnings("all")
    public static void showToast(final String msg) {

        if (sToast == null) {
            sToast = Toast.makeText(App.getInstance(), msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);
        }

        ThreadUtil.runOnNewThread(new Runnable() {
            @Override
            public void run() {
                sToast.show();
            }
        });
    }

    @SuppressWarnings("all")
    public static void showToast(@StringRes final int resId) {

        if (sToast == null) {
            sToast = Toast.makeText(App.getInstance(), resId, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(resId);
        }

        ThreadUtil.runOnNewThread(new Runnable() {
            @Override
            public void run() {
                sToast.show();
            }
        });
    }


    public static void showToast(String msg, int... errorCode) {

        StringBuilder stringBuilder = new StringBuilder(msg);
        for (int anErrorCode : errorCode) {
            stringBuilder.append("-");
            stringBuilder.append(anErrorCode);
        }
        showToast(stringBuilder.toString());
    }


    public static void showToast(@StringRes int resId, int... errorCode) {

        String msg = App.getInstance().getResources().getString(resId);
        StringBuilder stringBuilder = new StringBuilder(msg);
        for (int anErrorCode : errorCode) {
            stringBuilder.append("-");
            stringBuilder.append(anErrorCode);
        }
        showToast(stringBuilder.toString());
    }

    /**
     * 取消toast
     */
    public static void cancelToast() {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
    }
}
