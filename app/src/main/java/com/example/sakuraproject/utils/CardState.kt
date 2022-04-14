package com.example.sakuraproject.utils

sealed class CardState {
    object LOADING: CardState()
    class SUCCESS<T>(val cards: T): CardState()
    class ERROR(val throwable: Throwable): CardState()
}