package cn.fhypayaso.androidscaffold.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import cn.fhypayaso.androidscaffold.utils.InjectUtil;

/**
 * @author fhyPayaso
 * @since 2018/4/30 on 上午10:49
 * fhyPayaso@qq.com
 */
public abstract class BaseNoBarActivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(InjectUtil.getContentViewId(this.getClass()));
        ButterKnife.bind(this);
        initActivity(savedInstanceState);
    }
}
