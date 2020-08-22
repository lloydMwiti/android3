package com.example.restuarant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restuarant.DB.Db;

import java.util.ArrayList;

public class MyviewAdapter extends RecyclerView.Adapter<MyviewAdapter.MyviewHolder> implements Filterable {
    Context context;
    ArrayList<Db> profile;
    ArrayList<Db> fullprofile;
    public MyviewAdapter(Context c,ArrayList<Db> p){
        this.context=c;
        this.profile=p;
        this.fullprofile=new ArrayList<>(p);
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

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Db> filteredlist=new ArrayList<>();
            if(constraint == null || constraint.length()==0){
                filteredlist.addAll(fullprofile);
            }else{
                String search=constraint.toString().toLowerCase().trim();
                for (Db p :fullprofile){
                    if(p.getName().toLowerCase().contains(search) || p.getEmail().toLowerCase().contains(search)){
                        filteredlist.add(p);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredlist;
            return  filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            profile.clear();
            profile.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };
}
