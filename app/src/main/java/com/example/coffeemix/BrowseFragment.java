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

import com.example.coffeemix.adapter.MyBeverageRecyclerViewAdapter;
import com.example.coffeemix.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class BrowseFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private List<Coffee> beverages;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BrowseFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BrowseFragment newInstance(int columnCount) {
        BrowseFragment fragment = new BrowseFragment();
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
        View view = inflater.inflate(R.layout.fragment_browse, container, false);

        beverages = new ArrayList<>();
        beverages.add(new Coffee(getString(R.string.coffee),R.drawable.coffee));
        beverages.add(new Coffee(getString(R.string.english_tea),R.drawable.english_tea));
        beverages.add(new Coffee(getString(R.string.cappuccino),R.drawable.cappucino));
        beverages.add(new Coffee(getString(R.string.ice_coffee),R.drawable.ice_coffee));
        beverages.add(new Coffee(getString(R.string.coffee),R.drawable.coffee));
        beverages.add(new Coffee(getString(R.string.english_tea),R.drawable.english_tea));
        beverages.add(new Coffee(getString(R.string.cappuccino),R.drawable.cappucino));
        beverages.add(new Coffee(getString(R.string.ice_coffee),R.drawable.ice_coffee));

        // Set the adapter
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.browse_list);
            recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), mColumnCount));
            recyclerView.setAdapter(new MyBeverageRecyclerViewAdapter(beverages));
        return view;
    }
}