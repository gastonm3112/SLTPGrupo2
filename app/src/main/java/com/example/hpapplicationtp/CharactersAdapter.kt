package com.example.hpapplicationtp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hpapplicationtp.dtos.Post

class CharactersAdapter(
    private var characters: List<Post>,
    private val onCharacterClick: (Post) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    fun updateCharacters(newCharacters: List<Post>) {
        characters = newCharacters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
        holder.itemView.setOnClickListener {
            onCharacterClick(character)
        }
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tvCharacterName)
        private val speciesTextView: TextView = itemView.findViewById(R.id.tvCharacterSpecies)

        fun bind(character: Post) {
            nameTextView.text = character.name
            speciesTextView.text = character.species
        }
    }
}