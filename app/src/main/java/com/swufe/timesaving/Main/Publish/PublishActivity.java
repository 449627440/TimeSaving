package com.swufe.timesaving.Main.Publish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.swufe.timesaving.Init.Published;
import com.swufe.timesaving.Init.Task;
import com.swufe.timesaving.Init.User;
import com.swufe.timesaving.Init.Welfare;
import com.swufe.timesaving.R;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class PublishActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editText,editText1,editText2,editText3;
    private EditText editText4,editText5,editText6,editText7;
    private EditText editText8,editText9,editText10,editText11;
    private EditText editText12,editText13;
    private Button button,button1;
    private Spinner spinner;
    private String spin=null;
    private final String[] spinnerItems = {"关爱服务","家政服务","家庭维修","培训教育","医疗保健","文化艺术","定制服务","其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        toolbar=findViewById(R.id.toolbar6);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        editText=findViewById(R.id.editText4);
        spinner=findViewById(R.id.spinner);
        spinner.setDropDownWidth(400); //下拉宽度
        spinner.setDropDownHorizontalOffset(100); //下拉的横向偏移
        spinner.setDropDownVerticalOffset(100); //下拉的纵向偏移
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spin = spinnerItems[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        editText1=findViewById(R.id.editText2);
        editText2=findViewById(R.id.editText6);
        editText3=findViewById(R.id.editText7);
        editText4=findViewById(R.id.editText8);
        editText5=findViewById(R.id.editText9);
        editText6=findViewById(R.id.editText10);
        editText7=findViewById(R.id.editText11);
        editText8=findViewById(R.id.editText12);
        editText9=findViewById(R.id.editText13);
        editText10=findViewById(R.id.editText14);
        editText11=findViewById(R.id.editText15);
        editText12=findViewById(R.id.editText16);
        editText13=findViewById(R.id.add_content);
        button=findViewById(R.id.button);
        button1=findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("PublishActivity", "onClick: "+String.valueOf(editText8.getText()));
                if(editText.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText1.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText2.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText3.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText4.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if (editText5.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText6.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText7.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText8.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText9.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText10.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText11.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText12.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else if(editText13.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"请检查是否填写完整",Toast.LENGTH_SHORT).show();
                }else {
                    if(String.valueOf(editText8.getText()).equals("0")){
                        final Welfare welfare = new Welfare();
                        final Published published = new Published();
                        welfare.setName(String.valueOf(editText.getText()));
                        welfare.setType(spin);
                        welfare.setPeopleNum(String.valueOf(editText1.getText()));
                        welfare.setStartYear(String.valueOf(editText2.getText()));
                        welfare.setStartMonth(String.valueOf(editText3.getText()));
                        welfare.setStartDate(String.valueOf(editText4.getText()));
                        welfare.setEndYear(String.valueOf(editText5.getText()));
                        welfare.setEndMonth(String.valueOf(editText6.getText()));
                        welfare.setEndDate(String.valueOf(editText7.getText()));
                        welfare.setCoinNum(String.valueOf(editText8.getText()));
                        welfare.setProvinceName(String.valueOf(editText9.getText()));
                        welfare.setCityName(String.valueOf(editText10.getText()));
                        welfare.setDistrictName(String.valueOf(editText11.getText()));
                        welfare.setDetailAddress(String.valueOf(editText12.getText()));
                        welfare.setDetail(String.valueOf(editText13.getText()));

                        published.setUsername(BmobUser.getCurrentUser(User.class).getUsername());
                        published.setName(String.valueOf(editText.getText()));
                        published.setType(spin);
                        published.setPeopleNum(String.valueOf(editText1.getText()));
                        published.setStartYear(String.valueOf(editText2.getText()));
                        published.setStartMonth(String.valueOf(editText3.getText()));
                        published.setStartDate(String.valueOf(editText4.getText()));
                        published.setEndYear(String.valueOf(editText5.getText()));
                        published.setEndMonth(String.valueOf(editText6.getText()));
                        published.setEndDate(String.valueOf(editText7.getText()));
                        published.setCoinNum(String.valueOf(editText8.getText()));
                        published.setProvinceName(String.valueOf(editText9.getText()));
                        published.setCityName(String.valueOf(editText10.getText()));
                        published.setDistrictName(String.valueOf(editText11.getText()));
                        published.setDetailAddress(String.valueOf(editText12.getText()));
                        published.setDetail(String.valueOf(editText13.getText()));

                        welfare.setTypeImage("http://bmob-cdn-25862.b0.upaiyun.com/2019/05/19/3dbd426b4055004b80fa0e08a935907c.png");
                        published.setTypeImage("http://bmob-cdn-25862.b0.upaiyun.com/2019/05/19/3dbd426b4055004b80fa0e08a935907c.png");
                        welfare.save(new SaveListener<String>() {
                            @Override
                            public void done(String s, BmobException e) {
                                if(e==null){
                                    published.save(new SaveListener<String>() {
                                        @Override
                                        public void done(String s, BmobException e) {
                                            if(e==null){
                                                Log.i("PublishActivity", "done: 成功");
                                                Toast.makeText(getApplicationContext(),"提交成功，等待小伙伴们参与哦~",Toast.LENGTH_SHORT).show();
                                                finish();
                                            }else {
                                                Log.i("PublishActivity", "done: "+e);
                                                Toast.makeText(getApplicationContext(),"请检查是否填写正确",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }else {
                                    Log.i("PublishActivity", "done: "+e);
                                    Toast.makeText(getApplicationContext(),"请检查是否填写正确",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else {
                        final Task task = new Task();
                        final Published published=new Published();
                        task.setName(String.valueOf(editText.getText()));
                        task.setType(spin);
                        task.setPeopleNum(String.valueOf(editText1.getText()));
                        task.setStartYear(String.valueOf(editText2.getText()));
                        task.setStartMonth(String.valueOf(editText3.getText()));
                        task.setStartDate(String.valueOf(editText4.getText()));
                        task.setEndYear(String.valueOf(editText5.getText()));
                        task.setEndMonth(String.valueOf(editText6.getText()));
                        task.setEndDate(String.valueOf(editText7.getText()));
                        task.setCoinNum(String.valueOf(editText8.getText()));
                        task.setProvinceName(String.valueOf(editText9.getText()));
                        task.setCityName(String.valueOf(editText10.getText()));
                        task.setDistrictName(String.valueOf(editText11.getText()));
                        task.setDetailAddress(String.valueOf(editText12.getText()));
                        task.setDetail(String.valueOf(editText13.getText()));

                        published.setUsername(BmobUser.getCurrentUser(User.class).getUsername());
                        published.setName(String.valueOf(editText.getText()));
                        published.setType(spin);
                        published.setPeopleNum(String.valueOf(editText1.getText()));
                        published.setStartYear(String.valueOf(editText2.getText()));
                        published.setStartMonth(String.valueOf(editText3.getText()));
                        published.setStartDate(String.valueOf(editText4.getText()));
                        published.setEndYear(String.valueOf(editText5.getText()));
                        published.setEndMonth(String.valueOf(editText6.getText()));
                        published.setEndDate(String.valueOf(editText7.getText()));
                        published.setCoinNum(String.valueOf(editText8.getText()));
                        published.setProvinceName(String.valueOf(editText9.getText()));
                        published.setCityName(String.valueOf(editText10.getText()));
                        published.setDistrictName(String.valueOf(editText11.getText()));
                        published.setDetailAddress(String.valueOf(editText12.getText()));
                        published.setDetail(String.valueOf(editText13.getText()));
                        published.setTypeImage("http://bmob-cdn-25862.b0.upaiyun.com/2019/05/19/3dbd426b4055004b80fa0e08a935907c.png");


                        task.setTypeImage("http://bmob-cdn-25862.b0.upaiyun.com/2019/05/19/3dbd426b4055004b80fa0e08a935907c.png");
                        task.setReceived(false);
                        task.save(new SaveListener<String>() {
                            @Override
                            public void done(String s, BmobException e) {
                                if(e==null){
                                    published.setiD(task.getObjectId());
                                    published.save(new SaveListener<String>() {
                                        @Override
                                        public void done(String s, BmobException e) {
                                            if(e==null){
                                                Log.i("PublishActivity", "done: 成功");
                                                Toast.makeText(getApplicationContext(),"提交成功，等待小伙伴们参与哦~",Toast.LENGTH_SHORT).show();
                                                finish();
                                            }else {
                                                Log.i("PublishActivity", "done: "+e);
                                                Toast.makeText(getApplicationContext(),"请检查是否填写正确",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }else {
                                    Log.i("PublishActivity", "done: "+e);
                                    Toast.makeText(getApplicationContext(),"请检查是否填写正确",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
