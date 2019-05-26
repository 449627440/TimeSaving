package com.swufe.timesaving.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.swufe.timesaving.Blockchain.BlockchainActivity;
import com.swufe.timesaving.Init.Welfare;
import com.swufe.timesaving.Main.Methods.MethodActivity;
import com.swufe.timesaving.Main.Methods.PersonInfo.PersonInfoActivity;
import com.swufe.timesaving.Main.Publish.PublishActivity;
import com.swufe.timesaving.Main.TaskList.TaskListActivity;
import com.swufe.timesaving.Main.Welfare.WelfareActivity;
import com.swufe.timesaving.R;

public class MainFragment extends Fragment {

    private View view;
    private ImageView imageView,imageView1,imageView2,imageView3,imageView4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_main, container,false);
        imageView=view.findViewById(R.id.imageView13);
        imageView1=view.findViewById(R.id.imageView14);
        imageView2=view.findViewById(R.id.imageView15);
        imageView3=view.findViewById(R.id.imageView16);
        imageView4=view.findViewById(R.id.imageView29);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), PublishActivity.class);
                startActivity(intent);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), TaskListActivity.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), WelfareActivity.class);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), MethodActivity.class);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), BlockchainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
