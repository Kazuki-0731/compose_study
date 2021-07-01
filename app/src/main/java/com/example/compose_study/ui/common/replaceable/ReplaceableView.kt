package com.example.compose_study.ui.common.replaceable

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

/**
 * Generic demo with a [title] that will be displayed in the list of demos.
 */
sealed class ReplaceableView(val title: String) {
    override fun toString() = title
}

/**
 * Demo that launches an [Activity] when selected.
 *
 * This should only be used for demos that need to customize the activity, the large majority of
 * demos should just use [ComposableReplaceableView] instead.
 *
 * @property activityClass the KClass (Foo::class) of the activity that will be launched when
 * this demo is selected.
 */
class ActivityReplaceableView<T : ComponentActivity>(title: String, val activityClass: KClass<T>) : ReplaceableView(title)

/**
 * Demo that displays [Composable] [content] when selected.
 * Demoクラスを継承したComposableを格納するクラス
 */
class ComposableReplaceableView(title: String, val content: @Composable () -> Unit) : ReplaceableView(title)

/**
 * A category of [ReplaceableView]s, that will display a list of [replaceableViews] when selected.
 */
class ReplaceableViewCategory(title: String, val replaceableViews: List<ReplaceableView>) : ReplaceableView(title)

/**
 * Flattened recursive DFS [List] of every demo in [this].
 */
fun ReplaceableViewCategory.allDemos(): List<ReplaceableView> {
    val allDemos = mutableListOf<ReplaceableView>()
    fun ReplaceableViewCategory.addAllDemos() {
        replaceableViews.forEach { demo ->
            allDemos += demo
            if (demo is ReplaceableViewCategory) {
                demo.addAllDemos()
            }
        }
    }
    addAllDemos()
    return allDemos
}

/**
 * Flattened recursive DFS [List] of every launchable demo in [this].
 */
fun ReplaceableViewCategory.allLaunchableReplaceables(): List<ReplaceableView> {
    return allDemos().filter { it !is ReplaceableViewCategory }
}
