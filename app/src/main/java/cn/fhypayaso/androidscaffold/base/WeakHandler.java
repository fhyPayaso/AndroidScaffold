package cn.fhypayaso.androidscaffold.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * handler弱引用封装
 *
 * @author FanHongyu.
 * @since 18/4/18 13:39.
 * email fanhongyu@hrsoft.net.
 */

public class WeakHandler extends Handler {


    WeakReference<IHandler> mRef;

    public WeakHandler(IHandler handler) {
        mRef = new WeakReference<>(handler);
    }

    public WeakHandler(Looper looper, IHandler handler) {
        super(looper);
        mRef = new WeakReference<>(handler);
    }

    @Override
    public void handleMessage(Message msg) {
        IHandler handler = mRef.get();
        if (handler != null && msg != null) {
            handler.handleMsg(msg);
        }
    }

    public interface IHandler {
        void handleMsg(Message msg);
    }
}
