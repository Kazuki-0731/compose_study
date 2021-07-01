package com.example.compose_study.ui.screen.home.jetpack_compose.foundation

import com.example.compose_study.ui.common.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableViewCategory
import com.example.compose_study.ui.screen.home.jetpack_compose.foundation.basetextfield.BaseTextFieldSample

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
