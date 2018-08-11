package cn.fhypayaso.androidscaffold.network;


import cn.fhypayaso.androidscaffold.network.response.ApiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author fhyPayaso
 * @since 2018/4/24 on 上午12:18
 * fhyPayaso@qq.com
 */
public interface ApiService {

    @POST("")
    Call<ApiResponse<String>> login();

}
