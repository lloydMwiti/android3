package com.example.restuarant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
    public void popup(String title,String msg){
        Popup popup=new Popup(title,msg);
        popup.show(getSupportFragmentManager(),"popup");
    }
    public void signup(){
        loginpassword.setText("");loginemail.setText("");
        finish();
    }
    public void login(){
        if(loginemail.getText().toString().isEmpty() || loginpassword.getText().toString().isEmpty()){
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
        }else{
            DatabaseReference reference=FirebaseDatabase.getInstance().getReference("users");
            Query q=reference.orderByChild("name").equalTo(loginemail.getText().toString());
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        String dbpassword=dataSnapshot.child(loginemail.getText().toString()).child("password").getValue(String.class);

                        if(dbpassword.equals(loginpassword.getText().toString().trim())){
                            Intent i=new Intent(Login.this,FragmentHolder.class);
                            loginpassword.setText("");loginemail.setText("");
                            finish();
                            startActivity(i);
                        }else if(!dbpassword.equals(loginpassword.getText().toString().trim())){
                            loginpassword.setError("wrong password");
                            Toast.makeText(Login.this, "check your password", Toast.LENGTH_SHORT).show();
                            popup("Failed ","the password you entered is wrong ");
                        }

                    }else{
                        Toast.makeText(Login.this, "Account does not exist", Toast.LENGTH_SHORT).show();
                        popup("Failed ","no such account exist check your user name");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
}
