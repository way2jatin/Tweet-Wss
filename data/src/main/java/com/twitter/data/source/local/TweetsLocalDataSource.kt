package com.twitter.data.source.local

import com.twitter.data.model.TweetResponse

interface TweetsLocalDataSource {

    suspend fun getTweets(): List<TweetResponse>?

    suspend fun insertTweets(list: List<TweetResponse>?)
}