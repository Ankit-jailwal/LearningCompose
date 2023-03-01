package com.example.learncompose.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginButton(email: MutableState<String>, password: MutableState<String>) {

    OutlinedButton(
        onClick = {
        Log.d("values","username: ${email.value} and password: ${password.value}") },

        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),

        border = BorderStroke(0.dp, Color.Unspecified),

        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFed5684)),

        elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),

        shape = RoundedCornerShape(10.dp)

    ) {
        Text("LOGIN",
            color = Color.White,
            modifier = Modifier.padding(4.dp),
            fontSize = 16.sp
            )
    }
}