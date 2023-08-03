package com.twitter.presentation.tweets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.presentation.R
import com.twitter.presentation.state.AppState

@Composable
fun TopBar() {
    Surface(elevation = 2.dp, color = AppState.theme.surface) {
        Row(
            modifier = Modifier.height(50.dp).padding(start = 16.dp, end = 16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painterResource(R.drawable.ic_twitter), modifier = Modifier.size(22.dp), contentDescription = "")
            Image(painterResource(R.drawable.ic_trends), modifier = Modifier.size(24.dp), contentDescription = "")
        }
    }
}

