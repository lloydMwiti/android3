package com.example.restuarant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.restuarant.Fragments.FragmentFind;
import com.example.restuarant.Fragments.FragmentHome;
import com.example.restuarant.Fragments.FragmentNotification;
import com.example.restuarant.Fragments.FragmentSearch;
import com.example.restuarant.Fragments.FragmentUser;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class  FragmentHolder extends AppCompatActivity {

    String superName,superEmail,superAge;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FragmentHome()).commit();
        BottomNavigationView bottomNav= findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(bnavlistener);
        toolbar= findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        superName= "Your Name :" + i.getStringExtra("superName");
        superEmail="Your Email :" + i.getStringExtra("superEmail");
        superAge="Your age :" + i.getStringExtra("superAge");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.tool_search:
                Intent i=new Intent(FragmentHolder.this,Search.class);
                startActivity(i);
                break;
        }return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bnavlistener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected=null;
                    switch (item.getItemId()){
                        case R.id.home_dir:
                            Toast.makeText(FragmentHolder.this, superEmail, Toast.LENGTH_SHORT).show();
                            selected=new FragmentHome();
                            break;
                        case R.id.user_dir:
                            selected=new FragmentUser();
                            break;
                        case R.id.find_dir:
                            selected=new FragmentFind();
                            break;
                        case R.id.search_dir:
                            selected=new FragmentSearch();
                            break;
                        case R.id.notification_dir:
                            selected=new FragmentNotification();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selected).commit();
                    return true;

                }
            };
}
