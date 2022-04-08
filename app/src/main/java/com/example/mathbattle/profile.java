package com.example.mathbattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {
FirebaseUser user;
Button rank,close,main;
String uid;
DatabaseReference db;
TextView pname,score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        pname=(TextView)findViewById(R.id.txtname);
        main=(Button)findViewById(R.id.btn_main1);

        score=(TextView)findViewById(R.id.txtscore);
        rank=(Button)findViewById(R.id.btnRanking);
        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, Rankings.class);
                startActivity(intent);
            }
        });
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, MainMenu.class);
                startActivity(intent);
            }
        });

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        db= FirebaseDatabase.getInstance().getReference("USERS").child(uid);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String sscore=dataSnapshot.child("score").getValue().toString();

                    pname.setText(name);
                    score.setText(sscore);
                   // Picasso.get().load(img).into(imgpro);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Successfully deactivated", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}