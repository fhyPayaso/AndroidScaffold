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
import cn.fhypayaso.androidscaffold.base.adapter.BaseQuickAdapter;
import cn.fhypayaso.androidscaffold.base.fragment.BaseFragment;
import cn.fhypayaso.androidscaffold.utils.ToastUtil;

/**
 * @author FanHongyu.
 * @since 18/4/16 19:50.
 * email fanhongyu@hrsoft.net.
 */

public class FragmentOne extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.rec_view)
    RecyclerView recView;
    Unbinder unbinder1;

    private List<LoginModel> loginModels = new ArrayList<>();
    private FragmentOneRecAdapter mFragmentOneRecAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {


        for (int i = 0; i < 20; i++) {
            loginModels.add(new LoginModel("user" + i, "password" + i));
        }
        mFragmentOneRecAdapter = new FragmentOneRecAdapter(loginModels, getContext(), R.layout.item_rec);
        mFragmentOneRecAdapter.setRecyclerView(recView);
        mFragmentOneRecAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ToastUtil.showToast("点击了" + position);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
