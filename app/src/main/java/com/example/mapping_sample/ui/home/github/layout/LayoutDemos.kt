package com.example.mapping_sample.ui.home.github.layout


import com.example.mapping_sample.ui.home.demo.ComposableDemo
import com.example.mapping_sample.ui.home.demo.DemoCategory


val LayoutDemos = DemoCategory(
    "LayoutDemos",
    listOf(
        ComposableDemo("BoxExample") { BoxExample() },
        ComposableDemo("ConstraintLayoutDemo") { ConstraintLayoutDemo() },

        ComposableDemo("ColumnExample") { ColumnExample() },
        ComposableDemo("RowExample") { RowExample() },
        )
)
