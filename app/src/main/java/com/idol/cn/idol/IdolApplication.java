package com.idol.cn.idol;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.idol.cn.idol.retrofitclient.RetrofitClient;

/**
 * Created by solin on 2017/6/27.
 */

public class IdolApplication extends Application {
    public static Context mContext;
    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        RetrofitClient.init();
        Utils.init(mContext);
    }
}
