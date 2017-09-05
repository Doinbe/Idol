package com.idol.cn.idol.retrofitclient;

import com.idol.cn.idol.retrofitclient.repository.GankRepository;
import com.idol.cn.idol.retrofitclient.repository.NewRepository;
import com.idol.cn.idol.retrofitclient.repositoryapi.GankRepositoryApi;
import com.idol.cn.idol.retrofitclient.repositoryapi.NewRepositoryApi;

/**
 * 统一管理Repository的工厂类
 * Created by solin on 2017/6/26.
 */

public class RepositoryFactory {

    public static GankRepositoryApi getGankRepository(){
        return new GankRepository();
    }
    public static NewRepositoryApi getNewReRepository() {
        return new NewRepository();
    }
}
