package com.swufe.timesaving.Mine.Task;

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

import com.swufe.timesaving.Init.Published;
import com.swufe.timesaving.Init.Received;
import com.swufe.timesaving.Mine.Task.PublishedAdapter;
import com.swufe.timesaving.R;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static android.content.ContentValues.TAG;

public class ReceivedFragment extends Fragment {
    private View view;
    private GridView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_published, container,false);
        listView=view.findViewById(R.id.gridview);
        BmobQuery<Received> query = new BmobQuery<>();
        query.addWhereEqualTo("username", String.valueOf(BmobUser.getCurrentUser().getUsername()));
        query.setLimit(50);
        query.findObjects(new FindListener<Received>() {
            @Override
            public void done(final List<Received> list, BmobException e) {
                if(e==null){
                    Log.i(TAG, "onCreateView: "+list);
                    listView.setAdapter(new ReceivedAdapter(getActivity(),list));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent=new Intent();
                            intent.setClass(getContext(),ReceivedActivity.class);
                            intent.putExtra("list",list.get(i));
                            startActivity(intent);
                        }
                    });
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        BmobQuery<Received> query = new BmobQuery<>();
        query.addWhereEqualTo("username", String.valueOf(BmobUser.getCurrentUser().getUsername()));
        query.setLimit(50);
        query.findObjects(new FindListener<Received>() {
            @Override
            public void done(final List<Received> list, BmobException e) {
                if(e==null){
                    Log.i(TAG, "onCreateView: "+list);
                    listView.setAdapter(new ReceivedAdapter(getActivity(),list));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent=new Intent();
                            intent.setClass(getContext(),ReceivedActivity.class);
                            intent.putExtra("list",list.get(i));
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}
