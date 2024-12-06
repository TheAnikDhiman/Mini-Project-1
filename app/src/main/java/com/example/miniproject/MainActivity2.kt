package com.example.miniproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val Android=findViewById<CardView>(R.id.android)
        val Web=findViewById<CardView>(R.id.web)
        val C=findViewById<CardView>(R.id.c)
        val Java=findViewById<CardView>(R.id.java)
        val ML=findViewById<CardView>(R.id.ml)
        val Game=findViewById<CardView>(R.id.game)
        val call=findViewById<Button>(R.id.call)

        Android.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://roadmap.sh/android"))
            startActivity(intent)
        }
        Web.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://roadmap.sh/full-stack"))
            startActivity(intent)
        }
        C.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://roadmap.sh/cpp"))
            startActivity(intent)
        }
        Java.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://roadmap.sh/java"))
            startActivity(intent)
        }
        ML.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://roadmap.sh/mlops"))
            startActivity(intent)
        }
        Game.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://roadmap.sh/game-developer"))
            startActivity(intent)
        }
        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:+919650533147"))
            startActivity(intent)
        }
    }
}