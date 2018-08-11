package cn.fhypayaso.androidscaffold.business;

import android.os.Bundle;

import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.activity.BaseToolBarActivity;
import cn.fhypayaso.androidscaffold.network.NetworkFactory;
import cn.fhypayaso.androidscaffold.network.ResponseCallBack;
import cn.fhypayaso.androidscaffold.network.response.ApiResponse;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author FanHongyu.
 * @since 18/5/31 20:01.
 * email fanhongyu@hrsoft.net.
 */
public class MainActivity extends BaseToolBarActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void initView() {

        NetworkFactory.getService().login().enqueue(new ResponseCallBack<ApiResponse<String>>() {
            @Override
            public void onDataResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {

            }

            @Override
            public void onDataFailure(Call<ApiResponse<String>> call, Throwable t) {

            }
        });

    }
}
