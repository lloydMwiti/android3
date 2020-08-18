package com.example.restuarant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
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
    EditText search_box;
    ImageButton search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        firebase_rec = (RecyclerView) findViewById(R.id.firebase_rec);
        search_box = findViewById(R.id.search_box);
        search_btn = findViewById(R.id.search_btn);
        db = FirebaseDatabase.getInstance().getReference("users");

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

    }

    private void search(){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query q = reference.orderByChild("name").equalTo(search_box.getText().toString());
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String dbemail = dataSnapshot.child(search_box.getText().toString()).child("email").getValue(String.class);
                    String dbage = dataSnapshot.child(search_box.getText().toString()).child("age").getValue(String.class);

                } else {
                    Toast.makeText(Search.this, "Account does not exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    class MyviewHolder extends RecyclerView.ViewHolder {
        View mview;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
        }
    }
}


