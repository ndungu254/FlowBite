package com.example.flowbite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;
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

        monthRelief.setText("Ksh2,400");
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        String userId= Objects.requireNonNull(fAuth.getCurrentUser()).getUid();




        DocumentReference documentReference=fStore.collection("record").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                payrollNumber.setText("Ksh"+documentSnapshot.getString("payrollId"));
                basicSalary.setText("Ksh"+documentSnapshot.getString("basicSalary"));
                house.setText("Ksh"+documentSnapshot.getString("savings"));
                commuter.setText(""+documentSnapshot.getString("commuterAllowance"));
                overtime.setText("Ksh"+documentSnapshot.getString("totalOvertime"));
                otherallawance.setText("Ksh"+documentSnapshot.getString("otherAllowance"));
                grossPay.setText("Ksh"+documentSnapshot.getString("grossPay"));
                contribution.setText("Ksh"+documentSnapshot.getString("contributions"));
                taxableIncome.setText("Ksh"+documentSnapshot.getString("taxableIncome"));
                taxChargeable.setText("Ksh"+documentSnapshot.getString("taxChargeable"));
                payee.setText("Ksh"+documentSnapshot.getString("payee"));
                nhif.setText("Ksh"+documentSnapshot.getString("NHIF"));
                nssf.setText("Ksh"+documentSnapshot.getString("NSSF"));
                savings.setText("Ksh"+documentSnapshot.getString("savings"));
                totalDeductions.setText("Ksh"+documentSnapshot.getString("totalDeductions"));
                netPay.setText("Ksh"+documentSnapshot.getString("netpay"));

            }
        });

        /*Intent intent=getIntent();
        String basicsalary=intent.getStringExtra("basicSalary");
        String hallowance=intent.getStringExtra("house allowance");
        String callowance=intent.getStringExtra("commuterAllowance");
        String otherAll=intent.getStringExtra("otherallowance");
        String contributions=intent.getStringExtra("contributions");
        String saving=intent.getStringExtra("savings");
        String randomNumber=intent.getStringExtra("payrollId");
        String totalOvertime=intent.getStringExtra("totalOvertime");
        String totalGross=intent.getStringExtra("totalGrossPay");
        String Taxable=intent.getStringExtra("taxableIncome");
        String tax=intent.getStringExtra("Tax");
        String paye=intent.getStringExtra("payee");
        String NHIF=intent.getStringExtra("NHIF");
        String NSSF=intent.getStringExtra("NSSF");
        String totalDedu=intent.getStringExtra("totalDeductions");
        String netpyy=intent.getStringExtra("netPay");*/


        /*payrollNumber.setText("Payroll number :"+randomNumber);
        basicSalary.setText("Ksh"+basicsalary);
        house.setText("Ksh"+hallowance);
        commuter.setText(""+callowance);
        overtime.setText("Ksh"+totalOvertime);
        otherallawance.setText("Ksh"+otherAll);
        grossPay.setText("Ksh"+totalGross);
        contribution.setText("Ksh"+contributions);
        taxableIncome.setText("Ksh"+Taxable);
        taxChargeable.setText("Ksh"+tax);
        monthRelief.setText("Ksh2,400");
        payee.setText("Ksh"+paye);
        nhif.setText("Ksh"+NHIF);
        nssf.setText("Ksh"+NSSF);
        savings.setText("Ksh"+saving);
        totalDeductions.setText("Ksh"+totalDedu);
        netPay.setText("Ksh"+netpyy);*/



        logout.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),MainActivity.class)));

    }






    }
