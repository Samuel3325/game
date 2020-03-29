package com.ahadu.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapt extends RecyclerView.Adapter<adapt.viewHolder> {

    Context context;
    List<taker> takerList;

    public adapt(Context context, List<taker> takerList) {
        this.context = context;
        this.takerList = takerList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.results,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        String num = takerList.get(position).getNum();
        String number = takerList.get(position).getNumber();
        String order = takerList.get(position).getOrder();

        viewHolder.setData(num,number,order);

    }

    @Override
    public int getItemCount() {
        return takerList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        private static TextView num,number,order;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.num);
            number = itemView.findViewById(R.id.number);
            order = itemView.findViewById(R.id.order);
        }
        public static void setData(String n,String nu,String o){
            num.setText(n);
            number.setText(nu);
            order.setText(o);
        }
    }
}
