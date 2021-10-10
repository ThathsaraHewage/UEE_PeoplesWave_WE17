package com.example.peopleswave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RequestNewLoan extends AppCompatActivity {
    EditText etname;
    EditText etbank;
    EditText etaccountNo;
    EditText etnic;
    EditText etphone;
    EditText etaddress;
    EditText etamount;

    Button submitbtn;
//    ProgressBar progressBar;

    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_new_loan);

        etname = (EditText)findViewById(R.id.name);
        etbank = (EditText)findViewById(R.id.nam);
        etaccountNo= (EditText)findViewById(R.id.name3);
        etnic= (EditText)findViewById(R.id.name4);
        etphone= (EditText)findViewById(R.id.name5);
        etaddress= (EditText)findViewById(R.id.name66);
        etamount= (EditText)findViewById(R.id.name77);

//        progressBar=findViewById(R.id.progressBar2);
        submitbtn=findViewById(R.id.button5);

//        AddLoanRequest();
    }

    public void AddLoanRequest(View view){
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference().child("Loan_Request");

                if(etaccountNo.getText().length() <= 5){
                    Toast.makeText(RequestNewLoan.this,"Account number is invalid",Toast.LENGTH_SHORT).show();
                }

                if(etphone.getText().length() == 0){
                    Toast.makeText(RequestNewLoan.this,"Please enter phone number",Toast.LENGTH_SHORT).show();
                }
                else if(etphone.getText().length() < 10){
                    Toast.makeText(RequestNewLoan.this,"Phone number is invalid",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference = FirebaseDatabase.getInstance().getReference("loanrequest");
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String ID = databaseReference.push().getKey();

                            final Loan loan = new Loan();

                            loan.setId(ID);
                            loan.setName(etname.getText().toString());
                            loan.setBank(etbank.getText().toString());
                            loan.setAccountNo(etaccountNo.getText().toString());
                            loan.setNic(etnic.getText().toString());
                            loan.setPhone(etphone.getText().toString());
                            loan.setAddress(etaddress.toString().trim());
                            loan.setAmount(etamount.toString());

                            Toast.makeText(getApplicationContext(),"Loan request added successfully",Toast.LENGTH_SHORT).show();
                            databaseReference.child(ID).setValue(loan);

                           clearDataAfterInsert();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
    public void clearDataAfterInsert(){
        etname.setText("");
        etbank.setText("");
        etamount.setText("");
        etaddress.setText("");
        etaccountNo.setText("");
        etnic.setText("");
        etphone.setText("");
    }
}