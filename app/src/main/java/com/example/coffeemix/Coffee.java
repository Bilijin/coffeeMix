package com.example.coffeemix;

public class Coffee {
    private String mCoffee_name;
    private int mImage;
    Coffee(String coffee_name, int image){
        mCoffee_name = coffee_name;
        mImage = image;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmCoffee_name() {
        return mCoffee_name;
    }
}
