package com.example.matches.presentation.matchdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.matches.databinding.FragmentMatchDetailBinding

class MatchDetailFragment : Fragment() {

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

        with(binding) {
            homeTeamTextView.text = matchDetail?.homeTeamName
            awayTeamTextView.text = matchDetail?.awayTeamName
            scoreTextView.text = "${matchDetail?.homeTeamScore} - ${matchDetail?.awayTeamScore}"
        }
    }
}