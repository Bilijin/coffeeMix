package com.example.coffeemix.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeemix.Order;
import com.example.coffeemix.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Order}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyOrdersRecyclerViewAdapter extends RecyclerView.Adapter<MyOrdersRecyclerViewAdapter.ViewHolder> {

    private final List<Order> mValues;

    public MyOrdersRecyclerViewAdapter(List<Order> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_orders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Order order = mValues.get(position);

        holder.mIdView.setText(order.getmStoreName());
        holder.mLogo.setImageResource(order.getmLogo());
        holder.mDate.setText(order.getmDate());
        holder.mTime.setText(order.getmTime());
        holder.mPrice.setText(order.getmPrice());
        holder.mRate.setText(order.getmRate());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final ImageView mLogo;
        public final TextView mDate;
        public final TextView mTime;
        public final TextView mPrice;
        public final TextView mRate;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mLogo = (ImageView) view.findViewById(R.id.logo) ;
            mIdView = (TextView) view.findViewById(R.id.latest_order_store_name);
            mDate = (TextView) view.findViewById(R.id.order_date);
            mTime = (TextView) view.findViewById(R.id.order_time);
            mPrice = (TextView) view.findViewById(R.id.order_price);
            mRate = (TextView) view.findViewById(R.id.order_rate);
        }
    }
}