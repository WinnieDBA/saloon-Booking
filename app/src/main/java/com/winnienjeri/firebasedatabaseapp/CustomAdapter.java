package com.winnienjeri.firebasedatabaseapp;

//CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<Item> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.itemlayout, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.tvnames = (TextView) convertView.findViewById(R.id.tvname);
            viewHolder.tvemail = (TextView) convertView.findViewById(R.id.Birthday);
            viewHolder.tvphone = (TextView) convertView.findViewById(R.id.tvphone);
            viewHolder.decline = convertView.findViewById(R.id.btndecline);

            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        final Item person = data.get(position);//modify here
        viewHolder.tvnames.setText(person.getName());//modify here
        viewHolder.tvemail.setText(person.getEmail());//modify here
        viewHolder.tvphone.setText(person.getPhone());//modify here
        viewHolder.decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Watu/"+person.getKey());
                ref.removeValue();
                Toast.makeText(mContext, "Booking Declined Successfully", Toast.LENGTH_LONG).show();

            }
        });

        return convertView;

    }
    static class ViewHolder {
        TextView tvnames;
        TextView tvemail;
        TextView tvphone;
        Button decline;
    }

}
