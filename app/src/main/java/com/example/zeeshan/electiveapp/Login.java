package com.example.zeeshan.electiveapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;


public class Login extends AppCompatActivity {
    final  static String passwordpattern= "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
    public static final Pattern Password = Pattern.compile(passwordpattern);
        EditText firstnametxt,middlenametxt,lastnametxt,mobiletxt,pwdtxt;
        CheckBox android_c,web_c,ml_c,cc_c;
        RadioButton genderbutton;
        RadioGroup radiogender;
        Button Registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firstnametxt= findViewById(R.id.firstnametxt);
        middlenametxt=findViewById(R.id.middlenametxt);
        lastnametxt=findViewById(R.id.lastnametxt);
        mobiletxt=findViewById(R.id.mobiletxt);
        pwdtxt=findViewById(R.id.pwdtxt);

        android_c=findViewById(R.id.androidcbx);
        web_c=findViewById(R.id.webcbx);
        ml_c=findViewById(R.id.mlcbx);
        cc_c=findViewById(R.id.cloudcbx);


        radiogender=findViewById(R.id.radiogender);

        Registerbtn=findViewById(R.id.loginbtn);

        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!namecheck()|| !mobilecheck() ||!checkpwd()){
                    return;
                }
                getGender();
                getIntrest();
                Toast.makeText(Login.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();


            }
        });

    }

    public boolean namecheck(){

        String firstname=firstnametxt.getText().toString();
        String middlename=middlenametxt.getText().toString();
        String lastname=lastnametxt.getText().toString();

        if(firstname.isEmpty()){
            firstnametxt.requestFocus();
            firstnametxt.setError("First name cannot be empty");
            return false;
        } else
            if(middlename.isEmpty()){
            middlenametxt.requestFocus();
            middlenametxt.setError("Middle name cannot be empty");
            return false;
        } else
            if(lastname.isEmpty()){
                lastnametxt.requestFocus();
                lastnametxt.setError("Last name cannot be empty");
                return false;
            }
            else{
                return true;
            }
    }

    public boolean mobilecheck() {
        String mobileno = mobiletxt.getText().toString();
        if (mobileno.isEmpty()) {
            mobiletxt.requestFocus();
            mobiletxt.setError("Enter mobile number");
            return false;
        } else if (!Patterns.PHONE.matcher(mobileno).matches()) {
            mobiletxt.requestFocus();
            mobiletxt.setError("Please Enter Valid Mobile Number");
            return false;
        } else {
            return true;
        }

    }

    public boolean checkpwd(){
        String password=pwdtxt.getText().toString();
        if(password.isEmpty()){
            pwdtxt.requestFocus();
            pwdtxt.setError("Password cannot be null");
            return false;
        }
        else if(!Password.matcher(password).matches()){
            pwdtxt.requestFocus();
            pwdtxt.setError("Password should at least 6 char, contain 1 upper 1 lower 1 special and 1 number");
            return false;
        }
        else {
            return true;
        }
    }

    public void getGender(){
        int selectedID=radiogender.getCheckedRadioButtonId();
        genderbutton=(RadioButton)findViewById(selectedID);


    }

    public void getIntrest(){

        StringBuilder result=new StringBuilder();
        if(android_c.isChecked()){
            result.append("Android ");
        }
        if(web_c.isChecked()){
            result.append("Web ");
        }
        if( ml_c.isChecked()){
            result.append("machine learning ");
        }
        if(cc_c.isChecked()){
            result.append("Cloud computing ");
        }
    }



}