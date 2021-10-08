package com.example.peopleswave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth fAuth;
    Button loginbtn;
    ProgressBar progressBar;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        fAuth = FirebaseAuth.getInstance();

        //find view by id
        email=findViewById(R.id.login_email_input);
        password=findViewById(R.id.login_password_input);
        progressBar=findViewById(R.id.progressBar);
        fAuth=FirebaseAuth.getInstance();
        loginbtn=findViewById(R.id.login_btn);

        progressBar.setVisibility(View.GONE);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EMAIL=email.getText().toString().trim();
                String PWD=password.getText().toString().trim();

                if(TextUtils.isEmpty(EMAIL)){
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(PWD)){
                    password.setError("Password is required");
                    return;
                }
                if(password.length()<6){
                    password.setError("password must be at least 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                fAuth.signInWithEmailAndPassword(EMAIL,PWD).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Logged in successfully! ",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),LoanHome.class));
                            progressBar.setVisibility(View.GONE);
                        }
                        else{
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this,"Login error has occured"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        progressBar.setVisibility(View.GONE);
    }




}