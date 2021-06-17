package com.example.compose_study.ui.home.github.other


import com.example.compose_study.ui.home.demo.ComposableDemo
import com.example.compose_study.ui.home.demo.DemoCategory


val OtherDemos = DemoCategory(
    "Other",
    listOf(
        ComposableDemo("TextFieldDemo") { TextFieldDemo() },
        )
)
