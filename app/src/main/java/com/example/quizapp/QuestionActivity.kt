package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), OnClickListener {
    private var currentPos: Int = 1
    private var questionList = ArrayList<Questions>()
    private var selectedOption: Int = 0
    private var score: Int = 0
    private lateinit var userName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        userName = intent.getStringExtra(question.userName).toString()
        questionList = question.getQuestion()
        setQuestions()
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)
        submit_btn.setOnClickListener(this)
    }

    private fun setQuestions() {
//        currentPos = 1
        val question = questionList[currentPos - 1]
        setDefault()

        if (currentPos == questionList.size) {
            submit_btn.text = "FINISH"
        } else {
            submit_btn.text = "SUBMIT"
        }

        question_no.text = "Question ${question.id.toString()}"
        question_text.text = question.qus
        option_1.text = question.opt1
        option_2.text = question.opt2
        option_3.text = question.opt3
        option_4.text = question.opt4
    }

    private fun setDefault() {
        val options = ArrayList<TextView>()
        options.add(0, option_1)
        options.add(1, option_2)
        options.add(2, option_3)
        options.add(3, option_4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.bg_btn
            )
        }
    }

    override fun onClick(p: View?) {
        when (p?.id) {
            R.id.option_1 -> {
                selectedOptionView(option_1, 1)
            }
            R.id.option_2 -> {
                selectedOptionView(option_2, 2)
            }
            R.id.option_3 -> {
                selectedOptionView(option_3, 3)
            }
            R.id.option_4 -> {
                selectedOptionView(option_4, 4)
            }
            R.id.submit_btn -> {
                if (selectedOption == 0) {
                    currentPos += 1

                    when {
                        currentPos <= questionList.size -> {
                            setQuestions()
                        }
                        else -> {
                            val intent = Intent(this, Results::class.java)
                            intent.putExtra(question.userName, userName)
                            intent.putExtra(question.totalQuestion, questionList.size)
                            intent.putExtra(question.score, score)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val qus = questionList[currentPos - 1]
                    Log.d("Current", qus.toString())
                    if (qus.answer != selectedOption) {
                        answerView(selectedOption, R.drawable.wrong_bg)
                    } else {
                        score += 1
                    }
                    answerView(qus.answer, R.drawable.correct_bg)
                    if (currentPos == questionList.size) {
                        submit_btn.text = "FINISH"
                    } else {
                        submit_btn.text = "GO TO NEXT QUESTION"
                    }
                    selectedOption = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                option_1.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                option_2.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                option_3.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                option_4.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }
    }

    private fun selectedOptionView(textView: TextView, option: Int) {
        setDefault()
        selectedOption = option
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_bg_btn
        )
    }

}