package com.idol.cn.idol.pview;

import com.idol.cn.idol.base.BasePresent;
import com.idol.cn.idol.base.BaseView;
import com.idol.cn.idol.base.DialogAble;
import com.idol.cn.idol.entity.NewListResponse;

import java.util.Map;

/**
 * Created by solin on 2017/7/4.
 */

public interface News {
    interface View extends BaseView,DialogAble{
        void showDatas(NewListResponse response);
    }
    interface Present extends BasePresent<View>{
        void getNewList(Map<String,String> params);
    }
}
