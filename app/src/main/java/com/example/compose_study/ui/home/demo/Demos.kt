package com.example.compose_study.ui.home.demo

import com.example.compose_study.ui.home.github.androidview.AndroidViewDemo
import com.example.compose_study.ui.home.github.animation.AnimationDemos
import com.example.compose_study.ui.home.github.foundation.FoundationDemos
import com.example.compose_study.ui.home.github.general.GeneralDemos
import com.example.compose_study.ui.home.github.layout.LayoutDemos
import com.example.compose_study.ui.home.github.material.MaterialDemos
import com.example.compose_study.ui.home.github.other.OtherDemos

/**
 * [DemoCategory] containing all the top level demo categories.
 */
val AllRootCategory = DemoCategory(
    "Jetpack Compose Playground Demos",
    listOf(
        AndroidViewDemo,
        AnimationDemos,
        FoundationDemos,
        LayoutDemos,
        MaterialDemos,
        GeneralDemos,
        OtherDemos
    )
)