package com.example.compose_study.ui.screen.animation.sample

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private const val DURATION = 500
private const val DOT_SPACE_FACTOR = 0.5f

@Composable
fun DotLoading(
    modifier: Modifier,
    dotsize: Dp = 24.dp,
    dotColor: Color = MaterialTheme.colors.primary
){
    val infiniteTraqnsition = rememberInfiniteTransition()
    val dotSpace: Dp = dotsize * DOT_SPACE_FACTOR

    val offset = with(LocalDensity.current){
        (dotsize + dotSpace).toPx()
    }

    val xOffSet by infiniteTraqnsition.animateFloat(
        initialValue = 0f,
        targetValue = offset,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = DURATION)
        )
    )

    val canvasSize = dotsize * 2 + dotSpace
    Canvas(modifier = modifier.size(canvasSize)) {
        val radius = dotsize.toPx() / 2
        repeat(4) { index ->
            rotate(90f * (index - 1)){
                drawCircle(
                    color = dotColor,
                    radius = radius,
                    center = Offset(radius+ xOffSet, radius)
                )
            }
        }
    }
}
