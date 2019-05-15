package com.swufe.timesaving.Info;

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

public class FriendFragment extends Fragment {
    private View view;
    private GridView listView;
    private List<String[]> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_friend, container,false);
        list=new ArrayList<>();
        list.add(new String[]{"盐假洁", "http://bmob-cdn-21576.b0.upaiyun.com/2018/09/22/f0143a5440f171ee8047f13e5fd528c7.png"});
        list.add(new String[]{"盐假洁", "http://bmob-cdn-21576.b0.upaiyun.com/2018/09/22/f0143a5440f171ee8047f13e5fd528c7.png"});
        listView=view.findViewById(R.id.gridview);
        Log.i(TAG, "onCreateView: "+list);
        listView.setAdapter(new FriendAdapter(getActivity(),list));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
