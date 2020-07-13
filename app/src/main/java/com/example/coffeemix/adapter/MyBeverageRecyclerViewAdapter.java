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
 * {@link RecyclerView.Adapter} that can display a {@link Coffee}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyBeverageRecyclerViewAdapter extends RecyclerView.Adapter<MyBeverageRecyclerViewAdapter.ViewHolder> {

    private final List<Coffee> mBeverages;

    public MyBeverageRecyclerViewAdapter(List<Coffee> items) {
        mBeverages = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_browse_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Coffee beverage = mBeverages.get(position);
        holder.mBrowseName.setText(beverage.getmCoffee_name());
        holder.mBrowseImage.setImageResource(beverage.getmImage());
    }

    @Override
    public int getItemCount() {
        return mBeverages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mBrowseName;
        public final ImageView mBrowseImage;
        public Coffee mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mBrowseName = (TextView) view.findViewById(R.id.browse_name);
            mBrowseImage = (ImageView) view.findViewById(R.id.browse_img);
        }
    }
}