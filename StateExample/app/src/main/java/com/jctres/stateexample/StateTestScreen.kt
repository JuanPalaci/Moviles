package com.jctres.stateexample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp



//remmeber --> presist state on recomposition
//remmeberSaveable --> persist even on configuration changes
//para usar viewModel necesitamos la dependencia de livedata: implementation("androidx.compose.runtime:runtime-livedata:1.6.7")
//ViewModel and Livedata -> Hoist the State for re-usability

@Composable
//procedemos a tener como parametro el viewModel
fun StateTestScreen(viewModel: StateTestViewModel){

    val name by viewModel.name.observeAsState(initial = "")
    val surname by viewModel.surname.observeAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText("$name $surname")
        MyTextField(name, onNameChange= {
            viewModel.onNameUpdate(it)
        })
        MyTextField(surname, onNameChange= {
            viewModel.onSurNameUpdate(it)
        })
    }
}

@Composable
fun MyText(name:String){
    Text(text = "Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name:String, onNameChange:(String)->Unit){

    OutlinedTextField(value = name, onValueChange = {
        onNameChange(it)
    }, label = { Text(text = "Enter name")})

}





