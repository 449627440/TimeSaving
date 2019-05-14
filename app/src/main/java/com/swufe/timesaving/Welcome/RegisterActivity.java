package com.swufe.timesaving.Welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.jkb.vcedittext.VerificationCodeEditText;
import com.swufe.timesaving.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText phone;
    private EditText password;
    private VerificationCodeEditText code;
    private Button send;
    private Button register;
    private String sphone = " ";
    private String spassword = " ";
    private String scode = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }
}
