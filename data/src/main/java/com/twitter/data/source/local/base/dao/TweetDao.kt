package com.twitter.data.source.local.base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.twitter.data.model.TweetResponse

@Dao
interface TweetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<TweetResponse>?)

    @Query("SELECT * FROM TweetResponse")
    suspend fun loadAll(): List<TweetResponse>?
}