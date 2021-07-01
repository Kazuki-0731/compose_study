package com.example.compose_study.ui.screen.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ViewModelProvider
import com.example.compose_study.databinding.FragmentHomeBinding
import com.example.compose_study.ui.common.FilterMode
import com.example.compose_study.ui.common.Navigator
import com.example.compose_study.ui.screen.replaceable.*

/**
 * FragmentとComposeの共存
 * https://github.com/takusan23/BottomFragmentComposeView
 *
 */
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.apply {
            composeView.setContent {
                val activityStarter = fun(replaceableView: ActivityReplaceableView<*>) {
                    startActivity(Intent(requireActivity(), replaceableView.activityClass.java))
                }
                /**
                 * Bundle に保存可能なすべての値を自動的に保存します。
                 * その他の値については、カスタムのセーバーオブジェクトに渡すことができます。
                 */
                val navigator = rememberSaveable(
                    saver = Navigator.Saver(HomeRootCategory, requireActivity().onBackPressedDispatcher, activityStarter)
                ) {
                    Navigator(HomeRootCategory, requireActivity().onBackPressedDispatcher, activityStarter)
                }
                //状態は再コンポーズをまたいで保持
                val replaceableColors = remember {
                    ReplaceableColors().also {
                        lifecycle.addObserver(
                            LifecycleEventObserver { _, event ->
                                if (event == Lifecycle.Event.ON_RESUME) {
                                    it.loadColorsFromSharedPreferences(requireActivity())
                                }
                            }
                        )
                    }
                }
                ReplaceableTheme(replaceableColors, requireActivity().window) {
                    val filteringMode = rememberSaveable(
                        saver = FilterMode.Saver(requireActivity().onBackPressedDispatcher)
                    ) {
                        FilterMode(requireActivity().onBackPressedDispatcher)
                    }
                    val onStartFiltering = { filteringMode.isFiltering = true }
                    val onEndFiltering = { filteringMode.isFiltering = false }
                    ReplaceableApp(
                        currentView = navigator.currentReplaceableView,
                        backStackTitle = navigator.backStackTitle,
                        isFiltering = filteringMode.isFiltering,
                        onStartFiltering = onStartFiltering,
                        onEndFiltering = onEndFiltering,
                        onNavigateToReplaceable = { replaceable ->
                            if (filteringMode.isFiltering) {
                                onEndFiltering()
                                navigator.popAll()
                            }
                            navigator.navigateTo(replaceable)
                        },
                        canNavigateUp = !navigator.isRoot,
                        onNavigateUp = {
                            requireActivity().onBackPressed()
                        },
                        launchSettings = {
                            // startActivity(Intent(this, DemoSettingsActivity::class.java))
                        }
                    )
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

@Composable
private fun ReplaceableTheme(
    replaceableColors: ReplaceableColors,
    window: Window,
    content: @Composable () -> Unit
) {
    MaterialTheme() {
        val statusBarColor = with(MaterialTheme.colors) {
            (if (isLight) primaryVariant else Color.Black).toArgb()
        }
        SideEffect {
            window.statusBarColor = statusBarColor
        }
        content()
    }
}
