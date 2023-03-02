package com.example.learncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.components.DefaultTextField
import com.example.learncompose.components.LoginButton
import com.example.learncompose.components.RememberMeButton
import com.example.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Learn Compose")
                            },
                            navigationIcon = {
                                IconButton(onClick =  { Log.d("msg","Menu Button")}) {
                                    Icon(Icons.Filled.Menu, contentDescription = "menu")
                                }
                            },
                            actions = {
                                IconButton(onClick =  { Log.d("msg","Notification Button")}) {
                                    Icon(Icons.Filled.Notifications, contentDescription = "notification")
                                }
                                IconButton(onClick =  { Log.d("msg","Search Button")}) {
                                    Icon(Icons.Filled.Search, contentDescription = "search")
                                }
                            }
                        )
                    },
                    
                    floatingActionButton = {
                        FloatingActionButton(onClick = {Log.d("msg", "Floating Button")}) {
                            IconButton(onClick = {}) {
                                Icon(Icons.Filled.Add, contentDescription = "floatingButton")
                            }
                        }
                    },
                
                ) {
                    padding -> Column(modifier = Modifier.padding(padding)) {
                    AuthUI()
                }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Hey(name: String) {
    Text(text = "Ankit $name")
}

@Composable
fun LoginUi() {
    val username = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 5.dp),
    ) {

        Text(
            text = "Hello \nWelcome to \nLearn Compose",
            fontFamily = FontFamily.SansSerif,
            color = Color.Blue, fontSize = 30.sp
        )

        OutlinedTextField(
            value = username.value,
            onValueChange = {username.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Filled.Person, contentDescription = "username")
            },
            label = { Text(text = "Username")}
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(Icons.Filled.Lock, contentDescription = "username")
            },
            label = { Text(text = "Password")}
        )
        
        OutlinedButton(
            onClick = {
                      Log.d("values","username: ${username.value} and password: ${password.value}")
            },
            modifier = Modifier
                .fillMaxWidth()
            ) {
            Text(text = "Login")
        }
    }

}

@Composable
fun AuthUI() {
    
    var email = remember {
        mutableStateOf("")
    }
    
    var password = remember {
        mutableStateOf("")
    }
    
    var rememberFlag = remember {
        mutableStateOf(false)
    }
    
    Column(
        modifier = Modifier.fillMaxSize().padding(30.dp, 35.dp, 30.dp)
    ) {
        Text(
            text = "SIGN UP",
            modifier = Modifier.padding(bottom = 25.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0Xff4d4d4d)
            )
        
        DefaultTextField(fieldName = "Email", email, 30.dp)
        DefaultTextField(fieldName = "Password", password)

        RememberMeButton(rememberFlag)

        LoginButton(email = email, password = password)
    }

}



@Composable
fun ShowSwitch() {
    val flag = remember {
        mutableStateOf(true)
    }

    Switch(
        checked = flag.value,
        onCheckedChange = {
            flag.value = it
        },
        modifier = Modifier.run {
            size(20.dp)
            padding(100.dp)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnComposeTheme {
        Greeting("Android")
    }
}

