package com.example.flowbite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    TextView payrollNumber,Name,basicSalary,house,commuter,overtime,otherallawance,grossPay,contribution,taxableIncome,taxChargeable,monthRelief,
    payee,nhif,nssf,savings,totalDeductions,netPay;
    FirebaseAuth fAuth;
    Button logout;
    FirebaseFirestore fStore;

    @SuppressLint("SetTextI18n")
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
        otherallawance=findViewById(R.id.otherallowance);
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
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();




        Intent intent=getIntent();
        String basicsalary=intent.getStringExtra("basicSalary");
        String hallowance=intent.getStringExtra("house allowance");
        String callowance=intent.getStringExtra("commuterAllowance");
        String overtimeday=intent.getStringExtra("overtimedays");
        String over=intent.getStringExtra("overTime");
        String otherAll=intent.getStringExtra("otherallowance");
        String contributions=intent.getStringExtra("contributions");
        String saving=intent.getStringExtra("savings");
        Random random = new Random();
        @SuppressLint("DefaultLocale") String randomNumber = String.format("%04d8", random.nextInt(100000));

        int basic=Integer.parseInt(basicsalary);
        int hallow=Integer.parseInt(hallowance);
        int commute=Integer.parseInt(callowance);
        int other=Integer.parseInt(otherAll);

        int overtimedays =Integer.parseInt(overtimeday);
        int overtimera =Integer.parseInt(over);

        int totalOvertime=overtimedays*overtimera;


        int totalGross= basic+commute+hallow+totalOvertime+other;

        int Contribute=Integer.parseInt(contributions);
        int Taxable=totalGross-Contribute;
        int tax = 0;
        if (basic<24000){
            tax= (int) (0.1*24000);
        }
        if (basic-24000<8333){
            tax= (int) ((basic-2400)*0.25+24000*0.1);
        }
        if (basic>32333){
            tax= (int) (8333*0.25+24000*0.1+(basic-32333)*0.3);
        }

        int paye= (int) (tax-2400);
        int NHIF= (int) (basic *0.12);
        int NSSF= (int) (basic *0.15);
        int savin=Integer.parseInt(saving);

        int totalDedu=paye+NHIF+NSSF+savin;
        int netpyy=totalGross-totalDedu;



        payrollNumber.setText("Payroll number :"+randomNumber);


        basicSalary.setText("Ksh"+basicsalary);
        house.setText("Ksh"+hallowance);
        commuter.setText(""+callowance);
        overtime.setText("Ksh"+totalOvertime);
        grossPay.setText("Ksh"+totalGross);
        contribution.setText("Ksh"+contributions);
        taxableIncome.setText("Ksh"+Taxable);
        taxChargeable.setText("Ksh"+tax);
        monthRelief.setText("Ksh2,400");
        payee.setText("Ksh"+paye);
        nhif.setText("Ksh"+NHIF);
        nssf.setText("Ksh"+NSSF);
        savings.setText("Ksh"+savin);
        totalDeductions.setText("Ksh"+totalDedu);
        netPay.setText("Ksh"+netpyy);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }






    }
