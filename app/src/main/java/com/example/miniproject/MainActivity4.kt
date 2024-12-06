package com.example.miniproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.databinding.ActivityMain4Binding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)
//        val signupButton = findViewById<Button>(R.id.btnsignup)
//        val nameEditText = findViewById<TextInputEditText>(R.id.etname)
//        val emailEditText = findViewById<TextInputEditText>(R.id.etmail)
//        val passwordEditText = findViewById<TextInputEditText>(R.id.etpassword)
//        val idEditText = findViewById<TextInputEditText>(R.id.etID)
//        val signIn =findViewById<TextView>(R.id.TVSignIn)
        binding.btnsignup.setOnClickListener {
            val openSignInIntent=Intent(this,MainActivity5::class.java)
            startActivity(openSignInIntent)
            binding.btnsignup.setOnClickListener {
                val name = binding.etname.text.toString()
                val email= binding.etmail.text.toString()
                val password = binding.etpassword.text.toString()
                val id = binding.etID.text.toString()

                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(id).setValue(User(name,email,password,id)).addOnSuccessListener {
                    Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
                }
                binding.etname.text?.clear()
                binding.etmail.text?.clear()
                binding.etpassword.text?.clear()
                binding.etID.text?.clear()
            }
            binding.TVSign.setOnClickListener {
                intent=Intent(this,MainActivity5::class.java)
                startActivity(intent)
            }
        }
    }
}