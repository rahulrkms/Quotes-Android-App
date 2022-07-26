package com.example.quots.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quots.R;
import com.example.quots.adapters.ShowCategorywiseDataAdapter;
import com.example.quots.apicontroller;
import com.example.quots.models.ShowCategorywiseDataResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowCategorywiseData extends AppCompatActivity {

    RecyclerView recyclerView_categoryWiseData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_categorywise_data);

        getSupportActionBar().hide();

        recyclerView_categoryWiseData=findViewById(R.id.recyclerView_categoryWiseData);
        recyclerView_categoryWiseData.setLayoutManager(new LinearLayoutManager(this));

        String ss = getIntent().getStringExtra("data");

        Call<List<ShowCategorywiseDataResponseModel>> call = apicontroller.getInstance().getapi().categoryWiseData(ss);
        call.enqueue(new Callback<List<ShowCategorywiseDataResponseModel>>() {
            @Override
            public void onResponse(Call<List<ShowCategorywiseDataResponseModel>> call, Response<List<ShowCategorywiseDataResponseModel>> response) {
                List<ShowCategorywiseDataResponseModel> model = response.body();
                ShowCategorywiseDataAdapter adapter2 = new ShowCategorywiseDataAdapter(model);
                recyclerView_categoryWiseData.setAdapter(adapter2);

            }

            @Override
            public void onFailure(Call<List<ShowCategorywiseDataResponseModel>> call, Throwable t) {
                Toast.makeText(ShowCategorywiseData.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}