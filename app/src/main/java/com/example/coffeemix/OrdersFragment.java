package com.example.coffeemix;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeemix.adapter.MyOrdersRecyclerViewAdapter;
import com.example.coffeemix.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class OrdersFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private List<Order> orders = new ArrayList<>();
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OrdersFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static OrdersFragment newInstance(int columnCount) {
        OrdersFragment fragment = new OrdersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders_list, container, false);

        orders.add(new Order(R.drawable.dunkin_donuts,getString(R.string.dunk),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price50)));
        orders.add(new Order(R.drawable.baskin_robbins,getString(R.string.dunk),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price30)));
        orders.add(new Order(R.drawable.krispy_kreme,getString(R.string.kreme),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price23)));
        orders.add(new Order(R.drawable.dunkin_donuts,getString(R.string.dunk),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price70)));
        orders.add(new Order(R.drawable.baskin_robbins,getString(R.string.dunk),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price30)));
        orders.add(new Order(R.drawable.krispy_kreme,getString(R.string.kreme),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price23)));
        orders.add(new Order(R.drawable.dunkin_donuts,getString(R.string.dunk),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price70)));
        orders.add(new Order(R.drawable.baskin_robbins,getString(R.string.dunk),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price30)));
        orders.add(new Order(R.drawable.krispy_kreme,getString(R.string.kreme),getString(R.string._5_7_2019),getString(R.string._09_18_am),R.string.rate,(R.string.price23)));

        // Set the adapter
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.order_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new MyOrdersRecyclerViewAdapter(orders));
        return view;
    }
}