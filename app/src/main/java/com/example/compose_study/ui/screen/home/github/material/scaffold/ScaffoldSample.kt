package com.example.compose_study.ui.screen.home.github.material.scaffold

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun ScaffoldSample() {
    val materialBlue700= Color(0xFF1976D2)

     Scaffold(
          //scaffoldState = ScaffoldState(DrawerValue.Open),
          topBar = { TopAppBar(title = {Text("TopAppBar")},backgroundColor = materialBlue700)  },
         // floatingActionButtonPosition = Scaffold.FabPosition.End,
          floatingActionButton = { FloatingActionButton(onClick = {}){
              Text("X")
          } },
          drawerContent = { Text(text = "drawerContent") },
          content = { Text("BodyContent") },
          bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
      )
}
