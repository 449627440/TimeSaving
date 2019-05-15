package com.swufe.timesaving.Info;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.swufe.timesaving.R;

import java.util.List;

public class NewsAdapter extends BaseAdapter {


    private List<String[]> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private static String TAG = "FriendAdapter";


    public NewsAdapter(Context context, List<String[]> data){
        this.context = context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }

    public final class Zujian{
        public ImageView imageView;
        public TextView tv1;
        public TextView tv2;
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
        NewsAdapter.Zujian zujian = null;
        if(convertView==null){
            zujian = new NewsAdapter.Zujian();
            convertView=layoutInflater.inflate(R.layout.fragment_news_adapter,null);
            zujian.imageView=convertView.findViewById(R.id.imageView4);
            zujian.tv1=convertView.findViewById(R.id.textView0);
            zujian.tv2=convertView.findViewById(R.id.textView5);
            convertView.setTag(zujian);
        }else {
            zujian=(NewsAdapter.Zujian)convertView.getTag();
        }
        zujian.tv1.setText(data.get(position)[0]);
        Log.i(TAG, "getView: "+data.get(position)[0]);
        zujian.tv2.setText(data.get(position)[1]);
        Log.i(TAG, "getView: "+data.get(position)[0]);
        Picasso.with(context).load(data.get(position)[2]).fit().into(zujian.imageView);
        Log.i(TAG, "getView: "+data.get(position)[2]);
        return convertView;
    }
}
