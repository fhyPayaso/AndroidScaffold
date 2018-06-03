package cn.fhypayaso.androidscaffold.network;

import android.util.Log;

import cn.fhypayaso.androidscaffold.common.Config;
import cn.fhypayaso.androidscaffold.network.response.ApiException;
import cn.fhypayaso.androidscaffold.network.response.ApiResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * @author fhyPayaso
 * @since 2018/4/24 on 上午1:00
 * fhyPayaso@qq.com
 */
public abstract class BaseObserver<T> implements Observer<ApiResponse<T>> {


    protected abstract void onSuccess(ApiResponse<T> response);

    protected abstract void onError(ApiException exception);

    @Override
    public void onNext(ApiResponse<T> response) {
        boolean isCodeTrue = false;
        for (int code : Config.NET_CORRECT_CODE) {
            if (code == response.getCode()) {
                onSuccess(response);
                isCodeTrue = true;
                break;
            }
        }
        //错误返回码
        if (!isCodeTrue) {
            onError(new ApiException(response.getCode(), response.getMsg()));
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException) {
            onError((ApiException) e);
            NetworkErrorHandler.handler((ApiException) e);
        } else {
            onError(new ApiException(-1, e.getMessage()));
        }
    }


    @Override
    public void onSubscribe(Disposable d) {

    }


    @Override
    public void onComplete() {

    }


    /**
     * RxJava线程调度
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> setThread() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}