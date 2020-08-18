package com.example.restuarant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restuarant.DB.Db;
import com.example.restuarant.Fragments.FragmentHome;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Button mbutton;
    private EditText mname,memail,mage,mpass;
    private String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @BindView(R.id.nameInput) EditText bname;
    @BindView(R.id.emailInput) EditText bemail;
    @BindView(R.id.ageInput) EditText bage;
    @BindView(R.id.passwordInput) EditText bpass;
    @BindView(R.id.submit) Button sub;
    @BindView(R.id.login) Button login;
    FirebaseDatabase fdb;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View decorView = getWindow().getDecorView();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextpage();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }
    public void login(){
        Intent i =new Intent(MainActivity.this,Login.class);
        startActivity(i);
    }

    public void nextpage(){
        if(bname.getText().toString().isEmpty() || bemail.getText().toString().isEmpty() || bage.getText().toString().isEmpty() || bpass.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "fill out all fields first", Toast.LENGTH_LONG).show();
        }else{
            if ( !bemail.getText().toString().trim().matches(emailPattern)){
                Toast.makeText(MainActivity.this, "enter a valid email", Toast.LENGTH_SHORT).show();
            }
            else if( bpass.getText().toString().length() < 6){
                bpass.setError("6 characters or more");

            }
            else{
                final Intent i=new Intent(this, FragmentHolder.class);
                final String superName=bname.getText().toString();
                final String superEmail=bemail.getText().toString();
                final String superAge=bage.getText().toString();
                final String superPass=bpass.getText().toString();
                i.putExtra("superName",superName);
                i.putExtra("superEmail",superEmail);
                i.putExtra("superAge",superAge);
                i.putExtra("superPass",superPass);



            // firebase connection
                fdb=FirebaseDatabase.getInstance();
                reference=fdb.getReference("users");

                final Db db=new Db(superName,superEmail,superPass,superAge);
                Query q=reference.orderByChild("name").equalTo(superName);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            bname.setError("username is not available");
                            popupfalse();
                            Toast.makeText(MainActivity.this, "try another username", Toast.LENGTH_SHORT).show();

                        }else{
                            startActivity(i);
                            Toast.makeText(MainActivity.this, "moving on", Toast.LENGTH_SHORT).show();
                            reference.child(superName).setValue(db);
                            bname.setText("");bemail.setText("");bage.setText("");bpass.setText("");
                            finish();
                        }
                    }

                    private void popupfalse() {
                        Popup popup=new Popup();
                        popup.show(getSupportFragmentManager(),"popup");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }}
    }



}
