package com.idol.cn.idol.entity;

import com.idol.cn.idol.base.BaseResponse;

import java.util.List;

/**
 * Created by solin on 2017/7/4.
 */

public class NewListResponse extends BaseResponse {

    public NewList result;

    public class NewList{
        public int stat;
        public List<NewEntity> data;
    }
}
