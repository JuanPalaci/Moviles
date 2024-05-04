package com.jctres.learnnavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun ScreenA(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Screen A")
        Button(onClick = {
            //elegir el navigate que tenga de parametro un route
            //en el + estoy mandando los datos a la pantalla B
            navController.navigate(Routes.screenB + "/Tom")
        }) {
            Text(text = "Go to Screen B")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ScreenAPreview(){
    val navController = rememberNavController()
    ScreenA(navController = navController)
}