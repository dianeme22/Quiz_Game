package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionTwo extends AppCompatActivity {
    public static final String TOTAL_SCORE = "com.example.quizgame.TOTAL_SCORE";
    RadioGroup radioGroup;
    RadioButton radioButton;

    Button submit;
    double newscore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        radioGroup = findViewById(R.id.radioGroup);

        submit = findViewById(R.id.submit);

        Intent Intent = getIntent();
        newscore = Intent.getDoubleExtra(QuestionOne.TOTAL_SCORE,0);
        String text = Double.toString(newscore);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
//adds on to your total score
                if (radioButton.getText().equals("boolean")){
                    newscore = newscore + 1;
                    Toast.makeText(QuestionTwo.this, "Correct", Toast.LENGTH_SHORT).show();
                }

                Intent LoginIntent = new Intent(QuestionTwo.this, Question3.class);
                LoginIntent.putExtra(TOTAL_SCORE, newscore);
                startActivity(LoginIntent);

            }
        });
    }
}
