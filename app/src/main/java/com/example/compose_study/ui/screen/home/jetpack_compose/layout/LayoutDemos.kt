package com.example.compose_study.ui.screen.home.jetpack_compose.layout


import com.example.compose_study.ui.screen.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.replaceable.ReplaceableViewCategory


val LayoutSample = ReplaceableViewCategory(
    "LayoutSamples",
    listOf(
        ComposableReplaceableView("BoxSample") { BoxSample() },
        ComposableReplaceableView("ConstraintLayoutSample") { ConstraintLayoutSample() },

        ComposableReplaceableView("ColumnSample") { ColumnSample() },
        ComposableReplaceableView("RowSample") { RowSample() },
        )
)
