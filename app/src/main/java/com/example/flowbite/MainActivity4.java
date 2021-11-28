package com.example.flowbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity4 extends AppCompatActivity {
    public static final String TAG = "Tag";
    EditText basicsalary,hallawance,callawance,Otherallawance,overtime,contribution,saving,overtimerate;
    Button calculate;
    TextView  tvid;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        basicsalary=findViewById(R.id.basicsalary);
        hallawance=findViewById(R.id.hallawance);
        callawance=findViewById(R.id.callawance);
        Otherallawance=findViewById(R.id.otherallowance);
        overtime=findViewById(R.id.overtimedays);
        contribution=findViewById(R.id.contributions);
        saving=findViewById(R.id.saving);
        overtimerate=findViewById(R.id.overtimerate);
        calculate=findViewById(R.id.calculate);
        fStore=FirebaseFirestore.getInstance();
        tvid=findViewById(R.id.tvid);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        String userID = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();

        tvid.setText(userID);
       calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DocumentReference documentReference=fStore.collection("record").document(userID);
               Map<String,Object>  record=new HashMap<>();
               record.put("bassicsallary",basicsalary);
               record.put("house allowance",hallawance);
               record.put("otherallowance",Otherallawance);
               record.put("overtime days",overtime);
               record.put("contributions",contribution);
               record.put("savings",saving);
               record.put("overtimerate",overtimerate);
               documentReference.set(record).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void unused) {
                       Toast.makeText(getApplicationContext(), "successful upload", Toast.LENGTH_SHORT).show();
                       Log.d(TAG,"onsuccess:User upload for  "+userID);
                   }
               });
           }
       });

    }
}