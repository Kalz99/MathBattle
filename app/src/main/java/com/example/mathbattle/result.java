package com.example.mathbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {
  TextView finalscore,Wanswers,Ranswers;
    int wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        finalscore=(TextView) findViewById(R.id.txtresultScore);
        Wanswers=(TextView) findViewById(R.id.txt_wrongAns);
        Ranswers=(TextView) findViewById(R.id.txt_rightAns);
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        int finalScore=score*50;
        finalscore.setText(String.valueOf(finalScore));
        Ranswers.setText("Right Answers "+String.valueOf(score));
        if(score!=10) {
            wrong = 10 - score;
        }
        Wanswers.setText("Wrong Answers "+String.valueOf(wrong));
    }
}