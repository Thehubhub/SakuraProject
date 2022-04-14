package com.example.sakuraproject.model


import com.google.gson.annotations.SerializedName

data class Cards(
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val `data`: List<CardInfo>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("totalCount")
    val totalCount: Int
)