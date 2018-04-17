package cn.fhypayaso.androidscaffold.base.presenter;

/**
 * @author FanHongyu.
 * @since 18/4/14 13:53.
 * email fanhongyu@hrsoft.net.
 */

public interface BaseContract {

    interface Presenter<V> {

        /**
         * 绑定操作
         *
         * @param view
         */
        void attach(V view);

        /**
         * 解绑操作
         */
        void detach();
    }

    interface View {

        /**
         * 显示错误信息
         *
         * @param msg
         */
        void showError(String msg);

    }
}
