package com.example.sakuraproject.views

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.animation.doOnEnd
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.sakuraproject.R
import com.example.sakuraproject.adapter.CardAdapter
import com.example.sakuraproject.databinding.CardflipFrontandbackBinding
import com.example.sakuraproject.model.CardInfo
import com.example.sakuraproject.utils.CardState
import java.lang.Exception

class CardFlipFragment : BaseFragment() {

    private val binding by lazy {
        CardflipFrontandbackBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
        }
        return binding.root
    }

    fun flipCard(
        context: Context,
        visibleView: View,
        inVisibleView: View){
        try {
            visibleView.isVisible
            val scale = context.resources.displayMetrics.density
            val cameraDist = 8000 * scale
            visibleView.cameraDistance = cameraDist
            inVisibleView.cameraDistance = cameraDist

            val flipOutAnimatorSet = AnimatorInflater.loadAnimator(
                context, R.animator.card_flip_out
            ) as AnimatorSet
            flipOutAnimatorSet.setTarget(inVisibleView)
            val flipInAnimatorSet = AnimatorInflater.loadAnimator(
                context, R.animator.card_flip_in
            ) as AnimatorSet
            flipInAnimatorSet.setTarget(visibleView)

            flipOutAnimatorSet.start()
            flipInAnimatorSet.start()
            flipInAnimatorSet.doOnEnd {
                inVisibleView.isGone
            }
        } catch (e: Exception){
        }
    }
}
