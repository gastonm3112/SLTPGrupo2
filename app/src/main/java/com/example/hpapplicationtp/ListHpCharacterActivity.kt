package com.example.hpapplicationtp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class ListHpCharacterActivity : AppCompatActivity() {

    lateinit var rvPersonajes: RecyclerView
    lateinit var personajesAdapter: PersonajesAdapter
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_hp_character)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)

        rvPersonajes = findViewById(R.id.rcPersonajes)
        personajesAdapter = PersonajesAdapter(getPersonajes(),this)
        rvPersonajes.adapter = personajesAdapter
    }

    private fun getPersonajes(): MutableList<Personaje>{
        var personajes: MutableList<Personaje> = ArrayList()
        personajes.add(Personaje(1,"Harry Potter","the Boy Who Liver", "human", "male","Gryffindor","31-07-1980","1980","true","half-blood","green","black", "wood holly phoenix tail","stag","true","Daniel Radcliffe","xx","true","foto"))
        personajes.add(Personaje(2,"Hermione Granger","Hermy", "human", "female","Gryffindor","19-09-1979","1979","true","muggleborn","brown","brown", "vine dragon heartstring","otter","false","Emma Watson","xxx","true","foto"))
        personajes.add(Personaje(3,"Draco Malfoy","vacio", "human", "male","Slytherin","05-06-1980","1980","true","pure-blood","grey","blonde", "hawthron unicorn tail hair","vacio","false","Tom Felton","vacio","true","foto"))
        return personajes
    }
}