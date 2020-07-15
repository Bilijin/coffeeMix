package com.example.coffeemix.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeemix.Coffee;
import com.example.coffeemix.R;
import com.example.coffeemix.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCartRecyclerViewAdapter extends RecyclerView.Adapter<MyCartRecyclerViewAdapter.ViewHolder> {

    private final List<Coffee> mCartItems;

    public MyCartRecyclerViewAdapter(List<Coffee> items) {
        mCartItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Coffee cart = mCartItems.get(position);
        holder.mCartId.setText(cart.getmCoffee_name());
        holder.mCartImage.setImageResource(cart.getmImage());

        holder.mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int figure = Integer.parseInt(holder.mQuantity.getText().toString());
                if (figure < 20) {
                    figure = figure + 1;
                    String number = String.valueOf(figure);
                    holder.mQuantity.setText(number);
                }
            }
        });

        holder.mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int figure = Integer.parseInt(holder.mQuantity.getText().toString());
                if (figure > 1) {
                    figure = figure - 1;
                    String number = String.valueOf(figure);
                    holder.mQuantity.setText(number);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mCartItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mCartId;
        public final ImageView mCartImage;
        public final TextView mPlus;
        public final TextView mMinus;
        public final TextView mQuantity;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCartId = (TextView) view.findViewById(R.id.cart_coffee_name);
            mCartImage = (ImageView) view.findViewById(R.id.cart_coffee_img);
            mPlus = (TextView) view.findViewById(R.id.plus_cart);
            mMinus = (TextView) view.findViewById(R.id.minus_cart);
            mQuantity = (TextView) view.findViewById(R.id.cart_item_number);
        }
    }
}