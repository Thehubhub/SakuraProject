package com.example.sakuraproject.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CardInfo(
    @SerializedName("appeardAnime")
    val appeardAnime: String,
    @SerializedName("appeardManga")
    val appeardManga: String,
    @SerializedName("cardNumber")
    val cardNumber: Int,
    @SerializedName("clowCard")
    val clowCard: String,
    @PrimaryKey
    @SerializedName("englishName")
    val englishName: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("kanji")
    val kanji: String,
    @SerializedName("meaning")
    val meaning: String,
    @SerializedName("Rōmaji")
    val rōmaji: String,
    @SerializedName("sakuraCard")
    val sakuraCard: String,
    @SerializedName("spanishName")
    val spanishName: String,
    @SerializedName("__v")
    val v: Int,
    @SerializedName("clowReverse")
    val clowReverse: String,
    @SerializedName("sakuraReverse")
    val sakuraReverse: String
)