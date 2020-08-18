package com.example.restuarant.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restuarant.DB.Db;
import com.example.restuarant.ListAdapter;
import com.example.restuarant.R;
import com.example.restuarant.Search;
import com.example.restuarant.SetData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearch extends Fragment {

    EditText search_box;
    ImageButton search_btn;
    List<SetData> setData=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        ListView mlist=root.findViewById(R.id.mylistsearch);
        search_box=root.findViewById(R.id.search_boxs);
        search_btn=root.findViewById(R.id.search_btns);
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        ListAdapter listAdapter=new ListAdapter(getContext(),R.layout.list_item,setData);
        mlist.setAdapter(listAdapter);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
        return root;
    }
    private void search(){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query q = reference.orderByChild("name").equalTo(search_box.getText().toString());
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String dbname=dataSnapshot.child(search_box.getText().toString()).child("name").getValue(String.class);
                    String dbemail=dataSnapshot.child(search_box.getText().toString()).child("email").getValue(String.class);
                    setData.add(new SetData(R.drawable.pimg,dbname,dbemail));

                } else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
