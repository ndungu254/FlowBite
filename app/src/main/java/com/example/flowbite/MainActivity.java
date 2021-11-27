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

public class MainActivity extends AppCompatActivity {
    EditText etMail,etPassword;
    Button btLogin,btSignup;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMail=findViewById(R.id.eTMail);
        etPassword=findViewById(R.id.eTpassword);
        btLogin=findViewById(R.id.btLogin);
        btSignup=findViewById(R.id.btSignup);
        progressBar=findViewById(R.id.progressBar);


        fAuth=FirebaseAuth.getInstance();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=etMail.getText().toString().trim();
                String password=etPassword.getText().toString().trim();
                if (mail.isEmpty()) {
                    etMail.setError("Email is empty");
                    return;
                }
                if (password.isEmpty()) {
                    etPassword.setError("Email is empty");
                    return;
                }
                if (password.length()<6) {
                    etPassword.setError("password is short");
                    return;
                }
                fAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
                            Toast.makeText(getApplicationContext(), "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        }

                    }
                });

            }
        });

        String gitToken="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";
    }
}