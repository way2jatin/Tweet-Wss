package com.twitter.data.source.local

import com.twitter.data.model.TweetResponse
import com.twitter.data.source.local.base.AppDatabase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TweetsLocalDataSourceImpTest {

    private lateinit var localDataSource: TweetsLocalDataSourceImp
    private val mockResult = mockk<List<TweetResponse>>(relaxed = true)
    private val mockDatabase : AppDatabase = mockk()

    @Before
    fun setUp() {
        localDataSource = TweetsLocalDataSourceImp(mockDatabase)
    }

    @Test
    fun testGetTweetsLocalDataSource() {
        val result : List<TweetResponse>?
        coEvery {  mockDatabase.tweetDao.loadAll() } returns mockResult

        runBlocking {  result = localDataSource.getTweets() }

        coVerify { mockDatabase.tweetDao.loadAll()  }

        Assert.assertEquals(result, mockResult)
    }
}