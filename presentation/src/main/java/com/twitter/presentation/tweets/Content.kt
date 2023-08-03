package com.twitter.presentation.tweets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.twitter.presentation.model.Tweet

@Composable
fun Content(tweetsLiveData: MutableLiveData<List<Tweet>>) {
    val tweets: List<Tweet> by tweetsLiveData.observeAsState(emptyList())
    Column(modifier = Modifier.padding(bottom = 54.dp)) {
        LazyColumn {
            tweets.forEach { tweet ->
                item{
                    TweetLayout(tweet)
                    CustomDivider()
                }
            }
        }
    }
}

