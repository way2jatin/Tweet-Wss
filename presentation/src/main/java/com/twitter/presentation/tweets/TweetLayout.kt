package com.twitter.presentation.tweets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.android.presentation.R
import com.twitter.presentation.model.Tweet

@Composable
fun TweetLayout(tweet: Tweet) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        UserAvatar(tweet)
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            NameAndUserName(tweet)
            Spacer(modifier = Modifier.size(1.dp))
            TweetAndImage(tweet)
            Spacer(modifier = Modifier.size(10.dp))
            TweetActions(tweet)
        }
    }
}

@Composable
private fun TweetActions(tweet: Tweet) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val imageSize = 18.dp
        Row {
            Image(
                painterResource(R.drawable.ic_comment),
                modifier = Modifier.size(imageSize),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(4.dp))
            GrayText(text = tweet.replies.toString())
        }
        Row {
            Image(
                painterResource(id = R.drawable.ic_retweet),
                modifier = Modifier.size(imageSize),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(4.dp))
            GrayText(text = tweet.retweets.toString())
        }


        Row {
            Image(
                painterResource(R.drawable.ic_like),
                modifier = Modifier.size(imageSize),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(4.dp))
            GrayText(text = tweet.likes.toString())
        }

        Image(
            painterResource(R.drawable.ic_share),
            modifier = Modifier.size(imageSize),
            contentDescription = ""
        )
    }
}

@Composable
private fun TweetAndImage(tweet: Tweet) {
    ThemedText(
        text = tweet.tweet,
        style = TextStyle(fontSize = 14.sp)
    )
}

@Composable
private fun NameAndUserName(tweet: Tweet) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        ThemedText(
            text = tweet.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
        )
        Spacer(modifier = Modifier.size(5.dp))
        GrayText(text = "@${tweet.handle} · ${tweet.timeAgo()}")
    }
}

@ExperimentalCoilApi
@Composable
private fun UserAvatar(tweet: Tweet) {

        Image(
            painter = rememberImagePainter(tweet.image),
            modifier = Modifier
                .size(50.dp)
                .clip(shape = RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
}
