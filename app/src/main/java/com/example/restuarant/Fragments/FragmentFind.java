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

import com.example.restuarant.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentFind extends Fragment implements OnMapReadyCallback {
    GoogleMap map;
    SupportMapFragment smap;
    View root;
    Fragment mapview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_find,container,false);
        smap=(SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);

        if(smap == null){
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            smap=SupportMapFragment.newInstance();
            ft.replace(R.id.map,smap).commit();
        }
        smap.getMapAsync(this);
        return root;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        // Add a marker in Sarova and move the camera
        LatLng sarova = new LatLng(-1.284175, 36.823071);
        map.addMarker(new MarkerOptions().position(sarova).title("Marker in Sarova"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sarova));

        // Add a marker in Sarova and move the camera
        LatLng hilton = new LatLng(-1.285152, 36.824757);
        map.addMarker(new MarkerOptions().position(hilton).title("Marker in Hilton"));
        map.moveCamera(CameraUpdateFactory.newLatLng(hilton));

        // Add a marker in Sarova and move the camera
        LatLng javaHouse = new LatLng(-1.285737, 36.823014);
        map.addMarker(new MarkerOptions().position(javaHouse).title("Marker in javaHouse"));
        map.moveCamera(CameraUpdateFactory.newLatLng(javaHouse));

        // Add a marker in Sarova and move the camera
        LatLng pepinos = new LatLng(-1.284729, 36.823998);
        map.addMarker(new MarkerOptions().position(pepinos).title("Marker in pepinos pizza"));
        map.moveCamera(CameraUpdateFactory.newLatLng(pepinos));

        LatLng kfc = new LatLng(-1.282543, 36.821869);
        map.addMarker(new MarkerOptions().position(kfc).title("Marker in kfc"));
        map.moveCamera(CameraUpdateFactory.newLatLng(kfc));
    }
}
