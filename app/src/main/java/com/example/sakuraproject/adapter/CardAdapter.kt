package com.example.sakuraproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sakuraproject.R
import com.example.sakuraproject.databinding.FragmentLookUpResultBinding
import com.example.sakuraproject.model.CardInfo
import com.example.sakuraproject.rest.CardApi

class CardAdapter(
    private val cards: MutableList<CardInfo> = mutableListOf(),
    private val onCardClicked: (CardInfo) -> Unit
): RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = FragmentLookUpResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return CardViewHolder(view, onCardClicked)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.bind(card)
    }

    override fun getItemCount(): Int = cards.size

    fun updateCards(newCards: List<CardInfo>){
        cards.clear()
        cards.addAll(newCards)
        notifyDataSetChanged()
    }
}

class CardViewHolder(
    private val binding: FragmentLookUpResultBinding,
    private val onCardClicked: (CardInfo) -> Unit
): RecyclerView.ViewHolder(binding.root){

    fun bind(card: CardInfo){
        binding.searchResultName.text = card.englishName
        binding.searchResultNumber.text = card.cardNumber.toString()
        binding.searchResultKanji.text = card.kanji
        binding.searchResultAnime.text = card.appeardAnime
        binding.searchResultManga.text = card.appeardManga
        binding.searchResultRomanji.text = card.rōmaji


        Glide.with(itemView)
            .load(CardApi.BASE_URL + card.sakuraCard)
            .placeholder(R.drawable.ic_baseline_error_1)
            .dontAnimate()
            .into(binding.searchResultCard)
    }
}