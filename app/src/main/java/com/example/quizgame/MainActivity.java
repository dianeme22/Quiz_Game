package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText etFirstName, etLastName, etDateOfBirth, etEmail, etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName= findViewById(R.id.etFirstName);
        etLastName= findViewById(R.id.etLastName);
        etDateOfBirth= findViewById(R.id.etDateOfBirth);
        etEmail= findViewById(R.id.etEmail);
        etUsername= findViewById(R.id.etUsername);
        bLogout=findViewById(R.id.bLogout);


        bLogout.setOnClickListener(this);

        //Displays toast showing user registered correctly
        Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_SHORT).show();
    }
    //clicking this button will bring you into the app for registering, hit "logout" button to go to main screen.
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:
                startActivity(new Intent(this, Login.class));
                break;


        }
    }
}
