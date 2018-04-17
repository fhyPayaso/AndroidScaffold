package cn.fhypayaso.androidscaffold.base.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cn.fhypayaso.androidscaffold.App;
import cn.fhypayaso.androidscaffold.R;

/**
 * @author FanHongyu.
 * @since 18/4/17 14:25.
 * email fanhongyu@hrsoft.net.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {


    private final SparseArray<View> mViewSparseArray;
    private Context mContext;
    private View mItemView;


    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        mItemView = itemView;
        mViewSparseArray = new SparseArray<>();
    }


    /**
     * 从布局获取泛型view
     *
     * @param viewId
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(@IdRes int viewId) {
        //从已经缓存的ViewMap中查找
        View view = mViewSparseArray.get(viewId);
        //如果没有缓存
        if (view == null) {
            //获取实例并加入缓存
            view = mItemView.findViewById(viewId);
            mViewSparseArray.append(viewId, view);
        }
        return (T) view;
    }


    /**
     * 设置TextView类型
     *
     * @param viewId
     * @param value
     * @return
     */
    public BaseViewHolder setText(@IdRes int viewId, @StringRes int value) {
        return setText(viewId, mContext.getString(value));
    }

    public BaseViewHolder setText(@IdRes int viewId, String value) {
        TextView textView = findViewById(viewId);
        textView.setText(value == null ? mContext.getString(R.string.empty) : value);
        return this;
    }


    /**
     * 设置ImageView的url
     *
     * @param viewId
     * @param value
     * @return
     */
    public BaseViewHolder setImgUrl(@IdRes int viewId, String value) {
        ImageView imageView = findViewById(viewId);
        if (value != null) {
            Glide.with(mContext).load(value).into(imageView);
        }
        return this;
    }


    /**
     * 设置控件是否可见
     *
     * @param viewId
     * @param isVisible
     * @return
     */
    public BaseViewHolder setVisible(@IdRes int viewId, boolean isVisible) {
        findViewById(viewId).setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
        return this;
    }


    /**
     * 设置控件是否消失(不保留空间)
     *
     * @return
     */
    public BaseViewHolder setGone(@IdRes int viewId) {
        findViewById(viewId).setVisibility(View.GONE);
        return this;
    }
}
