package com.example.mapping_sample.ui.home.github.general

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf


data class User(val name: String, val age: Int)

val LocalActiveUser = compositionLocalOf<User> { error("No user found!") }

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyUserScreen()
        }
    }
}

@Composable
private fun MyUserScreen() {
    val user = User("Jens", 31)
    CompositionLocalProvider(LocalActiveUser provides user) {
        UserInfo()
    }
}


@Composable
fun UserInfo() {
    Column {
        Text("Name: " + LocalActiveUser.current.name)
        Text("Age: " + LocalActiveUser.current.age)
    }
}
