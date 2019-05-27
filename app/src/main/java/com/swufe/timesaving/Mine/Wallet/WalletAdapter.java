package com.swufe.timesaving.Mine.Wallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.swufe.timesaving.Init.Wallet;
import com.swufe.timesaving.Init.Welfare;
import com.swufe.timesaving.Main.Welfare.WelfareAdapter;
import com.swufe.timesaving.R;

import java.util.List;

public class WalletAdapter extends BaseAdapter {
    private List<Wallet> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private static String TAG = "TaskListAdapter";


    public WalletAdapter(Context context, List<Wallet> data){
        this.context = context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }

    public final class Zujian{
        public ImageView imageView;
        public TextView tv3,tv4,tv5,tv6,tv7;
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
        WalletAdapter.Zujian zujian = null;
        if(convertView==null){
            zujian = new WalletAdapter.Zujian();
            convertView=layoutInflater.inflate(R.layout.activity_wallet_adapter,null);
            zujian.imageView=convertView.findViewById(R.id.imageView4);
            zujian.tv3=convertView.findViewById(R.id.textView34);
            zujian.tv4=convertView.findViewById(R.id.textView35);
            zujian.tv5=convertView.findViewById(R.id.textView36);
            zujian.tv6=convertView.findViewById(R.id.textView40);
            zujian.tv7=convertView.findViewById(R.id.textView38);
            convertView.setTag(zujian);
        }else {
            zujian=(WalletAdapter.Zujian)convertView.getTag();
        }
        Picasso.with(context).load(data.get(position).getTypeImage()).fit().into(zujian.imageView);
        zujian.tv3.setText(data.get(position).getType());
        zujian.tv4.setText(data.get(position).getName());
        zujian.tv5.setText(data.get(position).getStartMonth());
        zujian.tv6.setText(data.get(position).getTrueCoin());
        zujian.tv7.setText(data.get(position).getStartDate());
        return convertView;
    }
}
