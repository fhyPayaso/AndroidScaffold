package cn.fhypayaso.androidscaffold.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.fhypayaso.androidscaffold.App;
import cn.fhypayaso.androidscaffold.common.CacheKey;
import cn.fhypayaso.androidscaffold.common.Config;
import cn.fhypayaso.androidscaffold.network.converter.ResponseConverterFactory;
import cn.fhypayaso.androidscaffold.utils.CacheUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author FanHongyu.
 * @since 18/1/18 15:48.
 * email fanhongyu@hrsoft.net.
 */

public final class NetworkFactory {


    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;
    private static ApiService sApiService;


    /**
     * 生成Service接口
     *
     * @return RetrofitService
     */
    public static ApiService getService() {
        if (sApiService == null) {
            sApiService = getRetrofit().create(ApiService.class);
        }
        return sApiService;
    }


    /**
     * 构造Retrofit,设置相关参数
     *
     * @return Retrofit
     */
    private static Retrofit getRetrofit() {

        if (sRetrofit == null) {

            sRetrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(Config.APP_SERVER_BASE_URL)
                    //增加对返回值为自定义Response类型的支持,默认是Gson
                    .addConverterFactory(ResponseConverterFactory.create())
                    //增加对RxJava的适配
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }


    /**
     * 构造OkHttp客户端，设置相关参数
     *
     * @return OkHttp客户端
     */
    private static OkHttpClient getOkHttpClient() {


        if (sOkHttpClient == null) {

            sOkHttpClient = new OkHttpClient.Builder()
                    //设置超时时间为15s
                    .connectTimeout(Config.APP_SERVER_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                    //设置出现错误时重新连接
                    .retryOnConnectionFailure(true)
                    //添加应用拦截器，统一打印请求与响应的json
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    //添加网络拦截器，发送请求时加入token
                    .addNetworkInterceptor(getNetworkInterceptor())
                    .build();

        }
        return sOkHttpClient;
    }


    /**
     * 自定义网络拦截器,添加token请求头
     *
     * @return Interceptor
     */
    private static Interceptor getNetworkInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String token = CacheUtil.getSP().getString(CacheKey.TOKEN, "");
                //请求时加入token
                Request request = chain.request().newBuilder()
                        .header(CacheKey.TOKEN, token)
                        .build();
                return chain.proceed(request);
            }
        };
    }
}
