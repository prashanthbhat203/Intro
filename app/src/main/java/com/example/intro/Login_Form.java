package com.example.intro;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {

    EditText editTextusername, editTextpassword;
    Button buttonlogin, buttonregister;
    ProgressBar loading;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login Form");

        editTextusername = (EditText) findViewById(R.id.etUsername);
        editTextpassword = (EditText) findViewById(R.id.etPassword);
        buttonlogin = (Button) findViewById(R.id.btnLogin);
        buttonregister = (Button) findViewById(R.id.btnRegiter);
        loading = (ProgressBar) findViewById(R.id.pbLoading);


        firebaseAuth = FirebaseAuth.getInstance();

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextusername.getText().toString();
                String password = editTextpassword.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Login_Form.this, "Enter the Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login_Form.this, "Enter the Password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                loading.setVisibility(View.VISIBLE);
                                if (task.isSuccessful()) {
                                    loading.setVisibility(View.GONE);
                                    startActivity(new Intent(Login_Form.this, Succesfull_Login.class));


                                } else {
                                    loading.setVisibility(View.GONE);
                                    Toast.makeText(Login_Form.this, "Login Failed or User not found!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Form.this, Signup_Form.class));
            }
        });


    }
}