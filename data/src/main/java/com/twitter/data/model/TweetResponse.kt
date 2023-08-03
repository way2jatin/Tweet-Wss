package com.twitter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.twitter.domain.model.TweetEntity

@JsonClass(generateAdapter = true)
@Entity
data class TweetResponse(
    @PrimaryKey val id: Int,
    val name: String,
    val handle: String,
    @Json(name = "created_at")
    val createdAt: String,
    val image: String,
    val tweet: String,
    val replies: Int,
    val retweets: Int,
    val impressions: Int,
    val likes: Int
){
    fun toDomain(): TweetEntity =
        TweetEntity(
            id = id,
            name = name,
            handle = handle,
            createdAt = createdAt,
            image = image,
            tweet = tweet,
            replies = replies,
            retweets = retweets,
            impressions = impressions,
            likes = likes
        )
}
