package com.example.compose_study.ui.screen.home.github.foundation

import com.example.compose_study.ui.screen.home.demo.ComposableDemo
import com.example.compose_study.ui.screen.home.demo.DemoCategory
import com.example.compose_study.ui.screen.home.github.foundation.basetextfield.BaseTextFieldDemo

val FoundationDemos = DemoCategory(
    "Foundation",
    listOf(
        ComposableDemo("BaseTextFieldDemo") { BaseTextFieldDemo() },
        ComposableDemo("Canvas") { CanvasDrawExample() },
        ComposableDemo("LazyRowDemo") { LazyRowDemo() },
        ComposableDemo("LazyColumnDemo") { LazyColumnDemo() },
        ComposableDemo("TextDemo") { TextExample() },
        ComposableDemo("CircleShapeDemo") { ShapeDemo() },
        ComposableDemo("ImageResourceDemo") { ImageResourceDemo() },

        )
)
