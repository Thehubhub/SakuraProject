package com.example.sakuraproject.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.sakuraproject.R

fun navigate(supportFragmentManager: FragmentManager, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.recycler, fragment)
        .addToBackStack(fragment.id.toString())
        .commit()
}