package com.example.flowbite;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG1 = "TAG";
    EditText etMail,etPassword,fName,lName,pnumber;
    Button btnLogin,btnSignup;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ProgressBar progressBar;
    String userID;

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
        pnumber=findViewById(R.id.phoneNumber);
        progressBar=findViewById(R.id.progressBar);



        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

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
                String lastName=lName.getText().toString().trim();
                String firstName=fName.getText().toString().trim();
                String phone=pnumber.getText().toString().trim();
                String fullName=firstName+" "+lastName;

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
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "error ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            //etMail.setText("");
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "user created", Toast.LENGTH_SHORT).show();
                            userID= Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
                            DocumentReference documentReference=fStore.collection("user").document(userID);
                            Map<String,Object> user=new HashMap<>();
                            user.put("fullName",fullName);
                            user.put("phone",phone);
                            user.put("email",mail);
                            documentReference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG1, "onComplete: user profle is create for "+fullName);
                                    }
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        }
                    }
                });
            }
        });

    }
}