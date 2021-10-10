package com.example.peopleswave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoanList extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    loanAdapter myAdapter;
    ArrayList<Loan> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_list);

            recyclerView = findViewById(R.id.loanlist);
            database = FirebaseDatabase.getInstance().getReference("loanrequest");
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            list = new ArrayList<>();
            myAdapter = new loanAdapter(this,list);
            recyclerView.setAdapter(myAdapter);

            database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Loan loans = dataSnapshot.getValue(Loan.class);
                        list.add(loans);
                    }
                    myAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {}
            });


        }
    }
