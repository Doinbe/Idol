package com.idol.cn.idol.base;

import com.blankj.utilcode.util.NetworkUtils;
import com.idol.cn.idol.retrofitclient.ResponseException;

import rx.Subscriber;

/**
 * Created by solin on 2017/6/23.
 */

public class BaseSubscriber<T> extends Subscriber<T> {

    public static final String ERROR_404 = "HTTP 404 Not Found";
    private static final String ERROR_NET = "网络连接异常,请稍候重试";
    private static final String ERROR_NET_NOT_FOUND = "访问的页面未找到";
    private BaseView mView;

    public BaseSubscriber(){}

    public BaseSubscriber(BaseView view) {
        mView = view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if(!NetworkUtils.isAvailableByPing()){
            showErrorMessage("网络不可用");
            onCompleted();
            return;
        }
        if(!NetworkUtils.isConnected()){
            showErrorMessage("网络没有连接");
            onCompleted();
            return;
        }
    }

    @Override
    public void onNext(T t) {}

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ResponseException){
            showErrorMessage(e.getMessage());
        }else{
            e.printStackTrace();
            showErrorInfo(e);
        }
    }

    private void showErrorInfo(Throwable e) {
        String message = e.getMessage();
        if (message != null) {
            switch (message) {
                case ERROR_404:
                    message = ERROR_NET_NOT_FOUND;
                    break;
                default:
                    message = ERROR_NET;
            }
        } else {
            message = ERROR_NET;
        }
        showErrorMessage(message);
    }


    /**
     * 对异常信息的处理,由绑定的view显示
     * @param message 异常信息
     */
    protected void showErrorMessage(String message) {
        if (mView != null) {
            mView.onError(message);
        }
    }
}
