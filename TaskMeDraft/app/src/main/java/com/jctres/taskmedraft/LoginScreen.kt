package com.jctres.taskmedraft

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        FirstComponent(modifier = Modifier.weight(0.99f))
       SecondComponent(modifier = Modifier.weight(0.35f))
    }
}






@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}