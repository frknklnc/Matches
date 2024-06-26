package com.example.matches.presentation.matchlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.domain.model.Match
import com.example.matches.databinding.ItemLayoutBinding

class MatchesAdapter(
    private val onFavouriteClick: (Match) -> Unit,
    private val onDetailClick: (Match) -> Unit
) :
    ListAdapter<Match, MatchesAdapter.ItemViewHolder>(ItemDifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(match: Match) {
            with(binding) {
                matchStatusTextView.text = match.matchStatus
                homeTeamTextView.text = match.homeTeamName
                awayTeamTextView.text = match.awayTeamName
                scoreTextView.text = "${match.homeTeamScore} - ${match.awayTeamScore}"
                halfScoreTextView.text = "${match.homeTeamHalfScore} - ${match.awayTeamHalfScore}"

                favouriteImageView.isActivated = match.isFavourite

                favouriteImageView.setOnClickListener {
                    onFavouriteClick(match)
                }

                textViewGroup.setOnClickListener {
                    onDetailClick(match)
                }
            }
        }
    }

    class ItemDifUtil : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return  oldItem.hashCode() == newItem.hashCode()
        }
    }
}
