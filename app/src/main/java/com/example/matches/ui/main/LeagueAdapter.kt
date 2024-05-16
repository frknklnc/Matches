package com.example.matches.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.matches.data.model.remote.MatchModel
import com.example.matches.databinding.LeagueLayoutBinding

class LeagueAdapter(
    private var leagues: Map<String, List<MatchModel>>,
    private val onFavouriteClick: (MatchModel) -> Unit
) :
    RecyclerView.Adapter<LeagueAdapter.ItemViewHolder>() {
    fun updateLeagues(newLeagues: Map<String, List<MatchModel>>) {
        val diffUtil = ItemDiffUtil(oldItems = leagues, newItems = newLeagues)
        val result = DiffUtil.calculateDiff(diffUtil)
        leagues = newLeagues
        result.dispatchUpdatesTo(this)
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

    inner class ItemViewHolder(private val binding: LeagueLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(league: String, matches: List<MatchModel>) {
            with(binding) {
                headerText.text = league
                flagImage.load(matches.firstOrNull()?.leagueFlag)
                val adapter = MatchesAdapter(onFavouriteClick)
                adapter.submitList(matches)
                matchesList.adapter = adapter
            }
        }
    }

    class ItemDiffUtil(
        val oldItems: Map<String, List<MatchModel>>,
        val newItems: Map<String, List<MatchModel>>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldItems.size
        }

        override fun getNewListSize(): Int {
            return newItems.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems.entries.elementAt(oldItemPosition)
            val newItem = newItems.entries.elementAt(newItemPosition)

            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems.entries.elementAt(oldItemPosition)
            val newItem = newItems.entries.elementAt(newItemPosition)

            return oldItem.value.hashCode() == newItem.value.hashCode()
        }
    }
}