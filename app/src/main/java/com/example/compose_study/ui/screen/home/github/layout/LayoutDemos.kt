package com.example.compose_study.ui.screen.home.github.layout


import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory


val LayoutSample = ReplaceableViewCategory(
    "LayoutSamples",
    listOf(
        ComposableReplaceableView("BoxSample") { BoxSample() },
        ComposableReplaceableView("ConstraintLayoutSample") { ConstraintLayoutSample() },

        ComposableReplaceableView("ColumnSample") { ColumnSample() },
        ComposableReplaceableView("RowSample") { RowSample() },
        )
)
