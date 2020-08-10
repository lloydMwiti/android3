package com.example.restuarant.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restuarant.FragmentHolder;
import com.example.restuarant.R;

public class FragmentUser extends Fragment {
    TextView vname,vemail,vage;
    View root;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_user,container,false);
        vname=(TextView) root.findViewById(R.id.gtname);
        vemail=(TextView)root.findViewById(R.id.gtemail);
        vage=(TextView)root.findViewById(R.id.gtage);

        return root;

    }


}
