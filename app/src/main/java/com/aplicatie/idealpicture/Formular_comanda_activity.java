package com.aplicatie.idealpicture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.google.firebase.database.FirebaseDatabase.*;

public class  Formular_comanda_activity extends AppCompatActivity {
    private Button salveaza ;
    private EditText et_nume,et_prenume,et_email,et_adresa,et_telefon;
   private TextView tx_sedinta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular_comanda_activity);

        salveaza =findViewById(R.id.salveaza_comanda);
        et_nume =  findViewById(R.id.ed_nume);
        et_prenume = findViewById(R.id.ed_prenume);
        et_email = findViewById(R.id.ed_email);
        et_adresa = findViewById(R.id.ed_adresa);
        et_telefon = findViewById(R.id.ed_telefon);
        tx_sedinta = findViewById(R.id.text_sedinta);


        salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }
    }

