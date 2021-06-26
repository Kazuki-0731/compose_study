package com.example.compose_study.ui.screen.home.replaceable

import com.example.compose_study.ui.screen.home.github.androidview.AndroidViewDemo
import com.example.compose_study.ui.screen.home.github.animation.AnimationDemos
import com.example.compose_study.ui.screen.home.github.foundation.FoundationDemos
import com.example.compose_study.ui.screen.home.github.general.GeneralDemos
import com.example.compose_study.ui.screen.home.github.layout.LayoutDemos
import com.example.compose_study.ui.screen.home.github.material.MaterialDemos
import com.example.compose_study.ui.screen.home.github.other.OtherDemos

/**
 * [ReplaceableViewCategory] containing all the top level demo categories.
 */
val AllRootCategory = ReplaceableViewCategory(
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