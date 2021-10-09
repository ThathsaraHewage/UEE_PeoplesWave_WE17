package com.example.peopleswave;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestNewLoan extends AppCompatActivity {
    EditText etname,etbank,etaccountNo,etnic,etphone,etaddress,etamount;
    Button submitbtn;
    ProgressBar progressBar;

    FirebaseDatabase rootNode;
    DatabaseReference loanDBref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_new_loan);

        etname = findViewById(R.id.name);
        etbank =findViewById(R.id.nam);
        etaccountNo=findViewById(R.id.name3);
        etnic=findViewById(R.id.name4);
        etphone=findViewById(R.id.name5);
        etaddress=findViewById(R.id.name66);
        etamount=findViewById(R.id.name77);
        progressBar=findViewById(R.id.progressBar2);
        submitbtn=findViewById(R.id.button5);

        progressBar.setVisibility(View.GONE);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                loanDBref = FirebaseDatabase.getInstance().getReference().child("loan");

                String name = etname.getText().toString();
                String bank = etbank.getText().toString();
                String accountNo = etaccountNo.getText().toString();
                String nic = etnic.getText().toString();
                String phone = etphone.getText().toString();
                String address = etaddress.getText().toString();
                String amount = etamount.getText().toString();

                Loan loan = new Loan(name,bank,accountNo,nic,phone,address,amount);

                loanDBref.push().setValue(loan);
                Toast.makeText(RequestNewLoan.this,"Loan Request Added !",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}