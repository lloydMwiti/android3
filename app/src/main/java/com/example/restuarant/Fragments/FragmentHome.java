package com.example.restuarant.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restuarant.ListAdapter;
import com.example.restuarant.R;
import com.example.restuarant.SetData;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment {
    private String[] arrString=new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_home,container,false);

        ListView mlist=root.findViewById(R.id.mylist);
//        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrString);

        List<SetData> setData;
        setData=new ArrayList<>();
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        setData.add(new SetData(R.drawable.pimg,"james","james@gmail.com"));
        ListAdapter listAdapter=new ListAdapter(getContext(),R.layout.list_item,setData);
        mlist.setAdapter(listAdapter);
        return root;

    }


}
