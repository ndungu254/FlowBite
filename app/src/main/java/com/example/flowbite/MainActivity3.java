package com.example.flowbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity3 extends AppCompatActivity {
    TextView payrollNumber,Name,basicSalary,house,commuter,overtime,grossPay,contribution,taxableIncome,taxChargeable,monthRelief,
    payee,nhif,nssf,savings,totalDeductions,netPay;
    FirebaseAuth fAuth;
    Button logout;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        payrollNumber=findViewById(R.id.payrollNumber);
        Name=findViewById(R.id.Name);
        basicSalary=findViewById(R.id.basicSalary);
        house=findViewById(R.id.house);
        commuter=findViewById(R.id.commuter);
        overtime=findViewById(R.id.overtime);
        grossPay=findViewById(R.id.grosspay);
        contribution=findViewById(R.id.contribution);
        taxableIncome=findViewById(R.id.taxableIncome);
        taxChargeable=findViewById(R.id.taxchargeable);
        monthRelief=findViewById(R.id.monthRelief);
        payee=findViewById(R.id.payee);
        nhif=findViewById(R.id.nhif);
        nssf=findViewById(R.id.nssf);
        savings=findViewById(R.id.savings);
        totalDeductions=findViewById(R.id.totatdeductions);
        netPay=findViewById(R.id.netPay);
        logout=findViewById(R.id.logOut);
        monthRelief.setText("Ksh2,400");
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity3.class));
            }
        });

    }
}