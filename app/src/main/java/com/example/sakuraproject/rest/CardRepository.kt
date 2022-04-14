package com.example.sakuraproject.rest

import com.example.sakuraproject.model.Cards
import io.reactivex.Single
import retrofit2.Response

interface CardRepository {
    suspend fun getOneCard(
        cardName: String? = null,
        cardNumber: String? = null,
        kanji: String? = null,
        animeAppear: String? = null,
        mangaAppear: String? = null,
        romanji: String? = null,
        sakuraFront: String? = null
    ): Response<Cards>
}

class CardRepositoryImpl(
    private val cardApi: CardApi
): CardRepository{
    override suspend fun getOneCard(
        cardName: String?,
        cardNumber: String?,
        kanji: String?,
        animeAppear: String?,
        mangaAppear: String?,
        romanji: String?,
        sakuraFront: String?
    ): Response<Cards> {
        return cardApi.getOneCard(
            cardName,
            cardNumber,
            kanji,
            animeAppear,
            mangaAppear,
            romanji,
            sakuraFront
        )
    }
}