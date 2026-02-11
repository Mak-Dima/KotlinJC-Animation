package com.example.kotlinjc_animation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimateUpdateTransition(innerPadding: PaddingValues) {

    var counter by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.ThumbUp,
            contentDescription = "Thumb Up",
            modifier = Modifier
                .scale(3f)
                .clickable { counter++ }
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = "$counter",
            fontSize = 30.sp
        )
    }
}

@PreviewScreenSizes
@Composable
fun AnimationUpdateTransitionPreview() {
    val innerPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp)
    AnimateUpdateTransition(innerPadding = innerPadding)
}