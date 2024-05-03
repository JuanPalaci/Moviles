package com.jctres.taskmedraft

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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