package com.example.hpapplicationtp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hpapplicationtp.dtos.Post

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var tvCharacterDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        tvCharacterDetails = findViewById(R.id.tvCharacterDetails)

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
}
