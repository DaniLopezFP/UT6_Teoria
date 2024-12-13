package com.example.ut6_teoria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ut6_teoria.ui.theme.UT6_TeoriaTheme
import kotlin.random.Random.Default.nextInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UT6_TeoriaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding).padding(start = 10.dp)) {
                        /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                        //cardAnimation()
                        DraggableTextLowLevel()
                        circleAnimation()
                        //InfinitelyPulsingHeart()
                        //gradient()
                        //rotar()
                       // trasaladar()
                        //DrawCirc()
                       // dibujo()
                        //positionDraw()
                       // CustomDrawLine()
                      //  ColorAnimationSimple()
                      //  Spacer(Modifier.size(50.dp))
                        //ColorAnimationSimple2()
                       // visibilityAnimation()
                      /*  contentAnimation()
                        advanceContentAnimation()
                        Spacer(Modifier.size(50.dp))
                        sizeAnimation()
                        crossFadeExample()*/
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UT6_TeoriaTheme {
        Greeting("Android")
    }
}
enum class ComponentTye() {
    Image, Text, Box, Error
}

fun getComponentTypeRandon(): ComponentTye {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentTye.Image
        1 -> ComponentTye.Text
        2 -> ComponentTye.Box
        else -> ComponentTye.Error
    }
}


@Composable
fun crossFadeExample() {
    var myComponent: ComponentTye by remember {
        mutableStateOf(ComponentTye.Text)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponent= getComponentTypeRandon()}) {
            Text(text = "Cambiar componente")
        }
        Crossfade(targetState = myComponent, label = "Crossfade", animationSpec = tween(1000)) { myComponent->
            when (myComponent) {
                ComponentTye.Image -> Icon(Icons.Default.Edit, contentDescription = null)
                ComponentTye.Text -> Text(text = "Texto")
                ComponentTye.Box -> Box(modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red))
                ComponentTye.Error -> Text(text = "Error")
            }
        }
    }
}



