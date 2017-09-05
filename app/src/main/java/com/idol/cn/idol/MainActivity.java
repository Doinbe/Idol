package com.idol.cn.idol;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.idol.cn.idol.menu.DrawerAdapter;
import com.idol.cn.idol.menu.DrawerItem;
import com.idol.cn.idol.menu.SimpleItem;
import com.idol.cn.idol.menu.SpaceItem;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    private static final int MENU_GIRL = 0;
    private static final int MENU_ANDROID = 1;
    private static final int MENU_IOS = 2;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withGravity(SlideGravity.LEFT)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(MENU_GIRL).setChecked(true),
                createItemFor(MENU_ANDROID),
                createItemFor(MENU_IOS),
                new SpaceItem(48)));
        adapter.setListener(this);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(MENU_GIRL);

    }


    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.menuDefaultColor))
                .withTextTint(color(R.color.menuDefaultColor))
                .withSelectedIconTint(color(R.color.menuIconColor))
                .withSelectedTextTint(color(R.color.menuTitleColor));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.menu_Titles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.menu_Icons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }


    @Override
    public void onItemSelected(int position) {
        switch (position){
            case MENU_GIRL:

                break;
            case MENU_ANDROID:
                startActivity(new Intent(this,NewsMainActivity.class));
                break;
            case MENU_IOS:
                startActivity(new Intent(this,MapActivity.class));
                break;
        }
    }
}
