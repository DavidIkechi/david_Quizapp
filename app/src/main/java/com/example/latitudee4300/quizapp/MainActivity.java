package com.example.latitudee4300.quizapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    EditText username;
    String usernamevalue, names;

    // to get the value entered by the user before accessing the system
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }

    public void verifyLogin(View view) {
        username = (EditText) findViewById(R.id.username);
        usernamevalue = username.getText().toString();
        // essence of using trim is to remove trailing white spaces.
        // the essence of using length is to check if any value has been entered into the input field,making sure it is not empty.
        if (usernamevalue.trim().length() == 0) {
            Toast.makeText(this, "User name should not be empty", Toast.LENGTH_SHORT).show();
        } else {
            openQuizActivity(usernamevalue);
        }

    }

    public void openQuizActivity(String username) {
        int delay = 3000;
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runs();
            }
        }, delay);

        Intent newactivity = new Intent(this, loading.class);
        newactivity.putExtra("username", username);
        startActivity(newactivity);

    }

    public void runs() {
        Intent newactivitys = new Intent(this, quizActivity.class);
        newactivitys.putExtra("user", usernamevalue);
        startActivity(newactivitys);

    }

}

