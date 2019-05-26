package com.swufe.timesaving.Main.Methods.PersonInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.Init.Welfare;
import com.swufe.timesaving.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class PersonInfoActivity extends AppCompatActivity {

    private EditText editText1,editText2,editText3,editText4,editText5;
    private EditText editText6,editText7,editText8,editText9,editText10;
    private Button button1,button2;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        final User user = BmobUser.getCurrentUser(User.class);
        editText1=findViewById(R.id.editText4);
        editText1.setText(user.getName());
        editText2=findViewById(R.id.spinner);
        editText2.setText(user.getIDCard());
        editText3=findViewById(R.id.editText2);
        editText3.setText(user.getAge());
        editText4=findViewById(R.id.editText17);
        editText4.setText(user.getEmergentPerson());
        editText5=findViewById(R.id.editText12);
        editText5.setText(user.getEmergentPhone());
        editText6=findViewById(R.id.editText13);
        editText6.setText(user.getProvince());
        editText7=findViewById(R.id.editText14);
        editText7.setText(user.getCity());
        editText8=findViewById(R.id.editText15);
        editText8.setText(user.getCounty());
        editText9=findViewById(R.id.editText16);
        editText9.setText(user.getStreet());
        editText10=findViewById(R.id.add_content);
        editText10.setText(user.getBriefIntro());
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar=findViewById(R.id.toolbar6);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("PublishActivity", "onClick: " + editText8.getText());
                user.setName(String.valueOf(editText1.getText()));
                user.setIDCard(String.valueOf(editText2.getText()));
                user.setAge(String.valueOf(editText3.getText()));
                user.setEmergentPerson(String.valueOf(editText4.getText()));
                user.setEmergentPhone(String.valueOf(editText5.getText()));
                user.setProvince(String.valueOf(editText6.getText()));
                user.setCity(String.valueOf(editText7.getText()));
                user.setCounty(String.valueOf(editText8.getText()));
                user.setStreet(String.valueOf(editText9.getText()));
                user.setBriefIntro(String.valueOf(editText10.getText()));
                user.update(new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(getApplicationContext(),"提交成功，可以在个人信息页查看",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Log.i("PersonInfoActivity", "done: "+e);
                            Toast.makeText(getApplicationContext(),"请检查是否连接网络",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });





    }
}
