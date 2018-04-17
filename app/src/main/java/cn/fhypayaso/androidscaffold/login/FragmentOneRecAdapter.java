package cn.fhypayaso.androidscaffold.login;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.adapter.BaseQuickAdapter;
import cn.fhypayaso.androidscaffold.base.adapter.BaseViewHolder;

/**
 * @author FanHongyu.
 * @since 18/4/17 18:48.
 * email fanhongyu@hrsoft.net.
 */

public class FragmentOneRecAdapter extends BaseQuickAdapter<LoginModel> {

    public FragmentOneRecAdapter(List<LoginModel> loginModels, Context context, int itemLayoutId) {
        super(loginModels, context, itemLayoutId);
    }

    @Override
    protected void convert(BaseViewHolder helper, LoginModel item) {
        helper.setText(R.id.txt_username, item.getUsername())
                .setText(R.id.txt_password, item.getPassword());
    }
}
