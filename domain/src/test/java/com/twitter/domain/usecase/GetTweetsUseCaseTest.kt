package com.twitter.domain.usecase

import com.twitter.domain.model.TweetEntity
import com.twitter.domain.repository.TweetsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetTweetsUseCaseTest {

    private lateinit var usecase: GetTweetsUseCase
    private val mockRepository: TweetsRepository = mockk()
    private val mockResult = mockk<List<TweetEntity>>(relaxed = true)

    @Before
    fun setUp() {
        usecase = GetTweetsUseCase(mockRepository)
    }

    @Test
    fun testGetOnlineTweetsUseCase() {
        val result: List<TweetEntity>?

        coEvery {
            mockRepository.getTweetList(true)
        } returns (mockResult)

        runBlocking { result = usecase.run(true) }

        coVerify { mockRepository.getTweetList(true) }
        Assert.assertEquals(result, mockResult)
    }


    @Test
    fun testGetOfflineTweetsUseCase() {
        val result: List<TweetEntity>?

        coEvery {
            mockRepository.getTweetList(false)
        } returns (mockResult)

        runBlocking { result = usecase.run(false) }

        coVerify { mockRepository.getTweetList(false) }
        Assert.assertEquals(result, mockResult)
    }
}