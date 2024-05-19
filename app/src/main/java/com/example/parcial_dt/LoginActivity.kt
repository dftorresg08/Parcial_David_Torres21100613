package com.example.parcial_dt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etEmail: EditText = findViewById(R.id.etUser)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnSigin: Button = findViewById(R.id.btnLogin)

        btnSigin.setOnClickListener{
            val email: String = etEmail.text.toString()
            val pwd: String = etPassword.text.toString()

            if(email == "admin" && pwd == "123456")
            {
                val intent = Intent (this, MenuActivity:: class.java)
                startActivity(intent)

            }else{
                Toast.makeText( this,
                    "Credenciales inválidas", Toast.LENGTH_LONG).show()
            }

        }
    }
}