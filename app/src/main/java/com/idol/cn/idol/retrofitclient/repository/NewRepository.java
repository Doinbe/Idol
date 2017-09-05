package com.idol.cn.idol.retrofitclient.repository;

import com.idol.cn.idol.entity.NewListResponse;
import com.idol.cn.idol.retrofitclient.RetrofitClient;
import com.idol.cn.idol.retrofitclient.RxJavaUtil;
import com.idol.cn.idol.retrofitclient.repositoryapi.NewRepositoryApi;
import com.idol.cn.idol.retrofitclient.service.NewService;

import java.util.Map;

import rx.Observable;

/**
 * Created by solin on 2017/7/4.
 */

public class NewRepository implements NewRepositoryApi {
    private NewService service;

    public NewRepository(){
        service = RetrofitClient.news();
    }

    @Override
    public Observable<NewListResponse> getNewList(Map<String, String> params) {
        return RxJavaUtil.getMainObservable(service.getNewList(params));
    }
}
