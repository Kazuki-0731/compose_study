package com.example.compose_study.ui.screen.animation.samples.button

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ButtonSample() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            var count by remember { mutableStateOf(1) }

            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    if(targetState > initialState){
                        slideInVertically({ it }) + fadeIn() with
                                slideOutVertically({ -it }) + fadeOut(animationSpec = tween(200))
                    } else {
                        slideInVertically({ -it }) + fadeIn() with
                                slideOutVertically({ it }) + fadeOut(animationSpec = tween(200))
                    }.using(SizeTransform(clip = false))
                }
            ) {
                Text(
                    modifier = Modifier
                        .height(20.dp)
                        .wrapContentSize(Alignment.Center),
                    text = "$it"
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Button(onClick = { count-- }) { Text(text = "Minus") }
                Spacer(modifier = Modifier.size(60.dp))
                Button(onClick = { count++ }) { Text(text = "Plus") }
            }
        }
    }
}
