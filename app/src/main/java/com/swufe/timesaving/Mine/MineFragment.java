package com.swufe.timesaving.Mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.swufe.timesaving.Mine.Task.TaskActivity;
import com.swufe.timesaving.R;
import com.swufe.timesaving.Welcome.LoginActivity;

import cn.bmob.v3.BmobUser;

public class MineFragment extends Fragment {

    private View view;
    private TextView textView;
    private Toolbar toolbar;
    private ConstraintLayout constraintLayout,constraintLayout1;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mine, container,false);
        textView=view.findViewById(R.id.textView);
        textView.setText((String)BmobUser.getObjectByKey("nickName"));
        toolbar=view.findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        constraintLayout=view.findViewById(R.id.constraintLayout);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), WalletActivity.class);
                startActivity(intent);
            }
        });
        constraintLayout1=view.findViewById(R.id.constraintLayout2);
        constraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), TaskActivity.class);
                startActivity(intent);
            }
        });
        button=view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser.logOut();
                Intent intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
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
