package com.idol.cn.idol.base;

/**
 * Created by solin on 2017/6/26.
 */

public interface BasePresent<T extends BaseView> {
    void setView(T view);
}
