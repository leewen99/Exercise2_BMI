package com.example.bmicalculator

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var img: ImageView

    lateinit var height: EditText

    lateinit var weight: EditText

    lateinit var bmiResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById(R.id.imageViewProfile)
        height= findViewById(R.id.editTextHeight)
        weight = findViewById(R.id.editTextWeight)
        bmiResult = findViewById(R.id.textViewBMI)
        val calculateB : Button = findViewById(R.id.buttonCalculate)
        val resetB : Button = findViewById(R.id.buttonReset)

        calculateB.setOnClickListener{ calculator() }
        resetB.setOnClickListener { resetBMI() }
    }

    private fun calculator(){

        val heightDouble: Double = height.text.toString().toDouble() / 100

        val weightDouble: Double = weight.text.toString().toDouble()

        val cal: Double =  weightDouble / Math.pow(heightDouble, 2.0)

        img.setImageResource(R.drawable.empty)


        if (cal >= 25){
            img.setImageResource(R.drawable.over)
        }

        else if (cal >= 18.5 && cal <= 24.9){
            img.setImageResource(R.drawable.normal)
        }
        
        else if (cal < 18.5){
            img.setImageResource(R.drawable.under)
        }

        bmiResult.setText("BMI : "+cal)
    }

    private fun resetBMI(){

        height.setText("")

        weight.setText("")

        //set image empty
        img.setImageResource(R.drawable.empty)

        bmiResult.setText("BMI : ")


    }
}
