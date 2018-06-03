package cn.fhypayaso.androidscaffold.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;


/**
 * @author fhyPayaso
 * @since 2018/4/30 on 上午10:49
 * fhyPayaso@qq.com
 */
public abstract class BaseNoBarActivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initActivity(savedInstanceState);
    }
}
