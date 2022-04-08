package com.example.mathbattle.Game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathbattle.R;

public class ModeActivity extends AppCompatActivity {

    Button btnBeginner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode);
        btnBeginner=(Button) findViewById(R.id.btnBeginner);
        btnBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModeActivity.this, Game.class);
                startActivity(intent);
            }
        });
    }
}