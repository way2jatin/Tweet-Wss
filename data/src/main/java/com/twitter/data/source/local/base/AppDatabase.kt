package com.twitter.data.source.local.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.twitter.data.model.TweetResponse
import com.twitter.data.source.local.base.AppDatabase.Companion.DB_VERSION
import com.twitter.data.source.local.base.dao.TweetDao

/**
 * To manage data items that can be accessed and updated
 * & also maintain relationships between them
 *
 */
@Database(entities = [TweetResponse::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val tweetDao : TweetDao

    companion object {
        const val DB_NAME = "TweetWss.db"
        const val DB_VERSION = 1
    }
}