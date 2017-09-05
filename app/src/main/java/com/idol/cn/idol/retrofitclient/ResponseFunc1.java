package com.idol.cn.idol.retrofitclient;


import com.idol.cn.idol.base.BaseResponse;

import rx.functions.Func1;

/**
 * 对获得的响应进行判断.如果响应码不正确.终止流.
 * 抛出error.附带响应信息
 * Created by solin on 2017/6/26.
 */

public class ResponseFunc1<T extends BaseResponse> implements Func1<T,T> {
    @Override
    public T call(T t) {
        //这里的编码判断添加要和后台规定相对应
        if (t.resultcode==101||t.resultcode==102||t.resultcode==103||t.resultcode==104||t.resultcode==105||t.resultcode==106
                ||t.resultcode==107||t.resultcode==108||t.resultcode==109||t.resultcode==111||t.resultcode==112||t.resultcode==113
                ||t.resultcode==114||t.resultcode==120||t.resultcode==121){
            throw new ResponseException(t.reason);
        }
        return t;
    }
}
