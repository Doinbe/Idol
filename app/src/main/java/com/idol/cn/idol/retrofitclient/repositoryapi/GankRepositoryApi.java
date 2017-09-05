package com.idol.cn.idol.retrofitclient.repositoryapi;

import com.idol.cn.idol.entity.GankListResponse;

import rx.Observable;

/**
 * Created by solin on 2017/6/26.
 */

public interface GankRepositoryApi {

    Observable<GankListResponse> getGanKList(String gankNamen, int pageSize, int pageNo);
}
