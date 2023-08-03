package com.twitter.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.twitter.presentation.state.AppState
import com.twitter.presentation.tweets.Home
import com.twitter.presentation.tweets.TweetsViewModel
import com.twitter.presentation.util.NetworkState
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: TweetsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isNetworkAvailable = NetworkState.isAvailable(this)
        viewModel.getTweets(isNetworkAvailable)

        setContent {
            MaterialTheme(colors = AppState.theme) {
                AppContent(viewModel)
            }
        }
    }
}

@Composable
fun AppContent(viewModel: TweetsViewModel) {
    Surface(color = MaterialTheme.colors.background) {

        val systemUiController = rememberSystemUiController()

        LaunchedEffect(key1 = true, block = {
            systemUiController.setStatusBarColor(
                color = AppState.theme.surface
            )
        })

        Home(viewModel = viewModel)
    }
}