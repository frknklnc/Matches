package com.example.matches.presentation.matchdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.matches.databinding.FragmentMatchDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchDetailFragment : Fragment() {

    private val viewModel: MatchDetailViewModel by viewModels()
    private lateinit var binding: FragmentMatchDetailBinding
    private val args: MatchDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMatchDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val matchDetail = args.matchData

        viewModel.initializeFavouriteState(matchDetail?.isFavourite ?: false)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.favouriteState.collectLatest {
                    binding.matchLayout.favouriteImageView.isActivated = it
                }
            }
        }

        with(binding.matchLayout) {
            matchDetail?.let { match ->
                matchStatusTextView.text = match.matchStatus
                homeTeamTextView.text = match.homeTeamName
                awayTeamTextView.text = match.awayTeamName
                scoreTextView.text = "${match.homeTeamScore} - ${match.awayTeamScore}"
                halfScoreTextView.text = "${match.homeTeamHalfScore} - ${match.awayTeamHalfScore}"

                favouriteImageView.setOnClickListener {
                    if (viewModel.favouriteState.value) {
                        viewModel.removeFavourite(matchDetail.matchId)
                    } else {
                        viewModel.addFavourite(matchDetail.matchId)
                    }
                }
            }
        }
    }
}