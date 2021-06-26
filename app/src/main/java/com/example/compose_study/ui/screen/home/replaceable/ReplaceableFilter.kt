package com.example.compose_study.ui.screen.home.replaceable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

/**
 * A scrollable list of [launchableReplaceableViews], filtered by [filterText].
 */
@Composable
fun ReplaceableFilter(launchableReplaceableViews: List<ReplaceableView>, filterText: String, onNavigate: (ReplaceableView) -> Unit) {
    val filteredDemos = launchableReplaceableViews
        .filter { it.title.contains(filterText, ignoreCase = true) }
        .sortedBy { it.title }
    // TODO: migrate to LazyColumn after b/175671850
    Column(Modifier.verticalScroll(rememberScrollState())) {
        filteredDemos.forEach { demo ->
            FilteredDemoListItem(
                demo,
                filterText = filterText,
                onNavigate = onNavigate
            )
        }
    }
}

/**
 * [TopAppBar] with a text field allowing filtering all the demos.
 */
@Composable
fun FilterAppBar(
    filterText: String,
    onFilter: (String) -> Unit,
    onClose: () -> Unit
) {
    with(MaterialTheme.colors) {
        val appBarColor = if (isLight) {
            surface
        } else {
            // Blending primary over surface according to Material design guidance for brand
            // surfaces in dark theme
            primary.copy(alpha = 0.08f).compositeOver(surface)
        }
        TopAppBar(backgroundColor = appBarColor, contentColor = onSurface) {
            IconButton(modifier = Modifier.align(Alignment.CenterVertically), onClick = onClose) {
                Icon(Icons.Filled.Close, null)
            }
            FilterField(
                filterText,
                onFilter,
                Modifier.fillMaxWidth().align(Alignment.CenterVertically)
            )
        }
    }
}

/**
 * [BasicTextField] that edits the current [filterText], providing [onFilter] when edited.
 */
@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun FilterField(
    filterText: String,
    onFilter: (String) -> Unit,
    modifier: Modifier = Modifier
) {

}

/**
 * [ListItem] that displays a [replaceableView] and highlights any matches for [filterText] inside [ReplaceableView.title]
 */
@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun FilteredDemoListItem(
    replaceableView: ReplaceableView,
    filterText: String,
    onNavigate: (ReplaceableView) -> Unit
) {
    val primary = MaterialTheme.colors.primary
    val annotatedString = buildAnnotatedString {
        val title = replaceableView.title
        var currentIndex = 0
        val pattern = filterText.toRegex(option = RegexOption.IGNORE_CASE)
        pattern.findAll(title).forEach { result ->
            val index = result.range.first
            if (index > currentIndex) {
                append(title.substring(currentIndex, index))
                currentIndex = index
            }
            withStyle(SpanStyle(color = primary)) {
                append(result.value)
            }
            currentIndex = result.range.last + 1
        }
        if (currentIndex <= title.lastIndex) {
            append(title.substring(currentIndex, title.length))
        }
    }
    key(replaceableView.title) {
        ListItem(
            text = {
                Text(
                    modifier = Modifier.height(56.dp).wrapContentSize(Alignment.Center),
                    text = annotatedString
                )
            },
            modifier = Modifier.clickable { onNavigate(replaceableView) }
        )
    }
}
