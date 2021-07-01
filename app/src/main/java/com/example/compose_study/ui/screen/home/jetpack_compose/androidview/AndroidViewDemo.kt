package com.example.compose_study.ui.screen.home.jetpack_compose.androidview

import com.example.compose_study.ui.screen.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.replaceable.ReplaceableViewCategory

val AndroidViewSample = ReplaceableViewCategory(
    "AndroidView",
    listOf(
        ComposableReplaceableView("AndroidView") { EmbeddedAndroidViewDemo() }
    )
)
