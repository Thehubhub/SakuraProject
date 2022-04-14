package com.example.sakuraproject.di

import android.app.Application
import android.content.Context
import androidx.room.Room
//import com.example.sakuraproject.database.CardDao
//import com.example.sakuraproject.database.CardDatabase
//import com.example.sakuraproject.database.DatabaseRepository
//import com.example.sakuraproject.database.DatabaseRepositoryImpl
import com.example.sakuraproject.rest.CardApi
import com.example.sakuraproject.rest.CardRepository
import com.example.sakuraproject.rest.CardRepositoryImpl
import com.example.sakuraproject.viewmodel.CardViewModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    fun providesGson() = Gson()

    fun providesLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

    fun providesCardApi(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(CardApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CardApi::class.java)

    fun providesCardRepository(cardApi: CardApi) : CardRepository =
        CardRepositoryImpl(cardApi)

    single { providesGson() }
    single { providesLoggingInterceptor() }
    single { providesOkHttpClient(get()) }
    single { providesCardApi(get()) }
    single { providesCardRepository(get()) }
}

val viewModelModule = module {

    fun providesDispatcher() : CoroutineDispatcher = Dispatchers.IO

    single { providesDispatcher() }
    viewModel {CardViewModel(get(), get())}
}

