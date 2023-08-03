package com.twitter.presentation.tweets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.twitter.presentation.state.AppState

@Composable
fun ThemedText(text: String, style: TextStyle = TextStyle()) {
    Text(
        text = text,
        style = style,
        color = if (AppState.theme.isLight) Color(0xFF111111) else Color(0xFFEEEEEE)
    )
}


@Composable
fun GrayText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            color = if (AppState.theme.isLight) Color(0xFF666666) else Color(0xFFDDDDDD)
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
