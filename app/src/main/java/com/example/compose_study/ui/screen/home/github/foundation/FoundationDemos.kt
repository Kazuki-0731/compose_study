package com.example.compose_study.ui.screen.home.github.foundation

import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.github.foundation.basetextfield.BaseTextFieldDemo

val FoundationDemos = ReplaceableViewCategory(
    "Foundation",
    listOf(
        ComposableReplaceableView("BaseTextFieldDemo") { BaseTextFieldDemo() },
        ComposableReplaceableView("Canvas") { CanvasDrawExample() },
        ComposableReplaceableView("LazyRowDemo") { LazyRowDemo() },
        ComposableReplaceableView("LazyColumnDemo") { LazyColumnDemo() },
        ComposableReplaceableView("TextDemo") { TextExample() },
        ComposableReplaceableView("CircleShapeDemo") { ShapeDemo() },
        ComposableReplaceableView("ImageResourceDemo") { ImageResourceDemo() },

        )
)
