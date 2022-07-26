package com.example.quots.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quots.R;
import com.example.quots.models.model;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.myviewholder>{
    List<model> data;

    public AdapterClass(List<model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowmain,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.tv_quots.setText(data.get(position).getQuots());
        holder.tv_author.setText(data.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
            TextView tv_quots, tv_author;


            public myviewholder(@NonNull View itemView) {
                super(itemView);
               tv_author=itemView.findViewById(R.id.tv_author);
               tv_quots=itemView.findViewById(R.id.tv_quots);
            }
        }


}
