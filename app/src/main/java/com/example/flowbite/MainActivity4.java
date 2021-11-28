package com.example.flowbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import java.util.Random;

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

        Random random = new Random();
        @SuppressLint("DefaultLocale") String generatedPassword = String.format("%04d", random.nextInt(10000));



       calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String basic=basicsalary.getText().toString().trim();
               String houseAllowance=hallawance.getText().toString().trim();
               String commuterAllowance=callawance.getText().toString().trim();
               String otherAllowances=Otherallawance.getText().toString().trim();
               String overTime=overtime.getText().toString().trim();
               String contributions=contribution.getText().toString().trim();
               String overtimeRate=overtimerate.getText().toString().trim();
               String savings=saving.getText().toString().trim();




               if (basic.isEmpty()) {
                   basicsalary.setError("Field empty");
               }
               if (houseAllowance.isEmpty()) {
                   hallawance.setError("Field empty");
               }
               if (commuterAllowance.isEmpty()) {
                   callawance.setError("Field empty");
               }
               if (otherAllowances.isEmpty()) {
                   Otherallawance.setError("Field empty");
               }
               if (overTime.isEmpty()) {
                   overtime.setError("Field empty");
               }
               if (overtimeRate.isEmpty()) {
                   overtimerate.setError("Field empty");
               }
               if (contributions.isEmpty()) {
                   contribution.setError("Field empty");
               }
               if (savings.isEmpty()) {
                   saving.setError("fields empty");
               } else {
                   Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                   intent.putExtra("basicSalary", basic);
                   intent.putExtra("house allowance", houseAllowance);
                   intent.putExtra("commuterAllowance", commuterAllowance);
                   intent.putExtra("otherallowance", otherAllowances);
                   intent.putExtra("overtimedays", overTime);
                   intent.putExtra("overTime", overtimeRate);
                   intent.putExtra("contributions", contributions);
                   intent.putExtra("savings",savings);
                   startActivity(intent);

               }
           }
       });

    }
}