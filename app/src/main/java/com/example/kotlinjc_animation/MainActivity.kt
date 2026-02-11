package com.example.kotlinjc_animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.kotlinjc_animation.ui.theme.KotlinJCAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinJCAnimationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    AnimateAsState(innerPadding = innerPadding)
                    AnimateUpdateTransition(innerPadding)
                }
            }
        }
    }
}