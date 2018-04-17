package cn.fhypayaso.androidscaffold.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author FanHongyu.
 * @since 18/4/17 18:09.
 * email fanhongyu@hrsoft.net.
 */

public abstract class BaseQuickAdapter<Data> extends RecyclerView.Adapter<BaseViewHolder> {


    protected List<Data> mDataList;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected int mItemLayoutId;
    private RecyclerView mRecyclerView;


    public BaseQuickAdapter(List<Data> dataList, Context context, @LayoutRes int itemLayoutId) {
        mDataList = dataList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mItemLayoutId = itemLayoutId;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, mDataList.get(position));
    }

    protected abstract void convert(BaseViewHolder helper, Data item);


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(mItemLayoutId, parent, false);
        return new BaseViewHolder(mContext, view);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    public void setRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mRecyclerView.setAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
    }
}
