package com.swufe.timesaving.Mine.Info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.Main.Methods.PersonInfo.PersonInfoActivity;
import com.swufe.timesaving.R;

import cn.bmob.v3.BmobUser;

public class MyInfoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView textView1,textView2,textView3,textView4,textView5;
    private TextView textView6,textView7,textView8,textView9,textView10;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        toolbar=findViewById(R.id.toolbar6);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textView1=findViewById(R.id.editText4);
        User user = BmobUser.getCurrentUser(User.class);
        textView1.setText(user.getName());
        textView2=findViewById(R.id.spinner);
        textView2.setText(user.getIDCard());
        textView3=findViewById(R.id.editText2);
        textView4=findViewById(R.id.editText17);
        textView5=findViewById(R.id.editText12);
        textView6=findViewById(R.id.editText13);
        textView7=findViewById(R.id.editText14);
        textView8=findViewById(R.id.editText15);
        textView9=findViewById(R.id.editText16);
        textView10=findViewById(R.id.add_content);
        textView3.setText(user.getAge());
        textView4.setText(user.getEmergentPerson());
        textView5.setText(user.getEmergentPhone());
        textView6.setText(user.getProvince());
        textView7.setText(user.getCity());
        textView8.setText(user.getCounty());
        textView9.setText(user.getStreet());
        textView10.setText(user.getBriefIntro());

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MyInfoActivity.this, PersonInfoActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        User user = BmobUser.getCurrentUser(User.class);
        textView1.setText(user.getName());
        textView2.setText(user.getIDCard());
        textView3.setText(user.getAge());
        textView4.setText(user.getEmergentPerson());
        textView5.setText(user.getEmergentPhone());
        textView6.setText(user.getProvince());
        textView7.setText(user.getCity());
        textView8.setText(user.getCounty());
        textView9.setText(user.getStreet());
        textView10.setText(user.getBriefIntro());
    }
}
