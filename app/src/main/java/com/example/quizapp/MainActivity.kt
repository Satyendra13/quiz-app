package com.example.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val answer = "Option 2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.option_1)
//        val btn2 = findViewById<Button>(R.id.option_2)
//        val btn3 = findViewById<Button>(R.id.option_3)
//        val btn4 = findViewById<Button>(R.id.option_4)
//        val nextBtn = findViewById<Button>(R.id.next_btn)
//        val prevBtn = findViewById<Button>(R.id.prev_btn)
//        val question = findViewById<TextView>(R.id.question)

        btn1.setOnClickListener {
            val userAns = btn1.text.toString()
            Log.d("Sat", userAns)
            if(userAns==answer){
                btn1.setBackgroundResource(R.color.black)
            }else{
                btn1.setBackgroundColor(Color.RED)
            }
        }

    }
}