package com.example.restuarant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity {
@BindView(R.id.signup) Button signup;
@BindView(R.id.logincheck) Button login;
@BindView(R.id.emaillogin) EditText loginemail;
@BindView(R.id.passwordlogin) EditText loginpassword;
FirebaseDatabase database=FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }
    public void signup(){
        finish();
    }
    public void login(){
        if(loginemail.getText().toString().isEmpty() || loginpassword.getText().toString().isEmpty()){
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
        }else{

        }
    }
}
