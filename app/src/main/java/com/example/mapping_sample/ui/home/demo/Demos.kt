package com.example.mapping_sample.ui.home.demo

import com.example.mapping_sample.ui.home.github.animation.AnimationDemos
import com.example.mapping_sample.ui.home.github.foundation.FoundationDemos
import com.example.mapping_sample.ui.home.github.general.GeneralDemos
import com.example.mapping_sample.ui.home.github.layout.LayoutDemos
import com.example.mapping_sample.ui.home.github.material.MaterialDemos
import com.example.mapping_sample.ui.home.github.other.OtherDemos


/**
 * [DemoCategory] containing all the top level demo categories.
 */
val AllDemosCategory = DemoCategory(
    "Jetpack Compose Playground Demos",
    listOf(
        AnimationDemos,
        FoundationDemos,
        LayoutDemos,
        MaterialDemos,
        GeneralDemos,
        OtherDemos
    )
)