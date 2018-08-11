package cn.fhypayaso.androidscaffold.network;

import android.util.Log;


import cn.fhypayaso.androidscaffold.network.response.ApiException;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * @author FanHongyu.
 * @since 18/1/18 19:29.
 * email fanhongyu@hrsoft.net.
 */


public abstract class ResponseCallBack<T> implements Callback<T> {


    public abstract void onDataResponse(Call<T> call, Response<T> response);

    public abstract void onDataFailure(Call<T> call, Throwable t);


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response != null) {

            if (response.code() != 200) {
                GlobalAPIErrorHandler.handler(response.code());
                Log.i(TAG, "onResponse: " + response.code());

            } else {
                onDataResponse(call, response);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        if (t != null) {
            onDataFailure(call, t);
            if (t instanceof ApiException) {
                GlobalAPIErrorHandler.handler((ApiException) t);
            } else {
                ToastUtil.showToast("网络连接失败，请稍后再试");
            }
        }
    }
}
