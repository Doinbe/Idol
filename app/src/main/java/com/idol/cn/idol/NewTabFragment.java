package com.idol.cn.idol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.idol.cn.idol.adapter.NewItemAdapter;
import com.idol.cn.idol.entity.NewEntity;
import com.idol.cn.idol.entity.NewListResponse;
import com.idol.cn.idol.present.NewPresent;
import com.idol.cn.idol.pview.News;
import com.idol.cn.idol.retrofitclient.RepositoryFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by solin on 2017/7/3.
 */

public class NewTabFragment extends Fragment implements News.View,SwipeRefreshLayout.OnRefreshListener {

    private String TAB;
    private View mView;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerview;
    private NewItemAdapter itemAdapter;

    public static NewTabFragment newInstance(String tab){
        NewTabFragment fragnent=new NewTabFragment();
        Bundle args = new Bundle();
        args.putString("tab", tab);
        fragnent.setArguments(args);
        return fragnent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            TAB = bundle.get("tab").toString();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_tab,container,false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        getDatas();

    }

    private void initView(){
        refreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this);
        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        refreshLayout.setColorSchemeResources(R.color.Deep_Orange);
        recyclerview = (RecyclerView) mView.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        itemAdapter = new NewItemAdapter(R.layout.item_new_recycler);
        //添加item数据加载动画
        itemAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        itemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewEntity bean=(NewEntity)adapter.getItem(position);
                Toast.makeText(getActivity(), bean.title, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerview.setAdapter(itemAdapter);
    }

    private void getDatas(){
        Map<String,String> prarms=new HashMap<>();
        prarms.put("key","22ef69852520c99d4fd61265550d7477");
        prarms.put("type",TAB);
        new NewPresent(this,RepositoryFactory.getNewReRepository()).getNewList(prarms);
    }

    @Override
    public void showDatas(NewListResponse response) {
        itemAdapter.setNewData(response.result.data);
    }

    @Override
    public void onError(String message) {
        Snackbar snackbar = Snackbar.make(getView(),message, Snackbar.LENGTH_SHORT);
        setSnackbarBgColor(snackbar,R.color.Pink);
        dismissDialog();
    }

    private void setSnackbarBgColor(Snackbar snackbar,int color){
        snackbar.getView().setBackgroundColor(getResources().getColor(color));
        snackbar.show();
    }

    @Override
    public void onRefresh() {
        getDatas();
    }

    @Override
    public void showDialog() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void dismissDialog() {
        refreshLayout.setRefreshing(false);
    }
}
