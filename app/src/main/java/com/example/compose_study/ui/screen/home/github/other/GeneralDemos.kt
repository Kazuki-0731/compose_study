package com.example.compose_study.ui.screen.home.github.other


import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory


val OtherDemos = ReplaceableViewCategory(
    "Other",
    listOf(
        ComposableReplaceableView("TextFieldDemo") { TextFieldDemo() },
        )
)
