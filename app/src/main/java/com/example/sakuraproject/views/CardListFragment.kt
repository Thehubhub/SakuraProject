package com.example.sakuraproject.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sakuraproject.databinding.FragmentCardListBinding
import com.example.sakuraproject.model.CardInfo
import com.example.sakuraproject.utils.CardState

class CardListFragment : BaseFragment() {

    private val binding by lazy {
        FragmentCardListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        binding.recycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false)
            adapter = cardAdapter
        }


        viewModel.card.observe(viewLifecycleOwner){ state ->
            when(state){
                is CardState.LOADING -> {
                    Toast.makeText(requireContext(), "LOADING...", Toast.LENGTH_SHORT).show()
                }
                is CardState.SUCCESS<*> -> {
                    val cards = state.cards as List<CardInfo>
                    cardAdapter.updateCards(cards)
                }
                is CardState.ERROR -> {
                    Toast.makeText(requireContext(),state.throwable.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
            viewModel.getOneCard()
        }
        return binding.root
    }

}