package com.example.kotlinjc_animation

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun AnimateUpdateTransition(innerPadding: PaddingValues) {

    var counter by remember { mutableIntStateOf(0) }
    val transition = updateTransition(targetState = counter, label = "Icon State")
    val iconScale by transition.animateFloat(label = "Icon Scale") { state ->
        if (state % 2 == 0) 2f else 4f
    }
    val iconColor by transition.animateColor(label = "Icon Color") { state ->
        if (state % 2 == 0) Color.Red else Color.Blue
    }

    val rotation by transition.animateFloat(
        transitionSpec = {
            keyframes {
                durationMillis = 800
                (-45f) at 300 using EaseInOut
            }
        },
        label = "shake rotation"
    ) { _ -> 0f }

    val offsetX by transition.animateFloat(
        transitionSpec = {
            keyframes {
                durationMillis = 800
                30f at 300 using EaseInOut
            }
        },
        label = "shake offset X",
    ) { _ -> 0f }

    val offsetY by transition.animateFloat(
        transitionSpec = {
            keyframes {
                durationMillis = 800
                (-40f) at 300 using EaseInOut
            }
        },
        label = "shake offset Y",
    ) { _ -> 0f }

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
                .scale(iconScale)
                .rotate(rotation)
                .background(iconColor, shape = CircleShape)
                .graphicsLayer {
                    this.translationY = offsetY
                    this.translationX = offsetX
                }
                .clickable(
                    interactionSource = null,
                    indication = null,
                    onClick = { counter++ }
                )
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
