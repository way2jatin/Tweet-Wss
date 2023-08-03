package com.twitter.data.repository

import com.twitter.data.model.TweetResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class TweetsRepositoryImpTest {

    @MockK
    lateinit var tweetsRepository: TweetsRepositoryImp

    @Before
    fun setUp() {
        MockKAnnotations.init(this) //for initialization
    }

    @Test
    fun testOnlineTweetsData() = runBlocking {
        val tweets = mockk<List<TweetResponse>>(relaxed = true)
        coEvery {
            tweetsRepository.getTweetList(true)
        } returns (tweets.map { it.toDomain() })

        val result = tweetsRepository.getTweetList(true)
        MatcherAssert.assertThat(
            "Received result [$result] & mocked [$tweets] must be matches on each other!",
            result,
            CoreMatchers.`is`(tweets)
        )
    }

    @Test
    fun testOfflineTweetsData() = runBlocking {
        val tweets = mockk<List<TweetResponse>>(relaxed = true)
        coEvery {
            tweetsRepository.getTweetList(false)
        } returns (tweets.map { it.toDomain() })

        val result = tweetsRepository.getTweetList(false)
        MatcherAssert.assertThat(
            "Received result [$result] & mocked [$tweets] must be matches on each other!",
            result,
            CoreMatchers.`is`(tweets)
        )
    }
}