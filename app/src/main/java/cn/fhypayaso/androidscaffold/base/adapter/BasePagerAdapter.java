package cn.fhypayaso.androidscaffold.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.fhypayaso.androidscaffold.base.presenter.BaseContract;
import cn.fhypayaso.androidscaffold.login.FragmentOne;
import cn.fhypayaso.androidscaffold.login.FragmentTwo;

/**
 * ViewPager基类封装
 *
 * @author FanHongyu.
 * @since 18/4/15 19:34.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BasePagerAdapter extends FragmentPagerAdapter {


    /**
     * 标题列表
     */
    protected List<String> mTitleList;


    /**
     * 当前所指向的fragment
     */
    protected Fragment mCurrentFragment;


    public BasePagerAdapter(FragmentManager fm, List<String> titleList) {
        super(fm);
        mTitleList = titleList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = mTitleList.get(position);
        return title == null ? "" : title;
    }

    @Override
    public int getCount() {
        return mTitleList.size();
    }

}
