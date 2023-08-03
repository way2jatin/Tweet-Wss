package com.twitter.data.source.remote

import com.twitter.data.model.TweetResponse
import com.twitter.data.source.remote.base.TweetService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TweetsRemoteDataSourceImpTest {

    private lateinit var remoteDataSource: TweetsRemoteDataSourceImp
    private val mockResult = mockk<List<TweetResponse>>(relaxed = true)
    private val mockApiService: TweetService = mockk()

    @Before
    fun setUp() {
        remoteDataSource = TweetsRemoteDataSourceImp(mockApiService)
    }

    @Test
    fun testGetTweetsRemoteDataSource() {
        val result : List<TweetResponse>?
        coEvery { mockApiService.getTweets() } returns mockResult

        runBlocking {  result = remoteDataSource.getTweets() }

        coVerify { mockApiService.getTweets() }

        Assert.assertEquals(result, mockResult)
    }
}