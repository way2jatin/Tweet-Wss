package com.twitter.domain.model

data class TweetEntity(
    val id: Int,
    val name: String,
    val handle: String,
    val createdAt: String,
    val image: String,
    val tweet: String,
    val replies: Int,
    val retweets: Int,
    val impressions: Int,
    val likes: Int
)
