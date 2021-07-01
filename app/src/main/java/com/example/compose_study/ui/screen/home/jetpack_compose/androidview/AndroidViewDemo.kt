package com.example.compose_study.ui.screen.home.jetpack_compose.androidview

import com.example.compose_study.ui.common.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableViewCategory

val AndroidViewSample = ReplaceableViewCategory(
    "AndroidView",
    listOf(
        ComposableReplaceableView("AndroidView") { EmbeddedAndroidViewDemo() }
    )
)
