package com.example.test.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.R
import com.example.test.ui.theme.TestTheme

@Composable
fun LoginScreen(){
    Box {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Form()
    }
}


/**
 * Form that contains
 * Field: where the user will enter his email
 * Button: The submit button
 */
@Composable
private fun Form(){

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(
            top = 380.dp,
            start = 10.dp,
        )
    ) {
        Row (
            modifier = Modifier.padding(bottom = 5.dp)
        ){
            TextField(
                value = "ilias@example.com",
                onValueChange = {}
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(width = 100.dp, height = 55.dp)
            ) {
                Text(text = "Login")
            }
        }
        Text(text = "Error")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingBackGround() {
    TestTheme {
        LoginScreen()
    }
}