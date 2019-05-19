package com.swufe.timesaving.Info;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hjm.bottomtabbar.BottomTabBar;
import com.swufe.timesaving.Main.MainFragment;
import com.swufe.timesaving.Mine.MineFragment;
import com.swufe.timesaving.R;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_info, container,false);
        tabLayout=view.findViewById(R.id.tab);
        viewPager=view.findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FriendFragment());
        fragments.add(new MessageFragment());
        fragments.add(new NewsFragment());

        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getChildFragmentManager(), fragments, new String[]{"好友", "消息","新闻"});
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
