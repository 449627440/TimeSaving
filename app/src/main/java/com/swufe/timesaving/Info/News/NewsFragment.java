package com.swufe.timesaving.Info.News;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

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
        list.add(new String[]{"1小时前", "随便写点吧","http://bmob-cdn-21576.b0.upaiyun.com/2019/05/16/7c3431e7406ef85880c9f17cceb1716a.jpg"});
        list.add(new String[]{"1天前", "随便写点吧","http://bmob-cdn-21576.b0.upaiyun.com/2019/05/16/cfe617e04016456580289c3e5f227a15.jpg"});
        list.add(new String[]{"1天前", "随便写点吧","http://bmob-cdn-21576.b0.upaiyun.com/2019/05/16/1ab8474740bb9add803e2411d556bb66.jpg"});
        list.add(new String[]{"1天前", "随便写点吧","http://bmob-cdn-21576.b0.upaiyun.com/2019/05/16/81604bb640eb916380f9e9ec38966119.jpg"});
        listView=view.findViewById(R.id.gridview);
        Log.i(TAG, "onCreateView: "+list);
        listView.setAdapter(new NewsAdapter(getActivity(),list));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
