package com.example.restuarant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity {

    @BindView(R.id.drawnName) TextView displayName;
    @BindView(R.id.mlist) ListView mlist;
    @BindView(R.id.user) Button account;
    private String superName,superEmail,superAge;
    private String[] arrString=new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrString);
        mlist.setAdapter(adapter);

        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemName="you clicked "+parent.getItemAtPosition(position).toString();
                Toast.makeText(Home.this,itemName , Toast.LENGTH_SHORT).show();
            }
        });

        Intent i = getIntent();
        superName=i.getStringExtra("superName");
        superEmail=i.getStringExtra("superEmail");
        superAge=i.getStringExtra("superAge");
        displayName.setText(superName);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,Accounts.class);
                i.putExtra("superName",superName);
                i.putExtra("superEmail",superEmail);
                i.putExtra("superAge",superAge);
                startActivity(i);
            }
        });
    }

}
