package com.example.learncompose.components
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RememberMeButton(flag: MutableState<Boolean>) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = flag.value,
            onCheckedChange = {
                flag.value = !flag.value
            },
            colors = CheckboxDefaults.colors(checkedColor = Color(0XFFed5684))
        )

        Text("Remember me?")
    }

}