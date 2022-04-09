package com.example.mathbattle.Game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathbattle.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView question,score;
    Button ans1,ans2,ans3,ans4;
    private String rightAnswer;
    private int rightAnswercount=0;
    private int quizCount=1;
    private int Fscore=0;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray= new ArrayList<>();

    String quizData[][]={
            {"30","10+10+10","50/2","100/3","10*2"},
            {"100","1000/10","(10*10)/2","10*10*10","500/4"},
            {"15","(20/4)*3","5*5","50/10","10*2"},
            {"50","150/3","100/3","25*3","80-25"},
            {"500","(800/2)+100","1000/3","(100-50)*8","900/2"},
            {"1500","(500*4)-500","1000-500","2000-1000","4000/2"},
            {"3000","(1500*3)-1500","(1500*2)-500","5000-1500","1000+4000"},
            {"4500","1000+3500","2000+1000","5500-1500","6000/2"},
            {"10","(1000/10)/10","100000/1000","100-80","200-180"},
            {"80","20*4","30*3","50+30","100-60"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        question=(TextView)findViewById(R.id.txtQ);
        ans1=(Button)findViewById(R.id.btnAnswer1);
        ans2=(Button)findViewById(R.id.btnAnswer2);
        ans3=(Button)findViewById(R.id.btnAnswer3);
        ans4=(Button)findViewById(R.id.btnAnswer4);





            for(int i=0;i<quizData.length;i++){
                ArrayList<String> tempArray = new ArrayList<>();
                tempArray.add(quizData[i][0]);
                tempArray.add(quizData[i][1]);
                tempArray.add(quizData[i][2]);
                tempArray.add(quizData[i][3]);
                tempArray.add(quizData[i][4]);
                quizArray.add(tempArray);

            }

            showNextQuiz();



    }

    public void showNextQuiz(){
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);
        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        ans1.setText(quiz.get(0));
        ans2.setText(quiz.get(1));
        ans3.setText(quiz.get(2));
        ans4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);
    }



    public void checkAnswer(View view) {
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        score=(TextView)findViewById(R.id.txtScore);

        String alertTitle;
        if (btnText.equals(rightAnswer)) {
            Fscore=Fscore+50;
            String FFscore=String.valueOf(Fscore);
             score.setText(FFscore);
            alertTitle = "Correct!";
            rightAnswercount++;

        } else {
            alertTitle = "Wrong...";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    // Show Result.
                    if(rightAnswercount>5){
                         Intent intent = new Intent(getApplicationContext(), result.class);
                        intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswercount);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getApplicationContext(), result2.class);
                        intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswercount);
                        startActivity(intent);
                    }


                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
}