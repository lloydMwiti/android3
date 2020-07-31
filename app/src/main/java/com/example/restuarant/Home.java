package com.example.restuarant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private ListView mlist;
    private ArrayAdapter adapter;
    private String[] arrString=new String[]{"name","james","andy","faith","riley","hope","catherine","stacey"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mlist=(ListView) findViewById(R.id.mlist);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrString);
        mlist.setAdapter(adapter);
        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Home.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
