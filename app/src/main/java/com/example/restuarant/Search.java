package com.example.restuarant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restuarant.DB.Db;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static java.security.AccessController.getContext;

public class Search extends AppCompatActivity {
    View root;
    DatabaseReference db;
    RecyclerView firebase_rec;
    FirebaseRecyclerOptions<Db> options;
    FirebaseRecyclerAdapter<Db, MyviewHolder> fire_adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        firebase_rec = (RecyclerView) findViewById(R.id.firebase_rec);
        firebase_rec.setHasFixedSize(true);
        firebase_rec.setLayoutManager(new LinearLayoutManager(this));


        toolbar = findViewById(R.id.toolbar_search);
        db = FirebaseDatabase.getInstance().getReference("users");
        setSupportActionBar(toolbar);


        options=new FirebaseRecyclerOptions.Builder<Db>().setQuery(db,Db.class).build();
        fire_adapter=new FirebaseRecyclerAdapter<Db, MyviewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyviewHolder holder, int position, @NonNull Db model) {
                holder.name.setText(model.getName());
                holder.age.setText(model.getAge());
                holder.email.setText(model.getEmail());
            }
            @NonNull
            @Override
            public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_layout,parent,false);

                return new MyviewHolder(v);
            }
        };
        fire_adapter.startListening();
        firebase_rec.setAdapter(fire_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_up, menu);

        return super.onCreateOptionsMenu(menu);
    }



    class MyviewHolder extends RecyclerView.ViewHolder {
        View mview;
        TextView name,email,age;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            name=findViewById(R.id.rec_name);
            email=findViewById(R.id.rec_email);
            age=findViewById(R.id.rec_age);

        }
    }
}


