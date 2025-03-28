package com.example.poggiani_rolldice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var buttonRoll : Button = findViewById(R.id.buttonRoll)

        buttonRoll.setOnClickListener(View.OnClickListener{

            var toast = Toast.makeText(this, "LANCIO DEI DADI", Toast.LENGTH_LONG)
            //Toast è un messaggio di testo temporaneo. 4 parametri: contesto, testo, posizione, tempo di visualizzazione
            //posizione di defoult in basso (non dichiarata)

            toast.show()
        })
    }
}