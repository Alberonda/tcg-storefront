package com.alberonda.tcgstorefront.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.alberonda.tcgstorefront.R
import com.alberonda.tcgstorefront.databinding.FragmentMainBinding
import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.view.adapters.GameAdapter
import com.alberonda.tcgstorefront.viewmodel.MainFragmentViewModel
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainFragmentViewModel: MainFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        mainFragmentViewModel.games.value?.let {
            createAdapter(it)
        }
    }

    }

    private fun createAdapter(games: List<Game>) {
        val recyclerView = binding.gamesRecycler

        recyclerView.adapter = GameAdapter(requireContext(), games)
    }
}