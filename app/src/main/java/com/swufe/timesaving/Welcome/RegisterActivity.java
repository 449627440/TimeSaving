package com.swufe.timesaving.Welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jkb.vcedittext.VerificationCodeEditText;
import com.swufe.timesaving.R;
import com.swufe.timesaving.init.User;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phone;
    private EditText password,password1,code;
    private Button send;
    private Button register;
    private String sphone = "";
    private String spassword = "";
    private String spassword1 = " ";
    private String scode = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phone = findViewById(R.id.editText2);
        password = findViewById(R.id.editText);
        password1 = findViewById(R.id.editText5);
        code = findViewById(R.id.editText3);

        send = findViewById(R.id.button_getVcode);
        send.setOnClickListener(this);
        register = findViewById(R.id.button);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_getVcode:
                sphone = phone.getText().toString();
                if(!sphone.equals("") && sphone.length() == 11){
                    BmobSMS.requestSMSCode(sphone, "诚信状", new QueryListener<Integer>() {
                        @Override
                        public void done(Integer integer, BmobException e) {
                            if(e == null){
                                Toast.makeText(getApplicationContext(),"短信验证码已发送",Toast.LENGTH_SHORT).show();
                                send.setEnabled(false);
                                new CountDownTimer(60000,1000){
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        send.setText(millisUntilFinished / 1000 + "秒");
                                    }
                                    @Override
                                    public void onFinish() {
                                        send.setEnabled(true);
                                        send.setText("重新发送");
                                    }
                                }.start();
                            }
                            else
                                Toast.makeText(getApplicationContext(),"短信验证码发送失败，请稍后重试",Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    Toast.makeText(this,"手机号码格式不正确",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button:
                spassword = password.getText().toString();
                scode = code.getText().toString();
                if(!spassword.equals("") && !scode.equals("") && !spassword1.equals("") && spassword.equals(spassword1)){
                    User user = new User();
                    user.setUsername(sphone);
                    user.setMobilePhoneNumber(sphone);//设置手机号码（必填）
                    user.setPassword(spassword);
                    user.setNickname("城事");
                    user.setHeadPortrait("http://bmob-cdn-21576.b0.upaiyun.com/2018/09/22/f0143a5440f171ee8047f13e5fd528c7.png");
                    user.signOrLogin(scode, new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if(e == null){
                                Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent();
                                        intent.putExtra("phone",sphone);
                                        intent.putExtra("pwd",spassword);
                                        setResult(2, intent);
                                        finish();
                                    }
                                }, 1000);//1.5秒后执行Runnable中的run方法
                            }else if(!spassword.equals("") && !scode.equals("") && !spassword1.equals("") && !spassword.equals(spassword1)){
                                Toast.makeText(getApplicationContext(),"请检查密码是否填写正确",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"短信验证码错误或已注册",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(this,"请把内容填写完整",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
