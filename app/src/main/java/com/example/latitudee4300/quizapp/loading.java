package com.example.latitudee4300.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class loading extends AppCompatActivity {
    String names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Intent intent = getIntent();
        names = intent.getStringExtra("username");
        TextView h = (TextView) findViewById(R.id.loading_text);
        h.setText(" Hold on " + names + " while we fetch your quiz");
        int delay = 3000;
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        }, delay);


    }
}