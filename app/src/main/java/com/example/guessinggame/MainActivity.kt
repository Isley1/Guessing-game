package com.example.guessinggame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var numberToGuess = 0
    private var attempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberToGuess = Random.nextInt(1, 101)
        val guessInput = findViewById<EditText>(R.id.guessInput)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val resultText = findViewById<TextView>(R.id.resultText)

        submitBtn.setOnClickListener {
            val guess = guessInput.text.toString().toIntOrNull()
            if (guess == null) {
                resultText.text = "Please enter a valid number."
                return@setOnClickListener
            }
            attempts++
            when {
                guess < numberToGuess -> resultText.text = "Too low!"
                guess > numberToGuess -> resultText.text = "Too high!"
                else -> {
                    resultText.text = "Correct! You guessed in $attempts attempts."
                    numberToGuess = Random.nextInt(1, 101)
                    attempts = 0
                }
            }
        }
    }
}
