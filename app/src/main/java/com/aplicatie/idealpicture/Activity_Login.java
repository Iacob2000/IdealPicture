package com.aplicatie.idealpicture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener {
TextView autentificare;
Button login;
EditText email ,parola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.button_login);
        email = findViewById(R.id.editTextTextEmailAddress_Login);
        parola = findViewById(R.id.editTextNumberPassword_Login);
        autentificare = findViewById(R.id.button_inregistrare);
        autentificare.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.button_login:
                handleLoginClick();
            
            break;
            case R.id.button_inregistrare:
                handleAutentificationClick();
                break;
        }
    }

    private void handleAutentificationClick() {
    }

    private void handleLoginClick() {
    }
}