package cn.fhypayaso.androidscaffold.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 防止GridView滑动
 *
 * @author FanHongyu.
 * @since 18/4/27 15:07.
 * email fanhongyu@hrsoft.net.
 */

public class NoScrollGridView extends GridView {

    public NoScrollGridView(Context context) {
        super(context);
    }

    public NoScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
