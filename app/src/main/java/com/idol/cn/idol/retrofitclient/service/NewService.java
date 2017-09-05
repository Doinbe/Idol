package com.idol.cn.idol.retrofitclient.service;

import com.idol.cn.idol.entity.NewListResponse;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by solin on 2017/7/4.
 */

public interface NewService {

    @GET("index")
    Observable<NewListResponse> getNewList(@QueryMap(encoded = true) Map<String , String> params);

}
