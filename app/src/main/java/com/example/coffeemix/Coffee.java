package com.example.coffeemix;

public class Coffee {
    private String mCoffee_name;
    private int mImage;
    private String mPrice;
    Coffee(String coffee_name, int image){
        mCoffee_name = coffee_name;
        mImage = image;
    }

    Coffee(String coffee_name,int image, String price){
        mCoffee_name = coffee_name;
        mImage = image;
        mPrice = price;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmCoffee_name() {
        return mCoffee_name;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setPrice(String amount){
        this.mPrice = amount;
    }

}
