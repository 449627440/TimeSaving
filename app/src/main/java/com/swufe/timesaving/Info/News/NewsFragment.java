package com.swufe.timesaving.Info.News;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.swufe.timesaving.Main.Task.TaskActivity;
import com.swufe.timesaving.Main.TaskList.TaskListActivity;
import com.swufe.timesaving.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class NewsFragment extends Fragment {

    private View view;
    private GridView listView;
    private List<String[]> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_news, container,false);
        list=new ArrayList<>();
        list.add(new String[]{"1小时前", "时间银行提案走进两会","http://bmob-cdn-21576.b0.upaiyun.com/2019/05/16/7c3431e7406ef85880c9f17cceb1716a.jpg","https://mp.weixin.qq.com/s/SrzjB55kMnydPf6dwpRJIQ"});
        list.add(new String[]{"1天前", "时间银行","http://bmob-cdn-21576.b0.upaiyun.com/2019/05/16/cfe617e04016456580289c3e5f227a15.jpg","https://mp.weixin.qq.com/s?__biz=MzU2NzkzNTIyNw==&mid=2247483654&idx=1&sn=d901de75db3a87a4e02d7d5ddce0c988&chksm=fc94e892cbe361846dc0cff8574fd932ca030662ff5baaddc709d8a38225928e9c6f06a72724&bizpsid=1558943191&scene=126&sessionid=1558943191&ascene=3&devicetype=android-26&version=2700043b&nettype=WIFI&abtest_cookie=BAABAAoACwASABMABgAjlx4AVpkeAL2ZHgDcmR4A9pkeAAOaHgAAAA%3D%3D&lang=zh_CN&pass_ticket=c0UdJTN0NxY%2BngaG7pArNw3pm5NzEoj81h%2F%2BI3yVbfRzLprrvzn%2FhE715N2oeTgM&wx_header=1"});
        list.add(new String[]{"1小时前", "南京市推广“时间银行”互助养老新模式","http://bmob-cdn-21576.b0.upaiyun.com/2019/05/16/1ab8474740bb9add803e2411d556bb66.jpg","https://mp.weixin.qq.com/s?__biz=MzUxMDU5MjEyOA==&mid=2247483962&idx=1&sn=a8542a3bcff71d39032d983bceede0dd&chksm=f901d7d5ce765ec3c61ad725124adcea84d6e27c947ea7bdefe94845ab6029e2585eac7f6456&mpshare=1&scene=23&srcid=#rd"});
        listView=view.findViewById(R.id.gridview);
        Log.i(TAG, "onCreateView: "+list);
        listView.setAdapter(new NewsAdapter(getActivity(),list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(getContext(), NewsActivity.class);
                intent.putExtra("title",list.get(i)[1]);
                intent.putExtra("website",list.get(i)[3]);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
