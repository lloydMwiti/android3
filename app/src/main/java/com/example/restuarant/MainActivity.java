package com.example.restuarant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Button mbutton;
    private EditText mname,memail,mage;
    private String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @BindView(R.id.nameInput) EditText bname;
    @BindView(R.id.emailInput) EditText bemail;
    @BindView(R.id.ageInput) EditText bage;
    @BindView(R.id.submit) Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.submit)
    public void nextpage(){
        if(bname.getText().toString().isEmpty() || bemail.getText().toString().isEmpty() || bage.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "fill out all fields first", Toast.LENGTH_LONG).show();
        }else{
            if ( !bemail.getText().toString().trim().matches(emailPattern)){
                Toast.makeText(MainActivity.this, "enter a valid email", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "moving on", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(this,Home.class);
                startActivity(i);
                bname.setText("");bemail.setText("");bage.setText("");
                finish();
            }}
    }


}
