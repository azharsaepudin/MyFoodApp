package com.azhar.foodapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    List<FoodItem> data;
    Activity activity;

    public FoodAdapter(List<FoodItem> data, Activity activity){
        this.data = data;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_food, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView foodName, description, tv_code, price;

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.foodName);
            description = itemView.findViewById(R.id.description);
            tv_code = itemView.findViewById(R.id.tv_code);
            price = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.imageView);

        }

        public void bind(FoodItem foodItem) {
            foodName.setText(foodItem.name_food);
            description.setText(foodItem.description);
            tv_code.setText(foodItem.code);
            price.setText(foodItem.price);

            Glide.with(activity).load(foodItem.getImage()).into(imageView);

        }
    }
}
