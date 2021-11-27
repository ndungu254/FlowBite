package com.example.flowbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    EditText etMail,etPassword,fName,lName,phone;
    Button btnLogin,btnSignup;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

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
        phone=findViewById(R.id.phoneNumber);
        progressBar=findViewById(R.id.progressBar);


        fAuth=FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=etMail.getText().toString().trim();
                String password=etPassword.getText().toString().trim();
                String lastName=etMail.getText().toString().trim();
                String firstName=etPassword.getText().toString().trim();
                String phone=etMail.getText().toString().trim();

                if (mail.isEmpty()) {
                    etMail.setError("Email is empty");
                    return;
                }
                if (password.isEmpty()) {
                    etPassword.setError("password is empty");
                    return;
                }
                if (firstName.isEmpty()) {
                    fName.setError("first name is empty");
                    return;
                }
                if (lastName.isEmpty()) {
                    lName.setError("lastname is empty");
                    return;
                }

                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "phone is empty", Toast.LENGTH_SHORT).show();
                }
                if (password.length()<6){
                    etPassword.setError("password is short");
                }

                fAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.VISIBLE);
                        if (task.isComplete()) {
                            Toast.makeText(getApplicationContext(), "error ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            //etMail.setText("");
                            progressBar.setVisibility(View.GONE);
                        }
                        else {
                            progressBar.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "user created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

    }
}