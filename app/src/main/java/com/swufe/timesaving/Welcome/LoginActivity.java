package com.swufe.timesaving.Welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.swufe.timesaving.MainActivity;
import com.swufe.timesaving.R;
import com.swufe.timesaving.Init.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;
    private TextView register;
    private String susername;
    private String spassword;
    private String lastname;
    private SharedPreferences spLoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "273aad069f5dbbe226e9278c273d2363");

        User bmobUser = BmobUser.getCurrentUser(User.class);
        if(bmobUser != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        username = findViewById(R.id.editText2);
        password = findViewById(R.id.editText);
        login = findViewById(R.id.button);
        login.setOnClickListener(this);
        register = findViewById(R.id.textView2);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.button:
                susername = username.getText().toString();
                spassword = password.getText().toString();
                if(!susername.equals("") && !spassword.equals("")){
                    BmobUser.loginByAccount(susername, spassword, new LogInListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if(user!=null){
                                Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
                                password.setText("");
                            }
                        }
                    });
                }else {
                    Toast.makeText(getApplicationContext(),"请正确输入",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.textView2:
                intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==2){
            if(requestCode==2){
                String phone=data.getStringExtra("phone");
                String pwd=data.getStringExtra("pwd");
                Log.i("login", "onActivityResult: phone="+phone);
                username.setText(phone);
                password.setText(pwd);
            }
        }
    }
}
