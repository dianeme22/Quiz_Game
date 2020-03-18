package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etFirstName, etLastName, etDateOfBirth, etEmail, etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etDateOfBirth = findViewById(R.id.etDateOfBirth);
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        bRegister = findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);

        // below will tell user the edittext fields are empty if nothing is entered
        if (etFirstName.length() == 0) {
            etFirstName.setError("Enter First Name");
        }
        if (etLastName.length() == 0) {
            etLastName.setError("Enter Last Name");
        }
        if (etDateOfBirth.length() == 0) {
            etDateOfBirth.setError("Enter DOB");
        }
        if (etUsername.length() == 0) {
            etUsername.setError("Enter your username");
        }
        if (etPassword.length() == 0) {
            etPassword.setError("Enter your Password");
        }
        if (etEmail.length() == 0) {
            etEmail.setError("Enter your Email, make sure its in proper format XX@.com");
        }
    }

    @Override
    //below FirstName and LastName needs to be more than 3 characters in order for registration button to work
    public void onClick(View v) {
        String FirstName = etFirstName.getText().toString();
        if (FirstName.isEmpty() || FirstName.length() < 3) {
            etFirstName.setError("First name can not be less than 3 characters and no more than 30");
        } else {
            etFirstName.setError(null);
        }
        {
            String LastName = etLastName.getText().toString();
            if (LastName.isEmpty() || LastName.length() < 3) {
                etLastName.setError("Last Name can not be less than 3 characters and no more than 30");
            } else {
                etLastName.setError(null);
            }
        }


        //clicking Register button will bring you back to the Login page
        switch (v.getId()) {
            case R.id.bRegister:
                if (etFirstName.length() == 0 && etLastName.length() == 0) {
                    Toast.makeText(getApplicationContext(), "All Fields Must Be Filled", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, MainActivity.class));
                    break;

                }
        }

        }

    }