package com.twitter.data.source.remote

import com.twitter.data.model.TweetResponse
import com.twitter.data.source.remote.base.TweetService

class TweetsRemoteDataSourceImp(private val tweetService: TweetService): TweetsRemoteDataSource {
    override suspend fun getTweets(): List<TweetResponse> {
        return tweetService.getTweets()
    }
}