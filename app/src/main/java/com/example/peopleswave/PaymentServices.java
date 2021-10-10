package com.example.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_services);

        Button btnloanservices = findViewById(R.id.loanservices);

        btnloanservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentServices.this, LoanServicesMenu.class);
                Toast.makeText(getApplicationContext(),"Directing to Loan Services Menu..",Toast.LENGTH_SHORT).show();
                startActivity(i);

            }
        });
    }
}