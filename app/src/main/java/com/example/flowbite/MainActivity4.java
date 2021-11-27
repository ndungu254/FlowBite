package com.example.flowbite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
    EditText basicsalary,hallawance,callawance,Otherallawance,overtime,contribution,saving,overtimerate;
    Button calculate;

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



    }
}