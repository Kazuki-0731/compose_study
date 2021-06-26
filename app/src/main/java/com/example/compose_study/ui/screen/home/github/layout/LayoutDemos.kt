package com.example.compose_study.ui.screen.home.github.layout


import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory


val LayoutDemos = ReplaceableViewCategory(
    "LayoutDemos",
    listOf(
        ComposableReplaceableView("BoxExample") { BoxExample() },
        ComposableReplaceableView("ConstraintLayoutDemo") { ConstraintLayoutDemo() },

        ComposableReplaceableView("ColumnExample") { ColumnExample() },
        ComposableReplaceableView("RowExample") { RowExample() },
        )
)
