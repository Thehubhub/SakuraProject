package com.example.sakuraproject.rest

import com.example.sakuraproject.model.Cards
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CardApi {

    @GET("$CARD_LIST")
    suspend fun getOneCard(
        @Query("name") cardName: String? = null,
        @Query("cardNumber") cardNumber: String? = null,
        @Query("kanji") kanji: String? = null,
        @Query("animeAppear") animeAppear: String? = null,
        @Query("mangaAppear") mangaAppear: String? = null,
        @Query("romanji") romanji: String? = null,
        @Query("sakuraFront") sakuraFront : String? = null
    ): Response<Cards>

    companion object{
        const val BASE_URL = "https://protected-taiga-89091.herokuapp.com/"
//        const val BASE_URL = "https://protected-taiga-89091.herokuapp.com/api/card"
        private const val CARD_LIST = BASE_URL + "api/card"
    }
}