package com.jcstres.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jcstres.login.ui.theme.LoginTheme


@Composable
fun LoginScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "Test")
    }


    }



 @Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    LoginTheme{
        LoginScreen()
    }
}