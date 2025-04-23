package com.example.poggiani_rolldice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity avviata")

        val buttonRoll: Button = findViewById(R.id.buttonRoll)

        buttonRoll.setOnClickListener {
            Log.d(TAG, "Bottone premuto")
            Toast.makeText(this, "LANCIO DEL DADO", Toast.LENGTH_LONG).show()

            val mioRandom = (1..6).random()
            Log.d(TAG, "Numero casuale generato: $mioRandom")

            val editText = findViewById<EditText>(R.id.editTextNumber)
            val numeroInserito = editText.text.toString().toIntOrNull()

            if (numeroInserito == null) {
                Log.d(TAG, "Numero inserito non valido")
                Toast.makeText(this, "Inserisci un numero valido!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d(TAG, "Numero inserito: $numeroInserito")

            val mioIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("R", mioRandom)
                putExtra("I", numeroInserito)
            }

            Log.d(TAG, "Intent creato con extra - R: $mioRandom, I: $numeroInserito")

            startActivity(mioIntent)
        }
    }
}
