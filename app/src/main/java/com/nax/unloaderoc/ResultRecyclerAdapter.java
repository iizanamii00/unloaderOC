package com.nax.unloaderoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nax.unloaderoc.models.ResultItem;

import java.util.Collections;
import java.util.List;

public class ResultRecyclerAdapter extends RecyclerView.Adapter<ResultRecyclerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<ResultItem> data = Collections.emptyList();

    public ResultRecyclerAdapter(Context context, List<ResultItem> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  inflater.inflate(R.layout.result_row_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultRecyclerAdapter.MyViewHolder holder, int position) {
        ResultItem current = data.get(position);
        holder.itemName.setText(current.getName());
        holder.itemPrice.setText("Rs. " + current.getPrice());
        holder.icon.setImageResource(current.getIconid());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName, itemPrice;
        ImageView icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            icon = itemView.findViewById(R.id.item_icon);
        }
    }
}
