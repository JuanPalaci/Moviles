package com.jctres.learnnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MyAppNavigation(){
    //ahora con navController puedo navegar a cualquier pantalla
    val navController = rememberNavController()
    // el navhost hara que tenga todas las rutas que quiero tener en la App
    // en start destination sera la pantalla inicial de la app
    //es recomendable tener el propio archivo con las rutas para menores confusiones y que se vea mas profesional
    NavHost(navController = navController, startDestination = Routes.screenA) {
        //rutas para navegar
        composable(Routes.screenA,){
            //si queremos pasar entre pantallas necesitamos pasar como parametro a navController
            ScreenA(navController)
        }
        composable(Routes.screenB + "/{name}",){
            //hacemos que la pantalla B reciva algo como parametro en este caso name
            val name = it.arguments?.getString("name")
            // recuerda que puede aceptar nulos asi que por eso ponemos No name
            ScreenB(name?: "No name")
        }
    }
}