package com.twitter.data.source.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.twitter.data.model.TweetResponse
import com.twitter.data.source.local.base.AppDatabase
import com.twitter.data.source.local.base.dao.TweetDao
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TweetListReadWriteTest {

    private lateinit var tweetDao: TweetDao
    private lateinit var database : AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        tweetDao = database.tweetDao
    }

    @Test
    @Throws(Exception::class)
    fun testWriteTweetListAndRead() {
        val mockedTweet = mockk<TweetResponse>(relaxed = true)
        val tweetList = mutableListOf(mockedTweet)

        runBlocking {
            tweetDao.insertAll(tweetList)
        }

        runBlocking {
            val loadedTweetList = tweetDao.loadAll()
            assertThat(loadedTweetList?.size, CoreMatchers.equalTo(1))
        }
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }
}