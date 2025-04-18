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

        var imageViewSecond = findViewById<ImageView>(R.id.imageViewActivitySecond)

        val random = intent.getIntExtra("RANDOM", -1)

        var resource = when (random){
            1 -> R.drawable.dice_face_1
            2 -> R.drawable.dice_face_2
            3 -> R.drawable.dice_face_3
            4 -> R.drawable.dice_face_4
            5 -> R.drawable.dice_face_5
            6 -> R.drawable.dice_face_6
            else -> R.drawable.dices
        }

        imageViewSecond.setImageResource(resource)
        Log.d("SECOND", "FINITO DISEGNO DADO")

        var buttonVer : Button = findViewById(R.id.buttonVerify)

        buttonVer.setOnClickListener(View.OnClickListener{
            var toast_s = Toast.makeText(this, "VERIFICA ESITO ESTRAZIONE", Toast.LENGTH_LONG)
            toast_s.show()
            var Intent_s : Intent = Intent(this, ThirdActivity:: class.java,)
            Intent_s.putExtra("R", random)
            startActivity(Intent_s)
        })
    }
}