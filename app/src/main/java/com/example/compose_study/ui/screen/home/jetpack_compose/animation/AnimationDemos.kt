package com.example.compose_study.ui.screen.home.jetpack_compose.animation


import com.example.compose_study.ui.screen.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.jetpack_compose.animation.crossfade.crossfadeColor


val AnimationSample = ReplaceableViewCategory(
    "Animation",
    listOf(
        ComposableReplaceableView("Crossfade") { crossfadeColor() }
    )
)
