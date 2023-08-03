package com.twitter.presentation.tweets

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun Home(viewModel: TweetsViewModel) {
    Scaffold(
        topBar = {
            TopBar()
        },
        content = { _ ->
            Content(viewModel.tweetsData)
        },
        bottomBar = {
            BottomBar()
        }
    )
}
