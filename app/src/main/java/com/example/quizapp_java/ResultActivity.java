package com.example.quizapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView userNameText;
    private TextView resultText;
    private Button finishBtn;

    private int score;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initializeDataField();
        setViewData();
        setOnClickListener();
    }

    private void setOnClickListener() {
        finishBtn.setOnClickListener(view ->
                finish());
    }

    private void setViewData() {
        userNameText.setText(userName);
        resultText.setText("Your score is " + score + " out of 10");
    }

    private void initializeDataField() {
        initializeViews();
        getDataFromIntent();
    }

    private void initializeViews() {
        userNameText = findViewById(R.id.userNameText);
        resultText = findViewById(R.id.resultText);
        finishBtn = findViewById(R.id.finishBtn);
    }

    private void getDataFromIntent() {
        score = this.getIntent().getIntExtra(Constants.SCORE, -1);
        userName = this.getIntent().getStringExtra(Constants.USER_NAME);
    }
}