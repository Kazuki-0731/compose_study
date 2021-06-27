package com.example.compose_study.ui.screen.home.replaceable

import com.example.compose_study.ui.screen.home.github.androidview.AndroidViewSample
import com.example.compose_study.ui.screen.home.github.animation.AnimationSample
import com.example.compose_study.ui.screen.home.github.foundation.FoundationSample
import com.example.compose_study.ui.screen.home.github.general.GeneralSamples
import com.example.compose_study.ui.screen.home.github.layout.LayoutSample
import com.example.compose_study.ui.screen.home.github.material.MaterialSample
import com.example.compose_study.ui.screen.home.github.other.OtherSample

/**
 * [ReplaceableViewCategory] containing all the top level demo categories.
 */
val AllRootCategory = ReplaceableViewCategory(
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