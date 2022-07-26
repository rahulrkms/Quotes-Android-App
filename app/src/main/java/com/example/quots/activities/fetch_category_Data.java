package com.example.quots.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quots.R;
import com.example.quots.adapters.ShowOnlyCategoryNameAdapter;
import com.example.quots.apicontroller;
import com.example.quots.models.ShowOnlyCategoryNameResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fetch_category_Data extends AppCompatActivity {
    RecyclerView category_bottom_recview;
    int noOfitem = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_category_data);
        getSupportActionBar().hide();

        category_bottom_recview = findViewById(R.id.category_bottom_recview);

        category_bottom_recview.setLayoutManager(new GridLayoutManager(this,noOfitem));



        Call<List<ShowOnlyCategoryNameResponseModel>> call = apicontroller.getInstance().getapi().onlyCatName();
        call.enqueue(new Callback<List<ShowOnlyCategoryNameResponseModel>>() {
            @Override
            public void onResponse(Call<List<ShowOnlyCategoryNameResponseModel>> call, Response<List<ShowOnlyCategoryNameResponseModel>> response) {
               List<ShowOnlyCategoryNameResponseModel> model = response.body();
                ShowOnlyCategoryNameAdapter adapter = new ShowOnlyCategoryNameAdapter(model,getApplicationContext());

                category_bottom_recview.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<ShowOnlyCategoryNameResponseModel>> call, Throwable t) {

            }
        });


    }
}