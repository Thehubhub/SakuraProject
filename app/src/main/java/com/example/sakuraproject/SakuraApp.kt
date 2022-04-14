package com.example.sakuraproject

import android.app.Application
//import com.example.sakuraproject.di.applicationModule
import com.example.sakuraproject.di.networkModule
import com.example.sakuraproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SakuraApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SakuraApp)
            modules(networkModule, viewModelModule)
        }
    }
}