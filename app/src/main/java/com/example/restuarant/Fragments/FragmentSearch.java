package com.example.restuarant.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restuarant.DB.Db;
import com.example.restuarant.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentSearch extends Fragment {

    View root;
    DatabaseReference db;
    RecyclerView firebase_rec;
    FirebaseRecyclerOptions<Db> opt;
    FirebaseRecyclerAdapter<Db,MyViewHolder> adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_search, container, false);
        firebase_rec=(RecyclerView) getActivity().findViewById(R.id.firebase_rec);
        db= FirebaseDatabase.getInstance().getReference().child("users");
//        firebase_rec.setLayoutManager(new RecyclerView.LayoutManager(getContext()));
        opt=new FirebaseRecyclerOptions.Builder<Db>().setQuery(db,Db.class).build();
        adapter=new FirebaseRecyclerAdapter<Db, MyViewHolder>(opt) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Db model) {
                holder.name.setText(""+model.getName());
                holder.email.setText(""+model.getEmail());
                holder.age.setText(""+model.getAge());
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_layout,parent,false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        firebase_rec.setAdapter(adapter);
        return root;

    }
}
