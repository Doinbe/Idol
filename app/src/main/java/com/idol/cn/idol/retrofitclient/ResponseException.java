package com.idol.cn.idol.retrofitclient;

/**
 * 自定义异常类
 * Created by solin on 2017/6/23.
 */

public class ResponseException extends RuntimeException{
    public ResponseException(String msg){
        super(msg);
    }
}
