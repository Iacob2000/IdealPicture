package com.aplicatie.idealpicture;

import android.content.Context;
import android.util.Patterns;
import android.widget.Toast;



public class ValidateInput {
    Context context;
    ValidateInput(Context context){
        this.context = context;
    }
    Boolean checkemailvalid(String email)   {
        if (email.length() == 0){
            Toast.makeText(context,"Introdu adresa de email " ,Toast.LENGTH_SHORT).show();
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(context,"Introdu adresa de email valida" ,Toast.LENGTH_SHORT).show();
       return false;
        }else {
            return true;
        }
        }
        Boolean checkpasswordvalid(String password)   {
            if (password.length() == 0){
                Toast.makeText(context,"Introdu parola " ,Toast.LENGTH_SHORT).show();
                return false;
            }else if (password.length() < 6){
                Toast.makeText(context,"Introdu o parola cu mai mult de 6 caractere" ,Toast.LENGTH_SHORT).show();
                return false;
            }else {
                return true;
            }

    }

}
