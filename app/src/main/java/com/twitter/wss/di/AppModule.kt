package com.twitter.wss.di

import com.twitter.data.repository.TweetsRepositoryImp
import com.twitter.data.source.local.TweetsLocalDataSource
import com.twitter.data.source.local.TweetsLocalDataSourceImp
import com.twitter.data.source.local.base.AppDatabase
import com.twitter.data.source.remote.TweetsRemoteDataSource
import com.twitter.data.source.remote.TweetsRemoteDataSourceImp
import com.twitter.data.source.remote.base.TweetService
import com.twitter.domain.repository.TweetsRepository
import com.twitter.domain.usecase.GetTweetsUseCase
import com.twitter.presentation.tweets.TweetsViewModel
import org.koin.dsl.module

val appModule = module {

    //Repository & Data sources
    single { createTweetsRepository(get(), get()) }

    single { createTweetsRemoteDataSource(get()) }

    single { createTweetsLocalDataSource(get()) }

    single { createGetTweetsUseCase(get()) }

    single { TweetsViewModel(get()) }
}

fun createTweetsRepository(
    tweetsRemoteDataSource: TweetsRemoteDataSource,
    tweetsLocalDataSource: TweetsLocalDataSource
): TweetsRepository {
    return TweetsRepositoryImp(tweetsRemoteDataSource, tweetsLocalDataSource)
}

fun createTweetsRemoteDataSource(tweetService: TweetService): TweetsRemoteDataSource {
    return TweetsRemoteDataSourceImp(tweetService)
}

fun createTweetsLocalDataSource(appDatabase: AppDatabase): TweetsLocalDataSource {
    return TweetsLocalDataSourceImp(appDatabase)
}

fun createGetTweetsUseCase(tweetsRepository: TweetsRepository): GetTweetsUseCase {
    return GetTweetsUseCase(tweetsRepository)
}