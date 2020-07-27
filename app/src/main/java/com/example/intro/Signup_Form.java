package com.example.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Form extends AppCompatActivity {

    EditText editTextfullname, editTextemail, editTextpassword, editTextconfirmpassword;
    Button buttonregister;
    RadioButton radioButtonmale, radioButtonfemale;
    ProgressBar progressBarloading2;
    String gender = null;

    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("SignUp Form");

        editTextfullname = (EditText) findViewById(R.id.etFullName);
        editTextemail = (EditText) findViewById(R.id.etEmail);
        editTextpassword = (EditText) findViewById(R.id.etPassword);
        editTextconfirmpassword = (EditText) findViewById(R.id.etConfirmPassword);

        buttonregister = (Button) findViewById(R.id.btnRegiter);

        radioButtonmale = (RadioButton) findViewById(R.id.rbMale);
        radioButtonfemale = (RadioButton) findViewById(R.id.rbFemale);

        progressBarloading2 = (ProgressBar) findViewById(R.id.pbLoading2);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fullname = editTextfullname.getText().toString().trim();
                final String email = editTextemail.getText().toString().trim();
                String password = editTextpassword.getText().toString().trim();
                String confirmpassword = editTextconfirmpassword.getText().toString().trim();


                if (radioButtonmale.isChecked()) {
                    gender = "Male";
                } if(radioButtonfemale.isChecked()) {
                    gender = "Female";
                }


                if (TextUtils.isEmpty(fullname)) {
                    Toast.makeText(Signup_Form.this, "Please Enter your Name", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup_Form.this, "Please Enter your Email", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup_Form.this, "Please Enter Password", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(Signup_Form.this, "Please Enter the Password Again!!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(Signup_Form.this, "Password too short!", Toast.LENGTH_LONG).show();
                }

                if (password.equals(confirmpassword)) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBarloading2.setVisibility(View.VISIBLE);
                                    if (task.isSuccessful()) {
                                        progressBarloading2.setVisibility(View.GONE);

                                        User information = new User(fullname, email, gender);
                                        FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                startActivity(new Intent(getApplicationContext(), Login_Form.class));
                                                Toast.makeText(Signup_Form.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                    } else {
                                        progressBarloading2.setVisibility(View.GONE);
                                        Toast.makeText(Signup_Form.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                } else
                    Toast.makeText(Signup_Form.this, "Password does not matches!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

