package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    TextView bRegisterHere;

    //This is how many incorrect login attempts you have
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin = findViewById(R.id.bLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        bRegisterHere = findViewById(R.id.bRegisterHere);
        bLogin.setOnClickListener(this);
        bRegisterHere.setOnClickListener(this);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    //If logging in with incorrect username and password more than 5 times, button will disable
    //log in with admin and 12345 to bring you to quiz
    private void validate (String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("12345"))) {
            Intent intent = new Intent(Login.this, Intro.class);
            startActivity(intent);
        }else{
            counter--;
            if(counter ==0) {
                bLogin.setEnabled(false);
            }

        }
    }
    //this will bring to the registration page
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:

                break;

            case R.id.bRegisterHere:
                startActivity(new Intent(this, Register.class));
                break;




        }
    }

}