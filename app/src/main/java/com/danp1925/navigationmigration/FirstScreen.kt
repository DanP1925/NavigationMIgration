package com.danp1925.navigationmigration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(
    updateToolbar : (String) -> Unit,
    navigateToSecondScreen: () -> Unit,
    navigateToThirdScreen: () -> Unit
) {

    LaunchedEffect(Unit) {
        updateToolbar("First Screen")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First\nScreen",
            style = TextStyle(fontSize = 60.sp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Button(onClick = navigateToSecondScreen) {
            Text(text = "Go To Second Screen")
        }
        Button(onClick = navigateToThirdScreen) {
            Text(text = "Go To Third Screen")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen(
        updateToolbar = {},
        navigateToSecondScreen = {},
        navigateToThirdScreen = {}
    )
}