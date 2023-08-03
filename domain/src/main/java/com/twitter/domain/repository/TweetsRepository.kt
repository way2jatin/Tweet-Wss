package com.twitter.domain.repository

import com.twitter.domain.model.TweetEntity

interface TweetsRepository {

    suspend fun getTweetList(networkAvailability : Boolean) : List<TweetEntity>?

}