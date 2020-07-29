package com.example.zeeshan.electiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView=findViewById(R.id.charusat_link);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}