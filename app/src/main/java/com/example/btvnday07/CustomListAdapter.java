package com.example.btvnday07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<User> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public CustomListAdapter(Context aContext,  List<User> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.imgview = (ImageView) convertView.findViewById(R.id.imguser);
            holder.tvname = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvnote = (TextView) convertView.findViewById(R.id.tvNote);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        User user = this.listData.get(position);
        holder.tvname.setText(user.getName());
        holder.tvnote.setText(user.getNote());

       // int imageId = this.getMipmapResIdByName(user.get));

        holder.imgview.setImageResource(R.drawable.user);
        return convertView;
    }
    static class ViewHolder {
        ImageView imgview;
        TextView tvname;
        TextView tvnote;
    }
}
