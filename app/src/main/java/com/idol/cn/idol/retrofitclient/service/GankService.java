package com.idol.cn.idol.retrofitclient.service;


import com.idol.cn.idol.entity.GankListResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by solin on 2017/6/23.
 */

public interface GankService {

    @GET("data/{gankNamen}/{pageSize}/{pageNo}")
    Observable<GankListResponse> getGanKList(@Path("gankNamen") String gankNamen, @Path("pageSize") int pageSize, @Path("pageNo") int pageNo);

}
