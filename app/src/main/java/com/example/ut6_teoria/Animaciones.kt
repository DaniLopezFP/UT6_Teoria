package com.example.ut6_teoria

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimationSimple() {
    var colorPer by rememberSaveable {
        mutableStateOf(false)
    }
    var realColor = if (colorPer) Color.Red else Color.Blue
    Column {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { colorPer = !colorPer })

    }
}

@Composable
fun ColorAnimationSimple2() {
    var colorPer by rememberSaveable {
        mutableStateOf(false)
    }
    var realColor = if (colorPer) Color.Red else Color.Blue

    var showText by rememberSaveable {
        mutableStateOf(false)
    }


    var colorPer2 by rememberSaveable {
        mutableStateOf(false)
    }
    val realColor2 by animateColorAsState(
        targetValue = if (colorPer2) Color.Red else Color.Blue,
        animationSpec = tween(durationMillis = 2000),
        label = "Animación color",
        finishedListener = { showText = !showText }
    )
    Column {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { colorPer = !colorPer })


        Spacer(modifier = Modifier.size(10.dp))
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { colorPer2 = !colorPer2 }) {

            if (showText) {
                Text(text = "Finaliza animación")

            }

        }
    }
}

@Composable
fun sizeAnimation() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }
    var texto = ""
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(1000),
        label = "Animación tamaño"
    )
    Column {
        Box(modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize })
    }
}

@Composable
fun visibilityAnimation() {
    var isVisible by remember {
        mutableStateOf(true)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar /Ocultar")
        }
        Spacer(modifier = Modifier.size(10.dp))


        AnimatedVisibility(isVisible, enter = slideInHorizontally(), exit = slideOutHorizontally()) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Cyan)
            )
        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun contentAnimation(){
    Row {
        var count by remember { mutableStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Add")
        }
        Text(text= "Count: ")
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                // Compare the incoming number with the previous number.
                if (targetState > initialState) {
                    // If the target number is larger, it slides up and fades in
                    // while the initial (smaller) number slides up and fades out.
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    // If the target number is smaller, it slides down and fades in
                    // while the initial number slides down and fades out.
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }, label = ""
        ) { targetCount ->
            Text(text = "$targetCount")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun advanceContentAnimation() {
    var expanded by remember { mutableStateOf(false) }
    Surface(
        modifier=Modifier.padding(2.dp),
        color = MaterialTheme.colorScheme.primary,
        onClick = { expanded = !expanded }
    ) {
        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) with
                        fadeOut(animationSpec = tween(150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (targetState) {
                                keyframes {
                                    // Expand horizontally first.
                                    IntSize(targetSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            } else {
                                keyframes {
                                    // Shrink vertically first.
                                    IntSize(initialSize.width, targetSize.height) at 150
                                    durationMillis = 300
                                }
                            }
                        }
            }, label = ""
        ) { targetExpanded ->
            if (targetExpanded) {
                Text(text = "¿Quien gobierna los Británicos?\n" +
                        "¿Y prohíbe el sistema métrico?\n" +
                        "Nosotros, nosotros.\n" +
                        "¿Quien descubrió las Atlántida\n" +
                        "y contacta con alienígenas?\n" +
                        "Nosotros, nosostros.\n" +
                        "¿Quién retrasa los avances de la NASA?\n" +
                        "¿Quién sabe controlar a las masas?\n" +
                        "Nosotros, nosostros.\n" +
                        "¿Quién da al dólar su valor\n" +
                        "y el Oscar al mejor actor?\n" +
                        "Nosotros, nosostros.", modifier = Modifier.padding(10.dp))


            } else {
                Icon(imageVector = Icons.Default.Call, contentDescription = "Llamada")
            }
        }
    }
}




