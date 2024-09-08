package com.example.hpapplicationtp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    // Inicio las variables
    lateinit var etUsuario: EditText
    lateinit var etPassword: EditText
    lateinit var cbRecordarUsuario: CheckBox
    lateinit var btnRegistar: Button
    lateinit var btnIniciarSesion: Button
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Tooolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)

        // Variables tomadas desde el id de activity_login.xml
        etUsuario = findViewById(R.id.etUsuario)
        etPassword = findViewById(R.id.etpassword)
        cbRecordarUsuario = findViewById(R.id.cbRecordarUsuario)
        btnRegistar = findViewById(R.id.btnRegistrar)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)

        // Funcionalidad Boton registrarse
        btnRegistar.setOnClickListener {
            // Toast.makeText(this, "TODO - Crear Usuario", Toast.LENGTH_SHORT).show()
            val intent =  Intent(this, TermsAndConditionsActivity::class.java)
            startActivity(intent)
        }

        // Funcionalidad Boton Iniciar Sesion
        btnIniciarSesion.setOnClickListener {
            var usuario = etUsuario.text.toString()
            var password = etPassword.text.toString()

            if(usuario.isEmpty() || password.isEmpty()){
                var mensaje = "Por favor, completar datos"
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            } else {
                if(cbRecordarUsuario.isChecked) {
                    Log.i("TODO", "Funcionalidad Recordar usuario y contraseña")
                }

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Nombre", usuario)
                startActivity(intent)
                finish()
            }

        }
    }
}