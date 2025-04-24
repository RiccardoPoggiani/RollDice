package com.example.poggiani_rolldice

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    private val TAG = "ThirdActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        Log.d(TAG, "ThirdActivity avviata")

        val numeroEstratto = intent.getIntExtra("R", -1)
        val numeroInserito = intent.getIntExtra("I", -1)

        Log.d(TAG, "Numero estratto ricevuto: $numeroEstratto")
        Log.d(TAG, "Numero inserito dall'utente ricevuto: $numeroInserito")

        val textView = findViewById<TextView>(R.id.textViewActivityThird)

        val imageViewThird = findViewById<ImageView>(R.id.imageViewActivityThird)


        if (numeroEstratto == numeroInserito) {
            textView.text = "Complimenti! \nHai indovinato... \nEra proprio $numeroEstratto"
            Log.d(TAG, "Esito: indovinato")
            imageViewThird.setImageResource(R.drawable.win)
        } else {
            textView.text = "Peccato! \nNon hai indovinato... \nHai scelto $numeroInserito \nma il numero era $numeroEstratto"
            Log.d(TAG, "Esito: non indovinato")
            imageViewThird.setImageResource(R.drawable.lose)
        }
    }
}
