package com.example.quots.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quots.R;
import com.example.quots.activities.ShowCategorywiseData;
import com.example.quots.models.ShowOnlyCategoryNameResponseModel;

import java.util.List;

public class ShowOnlyCategoryNameAdapter extends RecyclerView.Adapter<ShowOnlyCategoryNameAdapter.ShowCatData>{

    List<ShowOnlyCategoryNameResponseModel> model;
    Context context;

    public ShowOnlyCategoryNameAdapter(List<ShowOnlyCategoryNameResponseModel> model,Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowCatData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fetch_category_data_singlerow,parent,false);
        return new ShowCatData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowCatData holder, int position) {
        holder.showOnlyCatName.setText(model.get(position).getCname());

        final ShowOnlyCategoryNameResponseModel temp =model.get(position);

        holder.showOnlyCatName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ShowCategorywiseData.class);
                intent.putExtra("data",temp.getCname());
                view.getContext().startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return model.size();
    }



    class ShowCatData extends RecyclerView.ViewHolder{

        TextView showOnlyCatName;

        public ShowCatData(@NonNull View itemView) {
            super(itemView);
            showOnlyCatName = itemView.findViewById(R.id.showOnlyCatName);

        }
    }

}
