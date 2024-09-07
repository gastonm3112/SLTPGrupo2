package com.example.hpapplicationtp

import android.os.Bundle
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        saludarUsuario()
    }

    private fun saludarUsuario() {
        val bundle: Bundle? = intent.extras

        if (bundle != null){
            val nombreUsuario = bundle?.getString("Nombre")
            Toast.makeText(this, "Bienvenido/a $nombreUsuario", Toast.LENGTH_SHORT).show()
        }
    }
}