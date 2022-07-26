package com.example.quots.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quots.R;
import com.example.quots.activities.ShowCategorywiseData;
import com.example.quots.models.ShowCategorywiseDataResponseModel;

import java.util.List;

public class ShowCategorywiseDataAdapter extends RecyclerView.Adapter<ShowCategorywiseDataAdapter.myviewholderr> {

    List<ShowCategorywiseDataResponseModel> model;

    public ShowCategorywiseDataAdapter(List<ShowCategorywiseDataResponseModel> model) {
        this.model = model;
    }

    @NonNull
    @Override
    public myviewholderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_all_category_data,parent,false);

        return new myviewholderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholderr holder, int position) {
            holder.tv_author_cat.setText(model.get(position).getAuthor());
            holder.tv_quots_cat.setText(model.get(position).getQuots());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    class myviewholderr extends RecyclerView.ViewHolder {

        TextView tv_quots_cat, tv_author_cat;

        public myviewholderr(@NonNull View itemView) {
            super(itemView);

            tv_quots_cat = itemView.findViewById(R.id.tv_quots_cat);
            tv_author_cat = itemView.findViewById(R.id.tv_author_cat);
        }
    }
}
