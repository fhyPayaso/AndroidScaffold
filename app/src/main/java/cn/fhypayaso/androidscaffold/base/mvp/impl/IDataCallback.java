package cn.fhypayaso.androidscaffold.base.mvp.impl;

/**
 * @author FanHongyu.
 * @since 18/4/23 19:45.
 * email fanhongyu@hrsoft.net.
 */

public interface IDataCallback {

    /**
     * 数据加载失败和成功都关注
     *
     * @param <T> 返回数据类型
     */
    interface Callback<T> extends SuccessCallback<T>, FailedCallback {

        /**
         * 无论成功失败都要进行的操作
         */
        void onOverLoaded();
    }

    /**
     * 只关注数据加载成功的接口
     *
     * @param <T>
     */
    interface SuccessCallback<T> extends INotifyListener {
        /**
         * 数据成功回调
         *
         * @param t 回调数据
         */
        void onSuccessLoaded(T t);
    }

    /**
     * 只关注数据加载失败的接口
     */
    interface FailedCallback extends INotifyListener {
        /**
         * 数据失败回调
         *
         * @param error 错误信息
         */
        void onFailedLoaded(String error);
    }
}
