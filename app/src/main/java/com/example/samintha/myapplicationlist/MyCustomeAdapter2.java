package com.example.samintha.myapplicationlist;

/**
 * Created by samintha on 1/23/2017.
 */

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCustomeAdapter2 extends RecyclerView.Adapter<MyCustomeAdapter2.MyViewHolder>{
    Context context;
    ArrayList<Information2> data;
    LayoutInflater inflater;

    public MyCustomeAdapter2(Context context, ArrayList<Information2> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyCustomeAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.list_item_row2,parent,false);
        MyCustomeAdapter2.MyViewHolder holder = new MyCustomeAdapter2.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyCustomeAdapter2.MyViewHolder holder, final int position) {
        holder.textview.setText(data.get(position).title);
        holder.descplyr.setText(data.get(position).desc);
        holder.quantity.setText(data.get(position).quant);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data2.removeOneByOne(position);

                // Save state (This is to stay on the same scroll position)
                Parcelable recyclerViewState;
                recyclerViewState = MainActivity.recyclerView2.getLayoutManager().onSaveInstanceState();

                //notify data changes
                MainActivity.adapter2 = new MyCustomeAdapter2(context, Data2.getData());
                MainActivity.adapter2.notifyItemChanged(0,getItemCount());
                MainActivity.recyclerView2.setAdapter(MainActivity.adapter2);

                // Resore state (This is to stay on the same scroll position)
                MainActivity.recyclerView2.getLayoutManager().onRestoreInstanceState(recyclerViewState);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Data2.removeWholeItem(position);

                // Save state (This is to stay on the same scroll position)
                Parcelable recyclerViewState;
                recyclerViewState = MainActivity.recyclerView2.getLayoutManager().onSaveInstanceState();

                //notify data changes
                MainActivity.adapter2 = new MyCustomeAdapter2(context, Data2.getData());
                MainActivity.adapter2.notifyDataSetChanged();
                MainActivity.recyclerView2.setAdapter(MainActivity.adapter2);

                // Resore state (This is to stay on the same scroll position)
                MainActivity.recyclerView2.getLayoutManager().onRestoreInstanceState(recyclerViewState);
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
        TextView quantity;
        public MyViewHolder(View itemView) {
            super(itemView);

            descplyr = (TextView)itemView.findViewById(R.id.txt_desc);
            textview = (TextView)itemView.findViewById(R.id.txt_row);
            quantity = (TextView)itemView.findViewById(R.id.txt_quan);
        }
    }
}
