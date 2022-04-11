package com.example.quizapp_java;

public class Question {
    public int id;
    public String question;
    public int image;
    public String optionOne;
    public String optionTwo;
    public String optionThree;
    public String optionFour;
    public int correctAnswer;

    public Question(int id, String question, int image, String optionOne, String optionTwo, String optionThree, String optionFour, int correctAnswer) {
        this.id = id;
        this.question = question;
        this.image = image;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correctAnswer = correctAnswer;
    }
}
