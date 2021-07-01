package com.example.compose_study.ui.screen.home.jetpack_compose.other


import com.example.compose_study.ui.screen.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.replaceable.ReplaceableViewCategory


val OtherSample = ReplaceableViewCategory(
    "Other",
    listOf(
        ComposableReplaceableView("TextFieldSample") { TextFieldSample() },
        )
)
