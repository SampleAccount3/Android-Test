package com.example.android_studio_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BatAdapter extends RecyclerView.Adapter<BatAdapter.MyViewHolder> {
    Context context;
    ArrayList<ObjectBattery> objArrayList;

    public BatAdapter(Context context , ArrayList<ObjectBattery> objArrayList){
    this.context = context;
    this.objArrayList = objArrayList;

    }
    @NonNull
    @Override
    public BatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        this is where you inflate the layout (Giving the look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent,false);
        return new BatAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BatAdapter.MyViewHolder holder, int position) {
//        assigning  values  to the views we created in the recycler_view_row layout file
//        based on the position of the recycle view
        holder.tvTitle.setText(objArrayList.get(position).getName());
        holder.img.setImageResource(objArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
//        the recycler view just want to know the number of items  you want to displayed
        return objArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
//        grabbing the views from our recycler_view_row layout file
//        kinda like in the  onCreate Method
        private TextView tvTitle;
        private ImageView img;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            img = itemView.findViewById(R.id.imgBat);
        }
    }
}
