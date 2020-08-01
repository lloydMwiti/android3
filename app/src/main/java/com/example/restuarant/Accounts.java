package com.example.restuarant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Accounts extends AppCompatActivity {
    @BindView(R.id.acname)TextView acname;
    @BindView(R.id.acemail)TextView acemail;
    @BindView(R.id.acage)TextView acage;

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

    }
}
