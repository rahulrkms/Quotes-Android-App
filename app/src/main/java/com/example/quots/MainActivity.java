package com.example.quots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quots.activities.fetch_category_Data;
import com.example.quots.adapters.AdapterClass;
import com.example.quots.models.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView headBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);
        headBar = findViewById(R.id.headBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        processData();

        headBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), fetch_category_Data.class);
                startActivity(intent);
            }
        });


    }

    private void processData() {

        Call<List<model>> call = apicontroller.getInstance().getapi().getdata();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {

                List<model> data = response.body();
                AdapterClass adapterClass = new AdapterClass(data);
                recyclerView.setAdapter(adapterClass);


            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}