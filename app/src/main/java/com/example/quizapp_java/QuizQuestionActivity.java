package com.example.quizapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizQuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private String userName;
    private int correctAnswers;

    private ImageView flagImageView;
    private ProgressBar progressBar;
    private TextView progressText;
    private TextView optionOne;
    private TextView optionTwo;
    private TextView optionThree;
    private TextView optionFour;
    private Button submitBtn;

    private TextView selectedOption;
    private ArrayList<Question> questions;
    private int currentQuestion;

    private static final String SUBMIT = "SUBMIT";
    private static final String NEXT = "NEXT";
    private static final String FINISH = "FINISH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        initializeDataField();
        setOnClickListeners();
        setQuestion();

    }

    private void setOnClickListeners() {
        optionOne.setOnClickListener(this);
        optionTwo.setOnClickListener(this);
        optionThree.setOnClickListener(this);
        optionFour.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
    }

    private void setQuestion() {
        Question question = getCurrentQuestion();
        flagImageView.setImageResource(question.image);

        setProgress();
        progressText.setText(getProgressText());

        optionOne.setText(question.optionOne);
        optionTwo.setText(question.optionTwo);
        optionThree.setText(question.optionThree);
        optionFour.setText(question.optionFour);


    }

    private String getProgressText() {
        return currentQuestion + 1 + "/" + questions.size();
    }

    private Question getCurrentQuestion() {
        return questions.get(currentQuestion);
    }

    private void initializeDataField() {
        userName = getIntent().getStringExtra(Constants.USER_NAME);
        correctAnswers = 0;
        flagImageView = findViewById(R.id.flagImage);
        progressBar = findViewById(R.id.progressBar);
        progressText = findViewById(R.id.progressText);
        optionOne = findViewById(R.id.optionOne);
        optionTwo = findViewById(R.id.optionTwo);
        optionThree = findViewById(R.id.optionThree);
        optionFour = findViewById(R.id.optionFour);
        submitBtn = findViewById(R.id.submitBtn);
        questions = Constants.getQuestions();
        currentQuestion = 0;
    }

    @Override
    public void onClick(View view) {
        if (optionOne.equals(view)) {
            setDefaultBackgrounds();
            setCustomBackgroundFor(optionOne);
            selectedOption = optionOne;
        } else if (optionTwo.equals(view)) {
            setDefaultBackgrounds();
            setCustomBackgroundFor(optionTwo);
            selectedOption = optionTwo;
        } else if (optionThree.equals(view)) {
            setDefaultBackgrounds();
            setCustomBackgroundFor(optionThree);
            selectedOption = optionThree;
        } else if (optionFour.equals(view)) {
            setDefaultBackgrounds();
            setCustomBackgroundFor(optionFour);
            selectedOption = optionFour;
        } else if (submitBtn.equals(view)) {
            if (submitBtn.getText().equals(SUBMIT)) {
                checkAnswerAndSetBackgrounds();
                changeTextOfSubmitBtn();
            } else if (submitBtn.getText().equals(NEXT)) {
                setDefaultBackgrounds();
                submitBtn.setText(SUBMIT);
                incrementCurrentQuestion();
                setProgress();
                progressText.setText(getProgressText());
                selectedOption = null;
                setQuestion();
            } else if (submitBtn.getText().equals(FINISH)) {
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra(Constants.USER_NAME, userName);
                intent.putExtra(Constants.SCORE, correctAnswers);
                startActivity(intent);
                finish();
            }
        }
    }

    private void changeTextOfSubmitBtn() {
        if (currentQuestion != 9) {
            submitBtn.setText(NEXT);
        } else {
            submitBtn.setText(FINISH);
        }

    }

    private int incrementCurrentQuestion() {
        return currentQuestion++;
    }

    private void setProgress() {
        progressBar.setProgress(currentQuestion + 1);
    }

    private void checkAnswerAndSetBackgrounds() {
        TextView[] options = {optionOne, optionTwo, optionThree, optionFour};
        Question question = getCurrentQuestion();
        TextView correctOption = options[question.correctAnswer-1];
        if (correctOption.equals(selectedOption)) {
            selectedOption.setBackgroundResource(R.drawable.correct_answer_bg);
            correctAnswers++;
        } else {
            correctOption.setBackgroundResource(R.drawable.correct_answer_bg);
            if (selectedOption != null) {
                selectedOption.setBackgroundResource(R.drawable.wrong_answer_bg);
            }
        }
    }

    private void setCustomBackgroundFor(TextView option) {
        option.setBackgroundResource(R.drawable.selected_option_border_bg);
        option.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }

    private void setDefaultBackgrounds() {
        TextView[] options = {optionOne, optionTwo, optionThree, optionFour};
        for (TextView option : options) {
            option.setBackgroundResource(R.drawable.default_option_border_bg);
            option.setTypeface(Typeface.DEFAULT);
            option.setTextColor(Color.BLACK);
        }

    }
}