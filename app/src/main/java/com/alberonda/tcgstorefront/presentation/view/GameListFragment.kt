package com.alberonda.tcgstorefront.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.alberonda.tcgstorefront.R
import com.alberonda.tcgstorefront.databinding.FragmentGameListBinding
import com.alberonda.tcgstorefront.presentation.view.adapters.GameAdapter
import com.alberonda.tcgstorefront.presentation.viewmodel.GameListFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GameListFragment : Fragment() {

    private val gameListFragmentViewModel: GameListFragmentViewModel by viewModels()

    private lateinit var binding: FragmentGameListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_list, container, false
        )

        subscribeLoading()

        subscribeSnackbar()

        subscribeAdapter()

        return binding.root
    }

    private fun subscribeLoading(){
        gameListFragmentViewModel.spinner.observe(viewLifecycleOwner) { show ->
            binding.spinner.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun subscribeSnackbar() {
        gameListFragmentViewModel.snackbar.observe(viewLifecycleOwner) { text ->
            text?.let {
                Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
                gameListFragmentViewModel.onSnackbarShown()
            }
        }
    }

    private fun subscribeAdapter() {
        val adapter = GameAdapter(this.requireActivity().applicationContext, emptyList())
        binding.gamesRecycler.adapter = adapter

        gameListFragmentViewModel.games.observe(viewLifecycleOwner) { games ->
            adapter.submitList(games)
        }
    }
}