package com.swufe.timesaving;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hjm.bottomtabbar.BottomTabBar;
import com.swufe.timesaving.Main.MainFragment;

public class MainActivity extends AppCompatActivity {


    private BottomTabBar mBottomTabBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);

        mBottomTabBar
                .init(getSupportFragmentManager())//初始化方法，必须第一个调用；传入参数为V4包下的FragmentManager
                .setImgSize(30,30)//设置ICON图片的尺寸
                .setFontSize(16)//设置文字的尺寸
                .setTabPadding(4,6,10)//设置ICON图片与上部分割线的间隔、图片与文字的间隔、文字与底部的间隔
                .addTabItem("首页", R.drawable.main_logo, MainFragment.class)//设置文字、一张图片、fragment
                .addTabItem("信息", R.drawable.message_logo, MainFragment.class)//设置文字、一张图片、fragment
                .addTabItem("我的", R.drawable.mine_logo, MainFragment.class)//设置文字、一张图片、fragment
                .isShowDivider(false)//设置是否显示分割线
                .setTabBarBackgroundColor(Color.WHITE)//设置底部导航栏颜色
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        Log.i("TGA", "位置：" + position + "      选项卡的文字内容：" + name);

                    }
                })
                .setCurrentTab(0);//设置当前选中的Tab，从0开始
    }
}
