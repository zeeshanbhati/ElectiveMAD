package com.example.zeeshan.electiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Login_Practical2 extends AppCompatActivity {

    EditText usrname,passwrod,email;
    Button lgnbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__practical2);

        usrname=findViewById(R.id.usernametxt);
        passwrod=findViewById(R.id.passwordtxt);
        email=findViewById(R.id.emailtxt);
        lgnbtn=findViewById(R.id.prac2btnlogin);

        lgnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!namecheck()|| !checkemail() || !checkpwd()){
                    return;
                }
                Toast.makeText(Login_Practical2.this, "Login Successfull", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public boolean namecheck(){
        String uname=usrname.getText().toString();

        if(uname.isEmpty()) {
            usrname.requestFocus();
            usrname.setError("First name cannot be empty");
            return false;
        }else if(uname!="charusat"){
            usrname.requestFocus();
            usrname.setError("Incorrect Email");
            return false;
        }
        else{
            return true;
        }
    }



    public boolean checkpwd(){
        String password=passwrod.getText().toString();
        if(password.isEmpty()){
            passwrod.requestFocus();
            passwrod.setError("Password cannot be null");
            return false;
        }
        else if(password!="ABCD"){
            passwrod.requestFocus();
            passwrod.setError("Password Incorrect");
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkemail(){
        String email_u=email.getText().toString();

        if(email_u.isEmpty()){
            email.requestFocus();
            email.setError("Email is null");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email_u).matches()){
            email.requestFocus();
            email.setError("Email format wrong");
            return false;
        }
        else if(email_u!="charusat@gmail.com"){
            email.requestFocus();
            email.setError("Incorrect email");
            return false;
        }
        else {
            return true;
        }

    }



}