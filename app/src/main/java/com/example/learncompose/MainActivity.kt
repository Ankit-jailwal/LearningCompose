package com.example.learncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting(name = "Android!")
                    ShowSwitch()
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

