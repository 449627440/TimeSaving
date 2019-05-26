package com.swufe.timesaving.Main.Methods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.swufe.timesaving.Main.Methods.PersonInfo.PersonInfoActivity;
import com.swufe.timesaving.R;

public class MethodActivity extends AppCompatActivity {
    private Button button1,button2;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);

        button1=findViewById(R.id.button4);
        button2=findViewById(R.id.button5);
        toolbar=findViewById(R.id.toolbar2);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MethodActivity.this, PersonInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
