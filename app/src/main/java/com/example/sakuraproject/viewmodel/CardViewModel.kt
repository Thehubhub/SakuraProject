package com.example.sakuraproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sakuraproject.model.CardInfo
import com.example.sakuraproject.rest.CardRepository
import com.example.sakuraproject.utils.CardState
import kotlinx.coroutines.*
import okhttp3.Dispatcher

class CardViewModel(
    private val cardRepository: CardRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val coroutineScope: CoroutineScope = CoroutineScope(SupervisorJob() + ioDispatcher)
): CoroutineScope by coroutineScope, ViewModel(){

    private val _card: MutableLiveData<CardState> = MutableLiveData(CardState.LOADING)
    val card: LiveData<CardState> get() = _card
    var cardInfo: CardInfo? = null

    fun getOneCard(
        cardName: String? = null,
        cardNumber: String? = null,
        kanji: String? = null,
        animeAppear: String? = null,
        mangaAppear: String? = null,
        romanji: String? = null,
        sakuraFront: String? =null
    ){
        _card.postValue(CardState.LOADING)
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = cardRepository.getOneCard(cardName, cardNumber, kanji, animeAppear, mangaAppear, romanji, sakuraFront)
                if (response.isSuccessful){
                    response.body()?.let {
                        _card.postValue(CardState.SUCCESS(it.data))
                    }?: throw Exception("No response")
                }else{
                    throw Exception("Unsuccessful Response")
                }
            }catch (e: Exception){
                _card.postValue(CardState.ERROR(e))
            }
        }
    }
}