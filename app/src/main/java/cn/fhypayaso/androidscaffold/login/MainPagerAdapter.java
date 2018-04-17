package cn.fhypayaso.androidscaffold.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import cn.fhypayaso.androidscaffold.base.adapter.BasePagerAdapter;

/**
 * @author FanHongyu.
 * @since 18/4/16 20:00.
 * email fanhongyu@hrsoft.net.
 */

public class MainPagerAdapter extends BasePagerAdapter {


    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;



    public MainPagerAdapter(FragmentManager fm, List<String> titleList) {
        super(fm, titleList);
    }


    @Override
    public Fragment getItem(int position) {


        switch (position) {

            case 0:
                if(mFragmentOne == null) {
                    mFragmentOne = new FragmentOne();
                }
                mCurrentFragment = mFragmentOne;
                break;
            case 1:
                if(mFragmentTwo == null) {
                    mFragmentTwo = new FragmentTwo();
                }
                mCurrentFragment = mFragmentTwo;
                break;
            default:
                break;
        }
        return mCurrentFragment;
    }
}
