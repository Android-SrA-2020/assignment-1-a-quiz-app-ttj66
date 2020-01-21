package com.example.rickandmortyquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private val questionBank = listOf(
    "Electrons are larger than molecules.",
    "The Atlantic Ocean is the biggest ocean on Earth.",
    "The chemical make up food often changes when you cook it.",
    "Sharks are mammals.",
    "The human body has four lungs.",
    "Atoms are most stable when their outer shells are full.",
    "Filtration separates mixtures based upon their particle size.",
    "Venus is the closest planet to the Sun.",
    "Conductors have low resistance.",
    "Molecules can have atoms from more than one chemical element.",
    "Water is an example of a chemical element.",
    "The study of plants is known as botany.")

    val quizzAnswers = mapOf<Int,Boolean>(1 to false,2 to false, 3 to true,4 to false,5 to false,6 to true,7 to true,8 to false, 9 to true,10 to true,11 to false,12 to true)
    private var questionIndex =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.move_Fwd_button).setOnClickListener{
            updateView()
            if(questionIndex < questionBank.size - 1)
            {
                questionIndex++
            }else{
                questionIndex=0
            }

        }
        findViewById<Button>(R.id.move_back_button).setOnClickListener{
            updateView()
            if(questionIndex > 0)
            {
                questionIndex--
            }else{
                questionIndex = questionBank.size - 1
            }

        }
        findViewById<Button>(R.id.answer_false_button).setOnClickListener{
                updateAnswerView(checkAnswer(questionIndex))
        }
        findViewById<Button>(R.id.answer_true_button).setOnClickListener{
            updateAnswerView(checkAnswer(questionIndex))
        }
    }
    private fun updateView(){
        check_answer_text.setBackgroundResource(R.drawable.ic_launcher_foreground)
        findViewById<TextView>(R.id.question_text).setText(questionBank.get(questionIndex))
    }
    private fun updateAnswerView(answer : Boolean){
        if(answer){
             check_answer_text.setBackgroundResource(R.drawable.check_true)

        }
        else
        {
                 check_answer_text.setBackgroundResource(R.drawable.check_false)
        }
    }
    private fun checkAnswer( question:Int): Boolean{
        return quizzAnswers.getValue(question)
    }
}
