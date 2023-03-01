package com.example.learncompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTextField(fieldName: String, input: MutableState<String>, bottomPadding : Dp = 0.dp) {

    Column(

    ) {
        Text(
            text = fieldName,
            color = Color(0Xff4d4d4d),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 5.dp)
            )

        OutlinedTextField(
            value = input.value,
            onValueChange = {
                input.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = bottomPadding)
                .height(45.dp),
            shape = RoundedCornerShape(8.dp)
        )
    }
}