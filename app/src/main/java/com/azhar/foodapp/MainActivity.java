package com.azhar.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    MyService myService;
    FoodAdapter adapter;
    RecyclerView rv_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_food = findViewById(R.id.rv_food);

        myService = new MyService(this);

        rv_food.setHasFixedSize(true);
        rv_food.setLayoutManager(new LinearLayoutManager(this));

        getDataFood();

    }

    public void getDataFood(){

        myService.getInstance().getFood().enqueue(new Callback<FoodResponse<FoodItem>>() {
            @Override
            public void onResponse(Call<FoodResponse<FoodItem>> call, Response<FoodResponse<FoodItem>> response) {

                FoodResponse resp = response.body();

                if (resp.getData() != null && resp.getData().size() > 0){


                    adapter = new FoodAdapter(resp.getData(),MainActivity.this);
                    rv_food.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<FoodResponse<FoodItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}