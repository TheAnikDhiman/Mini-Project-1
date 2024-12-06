package com.example.miniproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity5 : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1= "com.example.database.SignIn.id"
        const val KEY2= "com.example.database.SignIn.mail"
        const val KEY3= "com.example.database.SignIn.name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        val signinButton = findViewById<Button>(R.id.btnsignin)
        val usernameID=findViewById<TextInputEditText>(R.id.usernameID)
//        val username=findViewById<TextInputEditText>(R.id.username)
        signinButton.setOnClickListener {
            val uniqueId=usernameID.text.toString()
            if (uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this,"Please enter the username",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId: String) {
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            if (it.exists()) {
                val name = it.child("name").value
                val email = it.child("email").value
                val id = it.child("id").value
                val intentWelcome = Intent(this, MainActivity::class.java)
                intentWelcome.putExtra(KEY3,name.toString())
                intentWelcome.putExtra(KEY2,email.toString())
                intentWelcome.putExtra(KEY1,id.toString())
                startActivity(intentWelcome)
            }else{
                Toast.makeText(this,"User Does not exist please first sign up!!",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this,"Failed!!,Error On our Side!!",Toast.LENGTH_SHORT).show()
        }
    }
}