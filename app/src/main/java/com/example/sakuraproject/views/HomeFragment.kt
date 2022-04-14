package com.example.sakuraproject.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sakuraproject.R
import com.example.sakuraproject.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.showList.setOnClickListener {
            findNavController().navigate(R.id.cardListFragment)
        }

        binding.searchForCard.setOnClickListener {
            findNavController().navigate(R.id.cardLookUpFragment)
        }

        binding.seeItFlip.setOnClickListener {
            findNavController().navigate(R.id.cardFlipFragment)
        }
        return binding.root
    }

    override fun onStop() {
        super.onStop()

        viewModel.card.removeObservers(viewLifecycleOwner)
    }

}