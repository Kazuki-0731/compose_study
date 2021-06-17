package com.example.compose_study.ui.home.github.animation


import com.example.compose_study.ui.home.demo.ComposableDemo
import com.example.compose_study.ui.home.demo.DemoCategory
import com.example.compose_study.ui.home.github.animation.crossfade.crossfadeColor


val AnimationDemos = DemoCategory(
    "Animation",
    listOf(
        ComposableDemo("CrossfadeDemo") { crossfadeColor() }
    )
)
