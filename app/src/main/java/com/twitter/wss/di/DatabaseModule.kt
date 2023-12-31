package com.twitter.wss.di

import android.content.Context
import androidx.room.Room
import com.twitter.data.source.local.base.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    single { createAppDatabase(get()) }

}

internal fun createAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppDatabase.DB_NAME
    ).build()
}