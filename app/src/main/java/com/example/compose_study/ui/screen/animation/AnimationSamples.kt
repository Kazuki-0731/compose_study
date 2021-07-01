package com.example.compose_study.ui.screen.animation

import com.example.compose_study.ui.screen.animation.samples.DotLoading
import com.example.compose_study.ui.common.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableViewCategory

val AnimationSamples = ReplaceableViewCategory(
    "AnimationSamples",
    listOf(
        ComposableReplaceableView("DotLoadingSample") { DotLoading() }
    )
)
