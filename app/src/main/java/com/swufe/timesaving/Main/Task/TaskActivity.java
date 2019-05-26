package com.swufe.timesaving.Main.Task;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.swufe.timesaving.Init.Received;
import com.swufe.timesaving.Init.Task;
import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.R;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class TaskActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Task list;
    private TextView textView1,textView2,textView3,textView4,textView5;
    private TextView textView6,textView7,textView8,textView9,textView10;
    private TextView textView11,textView12,textView13,textView14,textView15;
    private Button button;
    private int clicked=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        toolbar=findViewById(R.id.toolbar6);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        list= (Task) getIntent().getSerializableExtra("list");
        textView1=findViewById(R.id.name);
        textView1.setText(list.getName());
        textView2=findViewById(R.id.spinner);
        textView2.setText(list.getType());
        textView3=findViewById(R.id.editText2);
        textView3.setText(list.getPeopleNum());
        textView4=findViewById(R.id.editText6);
        textView4.setText(list.getStartYear());
        textView5=findViewById(R.id.editText7);
        textView5.setText(list.getStartMonth());
        textView6=findViewById(R.id.editText8);
        textView6.setText(list.getStartDate());
        textView7=findViewById(R.id.editText9);
        textView7.setText(list.getEndYear());
        textView8=findViewById(R.id.editText10);
        textView8.setText(list.getEndMonth());
        textView9=findViewById(R.id.editText11);
        textView9.setText(list.getEndDate());
        textView10=findViewById(R.id.editText12);
        textView10.setText(list.getCoinNum());
        textView11=findViewById(R.id.editText13);
        textView11.setText(list.getProvinceName());
        textView12=findViewById(R.id.editText14);
        textView12.setText(list.getCityName());
        textView13=findViewById(R.id.editText15);
        textView13.setText(list.getDistrictName());
        textView14=findViewById(R.id.editText16);
        textView14.setText(list.getDetailAddress());
        textView15=findViewById(R.id.add_content);
        textView15.setText(list.getDetail());

        button=findViewById(R.id.button);
        Log.i("TaskActivity", "onCreate: "+list.getReceived());
        if(list.getReceived()==true){
            button.setText("已领取");
        }else{
            Log.i("TaskActivity", "onCreate: "+clicked);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clicked == 0) {
                        clicked++;
                        list.setReceived(true);
                        list.update(new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                Received received = new Received();
                                received.setUsername(BmobUser.getCurrentUser(User.class).getUsername());
                                received.setName(list.getName());
                                received.setType(list.getType());
                                received.setPeopleNum(list.getPeopleNum());
                                received.setStartYear(list.getStartYear());
                                received.setStartMonth(list.getStartMonth());
                                received.setStartDate(list.getStartDate());
                                received.setEndYear(list.getEndYear());
                                received.setEndMonth(list.getEndMonth());
                                received.setEndDate(list.getEndDate());
                                received.setCoinNum(list.getCoinNum());
                                received.setProvinceName(list.getProvinceName());
                                received.setCityName(list.getCityName());
                                received.setDistrictName(list.getDistrictName());
                                received.setDetailAddress(list.getDetailAddress());
                                received.setDetail(list.getDetail());
                                received.setTypeImage("http://bmob-cdn-25862.b0.upaiyun.com/2019/05/19/3dbd426b4055004b80fa0e08a935907c.png");
                                received.setiD(list.getObjectId());
                                received.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if(e==null){

                                        }
                                    }
                                });
                                button.setText("已领取");
                                Toast.makeText(getApplicationContext(),"成功领取！",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }


                }
            });
        }


    }
}
