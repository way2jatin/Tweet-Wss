package com.twitter.presentation.tweets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twitter.domain.base.UseCaseResponse
import com.twitter.domain.model.TweetEntity
import com.twitter.domain.usecase.GetTweetsUseCase
import com.twitter.presentation.base.BaseViewModel
import com.twitter.presentation.model.Tweet
import com.twitter.presentation.model.toUI

class TweetsViewModel(private val getTweetsUseCase: GetTweetsUseCase): BaseViewModel() {

    var tweetsData = MutableLiveData<List<Tweet>>()
        private set

    fun getTweets(isNetworkAvailable : Boolean) {
        showLoadingProgressBar()
        getTweetsUseCase.invoke(viewModelScope, isNetworkAvailable, object :
            UseCaseResponse<List<TweetEntity>?> {
            override fun onSuccess(result: List<TweetEntity>?) {
                hideLoadingProgressBar()
                tweetsData.value = result?.map {
                    it.toUI()
                }
            }

            override fun onError(throwable: Throwable) {
                hideLoadingProgressBar()
            }
        })
    }
}