package com.twitter.domain.usecase

import com.twitter.domain.base.SingleUseCase
import com.twitter.domain.model.TweetEntity
import com.twitter.domain.repository.TweetsRepository

class GetTweetsUseCase(private val tweetsRepository: TweetsRepository): SingleUseCase<List<TweetEntity>?, Boolean>() {
    override suspend fun run(params: Boolean?): List<TweetEntity>? {
        return params?.let { tweetsRepository.getTweetList(it) }
    }
}