package com.example.cat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cat.R
import com.example.cat.ui.theme.TestTheme


@Composable
fun PrincipalScreen(){
    Image(
        painter = painterResource(R.drawable.img_1),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
    )
}


@Preview
@Composable
fun PrincipalPreview(){
    TestTheme {
        PrincipalScreen()
    }
}