package com.example.sakuraproject.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.sakuraproject.R
import com.example.sakuraproject.adapter.CardAdapter
import com.example.sakuraproject.adapter.CardViewHolder
import com.example.sakuraproject.databinding.FragmentLookUpResultBinding
import com.example.sakuraproject.model.CardInfo

class LookUpResultFragment : BaseFragment() {

    private val binding by lazy {
        FragmentLookUpResultBinding.inflate(layoutInflater)
    }

    private val cardInfo by lazy {
        viewModel.cardInfo
    }

    private val cardSearch by lazy {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fun bind(cardInfo: CardInfo){
            binding.searchResultNumber.text = "${cardInfo?.cardNumber}"
            binding.searchResultAnime.text = "${cardInfo?.appeardAnime}"
            binding.searchResultKanji.text = "${cardInfo?.kanji}"
            binding.searchResultManga.text = "${cardInfo?.appeardManga}"
            binding.searchResultRomanji.text = "${cardInfo?.rōmaji}"
            binding.searchResultName.text = "${cardInfo?.englishName}"

            Glide.with(this)
                .load(cardInfo?.sakuraCard)
                .into(binding.searchResultCard)
        }
        viewModel.getOneCard()

    return binding.root
    }

    private fun filteredList(){
    }
}