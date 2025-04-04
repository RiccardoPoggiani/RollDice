package com.example.poggiani_rolldice

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        var msg = intent.getStringExtra("MESSAGGE")
        //Ricavo il messaggio nell'Intent e lo inserisco nella variabile

        val textView = findViewById<TextView>(R.id.TextViewActivitySecond)
        //ricavo l'elemento textView dove inserire il risultato

        textView.text = msg;
        //Inserisco il messaggio memorizzato con l'intent nella textView
    }
}