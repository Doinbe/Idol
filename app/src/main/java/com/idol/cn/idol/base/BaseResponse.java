package com.idol.cn.idol.base;

/**
 * Created by solin on 2017/6/23.
 */

public class BaseResponse {

    public int resultcode;
    public String reason;
    public int error_code;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "resultcode=" + resultcode +
                "reason=" + reason +
                "error_code=" + error_code +
                '}';
    }
}
