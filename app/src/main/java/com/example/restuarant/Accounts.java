package com.example.restuarant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Accounts extends AppCompatActivity {
    @BindView(R.id.acname)TextView acname;
    @BindView(R.id.acemail)TextView acemail;
    @BindView(R.id.acage)TextView acage;
    @BindView(R.id.done) Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        ButterKnife.bind(this);

        Intent i = getIntent();
        String superName= "Your Name :" + i.getStringExtra("superName");
        String superEmail="Your Email :" + i.getStringExtra("superEmail");
        String superAge="Your age :" + i.getStringExtra("superAge");

        acname.setText(superName);
        acemail.setText(superEmail);
        acage.setText(superAge);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnHome();
            }
        });

    }

    public void returnHome(){
        Intent i=new Intent(this,Home.class);
        startActivity(i);
    }
}
