package com.example.flowbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    EditText etMail,etPassword,fName,lName,phone;
    Button btnLogin,btnSignup;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etMail=findViewById(R.id.etMail);
        etPassword=findViewById(R.id.eTpassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignup=findViewById(R.id.btnSignup);
        lName=findViewById(R.id.lName);
        fName=findViewById(R.id.fName);
        phone=findViewById(R.id.phone);


        fAuth=FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                etMail.setText("");
                etPassword.setText("");
            }
        });
    }
}