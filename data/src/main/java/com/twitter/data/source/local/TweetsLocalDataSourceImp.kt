package com.twitter.data.source.local

import com.twitter.data.model.TweetResponse
import com.twitter.data.source.local.base.AppDatabase

class TweetsLocalDataSourceImp(private val appDatabase: AppDatabase): TweetsLocalDataSource {
    override suspend fun getTweets(): List<TweetResponse>? {
        return appDatabase.tweetDao.loadAll()
    }

    override suspend fun insertTweets(list: List<TweetResponse>?) {
        return appDatabase.tweetDao.insertAll(list)
    }
}