package com.example.coffeemix.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeemix.CartFragment;
import com.example.coffeemix.Coffee;
import com.example.coffeemix.R;
import com.example.coffeemix.dummy.DummyContent.DummyItem;

import java.text.NumberFormat;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCartRecyclerViewAdapter extends RecyclerView.Adapter<MyCartRecyclerViewAdapter.ViewHolder> {

    private final List<Coffee> mCartItems;
    private int price;
    private CartFragment fragment;

    public MyCartRecyclerViewAdapter(List<Coffee> items, CartFragment fragment) {
        mCartItems = items;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Coffee cart = mCartItems.get(position);
        holder.mCartId.setText(cart.getmCoffee_name());
        holder.mCartImage.setImageResource(cart.getmImage());

        final String pp = cart.getmPrice();
        holder.mCartPrice.setText(NumberFormat.getCurrencyInstance().format(parseInt(pp)));


        holder.mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int figure = parseInt(holder.mQuantity.getText().toString());
                if (figure < 20) {
                    figure = figure + 1;
                    String number = String.valueOf(figure);
                    holder.mQuantity.setText(number);

                    price = Integer.parseInt(pp) * figure;
                    String amount = String.valueOf(price);
                    holder.mCartPrice.setText(NumberFormat.getCurrencyInstance().format(price));
                    cart.setPrice(amount);

                    fragment.setCartTotal();
                }
            }
        });

        holder.mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int figure = parseInt(holder.mQuantity.getText().toString());
                if (figure > 1) {
                    figure = figure - 1;
                    String number = String.valueOf(figure);
                    holder.mQuantity.setText(number);

                    price = Integer.parseInt(pp) * figure;
                    String amount = String.valueOf(price);
                    holder.mCartPrice.setText(NumberFormat.getCurrencyInstance().format(parseInt(amount)));
                    cart.setPrice(amount);

                    fragment.setCartTotal();
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
        public final TextView mCartPrice;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCartId = view.findViewById(R.id.cart_coffee_name);
            mCartImage = view.findViewById(R.id.cart_coffee_img);
            mPlus = view.findViewById(R.id.plus_cart);
            mMinus = view.findViewById(R.id.minus_cart);
            mQuantity = view.findViewById(R.id.cart_item_number);
            mCartPrice = view.findViewById(R.id.cart_item_price);
        }

    }

    public void addItem(Coffee cafe) {
        mCartItems.add(cafe);
    }
}