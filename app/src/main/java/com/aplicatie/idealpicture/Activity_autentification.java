package com.aplicatie.idealpicture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_autentification extends  AppCompatActivity implements View.OnClickListener {

    EditText mEmailField,mPasswordField,et_numar,et_password_confirm;
    private  String ema,confirm_passsord;
    Button autentificare;
    com.aplicatie.idealpicture.ValidateInput validateInput;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentification);

        et_numar = findViewById(R.id.editTextPhone);

        mEmailField = findViewById(R.id.editTextTextEmailAddress);
        mPasswordField = findViewById(R.id.editTextTextPassword);
        findViewById(R.id.button_login).setOnClickListener(this);
        findViewById(R.id.button_autentificare).setOnClickListener(this);


        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            onAuthSuccess(mAuth.getCurrentUser());
        }
    }

    private void onAuthSuccess(FirebaseUser firebaseUser) {
        String email = firebaseUser.getEmail();
        String username = email;
        if (email != null && email.contains("@")) {
            username = email.split("@")[0];
        }

        User user = new User(username, email);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(firebaseUser.getUid()).setValue(user);

        startActivity(new Intent(this, Activity_autentification.class));
        finish();
    }

    private void signIn() {
        String email = mEmailField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();

        if (validateForm(email, password)) {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        onAuthSuccess(task.getResult().getUser());
                    } else {
                        Toast.makeText(Activity_autentification.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void signUp() {
        String email = mEmailField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();

        if (validateForm(email, password)) {

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        onAuthSuccess(task.getResult().getUser());
                    } else {
                        Toast.makeText(Activity_autentification.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private boolean validateForm(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required");
            return false;
        } else if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required");
            return false;
        } else {
            mEmailField.setError(null);
            mPasswordField.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_inregistrare:
                signIn();
                break;
            case R.id.button_autentificare:
                signUp();
                break;
        }
    }
}


