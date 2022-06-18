package com.alberonda.tcgstorefront.view.adapters

import android.R.attr.data
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alberonda.tcgstorefront.R
import com.alberonda.tcgstorefront.model.data.Game


class GameAdapter(
    private val context: Context,
    private var dataset: List<Game>
): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_layout, parent, false)

        return GameViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = dataset[position]

        holder.gameNameView.text = item.name
    }

    override fun getItemCount() = dataset.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(games: List<Game>){
        dataset = games
        notifyDataSetChanged()
    }

    class GameViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val gameNameView: TextView = view.findViewById(R.id.game_name_text)
    }
}