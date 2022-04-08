package com.example.mathbattle.Game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathbattle.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class result extends AppCompatActivity {
  TextView finalscore,Wanswers,Ranswers;
    FirebaseUser user;
    DatabaseReference db;
    int wrong=0;
    String uid;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        finalscore=(TextView) findViewById(R.id.txtresultScore);
        Wanswers=(TextView) findViewById(R.id.txt_wrongAns);
        Ranswers=(TextView) findViewById(R.id.txt_rightAns);
        final int[] score = {getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0)};
        int finalScore= score[0] *50;
        finalscore.setText(String.valueOf(finalScore));
        Ranswers.setText("Right Answers "+String.valueOf(score[0]));
        if(score[0] !=10) {
            wrong = 10 - score[0];
        }
        Wanswers.setText("Wrong Answers "+String.valueOf(wrong));

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        db= FirebaseDatabase.getInstance().getReference("USERS").child(uid);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {

                    String sscore=dataSnapshot.child("score").getValue().toString();
                    int ssscore =Integer.parseInt(sscore);
                    if(finalScore>ssscore){
                        mDatabase = FirebaseDatabase.getInstance().getReference();
                        mDatabase.child("USERS").child(uid).child("score").setValue(finalScore);
                        mDatabase.child("USERS").child(uid).child("level").setValue(1);


                    }else{}


                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}