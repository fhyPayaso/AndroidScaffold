package cn.fhypayaso.androidscaffold.login;

import android.content.Context;

import java.util.List;

import cn.fhypayaso.androidscaffold.R;
import cn.fhypayaso.androidscaffold.base.adapter.BaseQuickAdapter;
import cn.fhypayaso.androidscaffold.base.adapter.BaseViewHolder;

/**
 * @author FanHongyu.
 * @since 18/4/17 20:02.
 * email fanhongyu@hrsoft.net.
 */

public class FragmentTwoRecAdapter extends BaseQuickAdapter<UserModle>{

    public FragmentTwoRecAdapter(List<UserModle> userModles, Context context, int itemLayoutId) {
        super(userModles, context, itemLayoutId);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserModle item) {

        helper.setText(R.id.txt_name,item.getName())
                .setText(R.id.txt_id,String.valueOf(item.getId()))
                .setText(R.id.txt_age,String.valueOf(item.getAge()));
    }
}
