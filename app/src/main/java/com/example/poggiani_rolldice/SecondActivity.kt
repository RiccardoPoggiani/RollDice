package com.example.poggiani_rolldice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private val TAG = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        Log.d(TAG, "SecondActivity avviata")

        val random = intent.getIntExtra("R", -1)
        val numeroInserito = intent.getIntExtra("I", -1)

        Log.d(TAG, "Numero estratto dal dado (random): $random")
        Log.d(TAG, "Numero inserito dall'utente: $numeroInserito")

        val textView = findViewById<TextView>(R.id.TextViewActivitySecond)
        textView.text = "Numero estratto: $random"

        val imageViewSecond = findViewById<ImageView>(R.id.imageViewActivitySecond)

        val resource = when (random) {
            1 -> R.drawable.dice_face_1
            2 -> R.drawable.dice_face_2
            3 -> R.drawable.dice_face_3
            4 -> R.drawable.dice_face_4
            5 -> R.drawable.dice_face_5
            6 -> R.drawable.dice_face_6
            else -> R.drawable.dices
        }

        Log.d(TAG, "Risorsa immagine associata al numero: $resource")
        imageViewSecond.setImageResource(resource)
        Log.d(TAG, "FINITO DISEGNO DADO")

        val buttonVer = findViewById<Button>(R.id.buttonVerify)

        buttonVer.setOnClickListener {
            Log.d(TAG, "Bottone verifica premuto")
            Toast.makeText(this, "VERIFICA ESITO ESTRAZIONE", Toast.LENGTH_LONG).show()

            val intentS = Intent(this, ThirdActivity::class.java).apply {
                putExtra("R", random)
                putExtra("I", numeroInserito)
            }

            Log.d(TAG, "Intent per ThirdActivity creato con R: $random, I: $numeroInserito")
            startActivity(intentS)
        }
    }
}
