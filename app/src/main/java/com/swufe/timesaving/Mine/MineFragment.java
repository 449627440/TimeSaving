package com.swufe.timesaving.Mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swufe.timesaving.R;

import cn.bmob.v3.BmobUser;

public class MineFragment extends Fragment {

    private View view;
    private TextView textView;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mine, container,false);
        textView=view.findViewById(R.id.textView);
        textView.setText((String)BmobUser.getObjectByKey("nickName"));
        toolbar=view.findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
