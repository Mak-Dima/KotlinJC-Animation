package com.example.kotlinjc_animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp

@Composable
fun TransitionAnimation(innerPadding: PaddingValues) {
    var isCircle by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isCircle, label = "transition")


    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        transition.AnimatedContent { targetState ->
            if (targetState) {
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .size(width = 100.dp, height = 100.dp)
                        .border(width = 10.dp, color = Color.Black, shape = CircleShape)
                )
            } else {
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .size(width = 100.dp, height = 100.dp)
                        .border(width = 10.dp, color = Color.Black, shape = RectangleShape)
                )
            }
        }

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
    TransitionAnimation(innerPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp))
}