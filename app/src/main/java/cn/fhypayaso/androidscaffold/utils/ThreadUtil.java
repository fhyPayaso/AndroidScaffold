package cn.fhypayaso.androidscaffold.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author FanHongyu.
 * @since 18/4/14 12:15.
 * email fanhongyu@hrsoft.net.
 */

public class ThreadUtil {


    /**
     * 获取cpu核心数
     */
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    /**
     * 允许线程闲置时间
     */
    private static final int KEEP_ALIVE_TIME = 1;

    private ThreadUtil() {

    }


    private static class HandlerHolder {
        private static final Handler INSTANCE = new Handler(Looper.getMainLooper());
    }

    private static Handler getUIHandler() {
        return HandlerHolder.INSTANCE;
    }


    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0);
    }


    public static void runOnUiThread(Runnable runnable, long delayMills) {
        getUIHandler().postDelayed(runnable, delayMills);
    }


    @SuppressWarnings("all")
    private static class ThreadPoolHolder {
        // TODO: 18/4/14 线程池优化
        private static final ExecutorService INSTANCE = new ThreadPoolExecutor(
                NUMBER_OF_CORES
                , NUMBER_OF_CORES * 2
                , KEEP_ALIVE_TIME
                , TimeUnit.SECONDS
                , new LinkedBlockingQueue<Runnable>());
    }

    private static ExecutorService getThreadPool() {
        return ThreadPoolHolder.INSTANCE;
    }

    public static void runOnNewThread(Runnable runnable) {
        getThreadPool().execute(runnable);
    }
}
