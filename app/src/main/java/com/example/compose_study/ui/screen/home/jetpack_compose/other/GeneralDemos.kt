package com.example.compose_study.ui.screen.home.jetpack_compose.other


import com.example.compose_study.ui.common.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableViewCategory


val OtherSample = ReplaceableViewCategory(
    "Other",
    listOf(
        ComposableReplaceableView("TextFieldSample") { TextFieldSample() },
        )
)
