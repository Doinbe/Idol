package com.idol.cn.idol.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.idol.cn.idol.R;
import com.idol.cn.idol.entity.NewEntity;

import java.util.List;

/**
 * Created by solin on 2017/7/11.
 */

public class NewItemAdapter extends BaseQuickAdapter<NewEntity,BaseViewHolder> {

    public NewItemAdapter(@LayoutRes int layoutResId, @Nullable List<NewEntity> data) {
        super(layoutResId, data);
    }

    public NewItemAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewEntity item) {
        Glide.with(mContext).load(item.thumbnail_pic_s).crossFade().into((ImageView)helper.getView(R.id.item_image));
        helper.setText(R.id.item_title,item.title);
    }
}
