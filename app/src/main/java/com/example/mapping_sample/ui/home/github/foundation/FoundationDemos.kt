package com.example.mapping_sample.ui.home.github.foundation

import com.example.mapping_sample.ui.home.demo.ComposableDemo
import com.example.mapping_sample.ui.home.demo.DemoCategory
import com.example.mapping_sample.ui.home.github.foundation.basetextfield.BaseTextFieldDemo

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
