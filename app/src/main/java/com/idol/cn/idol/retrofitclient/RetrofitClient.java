package com.idol.cn.idol.retrofitclient;


import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.idol.cn.idol.IdolApplication;
import com.idol.cn.idol.retrofitclient.service.GankService;
import com.idol.cn.idol.retrofitclient.service.NewService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络连接核心类
 * Created by solin on 2017/6/23.
 */

public class RetrofitClient {

    public static final int CONNECT_TIMEOUT=5;
    public static final int IO_TIMEOUT=5;

    public static OkHttpClient okHttpClient;
    public static Retrofit retrofit;

    /**
     * 初始化OkHttpClient
     */
    public static void init(){
        Context context = IdolApplication.getContext();
        Stetho.initializeWithDefaults(context);
        okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(new StethoInterceptor())//google Chrome 查看请求信息 日志
                .build();
    }

    private static Retrofit getRetrofit(){
        if(retrofit==null)retrofit=getRetrofit(okHttpClient);
        return retrofit;
    }

    private static Retrofit getRetrofit(OkHttpClient client){
        return getRetrofit(NetConfig.BASE_URL_NEWS,client);
    }

    private static Retrofit getRetrofit(String baseURL,OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static  <T> T getService(Retrofit retrofit, Class<T> service){
        return retrofit.create(service);
    }

    public static GankService gank(){
        return getService(getRetrofit(),GankService.class);
    }

    public static NewService news(){
        return getService(getRetrofit(),NewService.class);
    }
}
