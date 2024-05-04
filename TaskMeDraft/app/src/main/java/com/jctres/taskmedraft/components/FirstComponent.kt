package com.jctres.taskmedraft.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.jctres.taskmedraft.R

@Composable
    fun FirstComponent(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxHeight()

        ){
            Image(painter = painterResource(id = R.drawable.taskmebackground), contentDescription = "LoginImage",
                modifier = modifier
                    .background(Color(0xFFFFAA3F))
                    .fillMaxSize()

            )
        }

    }