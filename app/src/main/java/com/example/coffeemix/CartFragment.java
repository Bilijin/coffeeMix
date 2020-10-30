package com.example.coffeemix;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeemix.adapter.MyCartRecyclerViewAdapter;
import com.example.coffeemix.dummy.DummyContent;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * A fragment representing a list of Items.
 */
public class CartFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    public List<Coffee> mCartList;
    private TextView cartTotal;
    private TextView items;
    private ImageView bin;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CartFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CartFragment newInstance(int columnCount) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View cartView = inflater.inflate(R.layout.fragment_cart_list, container, false);

        items = cartView.findViewById(R.id.no_of_cart_items);
        cartTotal = cartView.findViewById(R.id.cart_total);
        RecyclerView recyclerView = (cartView.findViewById(R.id.cart_list));
        bin = cartView.findViewById(R.id.binn);

        mCartList = new ArrayList<>();

//        String tot = cartTotal.getText().toString();
//        cartTotal.setText(NumberFormat.getCurrencyInstance().format(parseInt(tot)));


        mCartList.add(new Coffee(getString(R.string.white_mocha),R.drawable.coffee1, "40"));
        mCartList.add(new Coffee(getString(R.string.white_mocha),R.drawable.coffee1,"60"));
        mCartList.add(new Coffee(getString(R.string.white_mocha),R.drawable.coffee1,"60"));
        // Set the adapter
        final Context context = cartView.getContext();

        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCartRecyclerViewAdapter(mCartList,CartFragment.this));

        int ci = mCartList.size();
        items.setText(String.valueOf(ci));

        setCartTotal();

//        bin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(context, LoginActivity.class));
//            }
//        });

        return cartView;
    }

    public void setCartTotal() {
        int total = 0;

        for (int i = 0; i<mCartList.size(); i++) {
            int boo = parseInt(mCartList.get(i).getmPrice());
            total = total + boo;

            cartTotal.setText(NumberFormat.getCurrencyInstance().format(total));
        }
    }
}