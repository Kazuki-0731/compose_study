package com.example.mapping_sample.ui.home.github.animation


import com.example.mapping_sample.ui.home.demo.ComposableDemo
import com.example.mapping_sample.ui.home.demo.DemoCategory
import com.example.mapping_sample.ui.home.github.animation.crossfade.crossfadeColor


val AnimationDemos = DemoCategory(
    "Animation",
    listOf(
        ComposableDemo("CrossfadeDemo") { crossfadeColor() }
    )
)
