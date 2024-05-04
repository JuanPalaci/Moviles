package com.jctres.taskmedraft.screens

import androidx.compose.foundation.layout.Column

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jctres.taskmedraft.components.FirstComponent
import com.jctres.taskmedraft.components.SecondComponent

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