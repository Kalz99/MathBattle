package com.example.mathbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathbattle.scoreboard.Rankings;

public class Howtoplay extends AppCompatActivity {

    Button how;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoplay);
        how=(Button)findViewById(R.id.btnhhow);
        how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Howtoplay.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}