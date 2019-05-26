package com.swufe.timesaving.Launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.MainActivity;
import com.swufe.timesaving.R;
import com.swufe.timesaving.Welcome.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class LaunchActivity extends Activity {

    private static String TAG = "LaunchActivity";
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Bmob.initialize(this, "273aad069f5dbbe226e9278c273d2363");

        User bmobUser = BmobUser.getCurrentUser(User.class);
        handler=new Handler();
        if(bmobUser != null){
            // 允许用户使用
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },3000);


        }else{
            //缓存用户对象为空时， 可打开用户注册界面…
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(LaunchActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            },3000);

        }

    }


}
