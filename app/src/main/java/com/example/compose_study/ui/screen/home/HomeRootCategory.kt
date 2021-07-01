package com.example.compose_study.ui.screen.home

import com.example.compose_study.ui.screen.home.jetpack_compose.androidview.AndroidViewSample
import com.example.compose_study.ui.screen.home.jetpack_compose.animation.AnimationSample
import com.example.compose_study.ui.screen.home.jetpack_compose.foundation.FoundationSample
import com.example.compose_study.ui.screen.home.jetpack_compose.general.GeneralSamples
import com.example.compose_study.ui.screen.home.jetpack_compose.layout.LayoutSample
import com.example.compose_study.ui.screen.home.jetpack_compose.material.MaterialSample
import com.example.compose_study.ui.screen.home.jetpack_compose.other.OtherSample
import com.example.compose_study.ui.screen.replaceable.ReplaceableViewCategory

/**
 * [ReplaceableViewCategory] containing all the top level demo categories.
 */
val HomeRootCategory = ReplaceableViewCategory(
    "Jetpack Compose Playground Demos",
    listOf(
        AndroidViewSample,
        AnimationSample,
        FoundationSample,
        LayoutSample,
        MaterialSample,
        GeneralSamples,
        OtherSample
    )
)