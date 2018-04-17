package cn.fhypayaso.androidscaffold.login;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.fragment.BaseFragment;

/**
 * @author FanHongyu.
 * @since 18/4/16 19:50.
 * email fanhongyu@hrsoft.net.
 */

public class FragmentTwo extends BaseFragment {


    Unbinder unbinder;

    List<UserModle> mUserModles = new ArrayList<>();
    @BindView(R.id.rec_view2)
    RecyclerView recView2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {


        for (int i = 0; i < 50; i++) {
            mUserModles.add(new UserModle("name" + i, i, i + 2));
        }

        FragmentTwoRecAdapter fragmentTwoRecAdapter = new FragmentTwoRecAdapter(mUserModles, getContext(), R.layout.item_two);
        recView2.setAdapter(fragmentTwoRecAdapter);
        fragmentTwoRecAdapter.setRecyclerView(recView2);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
