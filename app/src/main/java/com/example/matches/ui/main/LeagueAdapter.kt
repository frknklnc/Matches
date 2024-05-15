package com.example.matches.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.matches.data.model.remote.MatchModel
import com.example.matches.databinding.LeagueLayoutBinding

class LeagueAdapter(private var leagues: Map<String, List<MatchModel>>) :
    RecyclerView.Adapter<LeagueAdapter.ItemViewHolder>() {
    fun updateLeagues(newLeagues: Map<String, List<MatchModel>>) {
        leagues = newLeagues
        notifyDataSetChanged() //TODO: dif util eklenecek
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LeagueLayoutBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val (key, value) = leagues.entries.elementAt(position)
        holder.bind(key, value)
    }

    override fun getItemCount(): Int = leagues.size

    class ItemViewHolder(private val binding: LeagueLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(league: String, matches: List<MatchModel>) {
            with(binding) {
                headerText.text = league
                flagImage.load(matches.firstOrNull()?.leagueFlag)
                val adapter = MatchesAdapter(matches)
                matchesList.adapter = adapter
            }
        }
    }
}