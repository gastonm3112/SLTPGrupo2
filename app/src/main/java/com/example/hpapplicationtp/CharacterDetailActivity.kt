package com.example.hpapplicationtp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.hpapplicationtp.dtos.Post

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var tvCharacterDetails: TextView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        tvCharacterDetails = findViewById(R.id.tvCharacterDetails)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)


        // Obtener el personaje del intent
        val character = intent.getParcelableExtra<Post>("character")

        character?.let {
            tvCharacterDetails.text = formatCharacterDetails(it)
        }
    }

    private fun formatCharacterDetails(character: Post): String {
        return """
            Name: ${character.name}
            Species: ${character.species}
            Gender: ${character.gender}
            House: ${character.house}
            Date of Birth: ${character.dateOfBirth}
            Year of Birth: ${character.yearOfBirth}
            Wizard: ${character.wizard}
            Ancestry: ${character.ancestry}
            Eye Colour: ${character.eyeColour}
            Hair Colour: ${character.hairColour}
            Wand: ${character.wand?.wood} wood, core: ${character.wand?.core}, length: ${character.wand?.length} inches
            Patronus: ${character.patronus}
            Hogwarts Student: ${character.hogwartsStudent}
            Hogwarts Staff: ${character.hogwartsStaff}
            Actor: ${character.actor}
            Alive: ${character.alive}
        """.trimIndent()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_back, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_volver){
            var intent = Intent(this, ListHpCharacterActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }


}
