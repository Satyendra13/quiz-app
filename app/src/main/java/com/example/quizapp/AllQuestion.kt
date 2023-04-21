package com.example.quizapp

data class Questions(
    val id: Int,
    val qus: String,
    val opt1: String,
    val opt2: String,
    val opt3: String,
    val opt4: String,
    val answer: Int,
)

object question {

    const val userName: String = "User Name"
    const val totalQuestion: String = "Total Question"
    const val score: String = "Total Correct Answer"

    fun getQuestion(): ArrayList<Questions>{
        val questions =  ArrayList<Questions> ()


        val q1  =   Questions(
                1,
                "The JSON syntax is a subset of the _____ syntax.",
                "Ajax",
                "Php",
                "HTML",
                "JavaScript",
                4

            )
        questions.add(q1)

        val q2 =  Questions(
                2,
                "In the JSON syntax, data is separated by _____.",
                "Semicolons",
                "Colons",
                "Commas",
                "Hyper",
                3

            )
        questions.add(q2)
        return questions
    }
}
