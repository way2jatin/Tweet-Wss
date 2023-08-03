package com.twitter.presentation.model

import com.twitter.domain.model.TweetEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Tweet(
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
) {
    fun timeAgo(): String {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = format.parse(createdAt)
        val currentTime = Date().time
        val timeDiff = currentTime - date.time
        if (timeDiff >= (1000 * 60 * 60 * 24)) {
            // Days
            return "${timeDiff / (1000 * 60 * 60 * 24)}d";
        } else if (timeDiff >= (1000 * 60 * 60)) {
            // Hours
            return "${timeDiff / (1000 * 60 * 60)}h";
        } else if (timeDiff >= (1000 * 60)) {
            // Minutes
            return "${timeDiff / (1000 * 60)}m";
        } else if (timeDiff >= 1000) {
            // Seconds
            return "${timeDiff / 1000}s";
        }
        return "0s";
    }
}

fun TweetEntity.toUI() : Tweet = Tweet(
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
