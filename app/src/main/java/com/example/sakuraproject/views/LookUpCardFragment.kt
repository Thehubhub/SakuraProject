package com.example.sakuraproject.views

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.sakuraproject.MainActivity
import com.example.sakuraproject.R
import com.example.sakuraproject.adapter.CardAdapter
import com.example.sakuraproject.databinding.FragmentLookUpCardBinding
import com.example.sakuraproject.model.CardInfo
import com.example.sakuraproject.utils.CardState
import com.example.sakuraproject.utils.navigate

class LookUpCardFragment : BaseFragment() {

    private val binding by lazy {
        FragmentLookUpCardBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding.searchButton.setOnClickListener {
            val cardSearch = binding.enterSearch.text.trim()
            if (cardSearch.isNotEmpty() && cardSearch.length > 1){
                viewModel.getOneCard(cardName = String().lowercase())

                findNavController().navigate(R.id.cardLookUpResultFragment)
            }
            else{
                AlertDialog.Builder(requireContext())
                    .setMessage("Please enter a name.")
                    .setPositiveButton("OK"){
                            dialog, _ -> dialog.cancel()
                    }
                    .show()
            }
        }

        viewModel.card.observe(viewLifecycleOwner){ state ->
            when (state) {
                is CardState.LOADING -> {
                    Toast.makeText(requireContext(), "LOADING...", Toast.LENGTH_LONG).show()
                }
                is CardState.SUCCESS<*> -> {
                    val cards = state.cards as List<CardInfo>
                    cardAdapter.updateCards(cards)
                }
                is CardState.ERROR ->{
                    Toast.makeText(requireContext(),state.throwable.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
        return binding.root
    }

}