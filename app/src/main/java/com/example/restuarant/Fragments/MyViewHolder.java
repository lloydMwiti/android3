package com.example.restuarant.Fragments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restuarant.R;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name,age ,email;
    public MyViewHolder(@NonNull View itemView) {

        super(itemView);
        name= itemView.findViewById(R.id.rec_name);
        age=itemView.findViewById(R.id.rec_age);
        email=itemView.findViewById(R.id.rec_email);
    }
}
