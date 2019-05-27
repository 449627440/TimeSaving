package com.swufe.timesaving.Mine.Wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.Init.Wallet;
import com.swufe.timesaving.Mine.Task.PublishedActivity;
import com.swufe.timesaving.R;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class WalletActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;
    private ListView listView;

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
        listView=findViewById(R.id.listview);

        BmobQuery<Wallet> query=new BmobQuery<>();
        query.addWhereEqualTo("username",BmobUser.getCurrentUser(User.class).getUsername());
        query.order("-updateAt");
        query.findObjects(new FindListener<Wallet>() {
            @Override
            public void done(final List<Wallet> list, BmobException e) {
                listView.setAdapter(new WalletAdapter(getApplicationContext(),list));
            }
        });
    }
}
