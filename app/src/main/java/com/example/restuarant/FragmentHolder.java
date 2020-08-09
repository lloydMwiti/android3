package com.example.restuarant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.restuarant.Fragments.FragmentFind;
import com.example.restuarant.Fragments.FragmentHome;
import com.example.restuarant.Fragments.FragmentUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class  FragmentHolder extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentHome()).commit();
        BottomNavigationView bottomNav= findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(bnavlistener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener bnavlistener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected=null;
                    switch (item.getItemId()){
                        case R.id.home_dir:
                            selected=new FragmentHome();
                            break;
                        case R.id.user_dir:
                            selected=new FragmentUser();
                            break;
                        case R.id.find_dir:
                            selected=new FragmentFind();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selected).commit();
                    return true;

                }
            };
}
