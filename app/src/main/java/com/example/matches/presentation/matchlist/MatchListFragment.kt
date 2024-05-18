package com.example.matches.presentation.matchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.matches.databinding.FragmentMatchListBinding
import com.example.matches.domain.model.Match
import com.example.matches.presentation.matchlist.adapter.LeagueAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchListFragment : Fragment() {

    private val viewModel: MatchListViewModel by viewModels()
    private lateinit var adapter: LeagueAdapter
    private lateinit var binding: FragmentMatchListBinding

    private val navController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LeagueAdapter(
            leagues = emptyMap(),
            onFavouriteClick = { match ->
                if (match.isFavourite) {
                    viewModel.removeFavourite(match.matchId)
                } else {
                    viewModel.addFavourite(match.matchId)
                }
            },
            onDetailClick = { matchData ->
                navToDetail(matchData)
            }
        )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = null

        viewModel.matchesLiveData.observe(viewLifecycleOwner) {
            adapter.updateLeagues(it)
        }
    }

    private fun navToDetail(matchData: Match) {
        val action =
            MatchListFragmentDirections.actionMatchListFragmentToMatchDetailFragment(matchData)
        navController.navigate(action)
    }
}