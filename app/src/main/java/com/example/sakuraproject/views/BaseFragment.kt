package com.example.sakuraproject.views

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sakuraproject.R
import com.example.sakuraproject.adapter.CardAdapter
import com.example.sakuraproject.viewmodel.CardViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open class BaseFragment: Fragment(){

    protected val viewModel: CardViewModel by sharedViewModel()

    protected val cardAdapter by lazy {
        CardAdapter(onCardClicked = {
            viewModel.cardInfo = it
            findNavController().navigate(R.id.cardFlipFragment)
        })
    }
}