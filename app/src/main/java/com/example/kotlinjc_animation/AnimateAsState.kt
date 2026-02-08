package com.example.kotlinjc_animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun AnimateAsState(innerPadding: PaddingValues) {
    var isCircle by remember { mutableStateOf(false) }
    val cornerRadius by animateFloatAsState(
        targetValue = if(isCircle) 200f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "cornerRadius"
    )
    val offset by animateIntOffsetAsState(
       targetValue = if(isCircle) IntOffset(0 ,-500) else IntOffset(0, 0),
        animationSpec = tween(durationMillis = 1000),
        label = "offset"
    )

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .offset { offset }
                .padding(20.dp)
                .size(width = 100.dp, height = 100.dp)
                .border(width = 10.dp, color = Color.Black, shape = RoundedCornerShape(cornerRadius))
        )

        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = { isCircle = !isCircle }
        ) {
            Text("Toggle")
        }

    }
}

@PreviewScreenSizes
@Composable
fun AnimationComposablePreview() {
    AnimateAsState(innerPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp))
}