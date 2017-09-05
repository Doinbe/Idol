package com.idol.cn.idol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.Utils;
import com.idol.cn.idol.adapter.TabAdapter;
/**
 * Created by solin on 2017/7/3.
 */

public class NewsMainActivity extends AppCompatActivity {

    private AppBarLayout app_bar;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager tabpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);
        initView();
        setTabs();
    }
    private void initView() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        app_bar= (AppBarLayout) findViewById(R.id.app_bar);
        tabs= (TabLayout) findViewById(R.id.tabs);
        tabpager= (ViewPager) findViewById(R.id.tabpager);
        setViewPager(tabpager);
    }
    private void setTabs() {
        tabs.addTab(tabs.newTab().setText("头条"));
        tabs.addTab(tabs.newTab().setText("社会"));
        tabs.addTab(tabs.newTab().setText("国内"));
        tabs.addTab(tabs.newTab().setText("国际"));
        tabs.addTab(tabs.newTab().setText("娱乐"));
        tabs.addTab(tabs.newTab().setText("体育"));
        tabs.addTab(tabs.newTab().setText("军事"));
        tabs.addTab(tabs.newTab().setText("科技"));
        tabs.addTab(tabs.newTab().setText("财经"));
        tabs.addTab(tabs.newTab().setText("时尚"));
        tabs.setupWithViewPager(tabpager);
    }

    private void setViewPager(ViewPager vPager){
        TabAdapter adapter=new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(NewTabFragment.newInstance("top"),"头条");
        adapter.addFragment(NewTabFragment.newInstance("shehui"),"社会");
        adapter.addFragment(NewTabFragment.newInstance("guonei"),"国内");
        adapter.addFragment(NewTabFragment.newInstance("guoji"),"国际");
        adapter.addFragment(NewTabFragment.newInstance("yule"),"娱乐");
        adapter.addFragment(NewTabFragment.newInstance("tiyu"),"体育");
        adapter.addFragment(NewTabFragment.newInstance("junshi"),"军事");
        adapter.addFragment(NewTabFragment.newInstance("keji"),"科技");
        adapter.addFragment(NewTabFragment.newInstance("caijing"),"财经");
        adapter.addFragment(NewTabFragment.newInstance("shishang"),"时尚");
        vPager.setAdapter(adapter);
    }





}
