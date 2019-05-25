package com.swufe.timesaving.Mine.Task;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.swufe.timesaving.Info.Friend.FriendFragment;
import com.swufe.timesaving.Info.Message.MessageFragment;
import com.swufe.timesaving.Info.News.NewsFragment;
import com.swufe.timesaving.Info.TitleFragmentPagerAdapter;
import com.swufe.timesaving.R;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReceivedFragment());
        fragments.add(new PublishedFragment());

        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"已接受", "已发布"});
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        toolbar=findViewById(R.id.toolbar5);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
