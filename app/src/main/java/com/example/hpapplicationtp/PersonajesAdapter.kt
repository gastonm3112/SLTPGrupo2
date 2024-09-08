package com.example.hpapplicationtp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonajesAdapter( var personajes: MutableList<Personaje>, var context: Context):
    RecyclerView.Adapter<PersonajesAdapter.PersonajeViewHolder>() {


        class PersonajeViewHolder(view: View): RecyclerView.ViewHolder(view){
             val tvNombre: TextView
            val tvalternate_names: TextView
            val tvspecies: TextView
            val tvgender: TextView
            val tvhouse: TextView
            val tvDateOfBirth: TextView
            val tvYearOfBirth: TextView
             val tvWizard: TextView
             val tvAncestry: TextView
             val tvEyeColour: TextView
             val tvHairColour: TextView
             val tvWand: TextView
             val tvPatronus: TextView
             val tvHogwartsStaff: TextView
             val tvActor: TextView
             val tvAlternate_Actors: TextView
             val tvAlive: TextView
            val tvImage: TextView

            init {
                tvNombre = view.findViewById(R.id.hp_name)
                tvalternate_names = view.findViewById(R.id.alternate_names)
                tvspecies = view.findViewById(R.id.species)
                tvgender = view.findViewById(R.id.gender)
                tvhouse = view.findViewById(R.id.house)
                tvDateOfBirth = view.findViewById(R.id.dateOfBirth)
                tvYearOfBirth = view.findViewById(R.id.yearOfBirth)
                tvWizard = view.findViewById(R.id.wizard)
                tvAncestry = view.findViewById(R.id.ancestry)
                tvEyeColour = view.findViewById(R.id.eyeColour)
                tvHairColour = view.findViewById(R.id.hairColour)
                tvWand = view.findViewById(R.id.wand)
                tvPatronus = view.findViewById(R.id.patronus)
                tvHogwartsStaff = view.findViewById(R.id.hogwartsStaff)
                tvActor = view.findViewById(R.id.actor)
                tvAlternate_Actors = view.findViewById(R.id.alternate_actors)
                tvAlive =  view.findViewById(R.id.alive)
                tvImage =  view.findViewById(R.id.imag)

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personaje,parent, false)
        return PersonajeViewHolder(view)
    }

    override fun getItemCount() = personajes.size

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int){
        val item = personajes.get(position)

        holder.tvNombre.text = item.name
        holder.tvalternate_names.text = item.alternate_names
        holder.tvspecies.text = item.species
        holder.tvgender.text = item.gender
        holder.tvhouse.text = item.house
        holder.tvDateOfBirth.text = item.dateOfBirth
        holder.tvYearOfBirth.text = item.yearOfBirth
        holder.tvWizard.text = item.wizard.toString()
        holder.tvAncestry.text = item.ancestry
        holder.tvEyeColour.text = item.eyeColour
        holder.tvHairColour.text = item.hairColour
        holder.tvWand.text = item.wand
        holder.tvPatronus.text = item.patronus
        holder.tvHogwartsStaff.text = item.hogwartsStaff.toString()
        holder.tvActor.text = item.actor
        holder.tvAlternate_Actors.text = item.alternate_actors
        holder.tvAlive.text =  item.alive.toString()
        holder.tvImage.text =  item.imag
    }




}
