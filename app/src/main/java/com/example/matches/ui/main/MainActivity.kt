package com.example.matches.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matches.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: LeagueAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = LeagueAdapter(emptyMap()) { match ->
            if (match.isFavourite){
                viewModel.removeFavourite(match.matchId)
            }else{
                viewModel.addFavourite(match.matchId)
            }
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = null
        binding.swipe.setOnRefreshListener {
            viewModel.getMatches()
        }

        viewModel.matchesLiveData.observe(this) {
            adapter.updateLeagues(it)
            binding.swipe.isRefreshing = false
        }
    }
}
