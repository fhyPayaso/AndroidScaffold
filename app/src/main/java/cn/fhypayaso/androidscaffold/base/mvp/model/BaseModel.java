package cn.fhypayaso.androidscaffold.base.mvp.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.fhypayaso.androidscaffold.base.mvp.impl.IBaseContract;
import cn.fhypayaso.androidscaffold.base.mvp.impl.INotifyListener;

/**
 * Model层基类
 *
 * @author FanHongyu.
 * @since 18/4/23 18:39.
 * email fanhongyu@hrsoft.net.
 */
public abstract class BaseModel implements IBaseContract.IBaseModel {

    /**
     * 维护每一个Presenter所对应的回调
     */
    protected Map<IBaseContract.IBasePresenter, List<INotifyListener>> mListenerMap;

}
