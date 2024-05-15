package com.example.matches.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.data.model.remote.MatchModel
import com.example.matches.databinding.ItemLayoutBinding

class MatchesAdapter(private var matches: List<MatchModel>) :
    RecyclerView.Adapter<MatchesAdapter.ItemViewHolder>() {
    fun updateMatches(newMatches: List<MatchModel>) {
        matches = newMatches
        notifyDataSetChanged() //TODO: dif util eklenecek
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(matches[position])

    }

    override fun getItemCount(): Int = matches.size

    class ItemViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(match: MatchModel) {
            with(binding) {
                matchStatusTextView.text = match.matchStatus
                homeTeamTextView.text = match.homeTeamName
                awayTeamTextView.text = match.awayTeamName
                scoreTextView.text = "${match.homeTeamScore} - ${match.awayTeamScore}"
                halfScoreTextView.text = "${match.homeTeamHalfScore} - ${match.awayTeamHalfScore}"
            }
        }
    }
}
