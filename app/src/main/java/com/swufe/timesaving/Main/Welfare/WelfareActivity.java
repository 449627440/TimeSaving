package com.swufe.timesaving.Main.Welfare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.swufe.timesaving.Init.Task;
import com.swufe.timesaving.Init.Welfare;
import com.swufe.timesaving.Main.Task.TaskActivity;
import com.swufe.timesaving.Main.TaskList.TaskListActivity;
import com.swufe.timesaving.Main.TaskList.TaskListAdapter;
import com.swufe.timesaving.R;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

public class WelfareActivity extends AppCompatActivity {

    private GridView listView;
    private static String TAG = "TaskActivity";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welfare);

        listView = findViewById(R.id.gridview);
        String bql ="select * from Welfare";
        new BmobQuery<Welfare>().doSQLQuery(bql,new SQLQueryListener<Welfare>(){
            @Override
            public void done(BmobQueryResult<Welfare> bmobQueryResult, BmobException e) {
                if(e==null){
                    final List<Welfare> list = bmobQueryResult.getResults();
                    if(list!=null && list.size()>0){
                        listView.setAdapter(new WelfareAdapter(getBaseContext(),list));
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent = new Intent();
                                intent.setClass(WelfareActivity.this, WelfareTaskActivity.class);
                                intent.putExtra("list",list.get(i));
                                startActivity(intent);
                            }
                        });
                    }else{
                        Log.i(TAG, "done: 查询成功，无数据返回");
                    }
                }else {
                    Log.i(TAG, "done: "+e);
                }
            }
        });
        toolbar=findViewById(R.id.toolbar4);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
