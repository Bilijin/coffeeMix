package com.example.coffeemix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeemix.Coffee;
import com.example.coffeemix.R;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.MyViewHolder> {
    private List<Coffee> mCoffeeList;

    public CoffeeAdapter(List<Coffee> coffees) {
        mCoffeeList = coffees;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from
                (parent.getContext())
                .inflate(R.layout.home_coffee_item, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Coffee coffee = mCoffeeList.get(position);
        TextView textView = holder.coffeeNameTextView;
        textView.setText(coffee.getmCoffee_name());

        ImageView image = holder.coffeeImageView;
        image.setImageResource(coffee.getmImage());
    }

    @Override
    public int getItemCount() {
        return mCoffeeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView coffeeNameTextView;
        public ImageView coffeeImageView;

        public MyViewHolder(View view){
            super(view);
            coffeeNameTextView = view.findViewById(R.id.home_coffee_name);
            coffeeImageView = view.findViewById(R.id.coffee_img);
        }
    }
}
