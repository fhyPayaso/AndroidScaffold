package cn.fhypayaso.androidscaffold.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
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


    private OnItemClickListener mOnItemClickListener;


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

        final BaseViewHolder holder = new BaseViewHolder(mContext, view);

        //在创建viewHolder时候就设置点击事件
        if (mOnItemClickListener != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, holder.getAdapterPosition());
                }
            });
        }
        return holder;
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


    /**
     * 添加数据
     *
     * @param data
     */
    public void addItem(Data data) {
        mDataList.add(data);
        notifyDataSetChanged();
    }


    /**
     * @param collection
     */
    public void addItems(Collection<Data> collection) {
        mDataList.addAll(collection);
        notifyDataSetChanged();
    }


    /**
     * 移除数据
     */
    public void removeItem(Data data) {

        int position = mDataList.indexOf(data);
        mDataList.remove(data);
        //该方法不会使position及其之后位置的itemView重新onBindViewHolder
        notifyItemRemoved(position);
        //所以需要从position到列表末尾进行数据刷新
        if (position != mDataList.size()) {
            notifyItemRangeChanged(position, mDataList.size() - position);
        }
    }


    /**
     * 清除全部数据
     */
    public void removeAllItem() {
        mDataList.clear();
        notifyDataSetChanged();
    }


    public interface OnItemClickListener {

        /**
         * 点击事件回调
         *
         * @param view
         * @param position
         */
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

}
