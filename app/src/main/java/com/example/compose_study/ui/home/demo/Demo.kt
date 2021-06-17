package com.example.compose_study.ui.home.demo

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

/**
 * Generic demo with a [title] that will be displayed in the list of demos.
 */
sealed class Demo(val title: String) {
    override fun toString() = title
}

/**
 * Demo that launches an [Activity] when selected.
 *
 * This should only be used for demos that need to customize the activity, the large majority of
 * demos should just use [ComposableDemo] instead.
 *
 * @property activityClass the KClass (Foo::class) of the activity that will be launched when
 * this demo is selected.
 */
class ActivityDemo<T : ComponentActivity>(title: String, val activityClass: KClass<T>) : Demo(title)

/**
 * Demo that displays [Composable] [content] when selected.
 * Demoクラスを継承したComposableを格納するクラス
 */
class ComposableDemo(title: String, val content: @Composable () -> Unit) : Demo(title)

/**
 * A category of [Demo]s, that will display a list of [demos] when selected.
 */
class DemoCategory(title: String, val demos: List<Demo>) : Demo(title)

/**
 * Flattened recursive DFS [List] of every demo in [this].
 */
fun DemoCategory.allDemos(): List<Demo> {
    val allDemos = mutableListOf<Demo>()
    fun DemoCategory.addAllDemos() {
        demos.forEach { demo ->
            allDemos += demo
            if (demo is DemoCategory) {
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
fun DemoCategory.allLaunchableDemos(): List<Demo> {
    return allDemos().filter { it !is DemoCategory }
}
