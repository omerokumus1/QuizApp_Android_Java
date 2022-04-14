package com.example.quizapp_java;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    static final String USER_NAME = "user_name";
    static final String SCORE = "SCORE";

    public static ArrayList<Question> getQuestions() {
        return new ArrayList<>(
                Arrays.asList(
                        new Question(1, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_argentina,
                                "Argentina", "Australia",
                                "Armenia", "Austria", 1),
                        new Question(2, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_australia,
                                "Angola", "Austria",
                                "Australia", "Armenia", 3),
                        new Question(3, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_brazil,
                                "Belarus", "Belize",
                                "Brunei", "Brazil", 4),
                        new Question(4, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_belgium,
                                "Bahamas", "Belgium",
                                "Barbados", "Belize", 2),
                        new Question(5, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_fiji,
                                "Gabon", "France",
                                "Fiji", "Finland", 3),
                        new Question(6, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_germany,
                                "Germany", "Georgia",
                                "Greece", "none of these", 1),
                        new Question(7, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_denmark,
                                "Dominica", "Egypt",
                                "Denmark", "Ethiopia", 3),
                        new Question(8, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_india,
                                "Ireland", "Iran",
                                "Hungary", "India", 4),
                        new Question(9, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_new_zealand,
                                "Australia", "New Zealand",
                                "Tuvalu", "United States of America", 2),
                        new Question(10, "What country does this flag belong to?",
                                R.drawable.ic_flag_of_kuwait,
                                "Kuwait", "Jordan",
                                "Sudan", "Palestine", 1)
                )
        );
    }

}
