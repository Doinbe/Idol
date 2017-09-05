package com.idol.cn.idol.retrofitclient.repositoryapi;

import com.idol.cn.idol.entity.NewListResponse;

import java.util.Map;
import rx.Observable;

/**
 * Created by solin on 2017/7/4.
 */

public interface NewRepositoryApi {
    Observable<NewListResponse> getNewList(Map<String,String> params);
}
