package com.idol.cn.idol.retrofitclient.repository;

import com.idol.cn.idol.entity.GankListResponse;
import com.idol.cn.idol.retrofitclient.RetrofitClient;
import com.idol.cn.idol.retrofitclient.RxJavaUtil;
import com.idol.cn.idol.retrofitclient.repositoryapi.GankRepositoryApi;
import com.idol.cn.idol.retrofitclient.service.GankService;

import rx.Observable;

/**
 * Created by solin on 2017/6/26.
 */

public class GankRepository implements GankRepositoryApi {
    private GankService service;

    public GankRepository(){
        service = RetrofitClient.gank();
    }

    @Override
    public Observable<GankListResponse> getGanKList(String gankNamen, int pageSize, int pageNo) {
        return RxJavaUtil.getMainObservable(service.getGanKList(gankNamen,pageSize,pageNo));
    }
}
