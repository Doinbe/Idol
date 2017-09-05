package com.idol.cn.idol.pview;

import com.idol.cn.idol.base.BasePresent;
import com.idol.cn.idol.base.BaseView;
import com.idol.cn.idol.entity.GankListResponse;

/**
 * Created by solin on 2017/6/26.
 */

public interface Gank {
    interface View extends BaseView {
        void showDatas(GankListResponse response);
    }
    interface Present extends BasePresent<View> {
        void getGanKList(String gankNamen, int pageSize, int pageNo);
    }
}
