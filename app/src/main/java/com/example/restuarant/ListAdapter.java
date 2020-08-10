package com.example.restuarant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.restuarant.Fragments.FragmentHome;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends ArrayAdapter<SetData> {
    List<SetData> setData;
    int resource;
    Context context;

    public ListAdapter(Context context, int resource, List<SetData> setData){
        super(context,resource,setData);
        this.context=context;
        this.resource=resource;
        this.setData=setData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        @SuppressLint("ViewHolder") View view= layoutInflater.inflate(resource,null,false);
        TextView avname= view.findViewById(R.id.avname);
        TextView avemail= view.findViewById(R.id.avemaill);
        ImageView avimage= view.findViewById(R.id.avimg);
        SetData setDatanew=setData.get(position);
        avname.setText(setDatanew.getName());
        avemail.setText(setDatanew.getEmail());
        Picasso.get().load(setDatanew.getImage()).into(avimage);
        return view;
    }
}
