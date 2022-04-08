package com.example.mathbattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(){


            @Override
            public void run() {
                try{
                    sleep(5*1000);
                    Intent i = new Intent(MainActivity.this,Login.class);
                    startActivity(i);



                }
                catch(Exception e)
                {}
            }
        };
        thread.start();
    }
}