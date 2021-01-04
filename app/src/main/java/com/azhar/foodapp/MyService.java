package com.azhar.foodapp;

import android.content.Context;

public class MyService {

    FoodApi foodApi;

    public MyService(Context context) {
        foodApi = RetrofitBuilder
                .builder(context)
                .create(FoodApi.class);
    }

    public FoodApi getInstance() {
        return foodApi;
    }
}
