package com.example.mapping_sample.ui.home.github.other


import com.example.mapping_sample.ui.home.demo.ComposableDemo
import com.example.mapping_sample.ui.home.demo.DemoCategory


val OtherDemos = DemoCategory(
    "Other",
    listOf(
        ComposableDemo("TextFieldDemo") { TextFieldDemo() },
        )
)
