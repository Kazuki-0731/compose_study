package com.example.compose_study.ui.screen.home.github.foundation

import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.github.foundation.basetextfield.BaseTextFieldSample

val FoundationSample = ReplaceableViewCategory(
    "Foundation",
    listOf(
        ComposableReplaceableView("BaseTextFieldSample") { BaseTextFieldSample() },
        ComposableReplaceableView("Canvas") { CanvasDraw() },
        ComposableReplaceableView("LazyRowSample") { LazyRowSample() },
        ComposableReplaceableView("LazyColumnSample") { LazyColumnSample() },
        ComposableReplaceableView("TextSample") { TextSample() },
        ComposableReplaceableView("CircleShapeSample") { ShapeSample() },
        ComposableReplaceableView("ImageResourceSample") { ImageResourceSample() },

        )
)
