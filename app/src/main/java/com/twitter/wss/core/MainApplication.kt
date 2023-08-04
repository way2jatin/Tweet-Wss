package com.twitter.wss.core

import android.app.Application
import com.twitter.wss.di.appModule
import com.twitter.wss.di.databaseModule
import com.twitter.wss.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(listOf(
                appModule, networkModule,
                databaseModule
            ))
        }
    }
}