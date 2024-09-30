package com.example.hpapplicationtp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrarUsuarioActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var etCrearUsuario: EditText
    lateinit var etEmail: EditText
    lateinit var etCrearPassword: EditText
    lateinit var etCrearPasswordRepetido: EditText
    lateinit var btnCrearUsuario: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrar_usuario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Tooolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)

        etCrearUsuario = findViewById(R.id.etCrearUsuario)
        etEmail = findViewById(R.id.etEmail)
        etCrearPassword = findViewById(R.id.etCrearPassword)
        etCrearPasswordRepetido = findViewById(R.id.etCrearPasswordRepetido)
        btnCrearUsuario = findViewById(R.id.btnCrearUsuario)

        btnCrearUsuario.setOnClickListener {
            val nombreUsuario = etCrearUsuario.text.toString()
            val passwordUsuario = etCrearPassword.text.toString()
            val passwordUsuarioRepetido = etCrearPasswordRepetido.text.toString()
            val mailUsuario = etEmail.text.toString()

            if (nombreUsuario.isEmpty() || passwordUsuario.isEmpty() || mailUsuario.isEmpty() || passwordUsuarioRepetido.isEmpty()) {
                Toast.makeText(this, "Completa todos los datos", Toast.LENGTH_SHORT).show()
            } else {
                if (passwordUsuario != passwordUsuarioRepetido) {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                } else {
                    val newUser = Usuario(nombreUsuario, passwordUsuario, mailUsuario)
                    AppDatabase.getDatabase(this).usuarioDao().insertUsuario(newUser)
                    Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

    }
}
