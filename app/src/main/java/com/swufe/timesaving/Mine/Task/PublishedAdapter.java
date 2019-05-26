package com.swufe.timesaving.Mine.Task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.swufe.timesaving.Init.Published;
import com.swufe.timesaving.Init.Task;
import com.swufe.timesaving.Main.TaskList.TaskListAdapter;
import com.swufe.timesaving.R;

import java.util.List;

public class PublishedAdapter extends BaseAdapter {

    private List<Published> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private static String TAG = "TaskListAdapter";


    public PublishedAdapter(Context context, List<Published> data){
        this.context = context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }

    public final class Zujian{
        public ImageView imageView;
        public TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
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
        PublishedAdapter.Zujian zujian = null;
        if(convertView==null){
            zujian = new PublishedAdapter.Zujian();
            convertView=layoutInflater.inflate(R.layout.fragment_published_adapter,null);
            zujian.imageView=convertView.findViewById(R.id.imageView4);
            zujian.tv1=convertView.findViewById(R.id.textView35);
            zujian.tv2=convertView.findViewById(R.id.textView40);
            zujian.tv3=convertView.findViewById(R.id.textView34);
            zujian.tv4=convertView.findViewById(R.id.textView36);
            zujian.tv5=convertView.findViewById(R.id.textView38);
            zujian.tv6=convertView.findViewById(R.id.textView42);
            zujian.tv7=convertView.findViewById(R.id.textView44);
            convertView.setTag(zujian);
        }else {
            zujian=(PublishedAdapter.Zujian)convertView.getTag();
        }
        Picasso.with(context).load(data.get(position).getTypeImage()).fit().into(zujian.imageView);
        zujian.tv1.setText(data.get(position).getName());
        zujian.tv2.setText(data.get(position).getCoinNum());
        zujian.tv3.setText(data.get(position).getType());
        zujian.tv4.setText(data.get(position).getProvinceName());
        zujian.tv5.setText(data.get(position).getCityName());
        zujian.tv6.setText(data.get(position).getStartMonth());
        zujian.tv7.setText(data.get(position).getStartDate());
        return convertView;
    }
}
