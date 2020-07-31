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

public class MainActivity extends AppCompatActivity {
    Button mbutton;
    EditText mname,memail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mbutton=(Button)findViewById(R.id.submit);
        mname=(EditText) findViewById(R.id.nameInput);
        memail=(EditText) findViewById(R.id.emailInput);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mname.getText().toString().isEmpty() || memail.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "fill out all fields first", Toast.LENGTH_LONG).show();
                }else{
                    nextpage();
                    Toast.makeText(MainActivity.this, "moving on", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }

    public void nextpage(){
        Intent i=new Intent(this,Home.class);
        startActivity(i);
    }
}
