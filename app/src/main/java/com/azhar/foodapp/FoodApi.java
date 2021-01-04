package com.azhar.foodapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("getDataFood.json")
    Call<FoodResponse<FoodItem>> getFood();

}
