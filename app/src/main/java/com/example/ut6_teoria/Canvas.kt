package com.example.ut6_teoria

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import com.example.ut6_teoria.ui.theme.Tear

@Composable
fun dibujo() {
    Column {
        Canvas(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
        ) {
            //Cuadrado simple
            drawRect(
                color = Color.Red,
            )
        }
        Canvas(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
        ) {
            //Círulo simple
            drawCircle(
                color = Color.Cyan,
                radius = 90f,
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
        }
        Canvas(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
        ) {
            //Cuadrado redondeado
            drawRoundRect(color = Color.DarkGray, cornerRadius = CornerRadius(15.dp.toPx()))
        }
    }
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        //Círculo con línea gruesa
        drawCircle(
            color = Color.Red,
            radius = 90f,
            style = Stroke(width = 30f, cap = StrokeCap.Round)
        )
    }
}

@Composable
fun positionDraw() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        /*drawRect(
            color = Color.Red,
            topLeft = Offset(x = 100f, y = 100f)
        )*/
        drawCircle(
            color = Color.Red,
            radius = 90f,
            style = Stroke(width = 10f, cap = StrokeCap.Round),
            center = Offset(x = 200f, y = 500f)
        )
    }
}

@Composable
fun CustomDrawLine() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Tear, strokeWidth = 10f
        )
        drawLine(
            start = Offset(x =0f , y = 0f),
            end = Offset(x = canvasWidth, y = canvasHeight),
            color = Tear, strokeWidth = 10f
        )
    }
}

@Composable
fun DrawCirc() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        scale(scaleX = 10f, scaleY = 15f) {
            drawCircle(
                color = Color.Red,
                radius = 90f
            )
        }
    }
}
@Composable
fun trasaladar(){
    Canvas(modifier = Modifier.fillMaxSize()) {
        translate(left = 100f, top = -300f) {
            drawCircle(Color.Blue, radius = 200.dp.toPx())
        }
    }
}

@Composable
fun rotar(){
    Canvas(modifier = Modifier.fillMaxSize()) {
        rotate(degrees = 45F) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
                size = size / 3F
            )
        }
    }
}


