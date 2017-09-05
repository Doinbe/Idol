package com.idol.cn.idol.retrofitclient;

import com.idol.cn.idol.base.BaseResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by solin on 2017/6/26.
 */

public class RxJavaUtil {

    /**
     * 对返回response的Observable进行处理.订阅在子线程
     * @param observable 返回的observable（需要处理的observable）
     * @param <T>  BaseResponse的子类
     * @return  处理后的observable（运行在子线程）
     */
    public static <T extends BaseResponse> Observable<T> getThreadObservable(Observable<T> observable){
        return observable.subscribeOn(Schedulers.io())
                .map(new ResponseFunc1<T>());
    }

    /**
     * 同上，运行在主线程
     * @return 处理后的observable（运行在主线程）
     */
    public static <T extends BaseResponse> Observable<T> getMainObservable(Observable<T> observable){
        return getThreadObservable(observable).observeOn(AndroidSchedulers.mainThread());
    }
}
