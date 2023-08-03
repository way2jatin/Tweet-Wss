package com.twitter.data.model

import junit.framework.Assert
import org.junit.Test

class TweetResponseTest {

    /**
     *     "id": 1,
     *     "name": "Adam Smith",
     *     "handle": "adam_tweets",
     *     "created_at": "2023-08-03 10:00:00",
     *     "image": "https://images.freeimages.com/images/small-previews/313/dog-1-1358174.jpg",
     *     "tweet": "This is my 1st tweet. Stay tuned",
     *     "replies": 5,
     *     "retweets": 3,
     *     "impressions": 50,
     *     "likes": 20
     *
     */

    private val tweetResponse = TweetResponse(
        id = 1,
        name = "Adam Smith",
        handle = "adam_tweets",
        createdAt = "2023-08-03 10:00:00",
        image = "",
        tweet = "",
        replies = 5,
        retweets = 3,
        impressions = 50,
        likes = 20
    )

    @Test
    fun testTweetId() {
        val tweetResponseCopy = tweetResponse.copy(id = 7)
        Assert.assertEquals(7, tweetResponseCopy.id)
    }


    @Test
    fun testToDomain() {
        val tweetEntity = tweetResponse.toDomain()
        Assert.assertEquals(tweetResponse.id, tweetEntity.id)

    }
}