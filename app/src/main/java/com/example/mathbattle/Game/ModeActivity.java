package com.example.mathbattle.Game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mathbattle.R;

public class ModeActivity extends AppCompatActivity {

    Button btnBeginner,inter,advanc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode);
        btnBeginner=(Button) findViewById(R.id.btnBeginner);
        inter=(Button)findViewById(R.id.btnIntermediate);
        advanc=(Button)findViewById(R.id.btnAdvanced);
        btnBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModeActivity.this, Game.class);
                intent.putExtra("mode", "beg");
                startActivity(intent);
            }
        });
        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModeActivity.this, Game.class);
                intent.putExtra("mode", "inter");
                startActivity(intent);
            }
        });
        advanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModeActivity.this, Game.class);
                intent.putExtra("mode", "advance");
                startActivity(intent);
            }
        });
    }
}