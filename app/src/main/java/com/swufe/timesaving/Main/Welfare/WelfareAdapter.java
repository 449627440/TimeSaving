package com.swufe.timesaving.Main.Welfare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.swufe.timesaving.Init.Task;
import com.swufe.timesaving.Init.Welfare;
import com.swufe.timesaving.R;

import java.util.List;

public class WelfareAdapter extends BaseAdapter {
    private List<Welfare> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private static String TAG = "TaskListAdapter";


    public WelfareAdapter(Context context, List<Welfare> data){
        this.context = context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }

    public final class Zujian{
        public ImageView imageView;
        public TextView tv1,tv3,tv4,tv5,tv6,tv7;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        WelfareAdapter.Zujian zujian = null;
        if(convertView==null){
            zujian = new WelfareAdapter.Zujian();
            convertView=layoutInflater.inflate(R.layout.activity_welfare_adapter,null);
            zujian.imageView=convertView.findViewById(R.id.imageView4);
            zujian.tv1=convertView.findViewById(R.id.textView35);
            zujian.tv3=convertView.findViewById(R.id.textView34);
            zujian.tv4=convertView.findViewById(R.id.textView36);
            zujian.tv5=convertView.findViewById(R.id.textView38);
            zujian.tv6=convertView.findViewById(R.id.textView42);
            zujian.tv7=convertView.findViewById(R.id.textView44);
            convertView.setTag(zujian);
        }else {
            zujian=(WelfareAdapter.Zujian)convertView.getTag();
        }
        Picasso.with(context).load(data.get(position).getTypeImage()).fit().into(zujian.imageView);
        zujian.tv1.setText(data.get(position).getName());
        zujian.tv3.setText(data.get(position).getType());
        zujian.tv4.setText(data.get(position).getProvinceName());
        zujian.tv5.setText(data.get(position).getCityName());
        zujian.tv6.setText(data.get(position).getStartMonth());
        zujian.tv7.setText(data.get(position).getStartDate());
        return convertView;
    }
}
