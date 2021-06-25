package com.example.compose_study.ui.screen.home.github.animation


import com.example.compose_study.ui.screen.home.demo.ComposableDemo
import com.example.compose_study.ui.screen.home.demo.DemoCategory
import com.example.compose_study.ui.screen.home.github.animation.crossfade.crossfadeColor


val AnimationDemos = DemoCategory(
    "Animation",
    listOf(
        ComposableDemo("CrossfadeDemo") { crossfadeColor() }
    )
)
