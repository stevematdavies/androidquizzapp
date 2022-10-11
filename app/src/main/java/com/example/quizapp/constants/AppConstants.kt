package com.example.quizapp.constants

import com.example.quizapp.R
import com.example.quizapp.models.Question

object AppConstants {

    fun getQuestions():ArrayList<Question> {

        val questions = ArrayList<Question>()

        questions.add(Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Bolivia",
            "Chile",
            "Venezuela",
            1
                ))

        questions.add(Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Samoa",
            "Fiji",
            2
        ))

        questions.add(Question(
            3,
            "What country does this flag belong to?",
             R.drawable.ic_flag_of_belgium,
            "Germany",
            "Romania",
            "Armenia",
            "Belgium",
            4
        ))

        questions.add(Question(
            4,
            "What country does this flag belong to?",
             R.drawable.ic_flag_of_brazil,
            "Panama",
            "Mexico",
            "Brazil",
            "Puerto Rico",
            3
        ))

        questions.add(Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Sweden",
            "Norway",
            "Denmark",
            "Iceland",
            3
        ))

        questions.add(Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "Samoa",
            "Tonga",
            "Tuvalu",
            1
        ))

        questions.add(Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Luxembourg",
            "Romania",
            "Germany",
            "Belgium",
            3
        ))

        questions.add(Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Pakistan",
            "India",
            "Sri Lanka",
            "Nepal",
            2
        ))

        questions.add(Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Qatar",
            "Iraq",
            "Iran",
            "Kuwait",
            4
        ))

        questions.add(Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "New Zealand",
            "Australia",
            "Tonga",
            "Tuvalu",
            2
        ))

        return questions
    }

}