package com.aplicatie.idealpicture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Detalii_sedinta_activity extends AppCompatActivity {
    Button comada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii_sedinta_activity);
        comada = findViewById(R.id.comanda_sedinta);
        comada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detalii_sedinta_activity.this,Activity_Login.class);
                startActivity(intent);
            }
        });
    }
}