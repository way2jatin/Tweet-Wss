package com.twitter.data.source.remote

import com.twitter.data.model.TweetResponse

interface TweetsRemoteDataSource {

    suspend fun getTweets() : List<TweetResponse>
}