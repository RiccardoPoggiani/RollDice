package com.example.poggiani_rolldice

import android.content.Intent
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

            var toast = Toast.makeText(this, "LANCIO DEL DADO", Toast.LENGTH_LONG)
            //Toast è un messaggio di testo temporaneo. 4 parametri: contesto, testo, posizione, tempo di visualizzazione
            //posizione di defoult in basso (non dichiarata)

            toast.show()

            var mioIntent : Intent = Intent(this, SecondActivity:: class.java,)
            //Intent usato per passare da un'activity all'altra

            var mioRandom = (1..6).random()
            //genera numero causale tra 1 e 6

            mioIntent.putExtra("MESSAGGE", "Numero estratto: $mioRandom")
            //passare alla seconda activity alcune informazioni

            startActivity(mioIntent)

            mioIntent.putExtra("RANDOM", mioRandom)

            startActivity(mioIntent)
            //lancio dell'intent
        })
    }
}