package com.swufe.timesaving.Mine.Task;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.swufe.timesaving.Init.Published;
import com.swufe.timesaving.Mine.Task.PublishedAdapter;
import com.swufe.timesaving.R;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static android.content.ContentValues.TAG;

public class PublishedFragment extends Fragment {
    private View view;
    private GridView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_published, container,false);
        listView=view.findViewById(R.id.gridview);
        BmobQuery<Published> query = new BmobQuery<>();
        query.addWhereEqualTo("username", String.valueOf(BmobUser.getCurrentUser().getUsername()));
        query.setLimit(50);
        query.findObjects(new FindListener<Published>() {
            @Override
            public void done(List<Published> list, BmobException e) {
                if(e==null){
                    Log.i(TAG, "onCreateView: "+list);
                    listView.setAdapter(new PublishedAdapter(getActivity(),list));
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
