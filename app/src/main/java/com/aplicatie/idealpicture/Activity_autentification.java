package com.aplicatie.idealpicture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_autentification extends AppCompatActivity {

    EditText et_email,et_numar,et_password,et_password_confirm;
    private  String email,password,confirm_passsord;
    Button autentificare;
    ValidateInput validateInput;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentification);
        et_email = findViewById(R.id.editTextTextEmailAddress);
        et_numar = findViewById(R.id.editTextPhone);
        et_password = findViewById(R.id.editTextTextPassword);
        et_password_confirm = findViewById(R.id.editTextTextPassword2);
        autentificare = findViewById(R.id.button_autentificare);
        validateInput = new ValidateInput(this);

        autentificare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleInregistrareButon();
            }
        });
        auth = FirebaseAuth.getInstance();

    }

    private void handleInregistrareButon() {
        email = et_email.getText().toString();
        password = et_password.getText().toString();
        confirm_passsord = et_password_confirm.getText().toString();
        if (validateInput.checkemailvalid(email) && validateInput.checkpasswordvalid(password));
        {
            if (password.equals(confirm_passsord)){

            }else {
                Toast.makeText(this,"Parolele nu corespund" , Toast.LENGTH_SHORT).show();
            }
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull  Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        Toast.makeText(Activity_autentification.this, "Logare cu succes :"+user.getEmail(), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Activity_autentification.this, "Eroare:" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });



    }
    }
    }
