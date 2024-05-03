package com.jctres.taskmedraft

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SecondComponent(modifier: Modifier = Modifier) {
    Column(
        modifier= modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp,0.dp))
            .background(Color(0xFF121F34)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = { /*TODO*/ }
        ) {
            Text(text = "Crear una cuenta", color = Color.White)
        }
        
    }
}