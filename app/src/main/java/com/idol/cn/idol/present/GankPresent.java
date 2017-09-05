package com.idol.cn.idol.present;

import com.idol.cn.idol.base.BaseSubscriber;
import com.idol.cn.idol.entity.GankListResponse;
import com.idol.cn.idol.pview.Gank;
import com.idol.cn.idol.retrofitclient.repositoryapi.GankRepositoryApi;

/**
 * Created by solin on 2017/6/26.
 */

public class GankPresent implements Gank.Present{

    private Gank.View mView;
    private GankRepositoryApi mRepositoryApi;

    public GankPresent(Gank.View view,GankRepositoryApi repositoryApi){
        setView(view);
        this.mRepositoryApi=repositoryApi;
    }

    @Override
    public void setView(Gank.View view) {
        this.mView=view;
    }

    @Override
    public void getGanKList(String gankNamen,int pageSize,int pageNo) {
        mRepositoryApi.getGanKList(gankNamen,pageSize,pageNo)
                .subscribe(new BaseSubscriber<GankListResponse>(mView){
                    @Override
                    public void onNext(GankListResponse response) {
                        super.onNext(response);
                        mView.showDatas(response);
                    }
                });
    }
}
