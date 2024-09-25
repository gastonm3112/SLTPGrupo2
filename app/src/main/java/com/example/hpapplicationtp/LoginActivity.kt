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

        // Creamos la variable preferencias, donde su contenido seran string
        // siendo estos una forma local de guardar usuario y contrasenia, si no existe la crea
        var preferencias = getSharedPreferences(resources.getString(R.string.sp_credenciales),
            MODE_PRIVATE)

        // traemos el dato usuario y clave en variables propias
        var usuarioGuardado = preferencias.getString(resources.getString(R.string.nombre_usuario),"")
        var passwordGuardado = preferencias.getString(resources.getString(R.string.password_usuario),"")

        // Validamos para evitar inconvenientes, que no sean vacios y nunca nulos dichas variables
        if(usuarioGuardado != "" && passwordGuardado!= "" ){
            if(usuarioGuardado != null){
                startMainActivity(usuarioGuardado)
            }
        }


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
                    var preferencias = getSharedPreferences(resources.getString(R.string.sp_credenciales), MODE_PRIVATE)
                    preferencias.edit().putString(resources.getString(R.string.nombre_usuario),usuario).apply()
                    preferencias.edit().putString(resources.getString(R.string.password_usuario),password).apply()
                }
                // Reducimos codigo creando la funcion startMainActivity
                startMainActivity(usuario)

            }

        }
    }

    // implementamos la funcion de iniciar la activity pricipal
    private fun startMainActivity(usuario: String){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra(resources.getString(R.string.nombre_usuario),usuario)
        startActivity(intent)
        finish() // no queda en memoria la activty login, al ir atras, sale de la activity
    }
}