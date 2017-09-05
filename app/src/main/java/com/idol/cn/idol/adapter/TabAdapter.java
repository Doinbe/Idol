package com.idol.cn.idol.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

/**
 * Created by solin on 2017/7/3.
 */

public class TabAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragments=new ArrayList<Fragment>();
    private final ArrayList<String> titles=new ArrayList<String>();

    public  void addFragment(Fragment fragment,String title){
        titles.add(title);
        fragments.add(fragment);
    }

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
