package com.example.restuarant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restuarant.DB.Db;

import java.util.ArrayList;

public class MyviewAdapter extends RecyclerView.Adapter<MyviewAdapter.MyviewHolder>{
    Context context;
    ArrayList<Db> profile;
    public MyviewAdapter(Context c,ArrayList<Db> p){
        this.context=c;
        this.profile=p;
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(context).inflate(R.layout.single_view_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.name.setText(profile.get(position).getName());
        holder.age.setText(profile.get(position).getAge());
        holder.email.setText(profile.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return profile.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{

        TextView name,email,age;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.rec_name);
            email=itemView.findViewById(R.id.rec_email);
            age=itemView.findViewById(R.id.rec_age);

        }
    }


}
