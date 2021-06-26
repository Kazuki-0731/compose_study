package com.example.compose_study.ui.screen.home.github.animation


import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.github.animation.crossfade.crossfadeColor


val AnimationDemos = ReplaceableViewCategory(
    "Animation",
    listOf(
        ComposableReplaceableView("CrossfadeDemo") { crossfadeColor() }
    )
)
