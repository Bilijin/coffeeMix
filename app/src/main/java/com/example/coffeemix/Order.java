package com.example.coffeemix;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String mStoreName;
    private String mDate;
    private String mTime;
    private String mPrice;
    private int mRate;
    private int mLogo;

    Order(int logo, String storeName, String date, String time, int rate,int price){
        mLogo = logo;
        mStoreName = storeName;
        mDate = date;
        mTime = time;
        mRate = rate;
        mPrice = (NumberFormat.getCurrencyInstance().format(price));
    }

    public String getmStoreName() {
        return mStoreName;
    }

    public int getmLogo() {
        return mLogo;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public int getmRate() {
        return mRate;
    }

    public String getmPrice() {
        return mPrice;
    }
}
