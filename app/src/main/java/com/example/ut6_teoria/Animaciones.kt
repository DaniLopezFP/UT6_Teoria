package com.example.ut6_teoria

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
