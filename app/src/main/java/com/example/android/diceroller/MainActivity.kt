package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Only after inflation is a view in memory.
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
        button = findViewById(R.id.roll_button)
    }

    private fun rollDice() {
       // val diceImage: ImageView = findViewById(R.id.dice_image) //This is a problem
        //Everytime you call the function, you are doing an expensive findView operation.
        //I'd like to store this in a field.
        //You could create it as a var, but it'd start as null
        // Only after inflation would it receive a value
        // This would make our code have to check for null values all the time.
        // lateinit is the solution for that.
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = Random().nextInt(6) + 1 //Starts from 0, hence the +1
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        resultText.text = randomInt.toString()
        button.text = "Do it again!"
        diceImage.setImageResource(drawableResource)
    }
}