package com.example.compose_study.ui.common

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue
import com.example.compose_study.ui.common.replaceable.ActivityReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableViewCategory

/**
 * Activityを継承したカスタムクラスを保存
 */
class Navigator private constructor(
    private val backDispatcher: OnBackPressedDispatcher,
    private val launchActivityReplaceable: (ActivityReplaceableView<*>) -> Unit,
    private val rootReplaceableView: ReplaceableView,
    initialReplaceableView: ReplaceableView,
    private val backStack: MutableList<ReplaceableView>
) {
    constructor(
        rootReplaceableView: ReplaceableView,
        backDispatcher: OnBackPressedDispatcher,
        launchActivityReplaceable: (ActivityReplaceableView<*>) -> Unit
    ) : this(backDispatcher, launchActivityReplaceable, rootReplaceableView, rootReplaceableView, mutableListOf<ReplaceableView>())

    private val onBackPressed = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            popBackStack()
        }
    }.apply {
        isEnabled = !isRoot
        backDispatcher.addCallback(this)
    }

    private var _currentReplaceable by mutableStateOf(initialReplaceableView)
    var currentReplaceableView: ReplaceableView
        get() = _currentReplaceable
        private set(value) {
            _currentReplaceable = value
            onBackPressed.isEnabled = !isRoot
        }

    val isRoot: Boolean get() = backStack.isEmpty()

    val backStackTitle: String
        get() =
            (backStack.drop(1) + currentReplaceableView).joinToString(separator = " > ") { it.title }

    fun navigateTo(replaceableView: ReplaceableView) {
        if (replaceableView is ActivityReplaceableView<*>) {
            launchActivityReplaceable(replaceableView)
        } else {
            backStack.add(currentReplaceableView)
            currentReplaceableView = replaceableView
        }
    }

    fun popAll() {
        if (!isRoot) {
            backStack.clear()
            currentReplaceableView = rootReplaceableView
        }
    }

    private fun popBackStack() {
        currentReplaceableView = backStack.removeAt(backStack.lastIndex)
    }

    companion object {
        fun Saver(
            rootReplaceable: ReplaceableViewCategory,
            backDispatcher: OnBackPressedDispatcher,
            launchActivityReplaceable: (ActivityReplaceableView<*>) -> Unit
        ): Saver<Navigator, *> = listSaver<Navigator, String>(
            save = { navigator ->
                (navigator.backStack + navigator.currentReplaceableView).map { it.title }
            },
            restore = { restored ->
                require(restored.isNotEmpty())
                val backStack = restored.mapTo(mutableListOf()) {
                    requireNotNull(findView(rootReplaceable, it))
                }
                val initial = backStack.removeAt(backStack.lastIndex)
                Navigator(backDispatcher, launchActivityReplaceable, rootReplaceable, initial, backStack)
            }
        )

        private fun findView(replaceableView: ReplaceableView, title: String): ReplaceableView? {
            if (replaceableView.title == title) {
                return replaceableView
            }
            if (replaceableView is ReplaceableViewCategory) {
                replaceableView.replaceableViews.forEach { child ->
                    findView(child, title)
                        ?.let { return it }
                }
            }
            return null
        }
    }
}
