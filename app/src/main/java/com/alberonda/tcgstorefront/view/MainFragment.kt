package com.alberonda.tcgstorefront.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.alberonda.tcgstorefront.R
import com.alberonda.tcgstorefront.databinding.FragmentMainBinding
import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.view.adapters.GameAdapter

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

        val games = listOf(Game("Magic"), Game("Digimon"))

        createAdapter(games)

        return binding.root
    }

    private fun createAdapter(games: List<Game>) {
        val recyclerView = binding.gamesRecycler

        recyclerView.adapter = GameAdapter(requireContext(), games)
    }
}