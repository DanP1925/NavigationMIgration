package com.danp1925.navigationmigration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun ThirdScreen(
    numberArgument: Int,
    updateToolbar: (String) -> Unit
) {

    LaunchedEffect(Unit) {
        updateToolbar("Third Screen")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Third\nScreen",
            style = TextStyle(fontSize = 60.sp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Number from previous screen: $numberArgument",
            style = TextStyle(fontSize = 32.sp),
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun ThirdScreenPreview() {
    ThirdScreen(
        numberArgument = 1,
        updateToolbar = {}
    )
}