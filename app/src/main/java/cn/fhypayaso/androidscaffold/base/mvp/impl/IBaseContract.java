package cn.fhypayaso.androidscaffold.base.mvp.impl;

/**
 * @author fhyPayaso
 * @since 2018/5/3 on 上午1:55
 * fhyPayaso@qq.com
 */
public interface IBaseContract {

    interface IBaseView {

    }

    interface IBasePresenter {

        /**
         * p层与v层解绑
         */
        void unBindView();

        /**
         * p层是否绑定了v层
         *
         * @return
         */
        boolean isBindView();
    }

    interface IBaseModel {

    }
}
