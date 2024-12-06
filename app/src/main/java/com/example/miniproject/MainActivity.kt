package com.example.miniproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miniproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            intent= Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            intent= Intent(applicationContext,MainActivity4::class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            intent= Intent(applicationContext,MainActivity5::class.java)
            startActivity(intent)

        }
    }
}