package cn.fhypayaso.androidscaffold.network;

import cn.fhypayaso.androidscaffold.network.response.ApiException;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author fhyPayaso
 * @since 2018/4/24 on 上午1:12
 * fhyPayaso@qq.com
 */
public class NetworkErrorHandler {

    public static void handler(int code){
        switch (code){


            default:
                ToastUtil.showToast("请求不被允许，请确定是否有权进行该操作");
                break;
        }
    }

    public static void handler(ApiException e){
        switch (e.getCode()){

            default:
                ToastUtil.showToast(e.getMsg());
                break;
        }
    }
}
