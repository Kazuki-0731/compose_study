package com.example.compose_study.ui.screen.home.github.layout


import com.example.compose_study.ui.screen.home.demo.ComposableDemo
import com.example.compose_study.ui.screen.home.demo.DemoCategory


val LayoutDemos = DemoCategory(
    "LayoutDemos",
    listOf(
        ComposableDemo("BoxExample") { BoxExample() },
        ComposableDemo("ConstraintLayoutDemo") { ConstraintLayoutDemo() },

        ComposableDemo("ColumnExample") { ColumnExample() },
        ComposableDemo("RowExample") { RowExample() },
        )
)
