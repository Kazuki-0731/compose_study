package com.example.compose_study.ui.screen.home.github.other


import com.example.compose_study.ui.screen.home.demo.ComposableDemo
import com.example.compose_study.ui.screen.home.demo.DemoCategory


val OtherDemos = DemoCategory(
    "Other",
    listOf(
        ComposableDemo("TextFieldDemo") { TextFieldDemo() },
        )
)
