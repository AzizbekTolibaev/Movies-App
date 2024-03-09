package com.example.moviesapp.app

import android.app.Application
import com.example.moviesapp.di.appModule
import com.example.moviesapp.di.dataModule
import com.example.moviesapp.di.domainModule
import com.example.moviesapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(networkModule, domainModule, dataModule, appModule))
        }
    }
}
