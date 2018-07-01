package com.example.latitudee4300.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class quizActivity extends AppCompatActivity {
    String names;

    // to get the value entered by the user before accessing the system
    // defining all radiobuttons to be global variable
    RadioButton answer1, answer2, answer3, answer4, answer5, answer6;
    // Creating an arrayList to hold corrected answers.
    ArrayList answers;
    //defining the checkbox for answers
    CheckBox answer7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent = getIntent();
        names = intent.getStringExtra("user");
        TextView h = findViewById(R.id.name);
        h.setText(" Welcome " + names);

        //setting on click listener to the submit button
        Button btn = (Button) findViewById(R.id.submit_answer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answers = new ArrayList();
                int checkstatus = 0; // creating a local variable to check how many check boxes were clicked for the last answer
                int correctanswer = 0; // creating a local variable for correctly answered questions
                boolean check;
                // checking if question 1 was correctly answered;
                answer1 = (RadioButton) findViewById(R.id.xml);
                check = (answer1).isChecked();
                if (check) {
                    correctanswer += 1;

                }
                // checking if question 2 was correctly answered
                answer2 = (RadioButton) findViewById(R.id.start_signal);
                check = (answer2).isChecked();
                if (check) {
                    correctanswer += 1;
                }
                // checking if question 3 was correctly answered
                answer3 = (RadioButton) findViewById(R.id.device);
                check = (answer3).isChecked();
                if (check) {
                    correctanswer += 1;
                }
                // checking if question 4 was correctly answered
                answer4 = (RadioButton) findViewById(R.id.string);
                check = (answer4).isChecked();
                if (check) {
                    correctanswer += 1;
                }
                // checking if question 2 was correctly answered
                answer5 = (RadioButton) findViewById(R.id.news);
                check = (answer5).isChecked();
                if (check) {
                    correctanswer += 1;
                }
                // checking if question 2 was correctly answered
                answer6 = (RadioButton) findViewById(R.id.trues);
                check = (answer6).isChecked();
                if (check) {
                    correctanswer += 1;
                }

                // checking if the three checkboxes for question 7 was clicked
                answer7 = (CheckBox) findViewById(R.id.wrong);
                check = (answer7).isChecked();
                if (check) {
                    checkstatus += 1;
                }
                answer7 = (CheckBox) findViewById(R.id.runtime);
                check = (answer7).isChecked();
                if (check) {
                    checkstatus += 1;
                }
                answer7 = (CheckBox) findViewById(R.id.syntax);
                check = (answer7).isChecked();
                if (check) {
                    checkstatus += 1;
                }


                if (checkstatus == 3) {
                    correctanswer += 1;
                }
                Toast.makeText(quizActivity.this, "awesome " + names + ",you answered " + correctanswer + " questions correctly", Toast.LENGTH_LONG).show();
                //updating the percentage score board

                percentage(correctanswer);
            }
        });
    }

    //once the logout button as been clicked, direct back to the login page
    public void logout(View view) {
        Intent logoff = new Intent(this, MainActivity.class);
        startActivity(logoff);
    }

    //creating a click listener handler
    // checking for the first radio button
    public void percentage(int result) {
        double percent;
        String percentage_to_2dp;
        percent = ((double) result) / 7.0 * 100.0;

        // formatting the percentage to 2 decimal places
        DecimalFormat f = new DecimalFormat("#.0");
        percentage_to_2dp = f.format(percent);

        TextView scoreboard = (TextView) findViewById(R.id.score_percentage_board);
        scoreboard.setText(percentage_to_2dp + "% covered");
        Toast.makeText(quizActivity.this, "Thanks for participating", Toast.LENGTH_LONG).show();


    }


}