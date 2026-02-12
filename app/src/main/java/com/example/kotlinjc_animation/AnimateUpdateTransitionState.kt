package com.example.kotlinjc_animation

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class AnimateUpdateTransitionState(initialCounter: Int = 0) {
    var counter by mutableIntStateOf(initialCounter)
        private set

    fun incrementCounter() {
        counter++
    }
}

@Composable
fun rememberAnimateUpdateTransitionState(initialCounter: Int = 0): AnimateUpdateTransitionState {
    return remember {
        AnimateUpdateTransitionState(initialCounter)
    }
}

@Immutable
data class AnimateUpdateTransitionValues(
    val iconScale: Float,
    val iconColor: Color,
    val rotation: Float,
    val offsetX: Float,
    val offsetY: Float
)

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun animateTransitionAsState(counter: Int): AnimateUpdateTransitionValues {
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

    return AnimateUpdateTransitionValues(
        iconScale = iconScale,
        iconColor = iconColor,
        rotation = rotation,
        offsetX = offsetX,
        offsetY = offsetY
    )
}
