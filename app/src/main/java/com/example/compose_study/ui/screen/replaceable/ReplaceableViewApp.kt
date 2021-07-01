package com.example.compose_study.ui.screen.replaceable

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.compose_study.ui.screen.home.HomeRootCategory

@Composable
fun ReplaceableApp(
    currentView: ReplaceableView,
    backStackTitle: String,
    isFiltering: Boolean,
    onStartFiltering: () -> Unit,
    onEndFiltering: () -> Unit,
    onNavigateToReplaceable: (ReplaceableView) -> Unit,
    canNavigateUp: Boolean,
    onNavigateUp: () -> Unit,
    launchSettings: () -> Unit
) {
    val navigationIcon = (@Composable { AppBarIcons.Back(onNavigateUp) }).takeIf { canNavigateUp }

    var filterText by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            ReplaceableAppBar(
                title = backStackTitle,
                navigationIcon = navigationIcon,
                launchSettings = launchSettings,
                isFiltering = isFiltering,
                filterText = filterText,
                onFilter = { filterText = it },
                onStartFiltering = onStartFiltering,
                onEndFiltering = onEndFiltering
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        ReplaceableContent(modifier, currentView, isFiltering, filterText, onNavigateToReplaceable)
    }
}

@Composable
private fun ReplaceableContent(
    modifier: Modifier,
    currentReplaceableView: ReplaceableView,
    isFiltering: Boolean,
    filterText: String,
    onNavigate: (ReplaceableView) -> Unit
) {
    Crossfade(isFiltering to currentReplaceableView) { (filtering, replaceable) ->
        Surface(modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            if (filtering) {
                ReplaceableFilter(
                    launchableReplaceableViews = HomeRootCategory.allLaunchableReplaceables(),
                    filterText = filterText,
                    onNavigate = onNavigate
                )
            } else {
                DisplayReplaceable(replaceable, onNavigate)
            }
        }
    }
}

@Composable
private fun DisplayReplaceable(replaceableView: ReplaceableView, onNavigate: (ReplaceableView) -> Unit) {
    when (replaceableView) {
        is ActivityReplaceableView<*> -> {
            /* should never get here as activity replaceable views are not added to the backstack*/
        }
        is ComposableReplaceableView -> replaceableView.content()
        is ReplaceableViewCategory -> DisplayReplaceableCategory(replaceableView, onNavigate)
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun DisplayReplaceableCategory(category: ReplaceableViewCategory, onNavigate: (ReplaceableView) -> Unit) {
    // TODO: migrate to LazyColumn after b/175671850
    Column(Modifier.verticalScroll(rememberScrollState())) {
        category.replaceableViews.forEach { replaceable ->
            ListItem(
                text = {
                    Text(
                        modifier = Modifier.height(56.dp)
                            .wrapContentSize(Alignment.Center),
                        text = replaceable.title
                    )
                },
                modifier = Modifier.clickable { onNavigate(replaceable) }
            )
        }
    }
}

@Suppress("ComposableLambdaParameterNaming", "ComposableLambdaParameterPosition")
@Composable
private fun ReplaceableAppBar(
    title: String,
    navigationIcon: @Composable (() -> Unit)?,
    isFiltering: Boolean,
    filterText: String,
    onFilter: (String) -> Unit,
    onStartFiltering: () -> Unit,
    onEndFiltering: () -> Unit,
    launchSettings: () -> Unit
) {
    if (isFiltering) {
        FilterAppBar(
            filterText = filterText,
            onFilter = onFilter,
            onClose = onEndFiltering
        )
    } else {
        TopAppBar(
            title = {
                Text(title, Modifier.testTag(Tags.AppBarTitle))
            },
            navigationIcon = navigationIcon,
            actions = {
                AppBarIcons.Filter(onClick = onStartFiltering)
            }
        )
    }
}

private object AppBarIcons {
    @Composable
    fun Back(onClick: () -> Unit) {
        val icon = when (LocalLayoutDirection.current) {
            LayoutDirection.Ltr -> Icons.Filled.ArrowBack
            LayoutDirection.Rtl -> Icons.Filled.ArrowForward
        }
        IconButton(onClick = onClick) {
            Icon(icon, null)
        }
    }

    @Composable
    fun Filter(onClick: () -> Unit) {
        IconButton(modifier = Modifier.testTag(Tags.FilterButton), onClick = onClick) {
            Icon(Icons.Filled.Search, null)
        }
    }

    @Composable
    fun Settings(onClick: () -> Unit) {
        IconButton(onClick = onClick) {
            Icon(Icons.Filled.Settings, null)
        }
    }
}
