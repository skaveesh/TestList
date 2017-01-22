package com.example.samintha.myapplicationlist;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by samintha on 1/20/2017.
 */

public class MyCustomeAdapter extends RecyclerView.Adapter<MyCustomeAdapter.MyViewHolder> {

    Context context;
    ArrayList<Information> data;
    LayoutInflater inflater;

    public MyCustomeAdapter(Context context, ArrayList<Information> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.list_item_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textview.setText(data.get(position).title);
        holder.imageview.setImageResource(data.get(position).imageId);
        holder.descplyr.setText(data.get(position).desc);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "title : " + data.get(position).title, Toast.LENGTH_LONG).show();

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "description : " + data.get(position).desc, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textview;
        TextView descplyr;
        ImageView imageview;

        public MyViewHolder(View itemView) {
            super(itemView);

            descplyr = (TextView)itemView.findViewById(R.id.txt_desc);
            textview = (TextView)itemView.findViewById(R.id.txt_row);
            imageview = (ImageView)itemView.findViewById(R.id.img_row);
        }
    }
}
