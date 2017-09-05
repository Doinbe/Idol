package com.idol.cn.idol.present;

import com.idol.cn.idol.base.BaseSubscriber;
import com.idol.cn.idol.entity.NewListResponse;
import com.idol.cn.idol.pview.News;
import com.idol.cn.idol.retrofitclient.repositoryapi.NewRepositoryApi;

import java.util.Map;

/**
 * Created by solin on 2017/7/4.
 */

public class NewPresent implements News.Present {
    private News.View mView;
    private NewRepositoryApi mRepositoryApi;

    public NewPresent(News.View mView,NewRepositoryApi mRepositoryApi){
        setView(mView);
        this.mRepositoryApi=mRepositoryApi;
    }

    @Override
    public void setView(News.View view) {
        this.mView=view;
    }

    @Override
    public void getNewList(Map<String, String> params) {
        mView.showDialog();
        mRepositoryApi.getNewList(params)
                .subscribe(new BaseSubscriber<NewListResponse>(mView){
                    @Override
                    public void onNext(NewListResponse newListResponse) {
                        super.onNext(newListResponse);
                        mView.dismissDialog();
                        mView.showDatas(newListResponse);
                    }
                });
    }
}
