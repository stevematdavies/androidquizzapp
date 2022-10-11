package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.constants.AppConstants
import com.example.quizapp.models.Question
import java.lang.reflect.Type

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar? = null
    private var progressBarText: TextView? = null
    private var submitButton: Button? =  null
    private var questionImage: ImageView? = null

    private var questionText: TextView? = null
    private var answerOne: TextView? = null
    private var answerTwo: TextView? = null
    private var answerThree: TextView? = null
    private var answerFour: TextView? = null

    private var mCurrentPosition = 1
    private var mQuestions:ArrayList<Question>? = null
    private var mSelectedAnswerPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        window.decorView.windowInsetsController!!.hide(
            android.view.WindowInsets.Type.statusBars()
        )

        progressBar = findViewById(R.id.pbQuestions)
        progressBarText = findViewById(R.id.tvQuestionsProgress)
        submitButton = findViewById(R.id.btnSubmit)
        questionImage = findViewById(R.id.ivQuestionImage)
        questionText = findViewById(R.id.tvQuestion)
        answerOne =   findViewById(R.id.tvAnswerOne)
        answerTwo =   findViewById(R.id.tvAnswerTwo)
        answerThree = findViewById(R.id.tvAnswerThree)
        answerFour = findViewById(R.id.tvAnswerFour)
        mQuestions = AppConstants.getQuestions()


        setQuestion()

        answerOne?.setOnClickListener(this)
        answerTwo?.setOnClickListener(this)
        answerThree?.setOnClickListener(this)
        answerFour?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)


    }

    private fun setQuestion() {
        val question: Question = mQuestions!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        progressBarText?.text = getString(R.string.progress_text,mCurrentPosition, progressBar?.max)
        questionImage?.setImageResource(question.image)
        questionText?.text = question.question
        answerOne?.text = question.answerOne
        answerTwo?.text = question.answerTwo
        answerThree?.text = question.answerThree
        answerFour?.text = question.answerFour

        submitButton?.text = if(mCurrentPosition == mQuestions!!.size) "FINISH" else "SUBMIT"

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        answerOne?.let {
            options.add(0, it)
        }
        answerTwo?.let {
            options.add(1, it)
        }
        answerThree?.let {
            options.add(2, it)
        }
        answerFour?.let {
            options.add(3, it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor( "#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat
                .getDrawable(this, R.drawable.default_option_border_bg)

        }
    }

    private fun displaySelectionOption(tv: TextView, answerNo: Int){
        defaultOptionsView()
        mSelectedAnswerPosition = answerNo
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background  = ContextCompat
            .getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.tvAnswerOne   ->  answerOne?.let { displaySelectionOption(it, 1)}
           R.id.tvAnswerTwo   ->  answerTwo?.let { displaySelectionOption(it, 2)}
           R.id.tvAnswerThree ->  answerThree?.let { displaySelectionOption(it, 3)}
           R.id.tvAnswerFour  ->  answerFour?.let { displaySelectionOption(it, 4)}
           R.id.btnSubmit     -> { }
       }
    }
}