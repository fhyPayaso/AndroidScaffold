package cn.fhypayaso.androidscaffold.base.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.Collection;
import java.util.List;

import cn.fhypayaso.androidscaffold.R;

/**
 * @author fhyPayaso
 * @since 2018/4/30 on 上午11:41
 * fhyPayaso@qq.com
 */
public abstract class BaseRecyclerViewAdapter<Data> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int ITEM_NORMAL = 1000;
    public static final int ITEM_FOOTER = 1001;

    protected List<Data> mDataList;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected int mItemLayoutId;
    private boolean mWithFooter = false;
    private FooterViewHolder mFooterViewHolder;
    private OnItemClickListener mOnItemClickListener;


    public BaseRecyclerViewAdapter(List<Data> dataList, Context context, @LayoutRes int itemLayoutId) {
        mDataList = dataList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getItemCount() {
        return mWithFooter ? mDataList.size() + 1 : mDataList.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        //如果是footer类型渲染底部布局
        if (viewType == ITEM_FOOTER) {
            View footerView = mInflater.inflate(R.layout.item_recycler_footer, parent, false);
            mFooterViewHolder = new FooterViewHolder(footerView);
            return mFooterViewHolder;
        }


        final View view = mInflater.inflate(mItemLayoutId, parent, false);
        BaseViewHolder viewHolder = new BaseViewHolder(mContext, view);
        final int position = viewHolder.getAdapterPosition();
        if (mOnItemClickListener != null) {
            viewHolder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(view, mDataList.get(position), position);
                }
            });
        }
        return viewHolder;
    }


    @Override
    public int getItemViewType(int position) {


        //如果需要底部footer
        if (mWithFooter) {

            //如果是footerView
            if (position >= mDataList.size()) {
                return ITEM_FOOTER;
            } else {
                return ITEM_NORMAL;
            }
        } else {
            return ITEM_NORMAL;
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ITEM_NORMAL) {
            bindView((BaseViewHolder) holder, mDataList.get(position));
        } else if (holder.getItemViewType() == ITEM_FOOTER) {
            ((FooterViewHolder) holder).setLoadVisibility(false);
        }
    }

    /**
     * 绑定item中的view和数据
     *
     * @param viewHolder
     * @param item
     */
    protected abstract void bindView(BaseViewHolder viewHolder, Data item);


    /**
     * 重新设置数据
     *
     * @param data 数据
     */
    public void reSetDataList(Collection<Data> data) {
        this.mDataList.clear();
        notifyDataSetChanged();
        this.mDataList.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 获取当前列表的数据
     */
    public List<Data> getDataList() {
        return this.mDataList;
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
     *
     * @param data 移除的数据
     */
    public void removeItem(Data data) {
        this.mDataList.remove(data);
        notifyDataSetChanged();
    }


    /**
     * 移除数据
     */
    public void removeItem(int position) {

        mDataList.remove(position);
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


    /**
     * 设置是否需要上拉加载更多
     *
     * @param withFooter
     */
    public void setWithFooter(boolean withFooter) {
        mWithFooter = withFooter;
    }


    public interface OnItemClickListener<Data> {

        /**
         * 点击事件回调
         *
         * @param view
         * @param position
         */
        public void onItemClick(View view, Data data, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public void showFooterVisibility(boolean isShow) {
        mFooterViewHolder.setLoadVisibility(isShow);
    }


    /**
     * 上拉加载更多底部ViewHolder
     */
    public class FooterViewHolder extends RecyclerView.ViewHolder {
        ProgressBar mFooterProgressBar;

        public FooterViewHolder(View itemView) {
            super(itemView);
            mFooterProgressBar = (ProgressBar) itemView.findViewById(R.id.progress_footer);
        }

        void setLoadVisibility(boolean show) {
            mFooterProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }
}
