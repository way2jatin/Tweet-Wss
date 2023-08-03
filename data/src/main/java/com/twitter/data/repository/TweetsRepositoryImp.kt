package com.twitter.data.repository

import com.twitter.data.source.local.TweetsLocalDataSource
import com.twitter.data.source.remote.TweetsRemoteDataSource
import com.twitter.domain.model.TweetEntity
import com.twitter.domain.repository.TweetsRepository

class TweetsRepositoryImp constructor(
    private val tweetsRemoteDataSource: TweetsRemoteDataSource,
    private val tweetsLocalDataSource: TweetsLocalDataSource
): TweetsRepository {
    override suspend fun getTweetList(networkAvailability: Boolean): List<TweetEntity>? {
        if (networkAvailability) {
            tweetsRemoteDataSource.getTweets().also {
                tweetsLocalDataSource.insertTweets(it)
                return it.map { tweetResponse ->
                    tweetResponse.toDomain()
                }
            }

        } else return tweetsLocalDataSource.getTweets()?.map {
            it.toDomain()
        }
    }
}