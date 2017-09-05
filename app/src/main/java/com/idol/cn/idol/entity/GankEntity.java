package com.idol.cn.idol.entity;

import java.util.List;

/**
 * Created by solin on 2017/6/26.
 */

public class GankEntity{
    /**
     * _id : 592502d6421aa92c769a8bac
     * createdAt : 2017-05-24T11:49:42.14Z
     * desc : Whatʼs new in Swift 4
     * images : ["http://img.gank.io/44e8aa0a-b66f-4a5b-9cb0-74c3ae9fc156"]
     * publishedAt : 2017-05-24T12:09:25.526Z
     * source : chrome
     * type : iOS
     * url : https://github.com/ole/whats-new-in-swift-4
     * used : true
     * who : S
     */

    public String _id;
    public String createdAt;
    public String desc;
    public String publishedAt;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String who;
    public List<String> images;

}
