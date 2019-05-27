package com.swufe.timesaving.Mine.Task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.swufe.timesaving.Init.Published;
import com.swufe.timesaving.Init.Received;
import com.swufe.timesaving.Init.Task;
import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.Init.Welfare;
import com.swufe.timesaving.R;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class PublishedActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Published list;
    private TextView textView1,textView2,textView3,textView4,textView5;
    private TextView textView6,textView7,textView8,textView9,textView10;
    private TextView textView11,textView12,textView13,textView14,textView15,textView16;
    private Button button;
    private int clicked=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_published);
        toolbar=findViewById(R.id.toolbar6);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        list= (Published) getIntent().getSerializableExtra("list");
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
        textView16=findViewById(R.id.textView52);
        textView16.setText(list.getPasswd());

        button=findViewById(R.id.button);
        Log.i("TaskActivity", "onCreate: "+clicked);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked == 0) {
                    clicked++;
                    BmobQuery<Task> query=new BmobQuery<>();
                    query.addWhereEqualTo("objectId",list.getiD());
                    query.findObjects(new FindListener<Task>() {
                        @Override
                        public void done(List<Task> list1, BmobException e) {
                            if(e==null){
                                Task task = list1.get(0);
                                task.delete(new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        if(e==null){
                                            BmobQuery<Received> query=new BmobQuery<>();
                                            query.addWhereEqualTo("objectId",list.getiD());
                                            query.findObjects(new FindListener<Received>() {
                                                @Override
                                                public void done(List<Received> list2, BmobException e) {
                                                    if(e==null){
                                                        Received received = list2.get(0);
                                                        received.delete(new UpdateListener() {
                                                            @Override
                                                            public void done(BmobException e) {
                                                                if(e==null){
                                                                    list.delete(new UpdateListener() {
                                                                        @Override
                                                                        public void done(BmobException e) {
                                                                            button.setText("请回到发布界面重新发布");
                                                                            Toast.makeText(getApplicationContext(),"请回到发布界面重新发布！",Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        });

                                                    }else {
                                                        Log.i("PublishedActivity", "done: "+e);
                                                        list.delete(new UpdateListener() {
                                                            @Override
                                                            public void done(BmobException e) {
                                                                button.setText("请回到发布界面重新发布");
                                                                Toast.makeText(getApplicationContext(),"请回到发布界面重新发布！",Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                                    }
                                                }
                                            });

                                        }

                                    }
                                });
                            }else {
                                Log.i("ReceivedActivity", "done: "+e);
                                BmobQuery<Welfare> query=new BmobQuery<>();
                                query.addWhereEqualTo("objectId",list.getiD());
                                query.findObjects(new FindListener<Welfare>() {
                                    @Override
                                    public void done(List<Welfare> list1, BmobException e) {
                                        if(e==null){
                                            Welfare welfare = list1.get(0);
                                            welfare.delete(new UpdateListener() {
                                                @Override
                                                public void done(BmobException e) {
                                                    if(e==null){
                                                        BmobQuery<Received> query=new BmobQuery<>();
                                                        query.addWhereEqualTo("objectId",list.getiD());
                                                        query.findObjects(new FindListener<Received>() {
                                                            @Override
                                                            public void done(List<Received> list2, BmobException e) {
                                                                if(e==null){
                                                                    Received received = list2.get(0);
                                                                    received.delete(new UpdateListener() {
                                                                        @Override
                                                                        public void done(BmobException e) {
                                                                            if(e==null){
                                                                                list.delete(new UpdateListener() {
                                                                                    @Override
                                                                                    public void done(BmobException e) {
                                                                                        button.setText("请回到发布界面重新发布");
                                                                                        Toast.makeText(getApplicationContext(),"请回到发布界面重新发布！",Toast.LENGTH_SHORT).show();
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    });

                                                                }else {
                                                                    Log.i("PublishedActivity", "done: "+e);
                                                                    list.delete(new UpdateListener() {
                                                                        @Override
                                                                        public void done(BmobException e) {
                                                                            button.setText("请回到发布界面重新发布");
                                                                            Toast.makeText(getApplicationContext(),"请回到发布界面重新发布！",Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        });

                                                    }

                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });



                }
            }
        });


    }
}
