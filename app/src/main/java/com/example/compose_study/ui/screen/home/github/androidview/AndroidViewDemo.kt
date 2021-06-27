package com.example.compose_study.ui.screen.home.github.androidview

import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory

val AndroidViewSample = ReplaceableViewCategory(
    "AndroidView",
    listOf(
        ComposableReplaceableView("AndroidView") { EmbeddedAndroidViewDemo() }
    )
)
