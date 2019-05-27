package com.swufe.timesaving.Mine.Wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.R;

import cn.bmob.v3.BmobUser;

public class WalletActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        toolbar=findViewById(R.id.toolbar3);
        toolbar.setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textView=findViewById(R.id.textView13);
        textView.setText(String.valueOf(BmobUser.getCurrentUser(User.class).getCoin().intValue()));
        Log.i("WalletActivity", "onCreate: "+BmobUser.getCurrentUser(User.class).getCoin().intValue());
    }
}
