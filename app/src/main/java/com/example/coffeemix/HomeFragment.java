package com.example.coffeemix;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.coffeemix.adapter.CoffeeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Coffee> drinks;
    private CoffeeAdapter coffeeAdapter;

    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        drinks = new ArrayList<>();
        drinks.add(new Coffee(getString(R.string.white_mocha),R.drawable.coffee1));
        drinks.add(new Coffee(getString(R.string.cappuccino),R.drawable.coffee2));
        drinks.add(new Coffee(getString(R.string.white_mocha),R.drawable.coffee1));
        drinks.add(new Coffee(getString(R.string.cappuccino),R.drawable.coffee2));
        drinks.add(new Coffee(getString(R.string.white_mocha),R.drawable.coffee1));
        drinks.add(new Coffee(getString(R.string.cappuccino),R.drawable.coffee2));

        recyclerView = view.findViewById(R.id.coffee_recycler);
        coffeeAdapter = new CoffeeAdapter(drinks, getActivity());
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(coffeeAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetails nextFrag= new OrderDetails();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_fragment, nextFrag)
                        .commit();
            }
        });
        return view;
    }
}