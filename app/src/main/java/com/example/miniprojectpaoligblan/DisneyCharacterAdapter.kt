
package com.example.miniprojectpaoligblan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.miniprojectpaoligblan.model.DisneyCharacter
import com.example.miniprojectpaoligblan.R

class DisneyCharacterAdapter(private val characters: List<DisneyCharacter>) :
    RecyclerView.Adapter<DisneyCharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageViewCharacter: ImageView = itemView.findViewById(R.id.imageViewCharacter)
        val textViewCharacterName: TextView = itemView.findViewById(R.id.textViewCharacterName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.disney_characters, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]

        Glide.with(holder.itemView)
            .load(character.imageUrl)
            .into(holder.imageViewCharacter)

        holder.textViewCharacterName.text = character.name
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}
