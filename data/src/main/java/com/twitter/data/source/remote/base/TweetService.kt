package com.twitter.data.source.remote.base

import com.twitter.data.model.TweetResponse
import retrofit2.http.GET

interface TweetService {
    @GET("67469cdb-5c3c-46d1-874c-9498d6a48101")
    suspend fun getTweets(): List<TweetResponse>
}