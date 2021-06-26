package com.example.compose_study.ui.screen.home.github.androidview

import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory

val AndroidViewDemo = ReplaceableViewCategory(
    "AndroidViewDemo",
    listOf(
        ComposableReplaceableView("AndroidViewDemo") { EmbeddedAndroidViewDemo() }
    )
)
