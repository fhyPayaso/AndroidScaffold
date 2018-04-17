package cn.fhypayaso.androidscaffold;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import cn.fhypayaso.androidscaffold.base.activity.BaseToolBarActivity;
import cn.fhypayaso.androidscaffold.base.presenter.BaseContract;
import cn.fhypayaso.androidscaffold.login.FragmentOne;
import cn.fhypayaso.androidscaffold.login.MainPagerAdapter;
import cn.fhypayaso.androidscaffold.utils.ThreadUtil;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

public class MainActivity extends BaseToolBarActivity {


    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        List<String> stringList = new ArrayList<>();
        stringList.add("tab1");
        stringList.add("tab2");

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), stringList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public void onBackPressed() {
        App.getInstance().exitAppWithTwiceClick();
    }

}
