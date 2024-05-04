package com.appcalcu.mylogin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun LoginScreen(){
        var email by remember {
                mutableStateOf("")
        }

        var password by remember {
                mutableStateOf("")
        }
        Column (
                modifier = Modifier
                        .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally


        ){
                Image(painter = painterResource(id = R.drawable.a), contentDescription = "LoginImage",
                        modifier = Modifier
                                .size(200.dp))
                Text(text = "Welcome Back!",
                        fontSize = 28.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier
                        .height(4.dp))
                Text(text = "Login to your account")
                Spacer(modifier = Modifier
                        .height(16.dp))

                OutlinedTextField(value = email, onValueChange = {
                        email= it
                }, label = {
                        Text(text = "Email Address")
                })
                Spacer(modifier = Modifier
                        .height(16.dp))

                OutlinedTextField(value = password, onValueChange = {
                        password = it
                }, label = {
                        Text(text = "Password")
                }, visualTransformation = PasswordVisualTransformation())
                
                Spacer(modifier = Modifier
                        .height(16.dp))
                
                Button(onClick = {
                        Log.i("Credential", "email: $email Password: $password")
                }) {
                        Text(text = "Login")
                }

                Spacer(modifier = Modifier
                        .height(32.dp))

                Text(text = "Forgot Password?", modifier = Modifier.clickable {  })

                Spacer(modifier = Modifier
                        .height(32.dp))
                Text(text = "Or sign in with")

                Row (
                        modifier = Modifier
                                .padding(40.dp)
                                .fillMaxWidth(),
                     horizontalArrangement = Arrangement.SpaceEvenly
                ){
                        Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Facebook Icon",
                                modifier = Modifier
                                        .size(60.dp)
                                        .clickable {
                                                //Facbook clicked
                                        })
                        Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google Icon",
                                modifier = Modifier
                                        .size(60.dp)
                                        .clickable {
                                                //Google clicked
                                        })
                        Image(painter = painterResource(id = R.drawable.twitter), contentDescription = "Twitter Icon",
                                modifier = Modifier
                                        .size(60.dp)
                                        .clickable {
                                                //Twitter clicked
                                        })
                }


        }

}

@Preview (showBackground = true)
@Composable
fun LoginScreenPreview(){
        LoginScreen()
}
